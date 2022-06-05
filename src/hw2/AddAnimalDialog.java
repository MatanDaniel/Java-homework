import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;

public class AddAnimalDialog extends JDialog {

    private static final String[] animals = { "Leminaria","Zostera","Fish", "Jellyfish" };
    private static final String[] colors = { "Black", "Red", "Blue", "Green", "Cyan", "Orange", "Yellow", "Magenta", "Pink" };
    AquaPanel aquaPanel;
    JComboBox<String> animalList = new JComboBox<>(animals);
    public JTextField sizeTextField = new JTextField(10);
    public JTextField horSpeedTextField = new JTextField(10);
    public JTextField verSpeedTextField = new JTextField(10);
    JComboBox<String> colorList = new JComboBox<>(colors);
    JButton submitButton = new JButton("Submit");
    JDialog dialog= new JDialog();

    public AddAnimalDialog(AquaPanel panel) {
        aquaPanel = panel;
        this.createDialog();
    }

    private void createDialog() {
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
        submitButton.addActionListener(e -> SubmitButton());
        dialog.getRootPane().setDefaultButton(submitButton);
        dialog.add(panel);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
    }

    public void SubmitButton(){
            // Transferring elements into variables to save code line:
            String type = animalList.getSelectedItem().toString();
            int size = Integer.parseInt(sizeTextField.getText());
            int horSpeed = Integer.parseInt(horSpeedTextField.getText());
            int verSpeed = Integer.parseInt(verSpeedTextField.getText());
            Color col = getColor();

            // validations for each field:
            if (size < 20 || size > 320)
                JOptionPane.showMessageDialog(null, "Error: Animal's size must be between 20 to 320");
            if (horSpeed < 1 || horSpeed > 10)
                JOptionPane.showMessageDialog(null, "Error: Animal's horizontal velocity must be between 1-10!");
            if (verSpeed < 1 || verSpeed > 10)
                JOptionPane.showMessageDialog(null, "Error: Animal's vertical velocity must be between 1-10!");
            // TODO: color - string -> int
            if (!(size < 20 || size > 320) && !(horSpeed < 1 || horSpeed > 10) && !(verSpeed < 1 || verSpeed > 10)) {

                if (aquaPanel.seaCreatures.size() >= 5) {
                    JOptionPane.showMessageDialog(null, "Error: Can't add more than 5 animals!");
                    return;
                }

                AnimalFactory factory1 = new AnimalFactory(this);
                Swimmable fac = (Swimmable) factory1.produceSeaCreature(type);
                if(aquaPanel.isPaused)
                    fac.paused = true;
                aquaPanel.seaCreatures.add(fac);

                PlantFactory plantFac = new PlantFactory(this);
                Immobile creature = (Immobile) plantFac.produceSeaCreature(type);

                fac.start();
                this.dispose();
            }
        }

    public Color getColor() {
        String tmp = colorList.getSelectedItem().toString();
        return switch (tmp) {
            case "Black" -> Color.BLACK;
            case "Red" -> Color.red;
            case "Blue" -> Color.BLUE;
            case "Green" -> Color.GREEN;
            case "Cyan" -> Color.cyan;
            case "Orange" -> Color.orange;
            case "Yellow" -> Color.YELLOW;
            case "Magenta" -> Color.magenta;
            case "Pink" -> Color.PINK;
            default -> null;
        };
    }

}
