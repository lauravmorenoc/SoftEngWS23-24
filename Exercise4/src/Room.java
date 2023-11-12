import java.util.ArrayList;

public class Room{
    String Name;
    Boolean Light = false;
    Room current;
    ArrayList<Room> vecinos = new ArrayList<>();

    public String getName() {
        return Name;
    }
    public void addVecinos(Room room){
        vecinos.add(room);
    }

    public ArrayList<Room> getVecinos() {
        return vecinos;
    }

    public void printNeighbours(){
        for (int i = 0; i<vecinos.size(); i++){
            System.out.println(i+". "+vecinos.get(i).getName());
        }
    }

    public void switchLight(){
        Light =!Light;
    }

    public boolean energyWarning(){
        boolean on = false;
        if (Light){
            System.out.println("The light in the "+Name+" is on.");
            on = true;
        }
        return on;
    }

    public Room(String name, Boolean light) {
        Name = name;
        Light = light;
    }
}
