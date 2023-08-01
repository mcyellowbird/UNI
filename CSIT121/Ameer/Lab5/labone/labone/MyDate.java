/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 4 lab
-------------------------------------------------------*/
package labone;

public class MyDate implements Cloneable, Comparable < MyDate > {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(MyDate mydate) {
        this.year = mydate.year;
        this.month = mydate.month;
        this.day = mydate.day;
    }

    @Override
    public int compareTo(MyDate date) {
        if (date.day == day && date.month == month && date.year == year) {
            return 0;
        }
        return isExpired(date) ? 1 : -1;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    @Override
    public MyDate clone() throws CloneNotSupportedException {
        return (MyDate) super.clone();
    }

    Boolean isExpired(MyDate expiryDate) {
        if (expiryDate.getYear() >= year) {
            if (expiryDate.getMonth() >= month) {
                if (expiryDate.getDay() >= day) {
                    return true;
                }
            }

        }
        return false;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
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

}