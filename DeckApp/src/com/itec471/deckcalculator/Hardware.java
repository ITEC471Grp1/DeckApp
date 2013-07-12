package com.itec471.deckcalculator;


public class Hardware  
{
	private int mHardware;
	private int mPrice;
	
	
	/**
	 * @param hardware the hardware string resource id 
	 */
	public Hardware(int hardware)
	{
		mHardware = hardware;
		setPrice();
		
	}


	/**
	 * @return the hardware
	 */
	public int getHardware() 
	{
		return mHardware;
	}


	/**
	 * @param hardware the hardware to set
	 */
	public void setHardware(int hardware) 
	{
		mHardware = hardware;
	}


	/**
	 * @return the price
	 */
	public int getPrice() 
	{
		return mPrice;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice() 
	{
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
