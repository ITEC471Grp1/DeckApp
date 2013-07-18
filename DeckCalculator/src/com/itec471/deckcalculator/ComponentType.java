package com.itec471.deckcalculator;

//this list is not complete
//  it will contain a type 
//  for every component
//  including lumber, hardware,
//  flashing, concrete
public enum ComponentType {
	UNKNOWN ("Unknown"),
	SPAN_RATED_DECKING ("Span rated decking"),  
	TWO_BY_FOUR ("2 x 4"),
	TWO_BY_SIX ("2 x 6"), 
	TWO_BY_EIGHT ("2 x 8"),
	TWO_BY_TEN ("2 x 10"),
	TWO_BY_TWELVE ("2 x 12"), 
	FOUR_BY_FOUR ("4 x 4"), 
	SIX_BY_SIX ("6 x 6"),
	EIGHT_D_THREADED_NAILS ("8d threaded nails"),
	NO_EIGHT_WOOD_SCREWS ("#8 wood screws");	
	
	public final String NAME;	// used for string output
	
	ComponentType(String name){
		NAME = name;
	}
}
