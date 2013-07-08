package com.itec471.deckcalculator;

/**
 * A type to store, calculate, and return information about lumber
 * @author Jamie
 *
 */
public class Lumber extends DeckComponent{
    private String species;  // could use enum or final static String, can change later if other species are used
    private double length;
    
    // may want to add parameters or overloaded constructors
    Lumber(ComponentType name){
    	super();
    	component = name;
    	species = "Southern Pine";
    	length = 0.0;
    }

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	// this will probably need to be refined
	public String toString(){
		return component.NAME + "\t\t" + quantity + " " + (int)length + "' " + 
				material.NAME + "\t\t $" + this.getTotalPrice();
	}
}
