package edu.umb.cs.cs680.hw16;

import java.io.PrintStream;
import java.util.*;

public class Shell {

	private static final PrintStream stdout = System.out;
    private static final PrintStream stderr = System.err;
    
    public Shell(){
    	
    }
    
    public static void println(String s) {

        stdout.println(s);
    }

    public static void print(String s) {

        stdout.print(s);
    }
    
    public void run(FileSystem fileSystem) throws Exception {
    	String input;
    	CommandHistory commandHistory = new CommandHistory();
    	Scanner scan = new Scanner(System.in, "UTF-8");
    	 while (true) {
    		 
             Shell.print("> ");
             input = scan.nextLine();
             if (!"".equals(input)) {
                 commandHistory.push(input);
             }
             if("exit".equals(input)){
            	 Shell.println("Filesystem Command Promt ended");
            	 Shell.println("");
                 break;
             }else if("".equals(input)){
             }else{
            	 if ("history".equals(input)) {
                     for (String history : commandHistory.pull()) {
                         Shell.print(history+" ");
                     }
                 } if ("redo".equals(input)) {
                     ArrayList<String> history = commandHistory.pull();
                     input = history.get(history.size() - 2);
                     Shell.println("> " + input);
                     parse(input, fileSystem);
                     input = "";
                 }else {
                	 parse(input, fileSystem);
                 }
             }
         
    	 }
    }

	private void parse(String input, FileSystem fileSystem) {
		// TODO Auto-generated method stub
		if (input.startsWith("cd")) {
			input = input.toLowerCase();
			 if ("cd".equals(input)) {
	                Command command = new Cd(fileSystem);
	                command.execute();
	            } else {
	                String si = input.substring(input.indexOf(" "));
	                si = si.replaceAll("\\s+", "");
	                Command command = new Cd(fileSystem,si);
	                command.execute();
	            }
		}else if(input.equals("ls")){
			Command command = new Ls(fileSystem);
			command.execute();
		}else if(input.equals("pwd")){
			Command command = new Pwd(fileSystem);
			command.execute();
		}else if(input.equals("cls")){
			Command command = new Cls(fileSystem);
			command.execute();
		}else if(input.startsWith("dir")){
			 if ("dir".equals(input)) {
	                Command c = new Dir(fileSystem);
	                c.execute();
	            } else {
	                String sw = input.substring(input.indexOf(" "));
	                sw = sw.replaceAll("\\s+", "");
	                Command c = new Dir(fileSystem, sw);
	                c.execute();
	            }
		}else if (input.startsWith("mkdir")) {
            String[] str = input.split(" ", 3);
            Command c = new Mkdir(fileSystem, str[1]);
            c.execute();
		}else if (input.startsWith("chown")) {
            String[] str = input.split(" ", 3);
            if(str.length > 2){
            	Shell.println("Chown accepts one parameter");
            }
            Command c = new Chown(fileSystem, str[1], "");
            c.execute();
		}else if (input.startsWith("mv")) {
            String[] str = input.split(" ", 3);
            Command c = new Mv(fileSystem, str[1],str[2]);
            c.execute();
		}else if (input.startsWith("ln")) {
            String[] str = input.split(" ", 3);
            Command c = new Ln(fileSystem, str[1],str[2]);
            c.execute();
		}else if (input.startsWith("rmdir")) {
            String[] str = input.split(" ", 3);
            Command c = new Rmdir(fileSystem, str[1]);
            c.execute();
		}else if (input.equals("sort")) {
            Command c = new Sort(fileSystem);
            c.execute();
		}else{
        	Shell.println("Shell command "+input+ " not found.");			
		}
	}
    
}
