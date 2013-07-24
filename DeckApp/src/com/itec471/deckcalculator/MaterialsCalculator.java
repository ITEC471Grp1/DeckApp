package com.itec471.deckcalculator;
// Another comment Jamie 7/18

import java.util.ArrayList;
import java.util.List;

/**
 * Calculates the materials needed for the 
 *   given configuration
 * @author ITEC 471
 *
 */
//again, this class is not complete. This is a template of how it could work.
// need to calculate hardware as well as lumber.
public class MaterialsCalculator { 
	private DeckModel deckModel;
	List<String>  totaledList;
	private double totalPrice;
	
	public MaterialsCalculator(DeckModel configuration){
		deckModel = configuration;
		totaledList = new ArrayList<String>();
		totalPrice = 0.0;
	}
	
	public List<String> calculateMaterials(){
		calculateDecking();
	//	calculateJoists();
	//	calculateRimJoists();
	//	calculateBeams();
	//	calculatePosts();
		calculateJoistHangers();
		calculateNoEightWoodScrews();
		
		// to do...add calculate methods for other lumber
		//  and hardware that will do calculations and
		//  add to totalPrice, totaledList, and set config
		
		return totaledList;
	}
	
	public double getTotalPrice(){
		return totalPrice;
	}
	
	// I had this working but thanks to GitHub I lost it
	//  If I can ever figure out this stuff, I will re-implement
	private void calculateDecking(){
		Lumber decking = new Lumber(ComponentType.DECKING);
		
			// to do...calculate the length, count and
			//  total price for decking and set these
			//  values in the decking variable.....
		
		totalPrice += decking.getTotalPrice();
		totaledList.add(decking.getNameAndCost());
		totaledList.add(decking.getQuantityAndDescription());
		deckModel.setDecking(decking);
	}
	
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
	
	private void calculateNoEightWoodScrews(){
		Hardware noEightWoodScrews = new Hardware(ComponentType.FASTENERS);
		noEightWoodScrews.setMaterialType(MaterialType.NO_EIGHT_WOOD_SCREWS);
		
		noEightWoodScrews.setUnitPrice(0.061);
		
	
		
		double amtPerSqFt = (4);
		// to do...calculate the number of boxes of #8
			//  wood screws, the total price, and set these
			//  values in the noEightWoodScrews variable
		int quantity = (int) (amtPerSqFt  * deckModel.getSqft());		 
		
		noEightWoodScrews.setCount(quantity);
		totalPrice += noEightWoodScrews.getTotalPrice();				
		totaledList.add(noEightWoodScrews.getNameAndCost());
		totaledList.add(noEightWoodScrews.getQuantityAndDescription());
		deckModel.setNoEightWoodScrews(noEightWoodScrews);
	}
}
