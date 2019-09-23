package Project1;

import java.io.*;
import java.util.Scanner;
import org.junit.Test;



import static org.junit.Assert.*;
import java.lang.AssertionError;



public class TestGeoCountDownTimer {

    /****************************************************************************************************
     *testConstructor1()
     * testing constructor 1 for expected Illegal Argument Exception
     * Illegal Day (negative)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor1() {
        new GeoCountDownTimer(2020,3,-3);
    }

    /****************************************************************************************************
     *testConstructor1a()
     * testing constructor 1 for expected Illegal Argument Exception
     *Illegal Month (negative)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor1a() {
        new GeoCountDownTimer(2020,-3,3);
    }

    /****************************************************************************************************
     *testConstructor1b()
     *testing constructor 1 for expected Illegal Argument Exception
     *Illegal Month (greater than 12)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor1b() {
        new GeoCountDownTimer(2020,13,3);
    }

    /****************************************************************************************************
     *testConstructor1c()
     * testing constructor 1 for expected Illegal Argument Exception
     * Illegal Day && Leap Year (bigger than DAYS_IN_MONTH)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor1c() {
        new GeoCountDownTimer(2020,2,30);
    }

    /****************************************************************************************************
     *testConstructor1d()
     * testing constructor 1 for expected Illegal Argument Exception
     * Illegal Day && not leap Year (bigger than DAYS_IN_MONTH)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor1d() {
        new GeoCountDownTimer(2019,2,29);
    }

    /****************************************************************************************************
     *testConstructor1e()
     * testing constructor 1 for expected Illegal Argument Exception
     * Illegal year (positive) and less than 2019
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor1e() {
        new GeoCountDownTimer(2018,2,13);
    }

    /****************************************************************************************************
     *testConstructor1f()
     * testing constructor 1 for expected Illegal Argument Exception
     * Illegal year (negative) and less than 2019
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor1f() {
        new GeoCountDownTimer(-2018,2,3);
    }

    /****************************************************************************************************
     *testConstructor2()
     * testing constructor 2 for expected StringIndexOutofBoundException
     ****************************************************************************************************/
    @Test (expected = StringIndexOutOfBoundsException.class)
    public void testConstructor2() {
        new GeoCountDownTimer("2,3/2019");
    }

    /****************************************************************************************************
     * testConstructor2a()
     * Testing constructor 2 with first day of year
     ****************************************************************************************************/
    @Test
    public void testConstructor2a() {
        GeoCountDownTimer f = new GeoCountDownTimer("1/1/2019");
        assertEquals("Test for constructor 2 failed", "1/1/2019",f.toDateString());
    }

