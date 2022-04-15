package hw1.q2;

import hw1.q1.MyDate;
import java.time.LocalDate;

/**
 * @author Matan Daniel, 315783522 and Ron Bar-Zvi, 304969520
 * stores temperature measurement in Celsius by date
 */
public class Temperature
{
    private double scale;
    /**
     * date of scale
     */
    private MyDate scale_date;

    /**
     * constructor given parameters
     * @param scale given temperature
     * @param day given day
     * @param month given month
     * @param year given year
     */
    public Temperature(double scale, int day, int month, int year)
    {
        this.scale = scale;
        scale_date = new MyDate(day,month,year);
    }

    /**
     * creates temperature measurement with current date
     * @param scale given temperature measurement
     */
    public Temperature(double scale)
    {
      scale_date = new MyDate(LocalDate.now().getDayOfMonth(),
              LocalDate.now().getMonthValue(),LocalDate.now().getYear());
      this.scale = scale;
    }

    /**
     * copy c'tor
     * @param other the object to copy from
     */
    public Temperature(Temperature other)
    // Copy constructor:
    {
        if (other != null)
        {
            this.scale = other.scale;
            this.scale_date = other.scale_date;
        }
    }

    public Temperature()
    {}

    /**
     * sets temperature measurement and returns true is successful
     * @param scale a temperature measurement
     * @return true if successful, otherwise false
     */
    public boolean setScale(double scale)
    {
            return (this.scale = scale) == scale;
    }

    /**
     * sets date of temperature measurement and returns true is successful
     * @param scale_date date of a measurement
     * @return true if successful, otherwise false
     */
    public boolean setScale_date(MyDate scale_date)
    {
        if (scale_date == null) return false;
        return (this.scale_date = scale_date).equals(scale_date);
    }

    /**
     * getter of measurement
     * @return measurement value
     */
    public double getScale() {return scale;}

    /**
     * getter of date of measurement
     * @return date of measurement
     */
    public MyDate getScale_date() {return scale_date;}

    /**
     * overrides toString method, measurement to a string
     * @return measurement as a string
     */
    public String toString() {
        if (scale >= 0){
            return "+"+scale + "C°" + "\t" + scale_date;
        }
        else{
            return "-"+scale + "C°" + "\t" + scale_date;
        }
    }

    /**
     * prints temperature measure
     */
    public void printTemp()
    {System.out.println(" C°temp.-" + this.scale);}

    /**
     * prints both temperature measure and date
     */
    public void printTempFull()
    {System.out.println(this.toString());}

    /**
     * compares between 2 temperatures
     * @param other given object with temperature measurement
     * @return the object with the higher temperature
     */
    public Temperature compareTemp(Temperature other)
    {
        if (other.scale > this.scale)
        {
            return other;
        }
        return this;
    }

    /**
     * returns true if current object is equal to given object
     * @param other given object with temperature measurement
     * @return true if objects are same, otherwise false
     */
    public boolean equals(Temperature other)
    {return this == other;}
}
