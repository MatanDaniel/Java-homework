package hw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AquaPanel extends JPanel{
    public AquaPanel(){
        setLayout(new GridLayout());
        JButton addAnimal= new JButton("Add Animal");
        JButton sleep= new JButton("Sleep");
        JButton wakeUp= new JButton("Wake Up");
        JButton reset= new JButton("Reset");
        JButton food= new JButton("Food");
        JButton info= new JButton("Info");
        JButton exit= new JButton("Exit");

        add(addAnimal);
        add(sleep);
        add(wakeUp);
        add(reset);
        add(food);
        add(info);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}