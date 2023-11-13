public class Bathroom extends Room{
    boolean Shower; // Attribute representing the shower status

    public Bathroom(String name, boolean light, boolean Shower) { // Constructor of the class that considers the inheritance of the class Room
        super(name, light);
        this.Shower = Shower;
    }
    public void switchShower(){ // Method that modifies the state of the shower
        Shower =!Shower;
    }
    public boolean energyWarning() { //Method that adds a message to the user when the shower is on
        boolean on = false;
        super.energyWarning();
        if( Shower){
            System.out.println("The Shower is on");
        }
        return  on;
    }
}
