package com.itec471.deckcalculator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import android.content.res.AssetManager;

//*******This class is not complete. Need to add methods to calculate all hardware and lumber.********
//		**************************Will be done in future sprints********************************

/**
 * Calculates the materials needed for the 
 *   given configuration
 * @author ITEC 471
 *
 */
public class MaterialsCalculator { 
	private DeckModel deckModel;
	List<String>  totaledList;
	private double totalPrice;
	private static AssetManager assetManager;
	
	/**
	 * Private constructor for singleton class
	 */
	private MaterialsCalculator(){
		deckModel = DeckModel.getInstance();
		totaledList = new ArrayList<String>();
		totalPrice = 0.0;		
	}
	
	/**
	 * Holder for the singleton instance
	 *
	 */
	private static class CalcHolder{
		public static final MaterialsCalculator INSTANCE = new MaterialsCalculator();
	}
	
	/**
	 * Access for singleton instance
	 * @return The singleton instance
	 */
	public static MaterialsCalculator getInstance(){
		MaterialsCalculator calc = CalcHolder.INSTANCE;
		return calc;
	}
	
	/**
	 * Access for singleton instance
	 * @param assetMger
	 * @return The singleton instance
	 */
	public static MaterialsCalculator getInstance(AssetManager assetMger){
		MaterialsCalculator calc = CalcHolder.INSTANCE;
		assetManager = assetMger;
		return calc;
	}
	
	/**
	 * Initiates all calculations for the deck 
	 * @return A list of materials and costs
	 */
	public List<String> calculateMaterials(){
		calculateDecking();
	//	calculateJoists();
	//	calculateRimJoists();
	//	calculateBeams();
	//	calculatePosts();
	//	calculateJoistHangers();
	//	calculateNoEightWoodScrews();
		
		// to do...add calculate methods for other lumber
		//  and hardware that will do calculations and
		//  add to totalPrice, totaledList, and set deckModel
		
		return totaledList;
	}
	
	/**
	 * Builds a string for outputting the total square feet
	 * @return  The string to be output
	 */
	public String getSquareFeetString(){
		NumberFormat formatter = NumberFormat.getNumberInstance();
    	formatter.setMaximumFractionDigits(1);
    	String sqft = formatter.format(deckModel.getSqft());
    	String areaMsg = ("Total Square Feet: " + sqft);
    	return areaMsg;
	}
	
	/**
	 * Builds a string for outputting the total cost of the deck
	 * @return	The string to be output
	 */
	public String getPriceString(){
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String totalPrice = formatter.format(this.getTotalPrice());
    	String priceMsg = ("Total Price: " + totalPrice);    	
    	return priceMsg;
	}
	
	/**
	 * Gets the double value for the total cost of the deck
	 * @return	The double value
	 */
	public double getTotalPrice(){
		return totalPrice;
	}
	
	/**
	 * Calculates the length and quantity of decking boards
	 *  required for the input deck dimensions, and calls
	 *  a method to calculate the fasteners for the decking
	 */
	private void calculateDecking(){
		final double boardWidth = 5.625;					// the width of a decking board
		final double gap = .125;							// the required gap between boards
		Lumber decking = new Lumber(ComponentType.DECKING); 
		double deckLen = deckModel.getLength();
		double deckWidth = deckModel.getWidth();
		double boardLen = 0;							// will be assigned the required board length		
		double waste = 192;								// initialized to the widest available board
		double[] boardLengths = {192, 144, 120, 96}; 	// available board lengths
		int boardsPerSpan = 1;				// number of boards needed to span the width of the deck
		int temp;							// temporary variable
		int qty;							// number of boards needed to span the width and length of the deck
		
		// set the type of decking material
		decking.setMaterialType(deckModel.getDeckingType());
		
		// calculate the quantity of boards needed
		for (double brdLen : boardLengths){
			// if the deck is not wider than the longest available board
			if (deckWidth <= 192){
				// choose the shortest board that will span the deck
				if (brdLen >= deckWidth){
						waste = brdLen % deckWidth;						
						boardLen = brdLen;					
				}
			}
			// the deck is wider than the longest available board
			else{
				// get the number of boards needed to span the deck
				temp = (int) Math.ceil(deckWidth / brdLen);
				
				// choose the board that will result in the least amount of waste
				if ((brdLen * temp) % deckWidth < waste){
					boardsPerSpan = temp;
					waste = (brdLen * boardsPerSpan) % deckWidth;
					boardLen = brdLen;
				}
			}
		}
		// set the board length in feet
		decking.setLength(boardLen / 12);
		
		// get the number of boards needed for the decking
		qty = (int) Math.ceil((deckLen + gap) / (boardWidth + gap) * boardsPerSpan);
		decking.setCount(qty);
		
		// get the unit price of the boards
		decking.setUnitPrice(MaterialPrices.getPrice(decking.material.NAME, decking.getLength(), assetManager));
		
		// add the decking cost to the total deck cost
		totalPrice += decking.getTotalPrice();
		
		// add the decking to the materials list
		totaledList.add(decking.getNameAndCost());
		totaledList.add(decking.getQuantityAndDescription());
		deckModel.setDecking(decking);
		
		// get the screws needed for the decking
		calculateNoEightWoodScrews();
	}
	
