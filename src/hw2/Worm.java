package hw2;

import java.awt.*;

public class Worm{
    public boolean isOn=false;
    public Worm(){}

    public void setOn(boolean on) {
        isOn = on;
    }

    public static void drawAnimal(Graphics g, AquaPanel panel){
        Graphics2D g2=(Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.MAGENTA);
        g2.drawArc(panel.getWidth()/2,panel.getHeight()/2-5,10,10,30,210);
        g2.drawArc(panel.getWidth()/2,panel.getHeight()/2+5,10,10,180,270);
        g2.setStroke(new BasicStroke(1));
    }

}
