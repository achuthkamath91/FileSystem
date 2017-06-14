package edu.umb.cs.cs680.hw16;

import java.util.Date;

public class Mkdir implements Command{
	private FileSystem f;
	private String str;
	public Mkdir(FileSystem fs , String st){
		 f = fs;
		 str = st;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Directory current = FileSystem.getCurrent();
		if(f.containsDir(current,str)){
			System.out.print("Directory "+str+" already exists!!\n");
		}else{
			new Directory(current,str, current.getOwner(), new Date(),null, 0);	
			System.out.print("Directory "+str+" created!!\n");
		}
	}

}
