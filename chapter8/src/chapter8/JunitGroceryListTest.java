//Hank O'Brien
//hank.obrien900@icloud.com
package chapter8;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class JunitGroceryListTest {
	
	private final static int MAX_ITEMS = 10;
	private static GroceryItemOrder[] groceryOrders = new GroceryItemOrder[MAX_ITEMS];
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < groceryOrders.length; i++) {
			groceryOrders[i] = new GroceryItemOrder("" + (i + 1) , (i + 1), (i + 1));
			System.out.println(groceryOrders[i]);
		}
	}

	@Test
	public void testGroceryList() {
		GroceryList gl1 = new GroceryList();	
		assertEquals("test constructor()", 0.0, gl1.getTotalCost(), .001);
	}

	@Test
	public void testAdd() {
		GroceryList gl1 = new GroceryList();
		gl1.add(groceryOrders[0]);
		assertEquals("test Add()", 1.0, gl1.getTotalCost(), .001);
		
		for (int i = 1; i < groceryOrders.length; i++) {
			gl1.add(groceryOrders[i]);
		}
		System.out.println(gl1.getTotalCost());
		assertEquals("test Add()", 385.0, gl1.getTotalCost(), .001);
	
		// try to add another item
		gl1.add(groceryOrders[9]);
		assertEquals("test Add()", 385.0, gl1.getTotalCost(), .001);
	}

	@Test
	public void testGetTotalCost() {
		GroceryList gl1 = new GroceryList();
		gl1.add(groceryOrders[9]);
		assertEquals("test GetTotalCost()", 100.0, gl1.getTotalCost(), .001);
	}
	
	@Test
	public void testGetCost() {
		GroceryList gl1 = new GroceryList();
		gl1.add(groceryOrders[9]);
		assertEquals("test GetCost() of GroceryOrder", 100.0, groceryOrders[9].getCost(), .001);
	}

	@Test
	public void testSetQuantity() {
		GroceryList gl1 = new GroceryList();
		GroceryItemOrder go = new GroceryItemOrder("dummy", 35, 6.25);
		gl1.add(go);
		go.setQuantity(0);
		
//		gl1.add(groceryOrders[9]);
//		groceryOrders[9].setQuantity(0);
		assertEquals("test SetQuantity() of GroceryOrder", 0.0, go.getCost(), .001);
	}
	
	@Test
	public void testGroceryListEquality() {
		GroceryList gl1 = new GroceryList();
		gl1.add(groceryOrders[3]);
		GroceryList gl2 = new GroceryList();
		gl2.add(groceryOrders[3]);
		assertEquals("test equals() of GroceryOrder", true, gl1.equals(gl2));
		gl2.add(groceryOrders[3]);
		assertEquals("test equals() of GroceryOrder", false, gl1.equals(gl2));
	}
}
