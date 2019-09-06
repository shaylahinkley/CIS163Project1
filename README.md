# CIS163Project1
CIS 163 Project 1 
package project1;

public class GeoCountDownTimer {

    //instance variables
    private int year;
    private int month;
    private int day;

    /****************************************************************************************************
     * Private constructor that sets GeoCountDownTimer to zero
     ****************************************************************************************************/
    private GeoCountDownTimer() {
        year = 0;
        month= 0;
        day = 0;
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
        if(other != null) {
            this.year = other.year;
            this.month = other.month;
            this.day = other.day;
        }
    }

    /*****************************************************************************************************
     * Constructor that accepts a string as a parameter
     *****************************************************************************************************/
    public GeoCountDownTimer(String geoDate) {
        String date = geoDate;
        String yr = "";
        String mon = "";
        String dy = "";
        int z = 0;
        int y = 0;
        int x = 0;

        //finds first index of '/' for month
        z = geoDate.indexOf('/');

        //creates month substring from index 0 up until index of '/'
        mon = geoDate.substring(0, z);

        //looks for second index of '/' after the first known index of '/'
        y = geoDate.indexOf('/', z);

        //creates day substring from first index of '/' until the second index of '/'
        dy = geoDate.substring(z, y);

        //creates year substring from second known index of '/' to the end of the string
        yr = geoDate.substring(y, geoDate.length());
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

        if(this == obj) {
            return true;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        if(other == null) {
            return false;
        }
        if(this.day != other.day) {
            return false;
        }
        if(this.year != other.year) {
            return false;
        }
        if(this.month != other.month) {
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
        if(this.equals(other)) {
            return 0;
        }

        //checks the years and turns -1 if smaller
        if(this.year < other.year) {
            return -1;
        }

        //checks if year is greater and returns 1
        else if(this.year > other.year) {
            return 1;
        }

        //if years are the same
        else if(this.year ==  other.year) {

            //checks month and returns -1 if the month is smaller
            if(this.month < other.month) {
                return -1;
            }

            //checks month and returns 1 if the month is greater
            else if(this.month > other.month) {
                return 1;
            }

            //if the months are equal
            else if(this.month == other.month) {

                //checks day and returns -1 if smaller
                if(this.day < other.day) {
                    return -1;
                }

                //checks day and returns 1 if smaller
                else if(this.day > other.day) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /****************************************************************************************************
     * Method that substracts the number of days and adjusts the timer date down the correct number of days
     * @param days
     ****************************************************************************************************/

   /****************************************************************************************************
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



}
