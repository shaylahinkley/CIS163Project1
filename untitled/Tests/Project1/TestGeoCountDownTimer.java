package Project1;

import java.io.*;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestGeoCountDownTimer {

    @Test
    public void testConstructor2() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/10/2015");
        assertTrue(s.toDateString().equals("5/10/2015"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2015");
        assertTrue(s.toDateString().equals("2/29/2016"));
    }

    @Test
    public void testAddMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2015);
        s1.inc(365);
        System.out.println(s1.toDateString().equals("5/9/2016"));
        assertTrue(s1.toDateString().equals("5/9/2016"));

        s1 = new GeoCountDownTimer(5, 10, 2016);

		for (int i = 0; i < 365; i++)
			s1.inc();
		System.out.println (s1);
		assertTrue (s1.toDateString().equals("5/10/2017"));

		s1 = new GeoCountDownTimer(5,10,2016);

		System.out.println ("Start:" + s1);
    	for (int i = 0; i < 31665; i++)
			s1.inc();
		System.out.println ("Middle:" + s1);

		for (int i = 0; i < 31665; i++)
			s1.dec();
		System.out.println ("End: " + s1);

	}
//
//
//	// must have a separate test for each Exception
//	 @Test (expected = IllegalArgumentException.class)
//	    public void testContuctor1() {
//		 new GeoCountDownTimer(2,-3,-3);
//	    }
//
//	 @Test (expected = IllegalArgumentException.class)
//	    public void testContuctor2() {
//		 new GeoCountDownTimer("2,-3/-3");
//
//	    }
//
//	@Test
//	public void testEqual () {
//		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
//		GeoCountDownTimer s2 = new GeoCountDownTimer(6,1,2015);
//		GeoCountDownTimer s3 = new GeoCountDownTimer(5,5,2015);
//		GeoCountDownTimer s4 = new GeoCountDownTimer(5,9,3000);
//
//		assertEquals(s1, s2);
//		assertFalse(s1.equals(s2));
//		assertTrue (s1.equals(s4));
//
//
//
//	}
//	@Test
//	public void testCompareTo () {
//		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2015);
//		GeoCountDownTimer s2 = new GeoCountDownTimer(6,01,2015);
//		GeoCountDownTimer s3 = new GeoCountDownTimer(5,8,2015);
//		GeoCountDownTimer s4 = new GeoCountDownTimer(5,9,2015);
//
//		assertTrue (s2.compareTo(s1) > 0);
//		assertTrue (s3.compareTo(s1) < 0);
//		assertTrue (s1.compareTo(s4) == 0);
//
//	}
//
//	@Test
//	public void testLoadSave () {
//		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2015);
//		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2015);
//
//		s1.save("file1");
//		s1 = new GeoCountDownTimer(1,1,2014);  // resets to zero
//		s1.load("file1");
//		assertTrue (s2.equals(s1));
//
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
    }

