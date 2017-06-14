package edu.umb.cs.cs680.hw16;

public class Cp implements Command
{
	
	private FileSystem f;
	private String from;
	private String to;

    public Cp(FileSystem fs, String fr, String t) {
        f = fs;
        from = fr;
        to = t;
    }
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		f.MoveDirectory(from,to,false);
	}

}
