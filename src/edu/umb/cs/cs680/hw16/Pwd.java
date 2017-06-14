package edu.umb.cs.cs680.hw16;

public class Pwd implements Command{
	
	//private FileSystem fs = null;
	public Pwd(FileSystem f) {
       // fs = f;
    }
	
	public void execute() {
		System.out.println(FileSystem.getCurrent().getName());
		// TODO Auto-generated method stub
		
	}

}
