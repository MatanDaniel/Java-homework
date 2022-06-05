public class PlantFactory implements  AbstractSeaFactory{
    // UI object in order to transfer data into the AddAnimalDialog
    private AddAnimalDialog UI;

    public PlantFactory(AddAnimalDialog UI) {
        this.UI = UI;
    }
    public void setUI(AddAnimalDialog UI) {
        this.UI = UI;
    }

    public AddAnimalDialog getUI() {
        return UI;
    }
    @Override
    public SeaCreature produceSeaCreature(String factory) {
        if (factory.equals("Zostera")){
            return new Zostera(Integer.parseInt(UI.sizeTextField.getText()), 100 , 100);
        }
        if (factory.equals("Laminaria"))
            return new Laminaria(Integer.parseInt(UI.sizeTextField.getText()), 100 , 100);
        return null;
    }
}
