import java.lang.Math;

public class Kitchen extends Room {
    boolean Stove; // Attribute representing the stove status
    long kWh;

    public Kitchen (String name, boolean light, boolean Stove){ // Constructor of the class that considers the inheritance of the class Room
        super(name,light);
        this.Stove = Stove;
        this.kWh=0;
    }
    public void switchStove(){ // Method that modifies the state of the Stove

        Stove =!Stove;
        if (Stove){
            kWh=System.currentTimeMillis();
        } else{
            kWh=(long)((System.currentTimeMillis()-kWh)*2000/(Math.pow(3.6,10^6)));
            System.out.println(kWh+" kilowatt-hours were consumed by the stove");
        }
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
