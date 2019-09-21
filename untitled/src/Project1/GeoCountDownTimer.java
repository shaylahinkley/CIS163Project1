package Project1;

import java.io.*;
import java.util.Scanner;

/**********************************************************************************************************
 * CIS 163 01 Project One
 *
 * Creates methods for a GeoCountDownTimer that allows the user to countdown to a specific date
 *@author Keilani Bailey & Shayla Hinkley
 *@version 1.0
 **********************************************************************************************************/
public class GeoCountDownTimer {

    //instance variables
    private int year;
    private int month;
    private int day;
    private static final int MINYEAR = 2019;

    /****************************************************************************************************
     * Private constructor that sets GeoCountDownTimer to zero
     ****************************************************************************************************/

    private GeoCountDownTimer() {
            year = 0;
            month = 0;
            day = 0;
    }
    /***************************************************************************************************
     * Prevents someone from starting new GeoCountDownTimer Object
     **************************************************************************************************/
    private static boolean mutate = true;

    /***************************************************************************************************
     * Final array list of type int method for days in the month
     ***************************************************************************************************/

    // Days in each month (assuming months are numbered beginning with 1)
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};

    /***************************************************************************************************
     *Final array list of type String method for names of months
     ***************************************************************************************************/
    private static final String[] MONTHS = {"", "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

    /***************************************************************************************************
     * Method that checks if input is valid date
     * @param month
     * @param day
     * @param year
     * @return true
     ***************************************************************************************************/
    private static boolean isValidDate(int month, int day, int year) {

        return true;
    }

    /***************************************************************************************************
     * Method that checks if it is a leap year
     * @param year
     * @return true
     ***************************************************************************************************/
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /****************************************************************************************************
     * Constructor that initializes the instance variables
     * @param year
     * @param month
     * @param day
     ****************************************************************************************************/
    public GeoCountDownTimer(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /****************************************************************************************************
     * Constructor that initializes the instance variables with the other GeoCountDownTimer parameter
     * @param other
     ****************************************************************************************************/
    public void GeoCountDownTimer(GeoCountDownTimer other) {
        if (other != null) {
            this.year = other.year;
            this.month = other.month;
            this.day = other.day;
        }
    }

    /*****************************************************************************************************
     * Constructor that accepts a string as a parameter
     *****************************************************************************************************/
    public GeoCountDownTimer(String startDate) {
        String date = startDate;
        String yr = "";
        String mon = "";
        String dy = "";
        int z = 0;
        int y = 0;
        int x = 0;
        int lastIndex = 0;

        //finds first index of '/' for month
        z = startDate.indexOf('/');

        //creates month substring from index 0 up until index of '/'
        mon = startDate.substring(0, z);

        //looks for last index of '/'
        lastIndex = startDate.lastIndexOf('/');

        //creates day substring from first index of '/' until the last index of '/'
        dy = startDate.substring(z+1, lastIndex);

        //creates year substring form last known index of '/' to the end of the string
        yr = startDate.substring(lastIndex+1);

        //parses String to Integer
        this.month = Integer.parseInt(mon);
        this.year = Integer.parseInt(yr);
        this.day = Integer.parseInt(dy);

    }

    /*****************************************************************************************************
     * Method that checks if two GeoCountDownTimer objects are the same
     * @param s1
     * @param s2
     * @return true
     *****************************************************************************************************/
    public static boolean equals(GeoCountDownTimer s1, GeoCountDownTimer s2) {
        return (s2.year == s1.year) && (s2.month == s1.month)
                && (s2.day == s1.day);
    }

    /*****************************************************************************************************
     * Method that checks if GeoCountDownTimer object is exactly the same as the other object
     * @param obj
     * @return true
     *****************************************************************************************************/
    @Override
    public boolean equals(Object obj) {

        //casting other object as a GeoCountDownTimer object
        GeoCountDownTimer other = (GeoCountDownTimer) obj;

        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (other == null) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        return true;
    }

    /*******************************************************************************************************************
     * Method that compares two dates
     * @param other
     * @return 0
     *******************************************************************************************************************/
    public int compareTo(GeoCountDownTimer other) {

        //checks if this GeoCountDownTimer object is equal to other GeoCountDownTimer object
        if (this.equals(other)) {
            return 0;
        }

        //checks the years and turns -1 if smaller
        if (this.year < other.year) {
            return -1;
        }

        //checks if year is greater and returns 1
        else if (this.year > other.year) {
            return 1;
        }

        //if years are the same
        else if (this.year == other.year) {

            //checks month and returns -1 if the month is smaller
            if (this.month < other.month) {
                return -1;
            }

            //checks month and returns 1 if the month is greater
            else if (this.month > other.month) {
                return 1;
            }

            //if the months are equal
            else if (this.month == other.month) {

                //checks day and returns -1 if smaller
                if (this.day < other.day) {
                    return -1;
                }

                //checks day and returns 1 if smaller
                else if (this.day > other.day) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /****************************************************************************************************
     * Method that subtracts the number of days and adjusts the timer date down the correct number of days
     * calls the dec() method
     * @param days
     ****************************************************************************************************/
    public void dec(int days) {
        for (int i = days; i > 0; i--) {
            dec();
        }
    }

    /*****************************************************************************************************
     * Method that subtracts 1 day from this GeoCountDownTimer object
     *****************************************************************************************************/
    public void dec() {

        int isLeapYear = 0;

        //if it is leap year and the month is Match
        if (isLeapYear(this.year) && this.month == 3 && this.day == 1) {
            day = DAYS_IN_MONTH[this.month -1] + 1;
            this.month--;
        }

        //if it is the first day of the month
        else if (this.day == 1) {

            //if it is January, set day to DAYS_IN_MONTH of December and decrease the year
            if (this.month == 1) {
                day = DAYS_IN_MONTH[12];
                this.year--;
            }

            //if it is not Jan, set days equal to the DAYS_IN_MONTH of the previous month
            else {
                day = DAYS_IN_MONTH[this.month - 1];
                this.month--;
            }

        } else {
            this.day--;
        }
   }


    /*****************************************************************************************************
     * Method that adds the number of days to the GeoCountDownTimer Object by calling inc() method
     * @param days
     *****************************************************************************************************/
    public void inc(int days) {
        for (int i = days; i > 0; i--) {
            inc();
        }
    }

    /*****************************************************************************************************
     *Method that adds 1 day to the GeoCountDownTimer object
     *****************************************************************************************************/
    public void inc() {

        int daysInMonth = 0;
        if (isLeapYear(this.year) && this.month == 2) {
            daysInMonth = DAYS_IN_MONTH[this.month] + 1;
        } else {
            daysInMonth = DAYS_IN_MONTH[this.month];
        }
        if (this.day == daysInMonth) {

            if (this.month == 12) {
                day = 1;
                month = 1;
                this.year++;
            } else {
                day = 1;
                month++;

            }
        } else {
            this.day++;
        }
    }

    /*****************************************************************************************************
     *toString() method that outputs date in Month day, year format
     * @return String fullDate
     *****************************************************************************************************/
    public String toString() {
        String s = MONTHS[this.month] + " " + this.day + ", " + this.year;
        return s;
    }

    /*****************************************************************************************************
     * toDateString() method prints date in month/day/year format
     * @return String date
     *****************************************************************************************************/
    public String toDateString() {
        String date;
        date = this.month + "/" + this.day + "/" + this.year;

        return date;
    }

    /******************************************************************************************************
     * Getter method for int day
     * @return int days
     ****************************************************************************************************/
    public int getDay() {

        return day;
    }

    /****************************************************************************************************
     * Setter method for int day
     * @param day
     ****************************************************************************************************/
    public void setDay(int day) {

        this.day = day;
    }

    /*****************************************************************************************************
     * Getter method for int month
     * @return int month
     ****************************************************************************************************/
    public int getMonth() {

        return month;
    }

    /*****************************************************************************************************
     * Setter method for int month
     * @param month
     ****************************************************************************************************/
    public void setMonth(int month) {

        this.month = month;
    }

    /****************************************************************************************************
     * Getter method for int year
     * @return int year
     ****************************************************************************************************/
    public int getYear() {

        return year;
    }

    /****************************************************************************************************
     * Setter method for int year
     * @param year
     ****************************************************************************************************/
    public void setYear(int year) {

        this.year = year;
    }

    /****************************************************************************************************
     * Method that saves a date
     * @param filename
     ****************************************************************************************************/
    public void save(String filename) {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(
                    filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println(month);
        out.println(day);
        out.println(year);

        out.close();
    }

    /************************************************************************************************************
     *Method that loads GeoCountDownTimer object from file
     * @param fileName
     ************************************************************************************************************/
    public void load(String fileName) {
        int year, day, month;

        try {
            // open the data file
            Scanner fileReader = new Scanner(new File(fileName));

            // read one String in of data and an int
            month = fileReader.nextInt();
            day = fileReader.nextInt();
            year = fileReader.nextInt();
            System.out.println(month + " " + day + " " + year);
        }

        // could not find file
        catch (Exception error) {
            System.out.println("File not found ");
        }
    }


    /*************************************************************************************************
     * Main method
     * @param args
     *************************************************************************************************/
    public static void main(String[] args) {

        //testing startDate() method and constructor GeoCountDownTimer(int year, int month, int day)
        GeoCountDownTimer s = new GeoCountDownTimer("2/10/2020");
        System.out.println("Date expected: 2/10/2020 \tstartDate() given date: " + s);

        //testing startDate() method and toString() method
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/10/2022");
        System.out.println("Date expected: 2/10/2022 \tstartDate() and toString() date: " + s1.toString());

        //testing toString() method
        GeoCountDownTimer s9 = new GeoCountDownTimer(2019, 5, 2);
        System.out.println("Expecting: May 2, 2019 \ttoString(): " + s9.toString());

        //testing toDateString() method
        System.out.println("Expecting: 5/2/2019 \ttoDateString(): " + s9.toDateString());

        //testing dec(int days) method calling dec() method
        s1.dec(5);
        System.out.println("Date expected: 2/5/2022 \tdec(5) date: " + s1);

        //testing dec() method

            //by counting down one day
            GeoCountDownTimer x = new GeoCountDownTimer("4/11/2019");
            x.dec();
            System.out.println("Date expected: 4/10/2019 \tdec() date: " + x);

            //by rolling over months
            GeoCountDownTimer rollMonth = new GeoCountDownTimer("2/1/2019");
            rollMonth.dec();
            System.out.println("Date expected: 1/31/2019 \tdec() date: " + rollMonth);

            //by rolling over year
            GeoCountDownTimer rollYear = new GeoCountDownTimer("1/1/2020");
            rollYear.dec();
            System.out.println("Date expected: 12/31/2019 \tdec() date: " + rollYear);

            //leap year, dec one day
            GeoCountDownTimer decLeapYear = new GeoCountDownTimer("3/1/2020");
            decLeapYear.dec();
            System.out.println("Date expected: 2/29/2020 \tdec() leap year date: " + decLeapYear);


        //testing inc(int day) method
        GeoCountDownTimer s2 = new GeoCountDownTimer("2/10/2019");
        s2.inc(5);
        System.out.println("Expecting: 2/15/2019 \tinc() loop date: " + s2);

        //testing inc() method

            //testing inc by one day
            GeoCountDownTimer incOneDay = new GeoCountDownTimer("5/2/2019");
            incOneDay.inc();
            System.out.println("Date expected: 5/3/2019 \tinc() date: " + incOneDay);

            //testing rolling over month
            GeoCountDownTimer incRollMonth = new GeoCountDownTimer("1/31/2019");
            incRollMonth.inc();
            System.out.println("Date expected: 2/1/2019 \tinc() date: " + incRollMonth);

            //testing rolling over year
            GeoCountDownTimer incRollYear = new GeoCountDownTimer("12/31/2019");
            incRollYear.inc();
            System.out.println("Date expected: 1/1/2020 \tinc() date: " + incRollYear);

            //leap year, inc one day
            GeoCountDownTimer incLeapYear = new GeoCountDownTimer("2/28/2020");
            incLeapYear.inc();
            System.out.println("Date expected : 2/29/2019 \tinc() leap year date: " + incLeapYear);


        //testing isLeapYear() , expecting true
        GeoCountDownTimer s3 = new GeoCountDownTimer("2/10/2020");
        System.out.println("Date: 2/10/2020 \tisLeapYear() expected to be true: " + isLeapYear(s3.getYear()));

        //testing isLeapYear() , expecting false
        GeoCountDownTimer d = new GeoCountDownTimer("5/5/2019");
        System.out.println("Date: 5/5/2019 \tisLeapYear() expected to be false: " + isLeapYear(d.getYear()));

        //testing equals() method

            // expecting true
            GeoCountDownTimer s4 = new GeoCountDownTimer("2/15/2019");
            GeoCountDownTimer s5 = new GeoCountDownTimer("2/15/2019");
            System.out.println("Both dates: 2/15/2019 \tequals() expected to be true: " + equals(s4, s5));

            //testing equals() method, expecting false
            GeoCountDownTimer s6 = new GeoCountDownTimer("2/17/2019");
            System.out.println("Date one: 2/15/2019 \tDate two: 2/17/2019 \tequals() expected be false: " + equals(s5, s6));

        //testing compareTo() method

            //expecting return 0, meaning they are the same
            System.out.println("Both dates: 2/15/2019 \tcompareTo() expecting 0: " + s4.compareTo(s5));

            //expecting -1, meaning smaller (looking at months and days)
            System.out.println("Date one(smaller): 2/15/2019 \tDate two(larger): 5/5/2019 \tcompareTo() expecting -1: " + s4.compareTo(d));

            //expecting -1, meaning smaller (looking just at days)
            System.out.println("Date one(smaller): 2/15/2019 \tDate two(larger): 2/17/2019 \tcompareTo() expecting -1: " + s4.compareTo(s6));

            //expecting -1, meaning smaller (looking at just months)
            GeoCountDownTimer f  = new GeoCountDownTimer("3/15/2019");
            System.out.println("Date one(smaller): 2/15/2019 \tDate two(larger): 3/15/2019 \tcompareTo() expecting -1: " + s4.compareTo(f));

            //expecting -1, meaning smaller (looking at just years)
            GeoCountDownTimer g = new GeoCountDownTimer("2/10/2019");
            System.out.println("Date one(smaller): 2/10/2019 \tDate two(larger): 2/10/2020 \tcompareTo() expecting -1: " + g.compareTo(s3));

            //expecting 1, meaning bigger (looking at months and days)
            System.out.println("Date one(bigger): 5/5/2019 \tDate two(smaller): 2/15/2019 \tcompareTo() expecting 1: " + d.compareTo(s4));

            //expecting 1, meaning bigger(looking at just days)
            System.out.println("Date one(bigger): 2/17/2019 \tDate two(smaller): 2/15/2019 \tcompareTo() expecting 1: " + s6.compareTo(s4));

            //expecting 1, meaning bigger(looking at just months)
            System.out.println("Date one(bigger): 3/15/2019 \tDate two(smaller): 2/15/2019 \tcompareTo() expecting 1: " + f.compareTo(s4));

         //testing getter methods
            GeoCountDownTimer getterTest = new GeoCountDownTimer(2019, 8, 2 );

            //getting month
            System.out.println("Expected month: 8 \tgetMonth(): " + getterTest.getMonth());

            //getting day
            System.out.println("Expected day: 2 \tgetDay(): " + getterTest.getDay());

            //getting year
            System.out.println("Expected year: 2019 \tgetYear(): " + getterTest.getYear());

         //testing setter methods
            GeoCountDownTimer setterTest = new GeoCountDownTimer(2019, 7, 10);

            //setting day
            setterTest.setDay(12);
            System.out.println("Expected day: 12 \tsetDay(): " + setterTest.getDay());

            //setting month
            setterTest.setMonth(8);
            System.out.println("Expected month: 8 \tsetMonth(): " + setterTest.getMonth());

            //setting year
            setterTest.setYear(2020);
            System.out.println("Expected year: 2020 \tsetMonth(): " + setterTest.getYear());
    }
}
