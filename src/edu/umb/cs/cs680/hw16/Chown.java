package edu.umb.cs.cs680.hw16;

public class Chown implements Command {
	
	//private FileSystem fs = null;
	private String owner;
	
	public Chown(FileSystem f, String own, String str){
		//fs = f;
		owner= own;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Directory current = FileSystem.getCurrent();
		current.setOwner(owner);
	}
	
	
}
