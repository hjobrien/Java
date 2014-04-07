package programming_projects;
//Aaron Vargo
//aaronmvargo@gmail.com

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.textui.TestRunner;

import org.junit.Test;

public class RationalNumberTest {

	@Test
	public void testRationalNumber() {
		RationalNumber test1 = new RationalNumber();
		assertEquals("Default numerator", 0, test1.getNumerator());
		assertEquals("Default denominator", 1, test1.getDenominator());
	}

	@Test
	public void testRationalNumberIntInt() {
		RationalNumber test = new RationalNumber(3, 2);
		assertEquals("Numerator", 3, test.getNumerator());
		assertEquals("Denominator", 2, test.getDenominator());
		RationalNumber test1 = new RationalNumber(5, -3);
		assertEquals("Negative denominator: numerator", -5, test1.getNumerator());
		assertEquals("Negative denominator: denominator", 3, test1.getDenominator());
		RationalNumber test2 = new RationalNumber(3, 6);
		try {
			assertEquals("Reduction: numerator", 1, test2.getNumerator());
			assertEquals("Reduction: denominator", 2, test2.getDenominator());	
		} catch (AssertionError e) {
			if (test2.equals(new RationalNumber(1,2))) 
				fail("Reduction is included in the equals method but not the constructor");
			else throw e;
		}
		RationalNumber test3 = new RationalNumber(100876, -12596);
		assertEquals("Reduction with negative denominator: numerator", -25219, test3.getNumerator());
		assertEquals("Reduction with negative denominator: denominator", 3149, test3.getDenominator());
		try {
			new RationalNumber(-17, 0);
			fail("0 denominator");
		} catch (IllegalArgumentException e) {
		}

	}

	@Test
	//In the case reduction is incorrectly included in the equals method rather than the constructor
	//this test will pass but testRationalNumberIntInt() will fail
	public void testEqualsObject() {
		RationalNumber num = new RationalNumber(3, 6);
		RationalNumber num1 = new RationalNumber(3, 6);
		RationalNumber num2 = new RationalNumber(5, -3);
		assertTrue("Equal", num.equals(num1));
		assertTrue("Not Equal", !num1.equals(num2));
	}

	@Test
	public void testAdd() {
		RationalNumber test1A = new RationalNumber(9, -3);
		RationalNumber test1B = new RationalNumber(7, 2);
		RationalNumber result = test1A.add(test1B);
		int expectedNumerator1 = 1;
		int expectedDenominator1 = 2;
		assertEquals("Add", expectedNumerator1/(double)expectedDenominator1, result.getNumerator()/(double)result.getDenominator(), 0);
		//assertEquals("Add with reduction: numerator", expectedNumerator1, result.getNumerator());
		//assertEquals("Add with reduction: denominator", expectedDenominator1, result.getDenominator());
	}

	@Test
	public void testDivide() {
		RationalNumber test1A = new RationalNumber(9, -3);
		RationalNumber test1B = new RationalNumber(7, 2);
		RationalNumber result = test1A.divide(test1B);
		int expectedNumerator1 = -6;
		int expectedDenominator1 = 7;
		assertEquals("Divide", expectedNumerator1/(double)expectedDenominator1, result.getNumerator()/(double)result.getDenominator(), 0);
		//assertEquals("Divide with reduction: numerator", expectedNumerator1, result.getNumerator());
		//assertEquals("Divide with reduction: denominator", expectedDenominator1, result.getDenominator());
	}

	@Test
	public void testMultiply() {
		RationalNumber test1A = new RationalNumber(9, -3);
		RationalNumber test1B = new RationalNumber(7, 2);
		RationalNumber result = test1A.multiply(test1B);
		int expectedNumerator1 = -21;
		int expectedDenominator1 = 2;
		assertEquals("Multiply", expectedNumerator1/(double)expectedDenominator1, result.getNumerator()/(double)result.getDenominator(), 0);
		//assertEquals("Multiply with reduction: numerator", expectedNumerator1, result.getNumerator());
		//assertEquals("Multiply with reduction: denominator", expectedDenominator1, result.getDenominator());
	}

	@Test
	public void testSubtract() {
		RationalNumber test1A = new RationalNumber(9, -3);
		RationalNumber test1B = new RationalNumber(7, 2);
		RationalNumber result = test1A.subtract(test1B);
		int expectedNumerator1 = -13;
		int expectedDenominator1 = 2;
		assertEquals("Subtract", expectedNumerator1/(double)expectedDenominator1, result.getNumerator()/(double)result.getDenominator(), 0);
		//assertEquals("Subtract with reduction: numerator", expectedNumerator1, result.getNumerator());
		//assertEquals("Subtract with reduction: denominator", expectedDenominator1, result.getDenominator());
	}

	@Test
	public void testToString() {
		RationalNumber test1 = new RationalNumber(2, 3);
		RationalNumber test2 = new RationalNumber(3, 1);
		assertEquals("2/3", test1.toString());
		assertEquals("Whole number", "3", test2.toString());
	}
}