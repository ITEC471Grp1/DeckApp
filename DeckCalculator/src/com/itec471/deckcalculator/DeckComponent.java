package com.itec471.deckcalculator;

/**
 * This class should be extended by the Lumber
 *  and Hardware classes.
 * @author Jamie
 */
public abstract class DeckComponent {
	protected ComponentType component;
	protected MaterialType material;
	protected int quantity;
	private double unitPrice;
	
	public DeckComponent(){
		component = ComponentType.UNKNOWN;
		material = MaterialType.UNKNOWN;
		quantity = 0;
		unitPrice = 0.0;
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
}
