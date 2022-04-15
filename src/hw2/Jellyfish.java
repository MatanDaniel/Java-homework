package hw2;


import java.awt.*;
import java.util.concurrent.CyclicBarrier;

/**
 * * @author Matan Daniel, 315783522 and Ron Bar-Zvi, 304969520
 */
public class Jellyfish extends Swimmable {
        private static final int EAT_DISTANCE = 4;
        private int size;
        private int col, eatCount, x_front,y_front;
        private int x_dir, y_dir;

        /**
         * constructor given params
         * @param size base size of jellyfish
         * @param x_front future use
         * @param y_front future use
         * @param horSpeed horizontal speed
         * @param verSpeed vertical speed
         * @param col color of jellyfish
         */
        public Jellyfish(int size, int x_front, int y_front, int horSpeed, int verSpeed, int col)
        {
            super(horSpeed, verSpeed);
            this.size = size;
            this.x_front = x_front;
            this.y_front =y_front;
            this.col = col;
            eatCount = 0;
            y_dir = 1;
            x_dir = 1;
        }

        // Getters for each field:

        /**
         * getter
         * @return amount of food a jellyfish can eat
         */
        public int getEAT_DISTANCE() {return EAT_DISTANCE;}
        @Override
        public int getSize() {return size;}
        public String getColor()
        {
            return switch (col) {
                case 1 -> "Black";
                case 2 -> "Red";
                case 3 -> "Blue";
                case 4 -> "Green";
                case 5 -> "Cyan";
                case 6 -> "Orange";
                case 7 -> "Yellow";
                case 8 -> "Magenta";
                case 9 -> "Pink";
                default -> " ";
            };
        }

        public void eatInc() {
            eatCount++;
            if (eatCount > EAT_DISTANCE) {
                size++;
                eatCount = 0;
            }
        }

        @Override
        public String getAnimalName()
        {
            return "q3.Jellyfish";
        }

        /**
         * getter (future use)
         */
        @Override
        public int getEatCount() {return eatCount;}
        /**
         * getter (future use)
         */
        public int getX_front() {return x_front;}
        /**
         * getter (future use)
         */
        public int getY_front() {return y_front;}
        /**
         * getter (future use)
         */
        public int getX_dir() {return x_dir;}
        /**
         * getter (future use)
         */
        public int getY_dir() {return y_dir;}

        // Setters for each field

        /**
         * setter
         * @param size base size of jellyfish
         */
        public void setSize(int size) {this.size = size;}

        /**
         * setter
         * @param col color of jellyfish
         */
        public void setCol(int col) {this.col = col;}

        /**
         * setter
         * @param eatCount how much a jellyfish can eat
         */
        public void setEatCount(int eatCount) {this.eatCount = eatCount;}

        /**
         * setter future use
         * @param x_front
         */
        public void setX_front(int x_front) {this.x_front = x_front;}

        /**
         * setter future use
         * @param y_front
         */
        public void setY_front(int y_front) {this.y_front = y_front;}

        /**
         * setter future use
         * @param x_dir
         */
        public void setX_dir(int x_dir) {this.x_dir = x_dir;}

        /**
         * setter future use
         * @param y_dir
         */
        public void setY_dir(int y_dir) {this.y_dir = y_dir;}

        /**
         * change size of jellyfish
         * @return new size
         */
        public int changeJellyFish() {
            if (eatCount == EAT_DISTANCE)
                size++;
            return size;
        }

    public void drawAnimal(Graphics g)
    {
        int numLegs;
        if(size<40)
            numLegs = 5;
        else if(size<80)
            numLegs = 9;
        else
            numLegs = 12;

//        g.setColor(col);
        g.fillArc(x_front - size/2, y_front - size/4, size, size/2, 0, 180);

        for(int i=0; i<numLegs; i++)
            g.drawLine(x_front - size/2 + size/numLegs + size*i/(numLegs+1), y_front, x_front - size/2 + size/numLegs + size*i/(numLegs+1), y_front+size/3);
    }

    @java.lang.Override
    public void setSuspend() {

    }

    @java.lang.Override
    public void setResume() {

    }

    @Override
    public void setBarrier(CyclicBarrier b) {

    }

}
