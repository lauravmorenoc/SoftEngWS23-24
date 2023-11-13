public class Kitchen extends Room {
    boolean Stove; // Attribute representing the stove status

    public Kitchen (String name, boolean light, boolean Stove){ // Constructor of the class that considers the inheritance of the class Room
        super(name,light);
        this.Stove = Stove;
    }
    public void switchStove(){ // Method that modifies the state of the Stove
        Stove =!Stove;
    }
    public boolean energyWarning() { //Method that adds a message to the user when the stove is on
        super.energyWarning();
        boolean on = false;
        if (Stove){
            System.out.println("The Stove is on");
        }
        return on;
    }
}
