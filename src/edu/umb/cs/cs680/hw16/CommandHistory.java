package edu.umb.cs.cs680.hw16;

import java.util.ArrayList;

public class CommandHistory extends Shell{

	public final ArrayList<String> history = new ArrayList<>();
	public CommandHistory(){
		//Empty Constructor
	}
	
	public void push(String c){
		history.add(c);
	}
	
	public Command pop(){
		return null;
		
	}
	
	public ArrayList<String> pull(){
		return history;
	}
	
	public String getLast(){
		int size = history.size();
		return history.get(size - 1);
	}
	
}
