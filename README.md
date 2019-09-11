# CIS163Project1
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
        month = 0;
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
     * Method that subtracts the number of days and adjusts the timer date down the correct number of days
     * calls the dec() method
     * @param days
     ****************************************************************************************************/
    public void dec(int days) {
        for(int i = days; i > 0; i--) {
            dec();
        }
    }

    /*****************************************************************************************************
     * Method that subtracts 1 day from this GeoCountDownTimer object
     *****************************************************************************************************/
    public void dec() {

        //months of the year that contain 30 days
        if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {

            //if the day of the month is 1, roll over months
            if(this.day == 1) {
                this.day = 31;
                this.month--;
            }

            //if day of the month is greater than 1, subtract 1 from day
            else {
                if(this.day > 1) {
                    this.day--;
                }
            }
        }

        //months of the year that contain 31 days excluding March, including Feb for calculation
        else if(this.month == 1 || this.month == 2 || this.month == 5 || this.month == 7 ||
                this.month == 8 || this.month == 10 || this.month == 12) {

            //if the day is the first of the month
            if(this.day == 1) {

                //if the month is 1(Jan), roll over year and set new day and month and year
                if (this.month == 1) {
                    this.month = 12;
                    this.day = 31;
                    this.year--;

                    //if it is July or Feb, set the days equal to 31
                } else if (this.month == 8 || this.month == 2) {
                    this.month--;
                    this.day = 31;

                //set the days equal to 30
                } else {
                    this.day = 30;
                    this.month--;
                }
            }

            //if the day is greater than the first of the month
            else {
                if(this.day > 1) {
                    this.day--;
                }
            }
        }

        //if it is March
        else if(this.month == 3){

            //if it is not leap year
            if(this.year % 4 != 0) {

               //if it is the first day, roll over to 28 days in Feb
                if(this.day == 1) {
                    this.day = 28;
                    this.month--;
                }
                else{
                    if(this.day > 1) {
                        this.day--;
                    }
                }
            }
            else {

               //if it is leap year
                if(this.day == 1) {
                    this.day = 29;
                    this.month--;
                }
                else {
                    if(this.day > 1) {
                        this.day--;
                    }
                }
            }
        }
    }

    /*****************************************************************************************************
     * Method that adds the number of days to the GeoCountDownTimer Object by calling inc() method
     * @param days
     *****************************************************************************************************/
    public void inc(int days) {
        for(int i = days; i > 0; i--) {
            inc();
        }
    }

    /*****************************************************************************************************
     *Method that adds 1 day to the GeoCountDownTimer object
     *****************************************************************************************************/
    public void inc() {

        //months of the year that contain 30 days
        if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {

            //if the day of the month is 30, add 1 to the month and reset day to 1
            if(this.day == 30) {
                this.day = 1;
                this.month++;
            }

            //if the day of the month is not 30
            else {
                if(this.day < 30) {
                    this.day++;
                }
            }
        }

        //days of the month that contain 31 days
        else if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 ||
        this.month == 10 || this.month == 12) {

            //if the day of the month is 31 reset day to 1 and increase the month by 1
            if(this.day == 31) {

               //if it is December, roll over year and reset month and day to 1
                if(this.month == 12) {
                    this.month = 1;
                    this.day = 1;
                    this.year++;
                }
                else {
                    this.day = 1;
                    this.month++;
                }

             //if the day is less than 31
            } else {
                if(this.day < 31) {
                    this.day++;
                }
            }

         //if the month is February
        } else if(this.month == 2) {

            //if it is not leap year
            if(this.year % 4 != 0) {
               if(this.day == 28) {
                   this.day = 1;
                   this.month++;
               }
               else {
                   if(this.day < 28) {
                       this.day++;
                   }
               }
            }

            //if it is leap year
            else {
                if(this.day == 29) {
                    this.day = 1;
                    this.month++;
                }
                else {
                    if(this.day < 29) {
                        this.day++;
                    }
                }
            }
        }
    }

    /*****************************************************************************************************
     *toString() method that outputs date in Month day, year format
     * @return String fullDate
     *****************************************************************************************************/
    public String toString() {
        String strMonth = "";

        //naming months
        if(this.month == 1) {
            strMonth = "January";
        }
        else if(this.month == 2) {
            strMonth = "February";
        }
        else if(this.month == 3) {
            strMonth = "March";
        }
        else if(this.month == 4){
            strMonth = "April";
        }
        else if(this.month == 5) {
            strMonth = "May";
        }
        else if(this.month == 6) {
            strMonth = "June";
        }
        else if(this.month == 7) {
            strMonth = "July";
        }
        else if(this.month == 8) {
            strMonth = "August";
        }
        else if(this.month == 9) {
            strMonth = "September";
        }
        else if(this.month == 10) {
            strMonth = "October";
        }
        else if(this.month == 11) {
            strMonth = "November";
        }
        else if(this.month == 12) {
            strMonth = "December";
        }

        //creating the full string
        String fullDate = strMonth + " " + this.day + ", " + this.year;

        //return statement
        return fullDate;
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



}


