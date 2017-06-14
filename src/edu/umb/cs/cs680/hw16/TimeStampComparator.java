package edu.umb.cs.cs680.hw16;

import java.io.Serializable;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(FSElement fs, FSElement fs1) {
		// TODO Auto-generated method stub
		return fs.getCreated().compareTo(fs1.getCreated());
		
	}
	

}
