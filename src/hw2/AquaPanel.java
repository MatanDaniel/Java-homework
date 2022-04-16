package hw2;

import javax.swing.*;
import java.awt.*;

public class AquaPanel extends JPanel{
    public AquaPanel(){
        setLayout(new GridLayout());
        add(new JButton("Add Animal"));
        add(new JButton("Sleep"));
        add(new JButton("Wake Up"));
        add(new JButton("Reset"));
        add(new JButton("Food"));
        add(new JButton("Info"));
        add(new JButton("Exit"));
    }
}
