package edu.umb.cs.cs680.hw16;

import java.util.ArrayList;

public class Ln implements Command{
	
	private FileSystem f;
	private String from;
	private String to;
	public Ln(FileSystem fs, String t, String fr){
		 f = fs;
		 from = fr;
		 to = t;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ArrayList<FSElement> felm = FileSystem.getCurrent().getChildren();
        FSElement fsele = null;
        FSElement fsele2 = null;
        boolean exist = false;
        boolean exist2 = false;
		if( from != to){
			for (FSElement ff : felm) {
	            if (ff.getName().equals(from)) {
	                fsele = ff;
	                exist = true;
	            }
	            if (ff.getName().equals(to)) {
	            	fsele2 = ff;
	            	exist2 = true;
	            }
	        }
			if (exist && exist2) {
	            f.createLink(fsele, fsele2);
	        }
		}else{
			 Shell.println("Cannot link to itself");
		}
	}

}
