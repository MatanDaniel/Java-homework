package hw1.q3;
/**
 * * @author Matan Daniel, 315783522 and Ron Bar-Zvi, 304969520
 * fish that changes color everytime if changes its size
 */

public class MultiColorFish extends Fish
{
    /**
     * constructor given params
     * @param size size of fish
     * @param x_front future use
     * @param y_front future use
     * @param horSpeed horizontal speed
     * @param verSpeed vertical speed
     * @param col color of fish
     */
    public MultiColorFish(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col)
    {
        super(size, x_front, y_front, horSpeed, verSpeed, col);
    }
    public String getAnimalName() {
        return "hw1.q3.MultiColorFish";
    }

    public void eatInc() {
        this.setEatCount(this.getEatCount()+1);
        if (this.getEatCount() > this.getEAT_DISTANCE()) {
            this.setSize(this.getSize()+1);
            this.setEatCount(0);
            this.changeColor();
        }
    }



}
