import java.util.ArrayList;
import java.util.List;

public class Kitchen extends Room {
    boolean Stove;


    public Kitchen (String name, boolean light, boolean Stove){
        super(name,light);
        this.Stove = Stove;
    }
    public void switchEtwas(){
        Stove =!Stove;
    }
    public boolean energyWarning() {
        boolean on = false;
        if (Light){
            System.out.println("The light in the "+Name+" is on.");
            on = true;
        }
        if( Stove){
            System.out.println("The Stove is on");
        }
        return on;
    }
}
