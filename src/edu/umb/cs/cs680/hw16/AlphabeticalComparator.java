package edu.umb.cs.cs680.hw16;

import java.io.Serializable;
import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> , Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AlphabeticalComparator(){
	}

//	@Override
	public int compare(FSElement fs, FSElement fs1) {
		// TODO Auto-generated method stub
		int comp =  fs.getName().compareTo(fs1.getName());
		if(comp == 0){
			return -1;
		}else if(comp > 0 ){
			return 1;
		}else{
			return 0;
		}
	}


}
