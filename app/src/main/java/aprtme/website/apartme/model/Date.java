package aprtme.website.apartme.model;

/**
 * Created by patri_000 on 10/12/2017.
 */

public class Date {


    public enum MONTH{JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC}
    private MONTH month;
    private int day;
    private int year;


    public Date(MONTH month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
