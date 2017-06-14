package edu.umb.cs.cs680.hw16;


import java.sql.Timestamp;
//import java.util.ArrayList;
import java.util.Date;


public class FSElement {
	
	private String name;
	private String owner;
	private Date created;
	private Date lastModified;
	protected int size;
	private Directory parent;
	
	public FSElement(Directory parent, String name, String owner, Date Created, Date lastModified, int size){
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.size = size;
		this.lastModified = lastModified;
		this.created = Created;
	}
	
	public Timestamp getCreated(){
		return new Timestamp(this.created.getTime());
	}
	
	public Timestamp getLastModified(){
		return (Timestamp) this.lastModified;
	}
	
	public Directory getParent() {
		return this.parent;
	}
	
	public FSElement getCurrent() {
        return this;
    }
	
	public Directory getCurrentDir() {
        return (Directory) this;
    }
	
	public boolean isDir() {
		// TODO Auto-generated method stub
		if(this.getClass().getName().contains("Directory")){
			return true;
		}else{
			return false;			
		}
	}
	
	public boolean isLink() {
		// TODO Auto-generated method stub
		if(this.getClass().getName().contains("Link") && size!=0){
			return true;
		}else{
			return false;			
		}
	}
	
	public boolean isLeaf(){
		if(this.getClass().getName().contains("Directory") && this.size!=0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public String getInfo(){
		return "Name is "+getName()+ " Owner is: "+getOwner();
	}
	
	public int getSize(){
		if(isLeaf() == true){
			return this.size;
		}else{
			return this.parent.getSize();
		}
	}
	
	public String getOwner(){
		return this.owner;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setOwner(String own){
		this.owner = own;
	}
	
	public String type(){
		if(this.isDir()){
			return "Directory";
		}else if(this.isLink()){
			return "Link";
		}else{
			return "File";
		}
	}
}
