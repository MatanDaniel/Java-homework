import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Stream;

public class JPanelDecorator extends JDialog {

    public JPanel buttonPanel = new JPanel();
    public ArrayList<SeaCreature> seaCreatureArrayList = new ArrayList<>();
    public JList animalBox;
    public JButton changeColor;
    AquaPanel aquaPanel;

    public JPanelDecorator(ArrayList<SeaCreature> seaCreatures){
        this.seaCreatureArrayList = seaCreatures;
        animalBox = new JList(getAnimalNames(seaCreatures).toArray());
        add(animalBox);

        changeColor = new JButton("Change Color");
        add(changeColor, BorderLayout.SOUTH);

        changeColor.addActionListener(e -> {
            JColorChooser color = new JColorChooser();
            Color actualColor = JColorChooser.showDialog(null, "Pick a new color for the animal:", Color.BLACK);
            color.setVisible(true);
        });
        pack();

    }
    public Stream<SeaCreature> getAnimalNames(ArrayList<SeaCreature> seaCreatures){
        return seaCreatures.stream().filter(seaCreature -> seaCreature instanceof Swimmable);
    }

    public void changeInstanceColor(Swimmable swimmer){



    }

}
