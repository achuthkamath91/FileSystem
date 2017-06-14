package edu.umb.cs.cs680.hw16;

import java.util.ArrayList;

public class Cd implements Command{
	
	private FileSystem fs = null;
	private String Str;
	private Boolean direct= false;
	
	public Cd(FileSystem f) {
       fs= f;
    }
	public Cd(FileSystem f, String dir) {
	       fs= f;
	       Str = dir;
	       direct = true;
	    }
	
	public void execute() {
		// TODO Auto-generated method stub
		String outputMessage = "";
		if(direct == false){
			Directory ds = FileSystem.getCurrent();
			if(ds != null){
				ArrayList<FSElement> children = ds.getChildren();
				if(!children.isEmpty()){
					FileSystem.setCurrent(ds);
					outputMessage = "Directory set to "+ds.getName();
				}else{
					if(ds.isDir())
					outputMessage = "No directory found";
				}
			}else{
				fs.setCurrent();
				Directory dc = FileSystem.getCurrent();
				outputMessage = "Directory set to "+dc.getName();
			}
		}else{
			boolean error = false;
			ArrayList<FSElement> fe = FileSystem.getCurrent().getChildren();
			if(fe.size() == 0){
	        	error = true;
	        	//System.out.println("Empty Directory!!");
	        }
	        if (Str != null)
	        switch (Str) {
	            case "..":
	            	error = true;
	                if("root" != FileSystem.getCurrent().getName()){
		                FileSystem.setCurrent(FileSystem.getCurrent().getParent());	                	
	                }
	                break;
	            case ".":
	            	error = true;
	                break;
	            default:
	                  for (FSElement ff : fe) {
	                    if (ff.getName().equals(Str)&&ff.isDir()) {
	                        FileSystem.setCurrent((Directory) ff);
	                        error = true;
	                    }
	            }   break;
	        }
	        if (!error) {
	            System.out.println("Invalid Directory name " + Str);
	        }
		}
		System.out.println(outputMessage);
		
	}

}
