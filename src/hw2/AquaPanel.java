package hw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class AquaPanel extends JPanel {

    private static AquaPanel single_instance = null;

    public HashSet<Swimmable> swimmers;

    private AquaPanel() {
        setLayout(new GridLayout());
        JButton addAnimal = new JButton("Add Animal");
        JButton sleep = new JButton("Sleep");
        JButton wakeUp = new JButton("Wake Up");
        JButton reset = new JButton("Reset");
        JButton food = new JButton("Food");
        JButton info = new JButton("Info");
        JButton exit = new JButton("Exit");
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

        addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAnimalDialog dialog = new AddAnimalDialog();
            }
        });
    }

    public static AquaPanel getInstance() {
        if (single_instance == null)
            single_instance = new AquaPanel();

        return single_instance;
    }
}
