package com.itec471.deckcalculator;

/*
* The Hardware class is the model in the application for hardware objects. 
*/
public class Hardware extends ComponentModel 
{
	public Hardware(ComponentType type)
	{
		super();
		component = type;		
	}

	public String getQuantityAndDescription()
	{
		return "\t\t(" + quantity + ") " + material.NAME;		
	}
}
