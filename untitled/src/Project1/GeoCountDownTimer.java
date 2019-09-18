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
     * @return
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

        //finds first index of '/' for month
        z = startDate.indexOf('/');

        //creates month substring from index 0 up until index of '/'
        mon = startDate.substring(0, z);

        //looks for second index of '/' after the first known index of '/'
        y = startDate.indexOf('/', z);

        //creates day substring from first index of '/' until the second index of '/'
        dy = startDate.substring(z, y);

        //creates year substring from second known index of '/' to the end of the string
        yr = startDate.substring(y, startDate.length());
    }

    /*****************************************************************************************************
     * Method that checks if two GeoCountDownTimer objects are the same
     * @param s1
     * @param s2
     * @return
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
        if (isLeapYear(this.year) && this.month == 3) {
            day = DAYS_IN_MONTH[this.month - 1] + 1;
        }

        //if it is the first day of the month
        if (this.day == 1) {

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
     * Setter method for int month33333
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
        GeoCountDownTimer s = new GeoCountDownTimer("2/10/2020");
        System.out.println("Date: " + s);

        GeoCountDownTimer s1 = new GeoCountDownTimer("2/10/2022");
        System.out.println("Date: " + s1.toString());

        s1.dec(365);
        System.out.println("Date: " + s1);

        GeoCountDownTimer s2 = new GeoCountDownTimer("2/10/2019");
        for (int i = 0; i < (365 + 366); i++)
            s2.inc(1);
        System.out.println("Date: " + s2);

        // Create many more test cases in this driver method to
        // prove the class is functioning correctly

    }
}
