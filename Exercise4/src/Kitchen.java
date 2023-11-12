public class Kitchen extends Room {
    boolean Stove; // Attribute representing the stove status

    public Kitchen (String name, boolean light, boolean Stove){ // Constructor of the class that considers the inheritance of the class Room
        super(name,light);
        this.Stove = Stove;
    }
    public void switchStove(){ // Method that modifies the state of the Stove
        Stove =!Stove;
    }
    public boolean energyWarning() { //Method that sends a message to the user when boolean variables are in true state
        boolean on = false;
        if (Light){
            System.out.println("The light in the " + Name + " is on.");
            on = true;
        }
        if (Stove){
            System.out.println("The Stove is on");
        }
        return on;
    }
}
