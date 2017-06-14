package edu.umb.cs.cs680.hw16;

import java.util.ArrayList;

public class Dir implements Command{
	
	private FileSystem fs = null;
	private String Str;
	private boolean direct = false;
	
	public Dir(FileSystem f) {
        fs = f;
    }
	
	public Dir(FileSystem f, String Sw) {
        fs = f;
        Str = Sw;
        direct = true;
    }
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if( direct == false){
			Directory current = FileSystem.getCurrent();
			fs.showAllDirElements(current);			
		}else{
			boolean error = false;
			ArrayList<FSElement> felem = FileSystem.getCurrent().getChildren();
	        if(felem.size() == 0){
	        	error = true;
	        	System.out.println("Empty Directory!!");
	        }
	        if (Str != null)
	        switch (Str) {
	            case "..":
	            	error = true;
	                fs.showAllDirElements(FileSystem.getCurrent().getParent());
	                break;
	            case ".":
	                fs.showDir();
	                error = true;
	                break;
	            default:
	                for (FSElement ff : felem) {
	                    if (ff.getName().equals(Str)) {                        
	                        fs.showDir(ff);
	                        error = true;
	                    }
	                }   break;
	        }
	        if (!error) {
	            System.out.println("Invalid Directory name " + Str);
	        }
		}
	}

}
