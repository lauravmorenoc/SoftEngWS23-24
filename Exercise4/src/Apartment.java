import java.util.ArrayList;
import java.util.Scanner;

public class Apartment {
    private char userInput;
    public int currentRoom;
    Kitchen kitchen = new Kitchen("Kitchen", false, false);
    Bathroom bathroom = new Bathroom("Bathroom", false, false);
    ArrayList <Room> roomArrayList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Apartment() {
        roomArrayList.add(kitchen);
        roomArrayList.add(bathroom);
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public void enter(){
        userInput = ' ';
        System.out.println("Do you want a tour? y/n");
        userInput = input.next().charAt(0);
        if (userInput == 'y'){
            currentRoom = 2;
            actionUser1();
        }
    }

    public void actionUser1(){
        userInput = ' ';
        System.out.println("You are in the : "+roomArrayList.get(currentRoom).getName());

        // Imprimir el esta de la habitacion´actual
        if (roomArrayList.get(currentRoom).Light)
            System.out.println("The light here is on.");
        if (kitchen.Stove){
            System.out.println("The Stove is on.");
        }
        if (bathroom.Shower){
            System.out.println("The Shower is on.");
        }
        System.out.println("What do you want to do?");
        System.out.println(" 1) Light on/off. \n 2) Go to another Room. \n 3) Leave the actual Room.");
        if (roomArrayList.get(currentRoom).getClass() == Kitchen.class){
            System.out.println(" 4) Switch stove. ");
        }
        if (roomArrayList.get(currentRoom).getClass() == Bathroom.class){
            System.out.println(" 4) Switch shower. ");
        }
        System.out.println("\n");
        userInput = input.next().charAt(0);
        switch (userInput){
            case '1':
                System.out.println();
                roomArrayList.get(currentRoom).switchLight();
                System.out.println("The light is on: "+roomArrayList.get(currentRoom).Light+"\n");
                actionUser1();
                break;
            case '2':
                actionUser2();
                break;
            case '3':
                boolean aux2 = false;
                for (int i = 2; i<roomArrayList.size(); i++){
                    if (roomArrayList.get(i).energyWarning()){
                    aux2 = true;
                    }
                }
                bathroom.energyWarning();
                kitchen.energyWarning();
                if (kitchen.Stove){
                    aux2 = true;
                }
                if (bathroom.Shower){
                    aux2 = true;
                }
                if (aux2) {
                    System.out.println("Do you want to stay in the room? y/n");
                    userInput = input.next().charAt(0);
                    if ('y' == userInput){
                        actionUser1();
                    }
                }
                if (currentRoom == 2){
                        enter();
                    }
                else{
                    currentRoom = 2;
                    actionUser1();
                }
                break;
            case '4':
                System.out.println("This element has switched");
                if (currentRoom == 0){
                    kitchen.switchEtwas();
                }
                if (currentRoom == 1){
                    bathroom.switchEtwas();
                }
                actionUser1();
                break;
            default:
                System.out.println("Falsch");
                actionUser1();
        }
    }

    public void addNewRoom(Room room){
    roomArrayList.add(room);
    }

    public void actionUser2(){
        int userInt;
        System.out.println("Where do you want to go? ");
        roomArrayList.get(currentRoom).printNeighbours();
        userInt = input.nextInt();
        currentRoom=vergleichung(roomArrayList.get(currentRoom).getVecinos().get(userInt));
        actionUser1();
    }

    public int vergleichung(Room room){
        int position = 0;
        for (int i = 0; i<roomArrayList.size(); i++){
            if (roomArrayList.get(i).equals(room)){
            position = i;
            }
        }
        return position;
    }
}
