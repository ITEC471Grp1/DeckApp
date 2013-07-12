package com.itec471.deckcalculator;

/*
* The Hardware class is the model in the application for hardware objects. 
*/
public class Hardware  
{
	private int mHardware; //ID for string literal of hardware name
	private int mPrice; //ID for string literal of hardware price
	
	
	/**
	 * The Hardware constructor initializes the hardware object's fields
	 * 
	 * @param hardware the hardware string resource ID
	 */
	public Hardware(int hardware)
	{
		mHardware = hardware;
		setPrice();
		
	}


	/**
	 * The getHardware returns the hardware string resource ID
	 * 
	 * @return the hardware
	 */
	public int getHardware() 
	{
		return mHardware;
	}


	/**
	 * The setHardware method uses int passed to set the hardware object's
	 * string resource ID 
	 * 
	 * @param hardware the hardware to set
	 */
	public void setHardware(int hardware) 
	{
		mHardware = hardware;
	}


	/**
	 * The getPrice method returns the price of the hardware object
	 * that is a string resource ID
	 * 
	 * @return the price
	 */
	public int getPrice() 
	{
		return mPrice;
	}


	/**
	 * The setPrice method sets the price of the hardware object
	 * that is a string resource ID
	 */
	public void setPrice() 
	{
		//to do map all prices to hardware
		if(mHardware == R.string.hardware_post_cap)
		{
			mPrice = R.string.price_hardware_post_cap;
		}
		if(mHardware == R.string.hardware_post_anchor)
		{
			mPrice = R.string.price_hardware_post_anchor;
		}
	}	
}
