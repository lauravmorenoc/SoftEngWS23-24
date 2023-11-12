public class Bathroom extends Room{
    boolean Shower;

    public Bathroom(String name, boolean light, boolean Shower) {
        super(name, light);
        this.Shower=Shower;
    }
    public void switchEtwas(){
        Shower =!Shower;
    }

    public boolean energyWarning() {
        boolean on = false;
        if (Light){
            System.out.println("The light in the "+Name+" is on.");
            on = true;
        }
        if( Shower){
            System.out.println("The Shower is on");
        }
    return  on;
    }
}
