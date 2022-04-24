package hw2;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.*;

public class AquaPanel extends JPanel {

    private static AquaPanel single_instance = null;

    public HashSet<Swimmable> swimmers = new HashSet<Swimmable>();

    private AquaPanel() {
        // setLayout(new GridLayout());

        setPreferredSize(new Dimension(700, 700));

        JToolBar toolBar = new JToolBar();

        JButton addAnimal = new JButton("Add Animal");
        JButton sleep = new JButton("Sleep");
        JButton wakeUp = new JButton("Wake Up");
        JButton reset = new JButton("Reset");
        JButton food = new JButton("Food");
        JButton info = new JButton("Info");
        JButton exit = new JButton("Exit");

        toolBar.add(addAnimal);
        toolBar.add(sleep);
        toolBar.add(wakeUp);
        toolBar.add(reset);
        toolBar.add(food);
        toolBar.add(info);
        toolBar.add(exit);

        add(toolBar);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swimmers.clear();
                repaint();
            }
        });

        sleep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Swimmable swimmer : swimmers) {
                    swimmer.setSuspend();
                }
            };
        });

        wakeUp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                for (Swimmable swimmer : swimmers) {
                    swimmer.setResume();
                }
            }
        });

        addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAnimalDialog();
            }
        });

        // Thread thread = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // while (true) {
        // try {
        // for (Swimmable swimmer : swimmers) {
        // swimmer.
        // }
        // repaint();
        // Thread.sleep(100);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }
        // }
        // });

        // thread.start();
    }

    public static AquaPanel getInstance() {
        if (single_instance == null)
            single_instance = new AquaPanel();

        return single_instance;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Swimmable swimmer : swimmers) {
            swimmer.drawAnimal(g);
        }
    }
}
