package hw2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;

public class AddAnimalDialog extends JDialog {

  private static String[] animals = { "Fish", "Jelly Fish" };
  private static String[] colors = { "Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow", "Magenta", "Pink" };

  JComboBox animalList = new JComboBox<>(animals);
  JTextField sizeTextField = new JTextField(10);
  JTextField horSpeedTextField = new JTextField(10);
  JTextField verSpeedTextField = new JTextField(10);
  JComboBox colorList = new JComboBox<>(colors);
  JButton submitButton = new JButton("Submit");

  public AddAnimalDialog() {
    this.createDialog();
  }

  private void createDialog() {
    JDialog dialog = new JDialog();
    dialog.setSize(250, 300);

    JPanel panel = new JPanel();
    GridLayout layout = new GridLayout(6, 2, 5, 15);
    panel.setLayout(layout);

    panel.add(new JLabel("Choose Type:"));
    panel.add(animalList);

    panel.add(new JLabel("Size:"));
    panel.add(sizeTextField);

    panel.add(new JLabel("Horizontal Velocity:"));
    panel.add(horSpeedTextField);

    panel.add(new JLabel("Vertical Velocity:"));
    panel.add(verSpeedTextField);

    panel.add(new JLabel("Choose Color:"));
    panel.add(colorList);

    panel.add(submitButton);

    // ActionListeners
    submitButton.addActionListener(new submitButtonActionListener());

    dialog.add(panel);
    dialog.setVisible(true);
  }

  private class submitButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

      // TODO: add validations to the form
      System.out
          .println("properties: " + "\ntype: " + animalList.getSelectedItem() + "\nsize: " + sizeTextField.getText()
              + "\nhorizontal velocity: " + horSpeedTextField.getText()
              + "\nvertical velocity: " + verSpeedTextField.getText() + "\ncolor: " + colorList.getSelectedItem());

      // Transfering elements into variables to save code line:
      String type = animalList.getSelectedItem().toString();
      int size = Integer.parseInt(sizeTextField.getText());
      int horSpeed = Integer.parseInt(horSpeedTextField.getText());
      int verSpeed = Integer.parseInt(verSpeedTextField.getText());
      String color = colorList.getSelectedItem().toString();

      // validations for each field:
      if (size < 20 || size > 320)
        JOptionPane.showMessageDialog(null, "Error: Animal's size must be between 320 to 20");
      if (horSpeed < 1 || horSpeed > 10)
        JOptionPane.showMessageDialog(null, "Error: Animal's horizontal velocity must be between 1-10!");
      if (verSpeed < 1 || verSpeed > 10)
        JOptionPane.showMessageDialog(null, "Error: Animal's vertical velocity must be between 1-10!");

      // TODO: color - string -> int

      if (!(size < 20 || size > 320) && !(horSpeed < 1 || horSpeed > 10) && !(verSpeed < 1 || verSpeed > 10)) {

        AquaPanel aquaPanel = AquaPanel.getInstance();

        if (aquaPanel.swimmers.size() >= 5)
          JOptionPane.showMessageDialog(null, "Error: Can't add more than 5 animals!");

        if (type == "Fish") {
          Fish fish = new Fish(size, 100, 100, horSpeed, verSpeed, Color.RED);

          aquaPanel.swimmers.add(fish);
          fish.start();
        } else {
          Jellyfish jellyFish = new Jellyfish(size, 100, 100, horSpeed, verSpeed, Color.BLACK);

          aquaPanel.swimmers.add(jellyFish);
          jellyFish.start();
        }

        aquaPanel.repaint();
      }

    }
  }

}
