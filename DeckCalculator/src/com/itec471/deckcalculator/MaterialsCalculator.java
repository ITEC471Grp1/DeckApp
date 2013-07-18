package com.itec471.deckcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculates the materials needed for the 
 *   given configuration
 * @author Jamie
 *
 */
//again, this class is not complete. This is a template of how it could work.
// need to calculate hardware as well as lumber.
public class MaterialsCalculator { 
	private Configuration config;
	List<String>  totaledList;
	private double totalPrice;
	
	public MaterialsCalculator(Configuration configuration){
		config = configuration;
		totaledList = new ArrayList<String>();
		totalPrice = 0.0;
	}
	
	public List<String> calculateLumber(){
		calculateDecking();
		calculateJoists();
		calculateRimJoists();
		calculateBeams();
		calculatePosts();
		
		// to do...add calculate methods for other lumber
		//  and hardware that will do calculations and
		//  add to totalPrice, totaledList, and set config
		
		return totaledList;
	}
	
	public double getTotalPrice(){
		return totalPrice;
	}
	
	private void calculateDecking(){
		Lumber decking = new Lumber();
		
			// to do...calculate the length, count and
			//  total price for decking and set these
			//  values in the decking variable.....
		
		totalPrice += decking.getTotalPrice();
		totaledList.add(decking.toString());
		config.setDecking(decking);
	}
	
	private void calculateJoists(){
		Lumber joists = new Lumber();
		
			// to do...calculate the length, count and
			//  total price for joists and set these
			//  values in the joists variable.....
		
		totalPrice += joists.getTotalPrice();
		totaledList.add(joists.toString());
		config.setJoists(joists);
	}
	
	private void calculateRimJoists(){
		Lumber rimJoists = new Lumber();
		
			// to do...calculate the length, count and
			//  total price for rim joists and set these
			//  values in the rimJoists variable.....
		
		totalPrice += rimJoists.getTotalPrice();
		totaledList.add(rimJoists.toString());
		config.setRimJoists(rimJoists);
	}
	
	private void calculateBeams(){
		Lumber beams = new Lumber();
		
			// to do...calculate the length, count and
			//  total price for beams and set these
			//  values in the beams variable.....
		
		totalPrice += beams.getTotalPrice();
		totaledList.add(beams.toString());
		config.getBeams();
	}
	
	private void calculatePosts(){
		Lumber posts = new Lumber();
		
			// to do...calculate the length, count and
			//  total price for posts and set these
			//  values in the posts variable.....
		
		totalPrice += posts.getTotalPrice();
		totaledList.add(posts.toString());
		config.setPosts(posts);
	}
}
