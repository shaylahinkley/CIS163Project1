package Project1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


/**********************************************************************************************************
 * CIS 163 01 Project One
 *
 * Creates methods for a GeoCountDownTimer that allows the user to countdown to a specific date
 *@author Keilani Bailey & Shayla Hinkley
 *@version 1.0
 **********************************************************************************************************/
public class GeoCountDownTimer {

    /** private instance variable for the year*/
    private int year;

    /** private instance variable for the month*/
    private int month;

    /**  private instance variable for the day*/
    private int day;

    /** private static final instance variable that sets the minimum year to 2019*/
    private static final int MIN_YEAR = 2019;

    /****************************************************************************************************
     * Private constructor that sets GeoCountDownTimer to zero
     ****************************************************************************************************/
    private GeoCountDownTimer() {
        year = 0;
        month = 0;
        day = 0;
    }

    /****************************************************************************************************
     * Constructor that initializes the instance variables
     * @param year int
     * @param month int
     * @param day int
     ****************************************************************************************************/
    public GeoCountDownTimer(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

        //throws error if illegal year
        if(this.year < MIN_YEAR) {
            throw new IllegalArgumentException();

            //throws error if illegal month
        } else if(this.month < 1 || this.month > 12) {
            throw new IllegalArgumentException();

            //throws error if leap year and illegal day
        } else if(!isLeapYear(this.year) && this.day > DAYS_IN_MONTH[this.month]) {
            throw new IllegalArgumentException();

            //throws error if illegal day
        } else if(this.day < 0) {
            throw new IllegalArgumentException();

            //throws error if illegal day and leap year
        } else if(isLeapYear(this.year) && this.month == 2 && this.day > 29) {
            throw new IllegalArgumentException();
        }
    }

    /*****************************************************************************************************
     * Constructor that accepts a string as a parameter and parses the string to type integer
     * to be able to be set to the instance variables of object GeoCountDownTimer
     * @param startDate String in the form of MM/dd/yyyy
     *****************************************************************************************************/
    public GeoCountDownTimer(String startDate) {

        //initializing variables
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
        dy = startDate.substring(z + 1, lastIndex);

        //creates year substring form last known index of '/' to the end of the string
        yr = startDate.substring(lastIndex + 1);

        //parses String to Integer
        this.month = Integer.parseInt(mon);
        this.year = Integer.parseInt(yr);
        this.day = Integer.parseInt(dy);

        //throws error if illegal year
        if(this.year < MIN_YEAR) {
            throw new IllegalArgumentException();

            //throws error if illegal month
        } else if(this.month < 1 || this.month > 12) {
            throw new IllegalArgumentException();

            //throws error if leap year and illegal day
        } else if(!isLeapYear(this.year) && this.day > DAYS_IN_MONTH[this.month]) {
            throw new IllegalArgumentException();

            //throws error if illegal day
        } else if(this.day < 0) {
            throw new IllegalArgumentException();

            //throws error if illegal day and leap year
        } else if(isLeapYear(this.year) && this.month == 2 && this.day > 29) {
            throw new IllegalArgumentException();
        }
    }

