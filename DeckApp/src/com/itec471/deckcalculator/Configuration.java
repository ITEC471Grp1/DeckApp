package com.itec471.deckcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to store information about a deck
 * @author Jamie
 *
 */

// This class is not complete. Will need additional variables and methods,
//  but I hope the concept is clear. This is the class that will be used
//  to store all information about a particular deck configuration.
public class Configuration {
	private final static double CONVERSION_FACTOR = 144.0; // for converting from sq inches to sq feet
	private double length;
	private double width;
	private double height;
	private double sqft;
	private Lumber decking;
	private Lumber joists;
	private Lumber rimJoists;
	private Lumber beams;
	private Lumber posts;
	private List<DeckComponent> componentList; // the setter method for each lumber and hardware 
									 //  variable needs to add that variable to this list
	
	private Configuration(){
	}
	
	private static class ConfigurationHolder{
		public static final Configuration INSTANCE = new Configuration();
	}
	
	public static Configuration getInstance(double len, double wdth, double hght){
		Configuration config = ConfigurationHolder.INSTANCE;
		config.setLength(len);
		config.setWidth(wdth);
		config.setHeight(hght);
		config.setSqft(wdth * len / CONVERSION_FACTOR);
		config.componentList = new ArrayList<DeckComponent>();
		
		return config;		
	}
	
	public static Configuration getInstance(){
		return ConfigurationHolder.INSTANCE;
	}

	public double getLength() {
		return length;
	}
	
	public void setLength(double len) {
		this.length = len;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double wdth) {
		this.width = wdth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double hght) {
		this.height = hght;
	}

	public double getSqft() {
		return sqft;
	}

	public void setSqft(double sqft) {
		this.sqft = sqft;
	}
	
	// we may not need any of the getter methods for components
	//  as they are accessed through the componentList
	//  can remove later if this proves true
	public Lumber getDecking() {
		return decking;
	}

	public void setDecking(Lumber decking) {
		this.decking = decking;
		componentList.add(decking);
	}

	public Lumber getJoists() {
		return joists;
	}

	public void setJoists(Lumber joists) {
		this.joists = joists;
		componentList.add(joists);
	}

	public Lumber getRimJoists() {
		return rimJoists;
	}

	public void setRimJoists(Lumber rimJoists) {
		this.rimJoists = rimJoists;
		componentList.add(rimJoists);
	}

	public Lumber getBeams() {
		return beams;
	}

	public void setBeams(Lumber beams) {
		this.beams = beams;
		componentList.add(beams);
	}

	public Lumber getPosts() {
		return posts;
	}

	public void setPosts(Lumber posts) {
		this.posts = posts;
		componentList.add(posts);
	}
}
