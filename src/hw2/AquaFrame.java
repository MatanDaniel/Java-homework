package hw2;

import javax.swing.*;

public class AquaFrame extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setVisible(true);
        frame.setSize(750, 350);
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
    }

}