    /****************************************************************************************************
     * Constructor that initializes the instance variables with the other GeoCountDownTimer parameter
     * @param other GeoCountDownTimer
     ****************************************************************************************************/
    public void GeoCountDownTimer(GeoCountDownTimer other) {

        //throw error if illegal year
        if(other.year < MIN_YEAR) {
            throw new IllegalArgumentException();

            //throw error if illegal month
        } else if(other.month < 1 || other.month > 12) {
            throw new IllegalArgumentException();

            //throw error if illegal days not during leap year
        } else if(!isLeapYear(other.year) && other.day > DAYS_IN_MONTH[other.month]) {
            throw new IllegalArgumentException();

            //throw error if illegal days
        } else if(other.day < 0) {
            throw new IllegalArgumentException();

            //throw error if illegal days during leap year
        } else if(isLeapYear(other.year) && other.month == 2 && other.day > 29) {
            throw new IllegalArgumentException();
        }

        //checks if other GeoCountDownTimer exists and references other when this. is called
        if (other != null) {
            this.year = other.year;
            this.month = other.month;
            this.day = other.day;
        }
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
     * @param month int
     * @param day int
     * @param year int
     * @return boolean true
     ***************************************************************************************************/
    private static boolean isValidDate(int month, int day, int year) {
        return true;
    }

    /***************************************************************************************************
     * Method that checks if a given year is a leap year
     * @param year int
     * @return boolean true
     ***************************************************************************************************/
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /*****************************************************************************************************
     * Method that checks if two GeoCountDownTimer objects are the same
     * @param s1 GeoCountDownTimer object
     * @param s2 GeoCountDownTimer object
     * @return true
     *****************************************************************************************************/
    public static boolean equals(GeoCountDownTimer s1, GeoCountDownTimer s2) {

        //throws error if isValidDate() is false meaning not an integer
        if(!isValidDate(s1.getYear(), s1.getMonth(), s1.getDay()) || !isValidDate(s2.getYear(), s2.getMonth(), s2.getDay())) {
            throw new IllegalArgumentException();
        }

        //throws error if illegal year
         else if(s1.year < 2019 || s2.year < 2019) {
            throw new IllegalArgumentException();

        //throws error if illegal month
        } else if(s1.month < 1 || s1.month > 12 || s2.month < 1 || s2.month > 12) {
            throw new IllegalArgumentException();

        //throws error if leap year and illegal day
        } else if(!isLeapYear(s1.year) && s1.day > DAYS_IN_MONTH[s1.month] || !isLeapYear(s2.year) && s2.day > DAYS_IN_MONTH[s2.month]) {
            throw new IllegalArgumentException();

        //throws error if illegal day
        } else if(s1.day < 0 || s2.day < 0) {
            throw new IllegalArgumentException();

        //throws error if illegal day and leap year
        } else if(isLeapYear(s1.year) && s1.month == 2 && s1.day > 29 || isLeapYear(s2.year) && s2.month == 2 && s2.day > 29) {
            throw new IllegalArgumentException();
        }
        return (s2.year == s1.year) && (s2.month == s1.month) && (s2.day == s1.day);
    }

    /*****************************************************************************************************
     * Method that checks if GeoCountDownTimer object is exactly the same as the other object
     * @param obj Object
     * @return true
     *****************************************************************************************************/
    @Override
    public boolean equals(Object obj) {

        //casting other object as a GeoCountDownTimer object
        GeoCountDownTimer other = (GeoCountDownTimer) obj;

        //checks if this is the same as input Object
        if (this == obj) {
            return true;
        }

        //checks if the classes are the same
        if (getClass() != obj.getClass()) {
            return false;
        }

        //checks if other exists
        if (other == null) {
            return false;
        }

        //checks if the days are equal
        if (this.day != other.day) {
            return false;
        }

        //checks if years are equal
        if (this.year != other.year) {
            return false;
        }

        //checks if months are equal
        if (this.month != other.month) {
            return false;
        }
        return true;
    }

    /*******************************************************************************************************************
     * Method that compares two dates to each other in terms of in past or future
     * @param other GeoCountDownTimer
     * @return  0 int
     *******************************************************************************************************************/
    public int compareTo(GeoCountDownTimer other) {

        //throws error if the date is not of type int
        if(!isValidDate(other.getYear(), other.getMonth(), other.getDay())) {
            throw new IllegalArgumentException();
        }

        //throws error if illegal year
        else if(other.year < MIN_YEAR) {
            throw new IllegalArgumentException();

        //throws error if illegal month
        } else if(other.month < 1 || other.month > 12) {
            throw new IllegalArgumentException();

        //throws error if leap year and illegal day
        } else if(!isLeapYear(other.year) && other.day > DAYS_IN_MONTH[other.month]) {
            throw new IllegalArgumentException();

        //throws error if illegal day
        } else if(other.day < 0) {
            throw new IllegalArgumentException();

        //throws error if illegal day and leap year
        } else if(isLeapYear(other.year) && other.month == 2 && other.day > 29) {
            throw new IllegalArgumentException();
        }


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

                //checks day and returns 1 if bigger
                else if (this.day > other.day) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /****************************************************************************************************
     * Method that subtracts the number of days and adjusts the timer date down the correct number of days
     * that the user wants
     * calls the dec() method
     * @param days int
     ****************************************************************************************************/
    public void dec(int days) {

        //calls dec() method as many times as int days
        for (int i = days; i > 0; i--) {
            dec();
        }
    }

    /*****************************************************************************************************
     * Method that subtracts 1 day from this GeoCountDownTimer object date
     *****************************************************************************************************/
    public void dec() {

        int isLeapYear = 0;

        //if it is leap year and the month is Match
        if (isLeapYear(this.year) && this.month == 3 && this.day == 1) {
            day = DAYS_IN_MONTH[this.month - 1] + 1;
            this.month--;
        }

        //if it is the first day of the month
        else if (this.day == 1) {

            //if it is January, set day to DAYS_IN_MONTH of December and decrease the year
            if (this.month == 1) {
                day = DAYS_IN_MONTH[12];
                this.month = 12;
                this.year--;
            }

            //if it is not Jan, set days equal to the DAYS_IN_MONTH of the previous month
            else {
                day = DAYS_IN_MONTH[this.month - 1];
                this.month--;
            }

        //decrease day by 1
        } else {
            this.day--;
        }
    }


    /*****************************************************************************************************
     * Method that adds the number of days and adjusts the timer date up the correct number of days
     * that the user wants
     * calls inc() method
     * @param days int
     *****************************************************************************************************/
    public void inc(int days) {

        //calls inc() as many times as int days
        for (int i = days; i > 0; i--) {
            inc();
        }
    }

    /*****************************************************************************************************
     *Method that adds 1 day to the GeoCountDownTimer object date
     *****************************************************************************************************/
    public void inc() {

        int daysInMonth = 0;

        //checks for leap year and if month is February, add one to day in month
        if (isLeapYear(this.year) && this.month == 2) {
            daysInMonth = DAYS_IN_MONTH[this.month] + 1;

        //if no leap year and not February
        } else {
            daysInMonth = DAYS_IN_MONTH[this.month];
        }

        //checks if it is the last day of the month
        if (this.day == daysInMonth) {

            //if it is December set day equal to 1, month to 1, and increase year by 1
            if (this.month == 12) {
                day = 1;
                month = 1;
                this.year++;

            //set day to 1, increase year by 1
            } else {
                day = 1;
                month++;

            }

        //increase day by 1
        } else {
            this.day++;
        }
    }

    /*****************************************************************************************************
     *toString() method that outputs date in Month day, year format from the GeoCountDownTimer object
     * @return String s
     *****************************************************************************************************/
    public String toString() {
        String s = MONTHS[this.month] + " " + this.day + ", " + this.year;
        return s;
    }

    /*****************************************************************************************************
     * toDateString() method outputs date in month/day/year format from the GeoCountDownTimer object
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
     * @param day int
     ****************************************************************************************************/
    public void setDay(int day) {

        //throw error if illegal day
        if(!isLeapYear(this.year) && day > DAYS_IN_MONTH[this.month]) {
            throw new IllegalArgumentException();

            //throws error if illegal day
        } else if(day< 0) {
            throw new IllegalArgumentException();

            //throws error if illegal day and leap year
        } else if(isLeapYear(this.year) && this.month == 2 && day> 29) {
            throw new IllegalArgumentException();
        }

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
     * @param month int
     ****************************************************************************************************/
    public void setMonth(int month) {

        //throw error if illegal input
        if(month < 1 || month > 12) {
            throw new IllegalArgumentException();
        }
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
     * @param year int
     ****************************************************************************************************/
    public void setYear(int year) {

        if(year < MIN_YEAR) {
            throw new IllegalArgumentException();
        }
        this.year = year;
    }

    /****************************************************************************************************
     * Method that saves a GeoCountDownTimer
     * @param filename String
     ****************************************************************************************************/
    public void save(String filename) {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println(this.month + "/" + this.day + "/" + this.year);
        out.close();
    }

    /************************************************************************************************************
     *Method that loads GeoCountDownTimer object from file
     * @param fileName String
     ************************************************************************************************************/
    public void load(String fileName) {

        try {
            // open the data file
            Scanner fileReader = new Scanner(new File(fileName));

            // read one String in of data and an int
            this.month = fileReader.nextInt();
            this.day = fileReader.nextInt();
            this.year = fileReader.nextInt();
            System.out.println(this.month + "/" + this.day + "/" + this.year);
        }

        // could not find file
        catch (Exception error) {
            System.out.println("File not found ");
        }
    }

    /*************************************************************************************************
     *Method that counts the amount of days leading up until the GeoCountDownTimer Date
     * @param fromDate String is the beginning date until the GeoCountDownTimer object date
     * @return int totDaysBetween
     *************************************************************************************************/
    public int daysToGo(String fromDate) {
        String date = fromDate;
        String yr = "";
        String mon = "";
        String dy = "";
        int z = 0;
        int y = 0;
        int x = 0;
        int lastIndex = 0;

        //finds first index of '/' for month
        z = fromDate.indexOf('/');

        //creates month substring from index 0 up until index of '/'
        mon = fromDate.substring(0, z);

        //looks for last index of '/'
        lastIndex = fromDate.lastIndexOf('/');

        //creates day substring from first index of '/' until the last index of '/'
        dy = fromDate.substring(z + 1, lastIndex);

        //creates year substring form last known index of '/' to the end of the string
        yr = fromDate.substring(lastIndex + 1);

        //creates a sample toDateString() format
        String dateStr = mon + "/" + dy + "/" + yr;

        //parses String to Integer
        int fromMonth = Integer.parseInt(mon);
        int fromYear = Integer.parseInt(yr);
        int fromDay = Integer.parseInt(dy);

        //throws error if the date is not of type int
        if(!isValidDate(fromYear, fromMonth, fromDay)) {
            throw new IllegalArgumentException();
        }

        //throws error if illegal year
         else if(fromYear < MIN_YEAR) {
            throw new IllegalArgumentException();

        //throws error if illegal month
        } else if(fromMonth < 1 || fromMonth > 12) {
            throw new IllegalArgumentException();

        //throws error if leap year and illegal day
        } else if(!isLeapYear(fromYear) && fromDay > DAYS_IN_MONTH[fromMonth]) {
            throw new IllegalArgumentException();

        //throws error if illegal day
        } else if(fromDay < 0) {
            throw new IllegalArgumentException();

        //throws error if illegal day and leap year
        } else if(isLeapYear(fromYear) && fromMonth == 2 && fromDay > 29) {
            throw new IllegalArgumentException();
        }

        GeoCountDownTimer dayToGo = new GeoCountDownTimer(fromYear, fromMonth, fromDay);
        int totDaysBetween = 0;

        if(this.compareTo(dayToGo) == -1) {
            throw new IllegalArgumentException();
        } else {
            //creating date format
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try {

                //parses strings to Date data type
                Date toDate = sdf.parse(toDateString());
                Date secondDate = sdf.parse(dateStr);

                //calculating the time between
                long diff = secondDate.getTime() - toDate.getTime();

                //converting to days
                float daysBetween = (diff / (1000 * 60 * 60 * 24));

                //casting daysBetween as typ int
                totDaysBetween = (int) Math.abs(daysBetween);
                System.out.println("Days between: " + totDaysBetween);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return totDaysBetween;
        }
    }

    /*************************************************************************************************
     * Method that returns the date of the date that is n future days away from GeoCountDownTimer object
     * @param n int
     * @return GeoCountDownTimer daysIntFuture
     *************************************************************************************************/
    public GeoCountDownTimer daysInFuture(int n) {

        //creating new GeoCountDownTimer object that is the same as the current GeoCountDownTimerObject
        GeoCountDownTimer daysInFuture = new GeoCountDownTimer(this.year, this.month, this.day);

        //if the days is less than 0, decrease date by n
        if(n < 0) {
            daysInFuture.dec(Math.abs(n));
            return daysInFuture;

            //if the days in future is greater than 0, increase date by n
        } else if(n > 0){
            daysInFuture.inc(n);
            return daysInFuture;
        }
        return daysInFuture;
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
        System.out.println("Date expected: 2/10/2022 \tstartDate() and toString() date: " + s1.toDateString());

        //testing toString() method
        GeoCountDownTimer s9 = new GeoCountDownTimer(2019, 5, 2);
        System.out.println("Expecting: May 2, 2019 \ttoString(): " + s9.toDateString());

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

            //expecting 1, meaning bigger(looking at just years)
            GeoCountDownTimer daysCompare = new GeoCountDownTimer(2022, 3, 1);
            GeoCountDownTimer daysCompare2 = new GeoCountDownTimer(2021, 3, 1);
            System.out.println("Date one(bigger): 3/1/2022 \tDate two(smaller): 3/1/2021 \tcompareTo() expecting 1: " + daysCompare.compareTo(daysCompare2));

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

         //testing daysToGo() method

            // in case of leap year
            GeoCountDownTimer tryMe = new GeoCountDownTimer(2020, 3, 1);
            tryMe.daysToGo("2/28/2020");

             //in a case that it is not leap year
            GeoCountDownTimer tryMe2 = new GeoCountDownTimer(2019, 3, 1);
            tryMe2.daysToGo("2/28/2019");

            //for multiple leap year days
            GeoCountDownTimer tryMe10 = new GeoCountDownTimer(2020, 3, 1);
            tryMe10.daysToGo("3/1/2019");

            //for the correct number of days in a year
            GeoCountDownTimer tryMe11 = new GeoCountDownTimer(2022, 3, 1);
            tryMe11.daysToGo("3/1/2021");

         //testing daysInFuture() method

            // with positive n
            GeoCountDownTimer tryMe3 = new GeoCountDownTimer(2019, 3, 10);
            System.out.println("Expected date:  3/15/2019 \tfuture date: " + tryMe3.daysInFuture(5).toDateString());

            //with negative n
            GeoCountDownTimer tryMe4 = new GeoCountDownTimer(2019, 4, 10);
            System.out.println("Expected date: 4/5/2019 \tfuture date: " + tryMe4.daysInFuture((-5)).toDateString());

            //with positive n, going over a leap year
            GeoCountDownTimer tryMe5 = new GeoCountDownTimer(2020, 2, 28);
            System.out.println("Expected date: 3/4/2020 \tfuture date: " + tryMe5.daysInFuture(5).toDateString());

            //with positive n, going over a non leap year
            GeoCountDownTimer tryMe6 = new GeoCountDownTimer(2019, 2, 28);
            System.out.println("Expected date: 3/5/2019 \tfuture date: " + tryMe6.daysInFuture(5).toDateString());

            //with negative n, going over a leap year
            GeoCountDownTimer tryMe7 = new GeoCountDownTimer(2020, 3, 4);
            System.out.println("Expected date: 2/28/2020 \tfuture date: " + tryMe7.daysInFuture((-5)).toDateString());

            //with negative n, going over a non leap year
            GeoCountDownTimer tryMe8 = new GeoCountDownTimer(2020, 3, 5);
            System.out.println("Expected date: 2/28/2020 \tfuture date: " + tryMe8.daysInFuture((-5)).toDateString());
    }
}
