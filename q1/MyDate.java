package q1;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Matan Daniel, 315783522 and Ron Bar-Zvi, 304969520
 * stores and enables actions on a certain date
 *
 */
public class MyDate
{
    private int day, month, year;
    /**
     *default constructor
     */
    public MyDate()
    {

        day = LocalDate.now().getDayOfMonth();
        month = LocalDate.now().getMonthValue();
        year = LocalDate.now().getYear();
    }
    /**
     * constructor given parameters
     * @param d given day
     * @param m given month
     * @param y given year
     */
    public MyDate(int d, int m, int y)
    {

        if(d >= 1 && d <= 31) this.day = d;
        else{day = LocalDate.now().getDayOfMonth();}
        if(m >= 1 && m <= 12) this.month = m;
        else{month = LocalDate.now().getMonthValue();}
        if(y >= 1900 && y <= 2100) this.year = y;
        else{year = LocalDate.now().getYear();}
    }

    /**
     * copy ctor
     * @param other date to copy from
     */
    public MyDate(MyDate other){
        this(); // initialization
        if(other!=null)
        {
            this.day = other.day;
            this.month = other.month;
            this.year = other.year;
        }
    }
    // Getters & Setters for each field:
    /**
     * getter
     * @return day
     */
    public int getDay() {return day;}
    /**
     * setter
     * @param day
     * @return true if successful or false if failed to set day value
     */
    public boolean setDay(int day) {
        if(day < 1 || day >30)
            return false;
        this.day = day;
        return true;
    }

    /**
     * getter
     * @return month
     */
    public int getMonth() {return month;}

    /**
     * setter
     * @param month
     * @return true if successful or false if failed to set month value
     */
    public boolean setMonth(int month)
    {
        if (month <1 || month <12)
            return false;
        this.month = month;
        return true;
    }

    /**
     * getter
     * @return day
     */
    public int getYear(){return year;}

    /**
     * setter
     * @param year
     * @return true if successful or false if failed to set year value
     */
    public boolean setYear(int year)
    {
        if (year >2100 || year < 1900)
            return false;
        this.year = year;
        return true;
    }


    /**
     * overrides implemented toString function
     * @return date in string format
     */
    public String toString(){
        return String.format("%02d/%02d/%04d",day, month , year);}
    /**
     * prints date
     */
    public void printDate(){System.out.println(day + "/" + month + "/" + year);}

    /**
     * prints month
     */
    public void printMonthName()
    {System.out.println(day + " "+  Month.of(this.month).name() + " "+ this.year);}

    /**
     * @return number of days in a month
     */
    public int getMonthDay()
    {
        int[] dates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return dates[this.month - 1];
    }

    /**
     * checks if a year is a leap year
     * @return true if is a leap year, otherwise returns false
     */
    public boolean isLeapYear() {return LocalDate.of(year,month,day).isLeapYear();}

    /**
     * checks if the following day is valid and if so creates new object of the following day
     * @return new object with the following day date
     */
    public MyDate nextDate()
    {
        var x =LocalDate.of(year,month,day).plusDays(1);
        return new MyDate(x.getDayOfMonth(),x.getMonthValue(),x.getYear());
    }

    /**
     * converts date to certain format depends on the given parameter and prints in the new format
     * @param format receives string format
     */
    public void printFormatDate(String format)
    {
        switch (format) {
            case "ddmmyy" -> System.out.println(day + "/" + month + "/" + year % 100);
            case "ddmmyyyy" -> System.out.println(toString());
            case "mmddyyyy" -> System.out.println(month + "/" + day + "/" + year);
            case "yyyymmdd" -> System.out.println(year + "/" + month + "/" + day);
            case "ddMMyyyy" -> printMonthName();
        }
    }

    /**
     * compares between 2 dates, the current object and "other"
     * @param other the date to compare with
     * @return 0 if identical, -1 if this date is earlier than "other" date, else returns 1
     */
    public int compareDate(MyDate other)
    {
        var now = LocalDate.of(year,month,day);
        var after = LocalDate.of(other.year,other.month,other.day);
        return  Math.max(-1, Math.min(1,now.compareTo(after)));
    }

    /**
     * overrids equals function
     * @param other date to compare with
     * @return true if dates are equals, otherwise false
     */
    public boolean equals(MyDate other)
    // Equals function override:
    {return this.day == other.day && this.month == other.month && this.year == other.year;}
}