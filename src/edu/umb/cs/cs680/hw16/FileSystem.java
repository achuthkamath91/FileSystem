package edu.umb.cs.cs680.hw16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public final class FileSystem {
    private static Directory rootDir;
	private static FileSystem fileSystem = new FileSystem(rootDir); 
	private int count = 2;
	protected ArrayList<FSElement> found = new ArrayList<FSElement>();
	private static Directory current;
	private Comparator<FSElement> comp = null;
	
	private FileSystem(Directory root) {
        FileSystem.setRoot(root);
        FileSystem.setCurrent(root);

    }
	
	public static FileSystem getFileSystem(){
		return fileSystem;
	}
	
	public void showAllElements(Directory root){
		
		System.out.println("- "+root.getName()+"");
		
		Iterator<FSElement> fselements =  root.getChildren().iterator();
		while(fselements.hasNext())
		{			
			FSElement f = fselements.next();
			if(f.isLeaf()){
				printDash(count);
				printFilename(f.getName());
			}else{
				Directory dir = root.getDirectory(f.getName());
				displayChildrens(dir);	
				count = 2;
			}
		}
	}
	
	private void printDash(int count2) {
		for (int i=1; i<=count2; i++){
			System.out.print("--");
		}
	}

	private void displayChildrens(Directory dir){
		printDash(count);
		System.out.print(" "+dir.getName());
		System.out.println("");
		count +=1;
		if(dir.getSize() >0){
			for (FSElement a :dir.getChildren()){
				if(a.isLeaf()){
					printDash(count);
					printFilename(a.getName());
				}else if(a.getSize()>0){
					displayDirectory(a);
				}
			}
			count -=1;
		}
	}

	private void displayDirectory(FSElement f) {
		// TODO Auto-generated method stub
		Directory dir = (Directory) f;
		displayChildrens(dir);
	}

	private void printFilename(String name) {
		// TODO Auto-generated method stub
		System.out.println(" "+name);
		
	}
	
	public void showAllDirElements(Directory root){
		
		System.out.println(" "+root.type()+"- "+root.getName()+" "+root.getSize()+" "+root.getOwner()+" ");
		 
		Iterator<FSElement> fselements =  root.getChildren().iterator();
		while(fselements.hasNext())
		{			
			FSElement f = fselements.next();
			if(f.isLeaf()){
				System.out.println(" "+f.type()+"- "+f.getName()+" "+f.getSize()+" "+f.getOwner()+" ");
			}else{
				Directory dir = root.getDirectory(f.getName());
				displayDirChildrens(dir);
			}
		}
	}
	
	private void displayDirChildrens(Directory dir){
		System.out.println(" "+dir.type()+"- "+dir.getName()+" "+dir.getSize()+" "+dir.getOwner()+" ");
		if(dir.getSize() >0){
			for (FSElement a :dir.getChildren()){
				if(a.isLeaf()){
					System.out.println(" "+a.type()+"- "+a.getName()+" "+a.getSize()+" "+a.getOwner()+" ");
				}else if(a.getSize()>0){
					Directory dir1 = (Directory) a;
					displayDirChildrens(dir1);
				}
			}
		}
	}
	
	public void showDir() {
        if (FileSystem.getCurrent().isDir()) {
            System.out.println("Type: Directory");
        } else if (FileSystem.getCurrent().isLeaf()) {
            System.out.println("Type: File");
        } else {
            System.out.println("Type: Link");
        }
        System.out.println("Name: " + FileSystem.getCurrent().getName() + "\tSize: " + FileSystem.getCurrent().getSize() + " MB"+"\tOwner: " + FileSystem.getCurrent().getOwner());
    }
	
	public void showDir(FSElement f) {
        if (f.getCurrent().isDir()) {
            System.out.println("Type: Directory");
        } else if (f.getCurrent().isLeaf()) {
            System.out.println("Type: File");
        } else {
            System.out.println("Type: Link");
        }

        System.out.println("Name:" + f.getName() + "\tSize: " + f.getCurrent().getSize() + " MB"+"\tOwner: " + f.getCurrent().getOwner());
    }

	public static void setRoot(Directory root){
		FileSystem.rootDir = root;
	}
	
	public Directory getRoot(){
		return FileSystem.rootDir;
	}
	
	public static void setCurrent(Directory current1){
		current = current1;
	}
	
	public static Directory getCurrent(){
		return current;
	}
	
	public void setCurrent(){
		FileSystem.setCurrent(rootDir);
	}
	
	public void addChild(Directory parent,FSElement child){
		parent.addChild(child,getInsertionLocation(parent, child));
	}
	
	private int getInsertionLocation(Directory dir, FSElement element) {
		// TODO Auto-generated method stub
		ArrayList<FSElement> childrens = dir.getChildren();
		int count = childrens.size();
		return count;
	}

	public ArrayList<FSElement> getChildren(Directory current){
		return current.getChildren();
	}
	
	public ArrayList<FSElement> sort(Directory dir, Comparator<FSElement> fs1){
		 ArrayList<FSElement> chlidrens = dir.getChildren();
		 Collections.sort(chlidrens, fs1);
		 return chlidrens;
	}
	
	public void setComparator(Comparator<FSElement> compar){
		comp= compar;
	}
	
	public Comparator<FSElement> getComparator(){
		return comp;
	}
	
	public boolean containsDir(Directory current, String str) {
		// TODO Auto-generated method stub
		ArrayList<FSElement> children = current.getChildren();
		for (FSElement e:children){
			if(e.getName().equalsIgnoreCase(str)){
				return true;
			}
		}
		return false;
	}
	
	public FSElement getDir(Directory current, String str) {
		// TODO Auto-generated method stub
		ArrayList<FSElement> children = current.getChildren();
		for (FSElement e:children){
			if(e.getName().equalsIgnoreCase(str)){
				return e;
			}
		}
		return null;
	}

	public void rmDir(FSElement fsele) {
		// TODO Auto-generated method stub
		System.out.println(fsele.getName());
		current.remove(fsele);
	}

	public void createLink(FSElement fsele, FSElement to) {
		// TODO Auto-generated method stub
		 //Object a = to;
		Directory current = getCurrent();
		String name = fsele.getName();
	       Link a = new Link(current,name, fsele.getOwner(), new Date(), new Date(),1);
		a.setLink(to);
	}

	public void MoveDirectory(String from, String to, boolean remove) {
		// TODO Auto-generated method stub
		Directory root1 = getRoot();
		FSElement fromElm = null;
		FSElement toElm = null;
		Iterator<FSElement> fselements =  root1.getChildren().iterator();
		while(fselements.hasNext())
		{			
			FSElement f = fselements.next();
			if(f.isLeaf()){
				if(f.getName().equalsIgnoreCase(from)){
					fromElm = f;
				}
				if(f.getName().equalsIgnoreCase(to)){
					System.out.println("Cannot move to file!!");
					break;
				}
			}else if(f.isDir()){
				if(f.getName().equalsIgnoreCase(from)){
					Directory dir = root1.getDirectory(f.getName());
					fromElm = dir;					
				}else{
					Directory dir = root1.getDirectory(f.getName());
					getDirChildrens(dir,from);
					if(!found.isEmpty()){
						fromElm = found.get(0);
					}
				}
				if(f.getName().equalsIgnoreCase(to)){
					toElm = f;
				}else{
					Directory dir = root1.getDirectory(f.getName());
					toElm = getDirChildrens(dir,to);
				}
				
			}
		}
		Directory Director = (Directory)toElm ;
		addChild(Director, fromElm);
		if(remove == true){
			rmDir(fromElm);
		}
	}

	private FSElement getDirChildrens(Directory dir, String from) {
		// TODO Auto-generated method stub
		FSElement b = null;
		if(dir.getSize() >0){
			for (FSElement a :dir.getChildren()){				
				if(a.isLeaf() && a.getName().equalsIgnoreCase(from)){
					found.add(0, a.getCurrent());
					return a;
				}else if(a.getSize()>0 && a.isDir() && a.getName().equalsIgnoreCase(from)){
					found.add(0, a.getCurrent());
					//found.add(a);
					return a;
				}else if(a.getSize()>0 && a.isDir()){
					Directory dir1 = (Directory) a;
					b = getDirChildrens(dir1,from);
				}
			}
		}else{
			
		}
		
		return b;
	}

	public void print(ArrayList<FSElement> fsys) {
		// TODO Auto-generated method stub
        Iterator<FSElement> it = fsys.iterator();
        while (it.hasNext()) {

            FSElement next = it.next();
            Shell.print("        " + next.getName());

        }
        Shell.println("");
	}
	
}
