package chapter8;

public class Client {
	public static GroceryItemOrder[] order = new GroceryItemOrder[10];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GroceryList g1 = new GroceryList();
		g1.add(order[0]);
		//System.out.println((GroceryList.getContent(0)).toString());
	}
}
