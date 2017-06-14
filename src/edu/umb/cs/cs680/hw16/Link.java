package edu.umb.cs.cs680.hw16;

//import java.util.ArrayList;
import java.util.Date;

public class Link extends FSElement{

	//private ArrayList<FSElement> fselements;
	private FSElement linkElem;
	
	public Link(Directory parent, String name, String owner, Date created, Date lastModified, int size){
		super(parent, name, owner, created, lastModified, size);
		if(parent != null ) 
			parent.appendChild(this);
	}
	public String getName(){
		return super.getName();
	}
	
	/*public void accept(FSVisitor v){
		v.visit(this);
	}*/

	public int getDiskUtil() {
		// TODO Auto-generated method stub
		return getSize();
	}
	
	public int getTargetSize()
	{
		FSElement fs = linkElem;
		if(fs.isLeaf()){
			return fs.getSize();
		}else{
			return fs.getSize();
		}
	}
	
	public void setLink(FSElement linkElem1)
	{
		linkElem = linkElem1;
	}
	
}
