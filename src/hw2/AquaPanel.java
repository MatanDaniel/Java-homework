package hw2;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.*;

public class AquaPanel extends JPanel {
    private DefaultTableModel tbl_model;
    private JTable tbl_info;
    private JFrame frame=new JFrame("Info");
    private static BufferedImage image=null;
    private static AquaPanel single_instance = null;
    public HashSet<Swimmable> swimmers = new HashSet<Swimmable>();
    public JPanel buttonPanel=new JPanel();
    Worm w=new Worm();
    public AquaPanel() {
        buttonPanel.setLayout(new GridLayout());
        setPreferredSize(new Dimension(1200, 700));
        JButton addAnimal = new JButton("Add Animal");
        JButton sleep = new JButton("Sleep");
        JButton wakeUp = new JButton("Wake Up");
        JButton reset = new JButton("Reset");
        JButton food = new JButton("Food");
        JButton info = new JButton("Info");
        JButton exit = new JButton("Exit");

        buttonPanel.add(addAnimal);
        buttonPanel.add(sleep);
        buttonPanel.add(wakeUp);
        buttonPanel.add(reset);
        buttonPanel.add(food);
        buttonPanel.add(info);
        buttonPanel.add(exit);

        BorderLayout border=new BorderLayout();
        this.setLayout(border);
        this.add(buttonPanel,BorderLayout.SOUTH);


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        food.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.isOn=true;
                repaint();
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


        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInfo();
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

    public void getInfo(){
        if(this.frame.isVisible()){
            this.frame.dispose();
        }
        else{
            frame = new JFrame("Info");
            frame.setLayout(new BorderLayout());
            tbl_info = getAnimalList();
            JPanel counter = new JPanel();
            JLabel countLabel = new JLabel("Total Count:" /*+ totalEatCounter*/);
            counter.setLayout(new BorderLayout());
            counter.add(countLabel,BorderLayout.CENTER);

            frame.add(tbl_info,BorderLayout.CENTER);
            frame.add(counter,BorderLayout.SOUTH);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

    }

    public JTable getAnimalList(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Animal Name");
        tbl.addColumn("Color");
        tbl.addColumn("Size");
        tbl.addColumn("Hor.Speed");
        tbl.addColumn("Var.Speed");
        tbl.addColumn("Eat Count");
        Object[] columns = {"Name", "Color", "Size", "Hor.Speed", "Var.Speed",
                "Eat Counter"};
        tbl.addRow(columns);
        Object[] space = {"----------", "----------", "----------", "----------", "----------","----------"};
        tbl.addRow(space);

        for (Swimmable obj : this.swimmers) {
            String tmpColor="";
            if (obj instanceof Swimmable) {
                //Color to string
                if(Color.BLACK.equals(obj.getColor())){
                    tmpColor="Black";
                }
                if(Color.RED.equals(obj.getColor())){
                    tmpColor="Red";
                }
                if(Color.BLUE.equals(obj.getColor())){
                    tmpColor="Blue";
                }
                if(Color.GREEN.equals(obj.getColor())){
                    tmpColor="Green";
                }
                if(Color.CYAN.equals(obj.getColor())){
                    tmpColor="Cyan";
                }
                if(Color.ORANGE.equals(obj.getColor())){
                    tmpColor="Orange";
                }
                if(Color.YELLOW.equals(obj.getColor())){
                    tmpColor="Yellow";
                }
                if(Color.MAGENTA.equals(obj.getColor())){
                    tmpColor="Magenta";
                }
                if(Color.PINK.equals(obj.getColor())){
                    tmpColor="Pink";
                }
                Object[] row = {((Swimmable) obj).getAnimalName(), tmpColor, ((Swimmable) obj).getSize(),
                        ((Swimmable) obj).getHorSpeed(), ((Swimmable) obj).getVerSpeed(), ((Swimmable) obj).getEatCount()
                };
                tbl.addRow(row);
            }

        }
        JTable info = new JTable(tbl);
        return info;
    }

    public void changeBackground(String msg){
        if(msg == "image"){
                try{
                    image = ImageIO.read(AquaPanel.class.getResourceAsStream("image.jpg"));
                    repaint();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        if(msg=="blue"){
            image=null;
            this.setBackground(Color.BLUE);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if(msg=="white"){
            image=null;
            this.setBackground(Color.WHITE);
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

    public static AquaPanel getInstance() {
        if (single_instance == null)
            single_instance = new AquaPanel();

        return single_instance;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image!=null){
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        }
        for (Swimmable swimmer : swimmers) {
            swimmer.drawAnimal(g);
        }
        if(w.isOn){
            Worm.drawAnimal(g,this);
        }
    }
}
