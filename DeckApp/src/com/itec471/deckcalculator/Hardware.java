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
	private void setPrice() 
	{
		//Set the hardware's price accordingly.
		if(mHardware == R.string.hardware_hurricane_clip)
		{
			mPrice = R.string.price_hardware_hurricane_clip;
		}
		if(mHardware == R.string.hardware_joist_hanger)
		{
			mPrice = R.string.price_hardware_joist_hanger;
		}
		if(mHardware == R.string.hardware_post_cap)
		{
			mPrice = R.string.price_hardware_post_cap;
		}
		if(mHardware == R.string.hardware_post_anchor)
		{
			mPrice = R.string.price_hardware_post_anchor;
		}
		if(mHardware == R.string.hardware_flashing)
		{
			mPrice = R.string.price_hardware_flashing;
		}
		if(mHardware == R.string.hardware_holddown_anchor)
		{
			mPrice = R.string.price_hardware_holddown_anchor;
		}
	}
	
	
	/*
	*The toString method returns a string representation of the hardware object.
	*
	* @return the string representation of the hardware object
	*/	
	public String toString()
	{
		String str;
		
		str = mHardware + "\n" + mPrice;
		
		return str;		
	}
}
