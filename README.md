# CIS163Project1
CIS 163 Project 1 
package project1;

public class GeoCountDownTimer {

    //instance variables
    private int years;
    private int months;
    private int days;

    /****************************************************************************************************
     * Constructor for instance variables
     * @param years
     * @param months
     * @param days
     ****************************************************************************************************/
    public GeoCountDownTimer(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }

    /****************************************************************************************************
     * Getter method for int days
     * @return int days
     ****************************************************************************************************/
    public int getDays() {
        return days;
    }

    /****************************************************************************************************
     * Setter method for int days
     * @param days
     ****************************************************************************************************/
    public void setDays(int days) {
        this.days = days;
    }

    /*****************************************************************************************************
     * Getter method for int months
     * @return int months
     ****************************************************************************************************/
    public int getMonths() {

        return months;
    }

    /*****************************************************************************************************
     * Setter method for int months
     * @param months
     ****************************************************************************************************/
    public void setMonths(int months) {

        this.months = months;
    }

    /****************************************************************************************************
     * Getter method for int years
     * @return int years
     ****************************************************************************************************/
    public int getYears() {
        return years;
    }

    /****************************************************************************************************
     * Setter method for int years
     * @param years
     ****************************************************************************************************/
    public void setYears(int years) {
        this.years = years;
    }




}