    /****************************************************************************************************
     *testConstructor2b()
     * Testing constructor 2 with any day of year
     ****************************************************************************************************/
    @Test
    public void testConstructor2b() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/10/2019");
        assertEquals("Test for constructor 2 failed","5/10/2019", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor2c()
     *testing constructor 2 with last day of year
     ****************************************************************************************************/
    @Test
    public void testConstructor2c() {
        GeoCountDownTimer s = new GeoCountDownTimer("12/31/2019");
        assertEquals("Test for constructor 2 failed", "12/31/2019", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor2d()
     * testing constructor 2 for expected Illegal Argument Exception
     * Illegal Month (greater than 12)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor2d() {
        new GeoCountDownTimer("13/3/2019");
    }

    /****************************************************************************************************
     *testConstructor2e()
     * testing constructor 2 for expected Illegal Argument Exception
     * Illegal Month (negative)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor2e() {
        new GeoCountDownTimer("-1/3/2019");
    }

    /****************************************************************************************************
     *testConstructor2f()
     * testing constructor 2 for expected Illegal Argument Exception
     * Illegal Day (greater than days in month) when not leap year
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor2f() {
        new GeoCountDownTimer("2/29/2019");
    }

    /****************************************************************************************************
     *testConstructor2g()
     * testing constructor 2 for expected Illegal Argument Exception
     * Illegal Day (greater than days in month) when leap year
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor2g() {
        new GeoCountDownTimer("2/30/2029");
    }

    /****************************************************************************************************
     *testConstructor2h()
     * testing constructor 2 for expected Illegal Argument Exception
     * Illegal Day (negative)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor2h() {
        new GeoCountDownTimer("2/-3/2029");
    }

    /****************************************************************************************************
     *testConstructor2i()
     * testing constructor 2 for expected Illegal Argument Exception
     * Illegal year (less than 2019)
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor2i() {
        new GeoCountDownTimer("2/3/2018");
    }

    /****************************************************************************************************
     *testConstructor2j()
     * testing constructor 2 for expected Illegal Argument Exception
     * Leap Year
     ****************************************************************************************************/
    @Test
    public void testConstructor2j() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2020");
        assertEquals("Test for constructor 2 failed", "2/29/2020", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor3()
     * testing constructor 3
     ****************************************************************************************************/
    @Test
    public void testConstructor3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer d = new GeoCountDownTimer("3/2/2020");

        s.GeoCountDownTimer(d);
        assertEquals("Constructor 3 failed", "3/2/2020", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor3()
     * testing constructor 3 for Illegal Exception Error
     * Illegal Day
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3a() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer d = new GeoCountDownTimer("2/29/2019");

        s.GeoCountDownTimer(d);
        assertEquals("Constructor 3 failed", "2/29/2019", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor3b()
     * testing constructor 3 for Illegal Exception Error
     * Illegal Year
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3b() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer d = new GeoCountDownTimer("2/29/2018");

        s.GeoCountDownTimer(d);
        assertEquals("Constructor 3 failed", "2/29/2018", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor3c()
     * testing constructor 3 for Illegal Exception Error
     * Illegal Day (negative)
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3c() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer d = new GeoCountDownTimer("2/-29/2019");

        s.GeoCountDownTimer(d);
        assertEquals("Constructor 3 failed", "2/-29/2019", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor3d()
     * testing constructor 3 for Illegal Exception Error
     * Illegal Month (greater than 12)
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3d() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer d = new GeoCountDownTimer("13/29/2019");

        s.GeoCountDownTimer(d);
        assertEquals("Constructor 3 failed", "13/29/2019", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor3e()
     * testing constructor 3 for Illegal Exception Error
     * Illegal Month (negative)
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3e() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer d = new GeoCountDownTimer("-3/29/2019");

        s.GeoCountDownTimer(d);
        assertEquals("Constructor 3 failed", "-3/29/2019", s.toDateString());
    }

    /****************************************************************************************************
     *testEquals()
     * testing boolean equals()
     * Illegal Month (negative)
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testEquals() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer s2 = new GeoCountDownTimer("-3/29/2019");

        GeoCountDownTimer.equals(s1, s2);
    }

    /****************************************************************************************************
     *testEquals2()
     * testing boolean equals()
     * Illegal Month (greater than 12)
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testEquals2() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer s2 = new GeoCountDownTimer("13/29/2019");

        GeoCountDownTimer.equals(s1, s2);
    }

    /****************************************************************************************************
     *testEquals3()
     * testing boolean equals()
     * Illegal Day (non leap year)
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testEquals3() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer s2 = new GeoCountDownTimer("2/29/2019");

        GeoCountDownTimer.equals(s1, s2);
    }

    /****************************************************************************************************
     *testEquals4()
     * testing boolean equals()
     * Illegal Year
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testEquals4() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer s2 = new GeoCountDownTimer("2/12/2018");

        GeoCountDownTimer.equals(s1, s2);
    }

    /****************************************************************************************************
     *testEquals5()
     * testing boolean equals()
     ****************************************************************************************************/
    @Test
    public void testEquals5() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/1/2019");
        GeoCountDownTimer s2 = new GeoCountDownTimer("2/29/2020");

        GeoCountDownTimer.equals(s1, s2);
    }

    /****************************************************************************************************
     *testEquals6()
     * testing boolean equals()
     * Illegal Day (non leap year)
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testEquals6() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/29/2019");
        GeoCountDownTimer s2 = new GeoCountDownTimer("2/20/2019");

        GeoCountDownTimer.equals(s1, s2);
    }

    /****************************************************************************************************
     *testEquals7()
     * testing boolean equals()
     * Illegal Month
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testEquals7() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("13/19/2019");
        GeoCountDownTimer s2 = new GeoCountDownTimer("2/20/2019");

        GeoCountDownTimer.equals(s1, s2);
    }

    /****************************************************************************************************
     *testEquals8()
     * testing boolean equals()
     * Illegal Year
     ****************************************************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void testEquals8() {
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/19/2018");
        GeoCountDownTimer s2 = new GeoCountDownTimer("2/20/2019");

        GeoCountDownTimer.equals(s1, s2);

    }

    /****************************************************************************************************
     *testAddMethod()
     * tests inc() method by increasing by one normal day
     ****************************************************************************************************/
    @Test
    public void testAddMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 10, 5);
        s1.inc(1);
        System.out.println(s1);
        System.out.println(s1.toDateString().equals("10/6/2019"));
        assertEquals("Increasing by one day failed", "10/6/2019", s1.toDateString());
    }

    /****************************************************************************************************
     *testAddMethod2()
     * tests inc()method when going into a new year
     ****************************************************************************************************/
    @Test
    public void testAddMethod2() {
        GeoCountDownTimer s2 = new GeoCountDownTimer(2019, 12, 31);
        s2.inc(1);
        System.out.println(s2);
        System.out.println(s2.toDateString().equals("1/1/2020"));
        assertEquals("Increase by one day failed", "1/1/2020", s2.toDateString());
    }

    /****************************************************************************************************
     *testAddMethod3()
     * testing inc() method in case of leap year
     ****************************************************************************************************/
    @Test
    public void testAddMethod3() {
        GeoCountDownTimer s3 = new GeoCountDownTimer(2020, 2, 28);
        s3.inc(1);
        System.out.println(s3);
        System.out.println(s3.toDateString().equals("2/29/2020"));
        assertEquals("Increase by one day in leap year failed", "2/29/2020", s3.toDateString());
    }

    /****************************************************************************************************
     *testAddMethod4()
     * tests inc() method by rolling over into new month
     ****************************************************************************************************/
    @Test
    public void testAddMethod4() {
        GeoCountDownTimer s4 = new GeoCountDownTimer(2019, 1, 31);
        s4.inc(1);
        System.out.println(s4);
        System.out.println(s4.toDateString().equals("2/1/2019"));
        assertEquals("Increase by one day failed", "2/1/2019", s4.toDateString());
    }

    /****************************************************************************************************
     *testAddMethod5()
     * tests inc(int day) method to call inc() and increase the date
     ****************************************************************************************************/
    @Test
    public void testAddMethod5() {
        GeoCountDownTimer s5 = new GeoCountDownTimer(2019, 1, 10);
        s5.inc(5);
        System.out.println(s5);
        System.out.println(s5.toDateString().equals("1/15/2019"));
        assertEquals("Increase by multiple days failed", "1/15/2019", s5.toDateString());
    }

    /****************************************************************************************************
     *testAddMethod()
     * tests inc() method of rolling into the new month of March in case of no leap year
     ****************************************************************************************************/
    @Test
    public void testAddMethod6() {
        GeoCountDownTimer s6 = new GeoCountDownTimer(2019, 2, 28);
        s6.inc(1);
        System.out.println(s6);
        System.out.println(s6.toDateString().equals("3/1/2019"));
        assertEquals("Increasing by one day failed", "3/1/2019",s6.toDateString());
    }

    /****************************************************************************************************
     *testDecMethod()
     * testing dec() method to decrease normal date by one day
     ****************************************************************************************************/
    @Test
    public void testDecMethod() {
        GeoCountDownTimer m1 = new GeoCountDownTimer(2019, 5, 2);
        m1.dec();
        System.out.println(m1);
        System.out.print(m1.toDateString().equals("5/1/2019"));
        assertEquals("Decreasing by one day failed", "5/1/2019", m1.toDateString());
    }

    /****************************************************************************************************
     *testDecMethod2()
     * testing dec() method to decrease date that rolls over into a previous month
     ****************************************************************************************************/
    @Test
    public void testDecMethod2() {
        GeoCountDownTimer m2 = new GeoCountDownTimer(2019, 5, 1);
        m2.dec();
        System.out.println(m2);
        System.out.print(m2.toDateString().equals("4/30/2019"));
        assertEquals("Decreasing by one day failed", "4/30/2019", m2.toDateString());
    }

    /****************************************************************************************************
     *testDecMethod3()
     * testing dec() method to decrease date that rolls over into previous year
     ****************************************************************************************************/
    @Test
    public void testDecMethod3() {
        GeoCountDownTimer m3 = new GeoCountDownTimer(2020, 1 ,1);
        m3.dec();
        System.out.println(m3);
        System.out.print(m3.toDateString().equals("12/31/2019"));
        assertEquals("Decreasing by one day failed", "12/31/2019", m3.toDateString());
    }

    /****************************************************************************************************
     *testDecMethod4()
     * testing dec() method in case of March decreasing one day in a leap year
     ****************************************************************************************************/
    @Test
    public void testDecMethod4() {
        GeoCountDownTimer m4 = new GeoCountDownTimer(2020, 3 ,1);
        m4.dec();
        System.out.println(m4);
        System.out.print(m4.toDateString().equals("2/29/2020"));
        assertEquals("Decreasing by one day in a leap year failed", "2/29/2020", m4.toDateString());
    }

    /****************************************************************************************************
     *testDecMethod5()
     * testing dec() method in case of March decreasing by one day that is not in a leap year
     ****************************************************************************************************/
    @Test
    public void testDecMethod5() {
        GeoCountDownTimer m5 = new GeoCountDownTimer(2019, 3 ,1);
        m5.dec();
        System.out.println(m5);
        System.out.print(m5.toDateString().equals("2/28/2019"));
        assertEquals("Decreasing by one day failed","2/28/2019", m5.toDateString());
    }

    /****************************************************************************************************
     *testDecMethod6()
     * testing dec(int days) to call dec() method to decrease the date
     ****************************************************************************************************/
    @Test
    public void testDecMethod6() {
        GeoCountDownTimer m6 = new GeoCountDownTimer(2020, 5, 10);
        m6.dec(5);
        System.out.println(m6);
        System.out.println(m6.toDateString().equals("5/5/2020"));
        assertEquals("Decreasing by multiple days failed", "5/5/2020", m6.toDateString());
    }

    /****************************************************************************************************
     *testEqual()
     * tests equals() method to see if two GeoCountDownTimer objects are equal in date
     ****************************************************************************************************/
    @Test
	public void testEqual () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2019,9,5);
		GeoCountDownTimer s2 = new GeoCountDownTimer(2020,6,1);
		GeoCountDownTimer s4 = new GeoCountDownTimer(2019,9,5);

		assertEquals(s1, s4);
        assertFalse("Dates are the same", s1.equals(s2));

    }

    /****************************************************************************************************
     *testCompareTo()
     * tests compareTo() method in case that GeoCountDownTimer objects are equal
     ****************************************************************************************************/
	@Test
	public void testCompareTo () {
		GeoCountDownTimer s5 = new GeoCountDownTimer(2019,5,9);
		GeoCountDownTimer s4 = new GeoCountDownTimer(2019,5,9);

		assertTrue ("Dates are the same", s5.compareTo(s4) == 0);
    }

    /****************************************************************************************************
     *testCompareTo2()
     * tests compareTo() method in case that a GeoCountDownTimer object is smaller (previous date) than
     * another GeoCountDownTimer object
     ****************************************************************************************************/
    @Test
    public void testCompareTo2() {
	    GeoCountDownTimer s3 = new GeoCountDownTimer(2019, 5, 8);
	    GeoCountDownTimer s5 = new GeoCountDownTimer(2019, 5, 9);

	    assertTrue("Date does not occur before", s3.compareTo(s5) < 0);
    }

    /****************************************************************************************************
     *testCompareTo3()
     * tests compareTo() method  in case that a GeoCountDownTimer object is larger (previous date) than
     * another GeoCountDownTimer object
     ****************************************************************************************************/
    @Test
    public void testCompareTo3() {
	    GeoCountDownTimer s2 = new GeoCountDownTimer(2019, 6, 1);
	    GeoCountDownTimer s7 = new GeoCountDownTimer(2019, 5, 9);

	    assertTrue("Date does not occur after", s2.compareTo(s7) > 0);
    }

    /****************************************************************************************************
     *testCompareTo4()
     * tests compareTo() method  for Illegal Argument Exception
     * Illegal Year
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testCompareTo4() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 6, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2018, 5, 9);

        assertTrue("Date does not occur after", s2.compareTo(s1) > 0);
    }

    /****************************************************************************************************
     *testCompareTo5()
     * tests compareTo() method  for Illegal Argument Exception
     * Illegal Day
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testCompareTo5() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 6, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2019, 2, 29);

        assertTrue("Date does not occur after", s2.compareTo(s1) > 0);
    }

    /****************************************************************************************************
     *testCompareTo6()
     * tests compareTo() method  for Illegal Argument Exception
     * Illegal Month
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testCompareTo6() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 6, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2019, 13, 20);

        assertTrue("Date does not occur after", s1.compareTo(s2) > 0);
    }

    /****************************************************************************************************
     *testCompareTo()
     * tests compareTo() method in case that GeoCountDownTimer objects are equal and leap year
     ****************************************************************************************************/
    @Test
    public void testCompareTo7() {
        GeoCountDownTimer s5 = new GeoCountDownTimer(2020,2, 29);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2020, 2, 29);

        assertTrue ("Dates are the same", s5.compareTo(s4) == 0);
    }

    /****************************************************************************************************
     *testIsLeapYear()
     * tests isLeapYear() method for a date that is in a leap year
     ****************************************************************************************************/
    @Test
    public void testIsLeapYear() {
        GeoCountDownTimer testLeapYear = new GeoCountDownTimer(2020, 5, 2);
        assertTrue("It is not leap year", GeoCountDownTimer.isLeapYear(testLeapYear.getYear()));
    }

    /****************************************************************************************************
     *testIsLeapYear2()
     * tests isLeapYear() method for a date that is not in a leap year
     ****************************************************************************************************/
    @Test
    public void testIsLeapYear2() {
        GeoCountDownTimer testLeapYear2 = new GeoCountDownTimer(2019, 5, 2);
        assertFalse("It is leap year", GeoCountDownTimer.isLeapYear(testLeapYear2.getYear()));
    }

    /****************************************************************************************************
     *testToString()
     * tests toString() method for right formatting
     ****************************************************************************************************/
    @Test
    public void testToString() {
        GeoCountDownTimer testToString = new GeoCountDownTimer(2019, 5,10);
        assertEquals("Wrong toString() format" ,"May 10, 2019", testToString.toString());
    }

    /****************************************************************************************************
     *testToDateString()
     *tests toDateString() method for right formatting
     ****************************************************************************************************/
    @Test
    public void testToDateString() {
        GeoCountDownTimer testDateString = new GeoCountDownTimer(2019, 5, 9);
        assertEquals("Wrong format for toDateString() ", "5/9/2019", testDateString.toDateString());
    }

    /****************************************************************************************************
     *testGetter()
     * tests getDay(), getMonth(), and getYear() methods for right output
     ****************************************************************************************************/
    @Test
    public void testGetter() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 5, 9);
        assertEquals("Wrong day outputted" ,9, s1.getDay());
        assertEquals("Wrong month outputted", 5, s1.getMonth());
        assertEquals("Wrong year outputted", 2019, s1.getYear());
    }

