package start;

import q1.MyDate;
import q2.Location;
import q3.Swimmable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * * @author Matan Daniel, 315783522 and Ron Bar-Zvi, 304969520
 * static functions
 */

public class Utility {
    /**
     * searches if there are 3 following dates in date array
     * @param dates array of dates
     * @return date of first of following of three dates, if there is such. otherwise, returns current date
     */
    public static MyDate threeDates(MyDate[] dates)
    {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < dates.length; i++)
        {
            data.add(dates[i].toString());
        }
        for (int i = 0; i < dates.length; i++)
        {
            if (data.contains(dates[i].nextDate().toString()) && data.contains(dates[i].nextDate().nextDate().toString()))
            {
                return dates[i];
            }
        }
        return new MyDate();
    }

    /**
     * function which finds the location with the highest average temperature
     * @param loc locations (as objects array) with temperature measurements
     * @return index of the highest average location in the array
     */
    public static int getMaxTemp(Location[] loc)
    {
        int index = 0;
        double maxTemp = 0;
        for (int i = 0; i < loc.length; i++)
        {
            if (loc[i].getAverage() > maxTemp)
            {
                maxTemp = loc[i].getAverage();
                index = i;
            }
        }
            return index;
    }

    /**
     * prints animals in aquarium
     * @param arr array of animals in aquarium
     */
    public static void printAquarium(Swimmable[] arr)
    {
        System.out.println("Aquarium[type/color/actual size/eat count]:");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i].toString());
        }
    }

    /**
     * feeds randomly animals in aquarium
     * @param arr array of animals in aquarium
     * @param foodSize amount of food
     */
    public static void feedAquaticAnimal(Swimmable[] arr, int foodSize)
    {
        Random r = new Random();
        for (int i = 0; i < foodSize; i++)
            arr[r.nextInt(arr.length)].eatInc();
    }

    /**
     * receives array of aquarium animals and returns number of swimmable animals smaller than the first swimmable animal in the array
     * @param arr array of animals in aquarium
     * @return number of swimmable animals smaller than the first swimmable animal in the array
     */
    public static int countAquaticAnimal(Swimmable[] arr)
    {
        int counter = 0;
        Swimmable firstSwim = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (firstSwim.compareTo(arr[i]) > 0)
                counter++;
        }
        return counter;
    }

    /**
     * sorts animals in aquarium by descending size
     * @param arr array of animals in aquarium
     */
    public static void sortAquaticAnimal(Swimmable[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j =1+i ; j < arr.length ; j++)
            {
                if (arr[i].getSize() < arr[j].getSize())
                {
                    Swimmable temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

