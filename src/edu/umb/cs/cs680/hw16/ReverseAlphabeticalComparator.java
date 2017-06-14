	package edu.umb.cs.cs680.hw16;

import java.io.Serializable;
import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReverseAlphabeticalComparator(){
		
	}

//	@Override
	public int compare(FSElement fs, FSElement fs1) {
		// TODO Auto-generated method stub
		int comp =  fs1.getName().compareToIgnoreCase(fs.getName());
		if(comp == 0){
			return -1;
		}else if(comp > 0 ){
			return 1;
		}else{
			return 0;
		}
	}

}