	/**
	 * incomplete method to be implemented in future sprint
	 */
	private void calculateJoists(){
		Lumber joists = new Lumber(ComponentType.JOISTS);
		
			// to do...calculate the length, count and
			//  total price for joists and set these
			//  values in the joists variable.....
		
		totalPrice += joists.getTotalPrice();
		totaledList.add(joists.getNameAndCost());
		totaledList.add(joists.getQuantityAndDescription());
		deckModel.setJoists(joists);
	}
	
	/**
	 * incomplete method to be implemented in future sprint
	 */
	private void calculateRimJoists(){
		Lumber rimJoists = new Lumber(ComponentType.RIM_JOISTS);
		
			// to do...calculate the length, count and
			//  total price for rim joists and set these
			//  values in the rimJoists variable.....
		
		totalPrice += rimJoists.getTotalPrice();
		totaledList.add(rimJoists.getNameAndCost());
		totaledList.add(rimJoists.getQuantityAndDescription());
		deckModel.setRimJoists(rimJoists);
	}
	
	/**
	 * incomplete method to be implemented in future sprint
	 */
	private void calculateBeams(){
		Lumber beams = new Lumber(ComponentType.BEAMS);
		
			// to do...calculate the length, count and
			//  total price for beams and set these
			//  values in the beams variable.....
		
		totalPrice += beams.getTotalPrice();
		totaledList.add(beams.getNameAndCost());
		totaledList.add(beams.getQuantityAndDescription());
		deckModel.getBeams();
	}
	
	/**
	 * incomplete method to be implemented in future sprint
	 */
	private void calculatePosts(){
		Lumber posts = new Lumber(ComponentType.POSTS);
		
			// to do...calculate the length, count and
			//  total price for posts and set these
			//  values in the posts variable.....
		
		totalPrice += posts.getTotalPrice();
		totaledList.add(posts.getNameAndCost());
		totaledList.add(posts.getQuantityAndDescription());
		deckModel.setPosts(posts);
	}
	
	/**
	 * incomplete method to be implemented in future sprint
	 */
	private void calculateJoistHangers(){
		Hardware joistHangers = new Hardware(ComponentType.JOIST_HANGERS);
		
		// in our finished method we would need to pick the quantity and type of
		//  hanger based on the joist quantity and size. for now I'm just setting it
		//  to demonstrate how it would work. the program should now output a list
		//  that will include 30 of this type of joist hanger, with a total cost
		joistHangers.setMaterialType
			(MaterialType.TWO_INCH_X_TEN_TWELVE_INCH_SLANT_NAIL_JOIST_HANGER);
		joistHangers.setCount(30);
		
		// We will be getting this info from either the database or a flat file
		//  for now, I'm just hard-coding it so the total price won't be $0.00
		joistHangers.setUnitPrice(1.52);
		
		totalPrice += joistHangers.getTotalPrice();
		totaledList.add(joistHangers.getNameAndCost());
		totaledList.add(joistHangers.getQuantityAndDescription());
		deckModel.setJoistHangers(joistHangers);
	}
	
	/**
	 * Calculates the number of wood screws needed for the decking
	 */
	private void calculateNoEightWoodScrews(){
		Hardware noEightWoodScrews = new Hardware(ComponentType.FASTENERS);
		noEightWoodScrews.setMaterialType(MaterialType.TWO_IN_NO_EIGHT_WOOD_SCREWS);
		noEightWoodScrews.setUnitPrice(MaterialPrices.getPrice(noEightWoodScrews.material.NAME, assetManager));	
		double amtPerSqFt = (4);	// the number of screws needed per square ft of decking
		
		// get the number of screws needed
		int quantity = (int) (amtPerSqFt  * deckModel.getSqft());		
		noEightWoodScrews.setCount(quantity);
		
		// add the cost of the screws to the cost of the deck
		totalPrice += noEightWoodScrews.getTotalPrice();
		
		// add the screws to the list of materials
		totaledList.add(noEightWoodScrews.getNameAndCost());
		totaledList.add(noEightWoodScrews.getQuantityAndDescription());
		deckModel.setNoEightWoodScrews(noEightWoodScrews);
	}
}
