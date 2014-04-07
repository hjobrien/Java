package programming_projects;

public class TestRationalNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test constructor with denominator = 0
		try  {
			RationalNumber rn1 = new RationalNumber(3, 0);
			System.out.println("Constructor with denominator 0 test failed.*****");
		}
		catch (Exception e){
			System.out.println("Constructor with denominator 0 test passed.");
		}
		
		// test constructor with valid values
		RationalNumber rn2 = new RationalNumber(3, 6);
		if ((rn2.getNumerator() != 1) || (rn2.getDenominator() != 2))
			System.out.println("Constructor with valid inputs test failed.*****");
		else
			System.out.println("Constructor with valid inputs test passed.");
		
		// test toString()
		if (rn2.toString().equals("1/2"))
			System.out.println("toString() test passed.");
		else
			System.out.println("toString() test failed.");
		
		// test toString() with denominator = 1
		
		// test equals()
		
		// test add()
		RationalNumber rn3 = rn2.add(rn2);
		// test subtract()
		// test multiply()
		// test divide()
		
		
		
	}

}
