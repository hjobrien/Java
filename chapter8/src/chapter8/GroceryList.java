//Hank O'Brien
//hank.obrien900@icloud.com
package chapter8;

import java.util.Arrays;


public class GroceryList {
	private static final int SIZE_OF_LIST = 10;
	
	private GroceryItemOrder[] list;// = new GroceryItemOrder[SIZE_OF_LIST];
	private int lowestOpenSlot;
	
	/**
	 * is the default constructor for a GroceryList object
	 */
	public GroceryList(){
		lowestOpenSlot = 0;
		list = new GroceryItemOrder[SIZE_OF_LIST];
	}
	
	/**
	 * 
	 * @param item a GroceryItemOrder object which will be added to this class
	 */
	public void add(GroceryItemOrder item){
		if(lowestOpenSlot < 10){
			list[lowestOpenSlot] = item;
			lowestOpenSlot++;
		}
		else{
			System.out.println("Grocery List is Full");
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(list);
		result = prime * result + lowestOpenSlot;
		return result;
	}
	/**
	 * determines if 'this' and the passed object contains equal values
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GroceryList))
			return false;
		GroceryList other = (GroceryList) obj;
		if (!Arrays.equals(list, other.list))
			return false;
		if (lowestOpenSlot != other.lowestOpenSlot)
			return false;
		return true;
	}

	/**
	 * 
	 * @returns the total cost of all of the items in the list
	 */
	public double getTotalCost(){
		double total = 0.0;
		for(int i = 0; i < lowestOpenSlot; i++){
			total += list[i].getCost();
		}
		return total;
	}
	
	/**
	 * CURRENTLY NOT USED. WAS USED FOR DEBUGGING ONLY
	 * @param location is the index of the array
	 * @return a GroceryItemOrder object
	 * only for debugging purposes, not used in JUnit or other methods
	 */
	public GroceryItemOrder getContent(int location){
		return list[location];
	}
}