    /****************************************************************************************************
     *testSetter()
     * tests getSet(), setMonth(), and setYear() methods for right output
     ****************************************************************************************************/
    @Test
    public void testSetter() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 5, 2);
        s1.setDay(1);
        s1.setMonth(1);
        s1.setYear(2020);

        assertEquals("Wrong day outputted" ,1, s1.getDay());
        assertEquals("Wrong month outputted", 1, s1.getMonth());
        assertEquals("Wrong year outputted", 2020, s1.getYear());
    }

    /****************************************************************************************************
     *testSetMonth1()
     * tests setMonth() for Illegal Argument Exception
     * illegal month
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testSetMonth1() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 5, 2);
        s1.setMonth(13);
        assertEquals("Wrong month outputted", 3, s1.getMonth());
    }

    /****************************************************************************************************
     *testSetDay1()
     * tests setDay() for Illegal Argument Exception
     * Illegal Day
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testSetDay1() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 2, 10);
        s1.setDay(29);
        assertEquals("Wrong month outputted", 29, s1.getDay());
    }

    /****************************************************************************************************
     *testSetYear1()
     * tests setYear() for Illegal Argument Exception
     * Illegal year
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testSetYear1() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 2, 10);
        s1.setYear(2018);
        assertEquals("Wrong month outputted", 2018, s1.getYear());
    }

    /****************************************************************************************************
     *testDaysToGo()
     * tests daysToGo() method for right output
     ****************************************************************************************************/
    @Test
    public void testDaysToGo() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019,2,9);
        assertTrue (s1.daysToGo("2/1/2019") == 8);
        assertTrue (s1.daysToGo("2/8/2019") == 1);
        assertTrue (s1.daysToGo("2/9/2019") == 0);
    }

    /****************************************************************************************************
     *testDaysToGo2()
     * tests daysToGo() method for right output when rolling over the months
     ****************************************************************************************************/
    @Test
    public void testDaysToGo2() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019,2,5);
        assertTrue (s1.daysToGo("1/31/2019") == 5);
        assertTrue (s1.daysToGo("1/30/2019") == 6);
        assertTrue (s1.daysToGo("1/24/2019") == 12);
    }

    /****************************************************************************************************
     *testDaysToGo3()
     * tests daysToGo() method for right output when rolling over the months in case if a leap year
     ****************************************************************************************************/
    @Test
    public void testDaysToGo3() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2020,3,1);
        assertTrue (s1.daysToGo("2/28/2020") == 2);
        assertTrue (s1.daysToGo("2/29/2020") == 1);
    }

    /****************************************************************************************************
     *testDaysToGo4()
     * tests daysToGo() method for right output when going over into a different year that is a leap year
     ****************************************************************************************************/
    @Test
    public void testDaysToGo4() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2020,3,1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2020, 3, 2);
        assertTrue (s1.daysToGo("3/1/2019") == 366);
        assertTrue(s2.daysToGo("3/1/2019") == 367);
    }

    /****************************************************************************************************
     *testDaysToGo5()
     * tests daysToGo() method for right output when going over into a different year that is not a leap year
     ****************************************************************************************************/
    @Test
    public void testDaysToGo5() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022,3,1);
        assertTrue (s1.daysToGo("3/1/2021") == 365);
    }

    /****************************************************************************************************
     *testDaysToGo7()
     * tests daysToGo() method for Illegal Argument Exception
     * Illegal year
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testDaysToGo7() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 3, 10);
        assertTrue(s1.daysToGo("3/10/2018") == 730);
    }

    /****************************************************************************************************
     *testDaysToGo8()
     * tests daysToGo() method for Illegal Argument Exception
     * Illegal month
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testDaysToGo8() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 3, 10);
        assertTrue(s1.daysToGo("13/10/2019") == 10);
    }

    /****************************************************************************************************
     *testDaysToGo6()
     * tests daysToGo() method for Illegal Argument Exception
     * Illegal day
     ****************************************************************************************************/
    @Test (expected = IllegalArgumentException.class)
    public void testDaysToGo6() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 3, 10);
        assertTrue(s1.daysToGo("2/29/2019") == 10);
    }

    /****************************************************************************************************
     *testDaysInFuture()
     * tests daysInFuture() method for right output when positive n
     ****************************************************************************************************/
    @Test
    public void testDaysInFuture() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022,3,1);
        assertEquals("Days in future failed", "3/5/2022", s1.daysInFuture(4).toDateString());
    }

    /****************************************************************************************************
     *testDaysInFuture2()
     * tests daysInFuture() method for right output when negative input parameter int n
     ****************************************************************************************************/
    @Test
    public void testDaysInFuture2() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022,3,10);
        assertEquals("Days in future failed", "3/5/2022", s1.daysInFuture(-5).toDateString());
    }

    /****************************************************************************************************
     *testDaysInFuture3()
     * tests daysInFuture() method for right output when positive input parameter int n
     * in case of a leap year
     ****************************************************************************************************/
    @Test
    public void testDaysInFuture3() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2020,2,28);
        assertEquals("Days in future failed", "2/29/2020", s1.daysInFuture(1).toDateString());
    }

    /****************************************************************************************************
     *testDaysInFuture4()
     * tests daysInFuture() method for right output when positive input parameter n
     * in case of a leap year
     ****************************************************************************************************/
    @Test
    public void testDaysInFuture4() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2020,3,1);
        assertEquals("Days in future failed", "2/29/2020", s1.daysInFuture(-1).toDateString());
    }

    /****************************************************************************************************
     *testDaysInFuture5()
     * tests daysInFuture() method for right output when positive input parameter n
     * in case of rolling over year
     ****************************************************************************************************/
    @Test
    public void testDaysInFuture5() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2020,12,31);
        assertEquals("Days in future failed", "1/1/2021", s1.daysInFuture(1).toDateString());
    }







    //test loadSave() method
