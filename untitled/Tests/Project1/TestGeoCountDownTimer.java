package Project1;

import java.io.*;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestGeoCountDownTimer {

    //testing second constructor
    @Test
    public void testConstructor2a() {
        GeoCountDownTimer f = new GeoCountDownTimer("1/1/2019");
        assertEquals(f.toDateString(),"1/1/2019");
    }

    //testing second constructor
    @Test
    public void testConstructor2b() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/10/2019");
        assertEquals(s.toDateString(), "5/10/2019");
    }

    //testing second constructor
    @Test
    public void testConstructor2c() {
        GeoCountDownTimer s = new GeoCountDownTimer("12/31/2019");
        assertEquals(s.toDateString(), "12/31/2019");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2019");
        assertEquals(s.toDateString(), "2/29/2020");
    }

    //testing inc() method, normal increase by 1 day
    @Test
    public void testAddMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2019, 10, 5);
        s1.inc(1);
        System.out.println(s1);
        System.out.println(s1.toDateString().equals("10/6/2019"));
        assertEquals(s1.toDateString(), "10/6/2019");
    }

   //testing inc() method,  roll over to new year
    @Test
    public void testAddMethod2() {
        GeoCountDownTimer s2 = new GeoCountDownTimer(2019, 12, 31);
        s2.inc(1);
        System.out.println(s2);
        System.out.println(s2.toDateString().equals("1/1/2020"));
        assertEquals(s2.toDateString(), "1/1/2020");
    }

    //testing inc() method, roll over of day in case of a leap year
    @Test
    public void testAddMethod3() {
        GeoCountDownTimer s3 = new GeoCountDownTimer(2020, 2, 28);
        s3.inc(1);
        System.out.println(s3);
        System.out.println(s3.toDateString().equals("2/29/2020"));
        assertEquals(s3.toDateString(), "2/29/2020");
    }

    //testing inc() method, the roll over to a new month
    @Test
    public void testAddMethod4() {
        GeoCountDownTimer s4 = new GeoCountDownTimer(2019, 1, 31);
        s4.inc(1);
        System.out.println(s4);
        System.out.println(s4.toDateString().equals("2/1/2019"));
        assertEquals(s4.toDateString(), "2/1/2019");
    }

    //testing inc() method, adding more than 1 day at a time
    @Test
    public void testAddMethod5() {
        GeoCountDownTimer s5 = new GeoCountDownTimer(2019, 1, 10);
        s5.inc(5);
        System.out.println(s5);
        System.out.println(s5.toDateString().equals("1/15/2019"));
        assertEquals(s5.toDateString(), "1/15/2019");
    }

    //testing inc() method, roll over to March in case of no leap year
    @Test
    public void testAddMethod6() {
        GeoCountDownTimer s6 = new GeoCountDownTimer(2019, 2, 28);
        s6.inc(1);
        System.out.println(s6);
        System.out.println(s6.toDateString().equals("3/1/2019"));
        assertEquals(s6.toDateString(),"3/1/2019");
    }

    //testing dec() method, normal decrease by 1 day
    @Test
    public void testDecMethod() {
        GeoCountDownTimer m1 = new GeoCountDownTimer(2019, 5, 2);
        m1.dec();
        System.out.println(m1);
        System.out.print(m1.toDateString().equals("5/1/2019"));
        assertEquals(m1.toDateString(), "5/1/2019");
    }

    //testing dec() method, roll over month
    @Test
    public void testDecMethod2() {
        GeoCountDownTimer m2 = new GeoCountDownTimer(2019, 5, 1);
        m2.dec();
        System.out.println(m2);
        System.out.print(m2.toDateString().equals("4/30/2019"));
        assertEquals(m2.toDateString(), "4/30/2019");
    }

    //testing dec() method, roll over year
    @Test
    public void testDecMethod3() {
        GeoCountDownTimer m3 = new GeoCountDownTimer(2020, 1 ,1);
        m3.dec();
        System.out.println(m3);
        System.out.print(m3.toDateString().equals("12/31/2019"));
        assertEquals(m3.toDateString(), "12/31/2019");
    }

    //testing dec() method in case of leap year
    @Test
    public void testDecMethod4() {
        GeoCountDownTimer m4 = new GeoCountDownTimer(2020, 3 ,1);
        m4.dec();
        System.out.println(m4);
        System.out.print(m4.toDateString().equals("2/29/2019"));
        assertEquals(m4.toDateString(), "2/29/2019");
    }

    //testing dec() method in case of not leap year
    @Test
    public void testDecMethod5() {
        GeoCountDownTimer m5 = new GeoCountDownTimer(2021, 1 ,1);
        m5.dec();
        System.out.println(m5);
        System.out.print(m5.toDateString().equals("2/28/2019"));
        assertEquals(m5.toDateString(), "2/28/2019");
    }



//        s1 = new GeoCountDownTimer(2016, 10, 5);
//
//		for (int i = 0; i < 365; i++)
//			s1.inc();
//		System.out.println (s1);
//		assertTrue (s1.toDateString().equals("10/5/2017"));
//
//		s1 = new GeoCountDownTimer(2016,10,5);
//
//		System.out.println ("Start:" + s1);
//    	for (int i = 0; i < 31665; i++)
//			s1.inc();
//		System.out.println ("Middle:" + s1);
//
//		for (int i = 0; i < 31665; i++)
//			s1.dec();
//		System.out.println ("End: " + s1);

//	}
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

        public static void main(String[] args) {

        }

}

