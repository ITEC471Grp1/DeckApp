package com.itec471.deckcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to store information about a deck
 * @author ITEC-471 Grp2
 *
 */

//  This is the class that will be used to store all information about a
//   particular deck configuration. More variables will be added 
//   as functionality is added.
public class DeckModel {
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
	private Hardware joistHangers;
	private Hardware noEightWoodScrews;
	private List<ComponentModel> componentList; 
	private MaterialType deckingType;				
									 
	/**
	 * Private constructor for singleton instance
	 */
	private DeckModel(){
	}
	
	/**
	 * Holder for the singleton instance
	 * @author ITEC-471 Grp2
	 *
	 */
	private static class DeckModelHolder{
		public static final DeckModel INSTANCE = new DeckModel();
	}
	
	/**
	 * This method is called when the user inputs new parameters
	 * @param len	The deck length
	 * @param wdth	The deck width
	 * @param hght	The deck height
	 * @return		The DeckModel Instance
	 */
	public static DeckModel getInstance(double len, double wdth, double hght){
		DeckModel deckModel = DeckModelHolder.INSTANCE;
		deckModel.setLength(len);
		deckModel.setWidth(wdth);
		deckModel.setHeight(hght);
		deckModel.setSqft(wdth * len / CONVERSION_FACTOR);
		deckModel.componentList = new ArrayList<ComponentModel>();
		
		return deckModel;		
	}
	
	/**
	 * This method is called when calculated information is needed
	 * @return	The DeckModel Instance
	 */
	public static DeckModel getInstance(){
		return DeckModelHolder.INSTANCE;
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
	
	public Hardware getJoistHangers(){
		return joistHangers;
	}
	
	public void setJoistHangers(Hardware joistHangers) {
		this.joistHangers = joistHangers;		
	}
	
	public Hardware getNoEightWoodScrews(){
		return noEightWoodScrews;
	}

	public void setNoEightWoodScrews(Hardware noEightWoodScrews) {
		this.noEightWoodScrews = noEightWoodScrews;		
	}
	
	public MaterialType getDeckingType() {
		return deckingType;
	}

	public void setDeckingType(MaterialType type) {
		this.deckingType = type;		
	}	
}
