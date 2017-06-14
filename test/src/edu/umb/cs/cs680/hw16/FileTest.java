package edu.umb.cs.cs680.hw16;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.util.Date;

public class FileTest {
	
	private static Directory root = new Directory(null, "root", "MAK", new Date(), null, 210);
	private static Directory system = new Directory(root, "System", "MAK", new Date(),null, 100);
	private static Directory home = new Directory(root, "Home", "MAK", new Date(),null, 100);
	private static Directory pictures = new Directory(home, "pictures", "MAK", new Date(),null, 50);
	private FileSystem fs = FileSystem.getFileSystem();
	//fs.setRoot(root);
    //fs.setCurrent(root);
    private static File a = new File(system, "a.txt","MAK", new Date(),null, 10);
	private static File b = new File(system, "b.png","MAK", new Date(),null, 20);
	private static File c = new File(system, "c.txt","MAK", new Date(),null, 30);
	private static File d = new File(home, "d.png","MAK", new Date(),null, 10);
	private static File e = new File(pictures, "e.txt","MAK", new Date(),null, 10);
	private static File f =  new File(pictures, "f.txt","MAK", new Date(),null, 15);
	private static File test = new File(root, "test","MAK", new Date(), null, 10);
	private static Link x = new Link(home,"x", "MAK", new Date(),null,15);
	private static Link y = new Link(pictures,"y", "MAK", new Date(),null,15);
	//x.setLink(system);
	//y.setLink(e);
	@Test
	public void testConstructors(){

		assertThat(root.getName(), is("root"));
		assertThat(system.getName(), is("System"));
		assertThat(home.getName(), is("Home"));
		
	}
	@Test
	public void testGetSize(){
		assertThat(root.getSize(), is(135));
		assertThat(x.getSize(), is(15));
		assertThat(y.getSize(), is(15));
	}
	
	@Test
	public void testGetTargetSize(){
		x.setLink(system);
		y.setLink(e);
		assertThat(x.getTargetSize(), is(60));
		assertThat(y.getTargetSize(), is(10));
	}
	
	@Test
    public void testIsDire() {
        boolean expResult = true;
        boolean result = root.isDir();
        assertThat(result, is( expResult));
        
    }
	
	@Test
    public void testIsFile() {
        boolean expResult = true;
        boolean resultA = a.isLeaf();
        boolean resultB = b.isLeaf();
        boolean resultC = c.isLeaf();
        boolean resultD = d.isLeaf();
        boolean resultE = e.isLeaf();
        boolean resultF = f.isLeaf();
        boolean resultG = test.isLeaf();
        assertThat(expResult, is( resultA));
        assertThat(expResult, is( resultB));
        assertThat(expResult, is( resultC));
        assertThat(expResult, is( resultD));
        assertThat(expResult, is( resultE));
        assertThat(expResult, is( resultF));
        assertThat(expResult, is( resultG));
        
    }
	
	 @Test
	    public void testGetFilename() {
	        String result = home.getName();
	        assertThat(result, is("Home"));
	        
	    }
	 
}
