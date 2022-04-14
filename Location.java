package q2;

import java.time.LocalDate;
import java.util.Arrays;


/**
 * commit testttttttt
 * @author Matan Daniel, 315783522 and Ron Bar-Zvi, 304969520
 *
 */
public class Location
{
    private String name;
    private Temperature[] temperatures;

    /**
     * default constructor
     */
    public Location(){this.name = "";}

    /**
     * constructor given a parameter
     * @param name name of location
     */
    public Location(String name) {
        this.name = name;
        temperatures = new Temperature[0];
    }

    /**
     * getter
     */
    public String getName() {return name;}

    /**
     * sets a name for a location
     * @param name name of a location
     * @return true if successful, otherwise false
     */
    public boolean setName(String name)
    {
        if (name == null)return false;
        this.name = name;
        return true;
    }

    /**
     * array of temperature measurements
     * @return object of temperatures
     */
    public Temperature[] getTemperatures() {return temperatures;}

    /**
     * insert temperature measurements to array
     * @param temperatures array of measurements of temperatures
     * @return true is successfully inserted to array, otherwise false
     */
    public boolean setTemperatures(Temperature[] temperatures)
    {
        if (temperatures.length > 0){
            this.temperatures = temperatures;
            return true;
        }
        return false;
    }

    /**
     * compares 2 location names
     * @param other second location object
     * @return true if names are same, otherwise false
     */
    public boolean equals(Location other) {return (this.name == other.name) && Arrays.equals(this.temperatures,other.getTemperatures());}

    /**
     * prints location's temperatures
     * @param range range of temperatures between range+avg and range-avg
     */
    public void printLocation(double range)
    {
        if (temperatures.length == 0)
        {
            System.out.println("There are no measurements available for " + name);
            return;
        }
        System.out.print(this.name + " temperature measurements: ");
        double Avg = this.getAverage();
        for (int i = 0; i < temperatures.length; i++)
        {
            if (temperatures[i].getScale() >= Avg-range && temperatures[i].getScale() <= Avg+range) {
                temperatures[i].printTempFull();
            }
        }
    }

    /**
     * prints
     */
    public void printLocation(){
        printLocation(Double.MAX_VALUE);
    }

    /**
     * calculates average of temperatures
     * @return average of temperatures
     */
    public double getAverage()
    {
        double count =0, sum =0;

        for (int i = 0; i < temperatures.length; i++)
        {
            if(temperatures[i]!=null) {
                count++;
                sum += temperatures[i].getScale();
            }
        }
        if(count != 0)
            sum= sum/count;
        return sum;
    }

    /**
     * adds a temperature measurement on a given date to measurement array
     * @param scale given temperature
     * @param day given day
     * @param month given month
     * @param year given year
     */
    public void addTemp(double scale, int day, int month, int year)
    {
        Temperature[] temp2 = new Temperature[temperatures.length+1];
        System.arraycopy(this.temperatures, 0, temp2, 0, temperatures.length); //shallow copy
        temp2[temperatures.length] = new Temperature(scale, day, month, year);
        temperatures = temp2;
    }

    /**
     * adds a temperature measurement with current date
     * @param scale given temperature
     */
    public void addTemp(double scale)
    {
        this.addTemp(scale, LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(), LocalDate.now().getYear());
    }

    /**
     * finds and returns max temperature in temperature measurements
     * @return max temperature in array
     */
    public Temperature getMax()
    {
        var max = this.temperatures[0];
        for (int i = 1; i < this.temperatures.length; i++)
        {
            var temp = this.temperatures[i];
            if (max.getScale() < temp.getScale())
               max = temp;
        }
        return max;
    }

    /**
     * overrides string function
     * @return location and temperature measurements
     */
    public String toString(){
        var value = ("Location: " + name + '\n');
        if (temperatures.length == 0) {
            return value + "No temperature data";
        }
        for (var t: temperatures){
            value += t.toString() + '\n';
        }
        return value;
    }


}