//	@Test
//	public void testLoadSave () {
//		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
//		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);
//
//		s1.save("file1");
//		s1 = new GeoCountDownTimer(1,1,2019);  // resets to zero
//    	s1.load("file1");
//		assertTrue (s2.equals(s1));
//	}
//

//
//        public void sampleReadData () {
//            int year;
//            int month;
//            int day;
//
//            try {
//                // open the data file
//                Scanner fileReader = new Scanner(new File("/testit"));
//                Scanner lineReader;
//
//                // read several int for year, month, and day
//                year = fileReader.nextInt();
//                month = fileReader.nextInt();
//                day = fileReader.nextInt();
//                System.out.println(year + " " + month + " " + day);
//            }
//
//            // could not find file
//            catch (FileNotFoundException error) {
//                System.out.println("File not found ");
//            }
//
//            // problem reading the fil
//            catch (IOException error) {
//                System.out.println("Oops!  Something went wrong.");
//            }
//        }
//
//        public void sampleWriteData() {
//            PrintWriter out = null;
//            try {
//                out = new PrintWriter(new BufferedWriter(new FileWriter("/testit")));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            String s = "ANCHORAGE";
//            out.println(s + " " + "256000");
//            out.close();
//
//        }

        public static void main(String[] args) {

        }

}

