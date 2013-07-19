package com.itec471.deckcalculator;
// Jamie 7/14 changed
//Matt 7/18 update check

public enum ComponentType {
	UNKNOWN ("Unknown"),
	DECKING ("Decking"), 
	JOISTS ("Joists"),
	RIM_JOISTS ("Rim Joists"),
	BEAMS ("Beams"),
	POSTS ("Posts"),
	FASTENERS ("Fasteners"),
	JOIST_HANGERS ("Joist Hangers");
	
	public final String NAME;
	
	ComponentType(String name){
		NAME = name;		
	}
}
