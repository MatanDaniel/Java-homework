package hw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import hw2.AquaPanel;

public class AquaFrame extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        JLabel displayField = new JLabel();
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(1200, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        JMenu file = new JMenu("File");
        menu.add(file);
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);

        JMenuItem item1 = new JMenuItem("Image");
        JMenuItem item2 = new JMenuItem("Blue");
        JMenuItem item3 = new JMenuItem("None");
        JMenu background = new JMenu("Background");
        menu.add(background);
        background.add(item1);
        background.add(item2);
        background.add(item3);

        JMenu help = new JMenu("Help");
        menu.add(help);

        JMenuItem helpItem = new JMenuItem("Help");
        help.add(helpItem);

        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, " Home Work 3 \n GUI @ Threads");
            }
        });
        BorderLayout border = new BorderLayout();
        frame.setLayout(border);

        // Singleton Design pattern
        JPanel bottomPanel = AquaPanel.getInstance();
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.pack();
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        // blue background
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AquaPanel.getInstance().changeBackground("blue");
            }
        });

        // Returning the background to white by pressing "None" item
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AquaPanel.getInstance().changeBackground("white");
            }
        });

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AquaPanel.getInstance().changeBackground("image");
            }
        });
    }
}
