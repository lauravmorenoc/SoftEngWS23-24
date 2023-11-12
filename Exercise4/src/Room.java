import java.util.ArrayList;
public class Room{ //Definition of the attributes of the Room class where the name, the state of the light and the list of neighbors are found.
    String  Name;
    Boolean Light = false;
    ArrayList<Room> neighborList = new ArrayList<>();

    public String getName() { // Getter method of the parameter name
        return Name;
    }
    public void addNeighbor(Room room){ // Method to add a neighbor to the neighborList
        neighborList.add(room);
    }

    public ArrayList<Room> getNeighbor() { // Getter method for the 'neighborList' attribute
        return neighborList;
    }

    public void printNeighbours(){ // Method to print the neighbors of the room
        for (int i = 0; i<neighborList.size(); i++){
            System.out.println(i + ". " + neighborList.get(i).getName());
        }
    }

    public void switchLight(){ // Method to switch the state of the light in the room
        Light =! Light;
    }

    public boolean energyWarning(){ // Method to check if the light is on and print a warning
        boolean on = false;
        if (Light){
            System.out.println("The light in the " + Name + " is on.");
            on = true;
        }
        return on;
    }

    public Room(String name, Boolean light) { // Constructor to initialize the Room with a name and light state
        Name  = name;
        Light = light;
    }
}
