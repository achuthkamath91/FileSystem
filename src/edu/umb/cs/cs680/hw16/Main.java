package edu.umb.cs.cs680.hw16;

import java.util.Date;

public class Main {
	
	static Directory root = new Directory(null, "root", "MAK", new Date(), null, 210);
	static Directory system;
	static Directory home;
	static Directory pictures;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileSystem fs = FileSystem.getFileSystem();
		FileSystem.setRoot(root);
        FileSystem.setCurrent(root);
		system = new Directory(root, "System", "MAK", new Date(),null, 100);
		home = new Directory(root, "Home", "MAK", new Date(),null, 100);
		pictures = new Directory(home, "pictures", "MAK", new Date(),null, 50);
		new File(root, "test","MAK", new Date(), null, 10);
		new File(system, "a.txt","MAK", new Date(), null, 10);
		new File(system, "b.png","MAK", new Date(), null, 20);
		new File(system, "c.png","MAK", new Date(), null, 30);
		new File(home, "d.txt","MAK", new Date(), null, 10);
		File e = new File(pictures,"e.txt","MAK", new Date(), null, 15);
		new File(pictures, "f","MAK", new Date(), null, 15);
		Link x = new Link(home, "x","MAK", new Date(),null, 15);
		x.setLink(system);
		Link y = new Link(pictures,"y", "MAK", new Date(),null, 15);
		y.setLink(e);
		System.out.println("Display all the File Structure!..");
		fs.showAllElements(root);
		System.out.println("Terminal is Open");
		System.out.println("Available Commands!!..");
		System.out.println("cd, chown, cls, dir, ln, mkdir, mv, pwd, rmdir, cp, sort, history, redo, exit(exit the terminal)");
		System.out.println("Type Exit to exit the terminal");
		Shell shell = new Shell();
		shell.run(fs);

	}

}
