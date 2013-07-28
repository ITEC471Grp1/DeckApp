package com.itec471.deckcalculator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import android.content.res.AssetManager;
import android.util.Log;

/**
 * Reads list of materials and prices from a file and returns
 *  the price of the parameter material if found in the list
 *  
 * @author ITEC471-Grp2
 *
 */
public final class MaterialPrices{
	
	/**
	 * Finds a price for a material with a description only
	 * @param material
	 * @param assetManager
	 * @return The material price
	 */
	public static double getPrice(String material, AssetManager assetManager){
		double price = 0;
		
		try{
			// file containing prices
			InputStream in = assetManager.open("prices.csv");
			
			// create BufferedReader to read file
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";
			String token;
			StringTokenizer st = null;
			boolean found = false;
			
			// read comma separated file line by line
			while((strLine = br.readLine()) != null){
				
				// break comma separated line
				st = new StringTokenizer(strLine, ",");
				
				while(st.hasMoreTokens()){
					
					// if the material was found
					if (found){
						price = Double.valueOf(st.nextToken());
					}
					else{
						// if this is the material
						token = st.nextToken();
						found = (token.equalsIgnoreCase(material));
					}					
				}
				// if the price is found end the loop
				if (found){
					break;
				}
			}
			// close the reader
			br.close();
			
		}catch (Exception e){
			// log if the price isn't found
			String tag = "MaterialsPrices";
			Log.e(tag , "File not found");
		}	
		
		return price;
	}
	
	/**
	 * Finds the price of a material with a description and a length
	 * @param material
	 * @param len
	 * @param assetManager
	 * @return  The material price
	 */
	public static double getPrice(String material, double len, AssetManager assetManager){
		double price = 0;
		
		try{
			// file containing prices
			InputStream in = assetManager.open("prices.csv");
			
			// create BufferedReader to read file
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";
			String token;
			StringTokenizer st = null;
			boolean foundMaterial = false, foundLen = false;
			
			// read comma separated file line by line
			while((strLine = br.readLine()) != null){
				
				// break comma separated line
				st = new StringTokenizer(strLine, ",");
				
				while(st.hasMoreTokens()){
					
					// if the material was found
					if (foundMaterial){
						if (foundLen){
							price = Double.valueOf(st.nextToken());
						}
						else{
							token = st.nextToken();
							foundLen = (Double.valueOf(token) == len);
						}
					}
					else{
						// if this is the material
						token = st.nextToken();
						foundMaterial = (token.equalsIgnoreCase(material));
					}					
				}
				// if the price is found end the loop
				if (foundMaterial && foundLen){
					break;
				}
			}
			// close the reader
			br.close();
			
		}catch (Exception e){
			// log if the price isn't found
			String tag = "MaterialsPrices";
			Log.e(tag , "File not found");
		}	
		
		return price;
	}
}



