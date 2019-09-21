package Project1;

import java.io.*;
import java.util.Scanner;
import org.junit.Test;



import static org.junit.Assert.*;
import java.lang.AssertionError;



public class TestGeoCountDownTimer {

    /****************************************************************************************************
     * testConStructor2a()
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
     *testConstructor3
     * testing constructor 3 for illegal date(leap year)
     * AssertionError expected
     ****************************************************************************************************/
    @Test(expected = AssertionError.class)
    public void testConstructor3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2019");
        assertEquals("Test for constructor 3 failed", "2/29/20", s.toDateString());
    }

    /****************************************************************************************************
     *testConstructor1()
     * testing constructor 1 for expected AssertionError
     ****************************************************************************************************/
    @Test (expected = AssertionError.class)
    public void testConstructor1() {
        new GeoCountDownTimer(2,-3,-3);
    }

    /****************************************************************************************************
     *testConstructor2()
     * testing constructor 2 for expected StringIndexOutofBoundException
     ****************************************************************************************************/
    @Test (expected = StringIndexOutOfBoundsException.class)
    public void testConstructor2() {
        new GeoCountDownTimer("2,-3/-3");
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
        System.out.print(m4.toDateString().equals("2/29/2019"));
        assertEquals("Decreasing by one day in a leap year failed", "2/29/2019", m4.toDateString());
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
//	@Test
//	public void testDaysToGo () {
//		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2015);
//		assertTrue (s1.daysToGo("2/1/2015") == 8);
//		assertTrue (s1.daysToGo("2/8/2015") == 1);
//		assertTrue (s1.daysToGo("2/9/2015") == 0);
//
//		s1 = new GeoCountDownTimer(2,9,5015);
//		System.out.println (s1.daysToGo("2/9/2015"));
//	}

        public void sampleReadData () {
            int year;
            int month;
            int day;

            try {
                // open the data file
                Scanner fileReader = new Scanner(new File("/testit"));
                Scanner lineReader;

                // read several int for year, month, and day
                year = fileReader.nextInt();
                month = fileReader.nextInt();
                day = fileReader.nextInt();
                System.out.println(year + " " + month + " " + day);
            }

            // could not find file
            catch (FileNotFoundException error) {
                System.out.println("File not found ");
            }

            // problem reading the fil
            catch (IOException error) {
                System.out.println("Oops!  Something went wrong.");
            }
        }

        public void sampleWriteData() {
            PrintWriter out = null;
            try {
                out = new PrintWriter(new BufferedWriter(new FileWriter("/testit")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String s = "ANCHORAGE";
            out.println(s + " " + "256000");
            out.close();

        }

        public static void main(String[] args) {

        }

}

