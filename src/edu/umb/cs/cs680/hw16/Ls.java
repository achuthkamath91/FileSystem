package edu.umb.cs.cs680.hw16;

public class Ls implements Command{
	
	private FileSystem fs = null;
	public Ls(FileSystem f) {
        fs = f;
    }
	public void execute() {
		// TODO Auto-generated method stub
		//Directory root = fs.getRoot();
		Directory current = fs.getCurrent();
		fs.showAllElements(current);
	}

}
