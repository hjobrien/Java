package chapter8;

import java.text.DecimalFormat;

//Hank O'Brien
//hank.obrien900@icloud.com

public class GroceryItemOrder {
	private String itemName;
	private int itemQuantity;
	private double pricePerUnit;
	
	/**
	 * 
	 * @param name is the name of the item
	 * @param quantity the number of items
	 * @param pricePerUnit the cost per unit 
	 */
	public GroceryItemOrder(String name, int quantity, double pricePerUnit){
		itemName = name;
		itemQuantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}
	
	/**
	 * 
	 * @return the total cost of the list
	 */
	public double getCost(){
		int cost = 0;
		for(int i = 0; i < itemQuantity; i++){
			cost += pricePerUnit;
		}
		return cost;
	}
	
	/**
	 * 
	 * @param allows the user to set the quantity of the items
	 */
	public void setQuantity(int quantity){
		itemQuantity = quantity;
	}
	
	/**
	 * 
	 * @return the items name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * 
	 * @return the item quantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	/**
	 * returns a reresentation of the obect of type String
	 */
	public String toString(){
		DecimalFormat df = new DecimalFormat();
		return itemQuantity + " " + itemName + " @ $" + df.format(pricePerUnit) + "ea total = $" + getCost();
	}
}
