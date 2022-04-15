package hw1.q3;
/**
 * * @author Matan Daniel, 315783522 and Ron Bar-Zvi, 304969520
 */


public class UnusualFish extends Fish
{
    private int factor;

    /**
     * constructor given parameters
     * @param size size of fish
     * @param x_front future use
     * @param y_front future use
     * @param horSpeed horizontal speed
     * @param verSpeed vertical speed
     * @param col color of fish
     * @param factor value of unusual fish
     */
    public  UnusualFish(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col,int factor)
    {
        super(size,x_front,y_front,horSpeed,verSpeed,col);
        this.factor = factor;
    }

    /**
     * default constructor
     * @param factor value of multiplication of unusual fish
     */
    public UnusualFish(int factor) {this.factor = factor;}

    /**
     * setter of value of multiplication of unusual fish
     * @param factor value of multiplication of unusual fish
     * @return true if successful, otherwise false
     */
    public Boolean setFactor(int factor)
    {
        this.factor = factor;
        return true;
    }

    /**
     * getter of factor
     * @return factor value
     */
    public int getFactor() {return factor;}
    public int getSize() {return super.getSize() *factor;}
    @Override
    public String getAnimalName()
    {
        return "hw1.q3.UnusualFish";
    }

}
