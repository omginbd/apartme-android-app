package aprtme.website.apartme.model;

import java.io.Serializable;

/**
 * Created by patri_000 on 10/12/2017.
 */

public class Date implements Serializable {


    private int month;
    private int day;
    private int year;

    public Date(){
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }

    public Date(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public String toStringNoYear(){
        switch(month) {
            case 1:
                return "Jan " + day;
            case 2:
                return "Feb " + day;
            case 3:
                return "Mar " + day;
            case 4:
                return "Apr " + day;
            case 5:
                return "May " + day;
            case 6:
                return "Jun " + day;
            case 7:
                return "Jul " + day;
            case 8:
                return "Aug " + day;
            case 9:
                return "Sep " + day;
            case 10:
                return "Oct " + day;
            case 11:
                return "Nov " + day;
            case 12:
                return "Dec " + day;

        }
        return "invalid";
    }

    public String toString() {

        switch(month) {
            case 1:
                return "Jan " + day + " " + year;
            case 2:
                return "Feb " + day + " " + year;
            case 3:
                return "Mar " + day + " " + year;
            case 4:
                return "Apr " + day + " " + year;
            case 5:
                return "May " + day + " " + year;
            case 6:
                return "Jun " + day + " " + year;
            case 7:
                return "Jul " + day + " " + year;
            case 8:
                return "Aug " + day + " " + year;
            case 9:
                return "Sep " + day + " " + year;
            case 10:
                return "Oct " + day + " " + year;
            case 11:
                return "Nov " + day + " " + year;
            case 12:
                return "Dec " + day + " " + year;

        }
        return "invalid";
    }

    public void setMonth(int month) {
        this.month = month;
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
