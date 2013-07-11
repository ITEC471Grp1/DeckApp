package com.itec471.deckcalculator;

public enum ComponentType {
	UNKNOWN ("Unknown"),
	DECKING ("Decking"), 
	JOISTS ("Joists"),
	RIM_JOISTS ("Rim Joists"),
	BEAMS ("Beams"),
	POSTS ("Posts");
	
	public final String NAME;
	
	ComponentType(String name){
		NAME = name;		
	}
}
