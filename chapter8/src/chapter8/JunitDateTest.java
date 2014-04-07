package chapter8;

import static org.junit.Assert.*;
import org.junit.Test;

public class JunitDateTest {

	@Test
	public void testDateIntIntInt() {
		Date d1 = new Date(2013, 3, 13);
		assertEquals("test constructor using getYear() ", 2013, d1.getYear());
		assertEquals("test constructor using getMonth() ", 3, d1.getMonth());
		assertEquals("test constructor using getDay() ", 13, d1.getDay());
	}

	@Test
	public void testAddDays() {
		Date d1 = new Date(2000, 2, 28);
		d1.addDays(1);
		assertEquals("test addDays(1) to 2/28/2000 ", 29, d1.getDay());
		
		d1 = new Date(2000, 2, 28);
		d1.addDays(365);
		assertEquals("test addDays(1) to 2/28/2000 ", 27, d1.getDay());
		assertEquals("test addDays(1) to 2/28/2000 ", 2, d1.getMonth());
		assertEquals("test addDays(1) to 2/28/2000 ", 2001, d1.getYear());
		
		d1 = new Date(2000, 1, 1);
		d1.addDays(365);
		assertEquals("test addDays(365) to 1/1/2000 ", 31, d1.getDay());
		assertEquals("test addDays(365) to 1/1/2000 ", 12, d1.getMonth());
		assertEquals("test addDays(365) to 1/1/2000 ", 2000, d1.getYear());
		
		d1 = new Date(2000, 1, 1);
		d1.addDays(59);
		assertEquals("test addDays(59) to 1/1/2000 ", 29, d1.getDay());
		assertEquals("test addDays(59) to 1/1/2000 ", 2, d1.getMonth());
		assertEquals("test addDays(59) to 1/1/2000 ", 2000, d1.getYear());
		
		d1 = new Date(2013, 12, 31);
		d1.addDays(1);
		assertEquals("test addDays(1) to 12/31/2013 ", 1, d1.getDay());
		assertEquals("test addDays(1) to 12/31/2013 ", 1, d1.getMonth());
		assertEquals("test addDays(1) to 12/31/2013 ", 2014, d1.getYear());
	}

	@Test
	public void testAddWeeks() {
		Date d1 = new Date(2000, 2, 28);
		d1.addWeeks(1);
		assertEquals("test addWeeks(1) to 2000/02/28", "2000/03/6", d1.toString());
		
		d1.addWeeks(51);
		assertEquals("test addWeeks(51) 2000/03/6", "2001/02/26", d1.toString());
	}

	@Test
	public void testDaysTo() {
		Date d1 = new Date(2000, 2, 28);
		Date d2 = new Date(2000, 3, 1);
		assertEquals("test daysTo() ", 2, d1.daysTo(d2));
		assertEquals("test daysTo() ", -2, d2.daysTo(d1));
		
		d1 = new Date(2000, 12, 31);
		d2 = new Date(2001, 1, 1);
		assertEquals("test daysTo() ", 1, d1.daysTo(d2));
		assertEquals("test daysTo() ", -1, d2.daysTo(d1));
		
		d1 = new Date(1999, 12, 31);
		d2 = new Date(2001, 1, 1);
		assertEquals("test daysTo() ", 367, d1.daysTo(d2));
		assertEquals("test daysTo() ", -367, d2.daysTo(d1));
		
	}

//	@Test
//	public void testGetDay() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	public void testGetMonth() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	public void testGetYear() {
//		fail("Not yet implemented"); // TODO
//	}

	@Test
	public void testIsLeapYear() {
		Date d1 = new Date(2000, 2, 28);
		assertEquals("test isLeapYear() ", true, d1.isLeapYear());
		
		d1 = new Date(2002, 2, 28);
		assertEquals("test isLeapYear() ", false, d1.isLeapYear());
	}

	@Test
	public void testToString() {
		Date d1 = new Date(2014, 2, 28);
		assertEquals("test toString() ", "2014/02/28", d1.toString());

	}

}
