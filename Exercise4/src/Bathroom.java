public class Bathroom extends Room{
    boolean Shower; // Attribute representing the shower status

    public Bathroom(String name, boolean light, boolean Shower) { // Constructor of the class that considers the inheritance of the class Room
        super(name, light);
        this.Shower = Shower;
    }
    public void switchShower(){ // Method that modifies the state of the shower
        Shower =!Shower;
    }
    public boolean energyWarning() { //Method that sends a message to the user when boolean variables are in true state
        boolean on = false;
        if (Light){
            System.out.println("The light in the " + Name + " is on.");
            on = true;
        }
        if( Shower){
            System.out.println("The Shower is on");
        }
        return  on;
    }
}
