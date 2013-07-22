package com.itec471.deckcalculator;

import java.text.NumberFormat;

/**
 * This class should be extended by the Lumber
 *  and Hardware classes.
 * @author Jamie
 */
public abstract class ComponentModel {
	protected ComponentType component;
	protected MaterialType material;
	protected int quantity;
	private double unitPrice;
	
	public ComponentModel(){
		component = ComponentType.UNKNOWN;
		material = MaterialType.UNKNOWN;
		quantity = 0;
		unitPrice = 0.0;
	}
	
	public MaterialType getMaterialType(){
		return material;
	}
	
	public void setMaterialType(MaterialType mat){
		material = mat;
	}
	
	public int getCount() {
		return quantity;
	}

	public void setCount(int count) {
		this.quantity = count;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return quantity * unitPrice;
	}
	
	public String getNameAndCost(){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String cost = formatter.format(this.getTotalPrice());
		return "\t" + component.NAME + ":  " + cost;
	}
}
