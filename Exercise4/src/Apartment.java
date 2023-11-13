import java.util.ArrayList;
import java.util.Scanner;

public class Apartment {
    private char userInput; // Stores user input
    public  int currentRoom; // Represents the current room index
    Scanner input = new Scanner(System.in); // Scanner object for user input


    ArrayList<Room> roomArrayList = new ArrayList<>(); // ArrayList to store rooms in the apartment
    Kitchen kitchen   = new Kitchen ("Kitchen", false, false); // Instance of Kitchen
    Bathroom bathroom = new Bathroom("Bathroom", false, false); // Instance of Bathroom


    public Apartment() { // Constructor to initialize the apartment
        roomArrayList.add(kitchen);
        roomArrayList.add(bathroom);
    }

    public Kitchen getKitchen() { // Getter methods for kitchen and bathroom instances
        return kitchen;
    }
    public Bathroom getBathroom() {
        return bathroom;
    }

    public void addNewRoom(Room room){ // Method to add a new room to the apartment
        roomArrayList.add(room);
    }

    public void initialStatus(){ // Method to initiate the tour of the apartment
        userInput = ' ';
        System.out.println("Do you want a tour? y/n");
        userInput = input.next().charAt(0);
        if (userInput == 'y'){
            currentRoom = 2;
            actionUser1();
        }
    }

    public void actionUser1(){ // Method to perform actions in the current room
        userInput = ' ';
        System.out.println("You are in the : "+roomArrayList.get(currentRoom).getName());

        if (roomArrayList.get(currentRoom).Light) { // Check and print the state of the light, stove, and shower
            System.out.println("The light here is on.");
        }
        if (kitchen.Stove){
            System.out.println("The Stove is on.");
        }
        if (bathroom.Shower){
            System.out.println("The Shower is on.");
        }

        System.out.println("What do you want to do?"); // Display user options
        System.out.println(" 1) Light on/off. \n 2) Go to another Room. \n 3) Leave the actual Room.");

        if (roomArrayList.get(currentRoom).getClass() == Kitchen.class){  // Options for Kitchen and Bathroom
            System.out.println(" 4) Switch stove. ");
        }
        if (roomArrayList.get(currentRoom).getClass() == Bathroom.class){
            System.out.println(" 4) Switch shower. ");
        }
        System.out.println("\n");
        userInput = input.next().charAt(0);

        switch (userInput){ // Process user input using a switch statement
            case '1': // Toggle the light in the current room
                System.out.println();
                roomArrayList.get(currentRoom).switchLight();
                System.out.println("The light is on: "+roomArrayList.get(currentRoom).Light+"\n");
                actionUser1();  // Recursive call to continue actions in the current room
                break;
            case '2': // Go to another room
                actionUser2();
                break;
            case '3': // Leaving the room
                boolean aux2 = false;
                for (int i = 2; i<roomArrayList.size(); i++){ // Check energy warnings in other rooms
                    if (roomArrayList.get(i).energyWarning()){
                    aux2 = true;
                    }
                }
                bathroom.energyWarning();
                kitchen.energyWarning();
                if ((kitchen.Stove)||(bathroom.Shower)){ // Check if the stove or shower are on
                    aux2 = true;
                }
                if (aux2) { // Display warnings and prompt the user to stay or leave
                    System.out.println("Do you want to stay in the room? y/n");
                    userInput = input.next().charAt(0);
                    if ('y' == userInput){
                        actionUser1(); // Recursive call to continue actions in the current room
                    }
                }
                if (currentRoom == 2){ // Go back to the initial status if in the hallway, else go back to the hallway
                        initialStatus();
                    }
                else{
                    currentRoom = 2;
                    actionUser1();
                }
                break;
            case '4': // Switch stove or shower in Kitchen or Bathroom
                System.out.println("This element has switched");
                if (currentRoom == 0){
                    kitchen.switchStove();
                }
                if (currentRoom == 1){
                    bathroom.switchShower();
                }
                actionUser1();
                break;
            default:
                System.out.println("Incorrect character");
                actionUser1();
        }
    }
    public void actionUser2(){ // Method to perform actions related to choosing another room
        int userInt;
        System.out.println("Where do you want to go? ");
        roomArrayList.get(currentRoom).printNeighbours();
        userInt = input.nextInt();
        currentRoom = comparison(roomArrayList.get(currentRoom).getNeighbor().get(userInt));  // Change the current room based on user selection
        actionUser1(); // Continue actions from the beginning in the new room
    }

    public int comparison(Room room){ // Method to compare and find the position of a room in the ArrayList
        int position = 0;
        for (int i = 0; i < roomArrayList.size(); i++ ){
            if (roomArrayList.get(i).equals(room)){
            position = i;
            }
        }
        return position;
    }
}