public class UseHouse {
    public static void main(String[] args) {
    	House myHouse = new House();
    	
    	House purpleHouse = new House(2, "purple");
    	
    	System.out.println(purpleHouse);
    	System.out.println("hash code of purple house = " + purpleHouse.hashCode());
    	
    	House anotherPurpleHouse = new House(2, "purple");
    	
    	System.out.println("hash code of purple house = " + purpleHouse.hashCode());
    	System.out.println("hash code of another purple house = " + anotherPurpleHouse.hashCode());
    	if (purpleHouse == anotherPurpleHouse)
    		System.out.println("Equal");
    	else
    		System.out.println("Unequal");
    	
    	    	
    	anotherPurpleHouse = purpleHouse;
    	System.out.println("hash code of purple house = " + purpleHouse.hashCode());
    	System.out.println("hash code of another purple house = " + anotherPurpleHouse.hashCode());
    	if (anotherPurpleHouse == purpleHouse)
    		System.out.println("Equal");
    	else
    		System.out.println("Unequal");
    	    	    	
    	if (purpleHouse.equals(anotherPurpleHouse)) 
    		System.out.println("Equal");
    	else
    		System.out.println("Unequal");
    	    	
    	House blueHouse = new House(2, "blue");
    	if (purpleHouse.equals(blueHouse)) 
    		System.out.println("Equal");
    	else
    		System.out.println("Unequal");	
    	
    	    	
    	House yellowHouse = new House(2, "yellow");
    	yellowHouse = null;   	
    	if (purpleHouse.equals(yellowHouse)) 
    		System.out.println("Equal");
    	else
    		System.out.println("Unequal");
    }
}