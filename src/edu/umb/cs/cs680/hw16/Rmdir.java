package edu.umb.cs.cs680.hw16;

import java.util.ArrayList;

public class Rmdir implements Command{
	
	private FileSystem f;
	private String str;
	public Rmdir(FileSystem fs , String st){
		 f = fs;
		 str = st;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ArrayList<FSElement> felm = FileSystem.getCurrent().getChildren();
        FSElement fsele = null;
        boolean error = false;
        for (FSElement ff : felm) {
            if (ff.getName().equals(str) && ff.isDir()) {
                fsele = ff;
                error = true;
            }
        }
        if (error) {
            f.rmDir(fsele);
        } else {
            Shell.println("Diretory " + str + " doesn not exist!!");
        }
	}

}
