package edu.umb.cs.cs680.hw16;

//import java.util.ArrayList;
import java.util.Date;

public class File extends FSElement{

	//private ArrayList<FSElement> fselements;
	
	public File(Directory parent, String name, String owner, Date created, Date lastModified, int size){
		super(parent, name, owner, created, lastModified, size);
		if(parent != null)
			parent.appendChild(this);
	}

	public int getDiskUtil() {
		// TODO Auto-generated method stub
		return this.getSize();
	}
}
