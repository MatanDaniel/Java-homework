package hw2;

import javax.swing.*;

public class AquaFrame extends JFrame{
    public static void main(String[] args){
        JFrame frame = new JFrame("my Aquarium");
        frame.setAlwaysOnTop(true);
        final JLabel label=new JLabel("Hello evddddderybody");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label);
        frame.setSize(300,200);
        frame.setVisible(true);
    }
}
