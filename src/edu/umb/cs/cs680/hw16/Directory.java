package edu.umb.cs.cs680.hw16;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class Directory extends FSElement {

	private ArrayList<FSElement> fselements;
	
	public Directory(Directory parent, String name, String owner, Date created, Date lastModified, int size){
		super(parent, name, owner, created, lastModified, size);
		fselements = new ArrayList<FSElement>();
		if(parent != null)
			parent.appendChild(this);
	}
	
	public void appendChild(FSElement child){
		fselements.add(child);
	}
	
	public void addChild(FSElement child,int index){
		fselements.add(index,child);
	}
	
	public ArrayList<FSElement> getChildren(){
		return this.fselements;
	}
	
	public int getSize(){
		int size = 0;
		if(fselements.isEmpty())
			return 0;
		else
		{
			Iterator<FSElement> it = fselements.iterator();
			while(it.hasNext())
			{
				FSElement ele = it.next();
				size = size + ele.getSize();
			}
			return size;
		}
	}

	public int getDiskUtil() {
		// TODO Auto-generated method stub
		return getSize();
	}
	
	public Directory getDirectory(String fs){
		Directory dir = null;
		String found = null;
		for (int x = 0; x < fselements.size(); x++){
			found = fselements.get(x).getName();
			if (found.equals(fs)){
				dir = (Directory) fselements.get(x);
			}
		}
		return dir;
	}

	public void remove(FSElement fsele) {
		// TODO Auto-generated method stub
		if(fsele.isLeaf()){
			if (fselements.contains(fsele)) {
            	fselements.remove(fsele);
            }
		}else if (fsele.getCurrentDir().getChildren().isEmpty()) {
            if (fselements.contains(fsele)) {
            	fselements.remove(fsele);
            }

        } else {
        	fsele.getCurrentDir().fselements.clear();
            if (fselements.contains(fsele)) {
            	fselements.remove(fsele);
            }
        }
		
	}

}
