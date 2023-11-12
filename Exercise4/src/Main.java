import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Apartment apartment = new Apartment();

        // Se crean los objetos de la clase ROOM:

        Room hallway = new Room("Hallway", false);
        Room bedroom = new Room("Bedroom", false);
        Room sauna = new Room("Sauna", false);


        // Se ordenan los elementos del apartamento en la lista:

        apartment.addNewRoom(hallway);
        apartment.addNewRoom(bedroom);
        apartment.addNewRoom(sauna);

        // Se agregar los vecinos de todas la habitaciones
        hallway.addVecinos(sauna);
        hallway.addVecinos(bedroom);
        hallway.addVecinos(apartment.getBathroom());
        hallway.addVecinos(apartment.getKitchen());

        apartment.getKitchen().addVecinos(sauna);
        apartment.getKitchen().addVecinos(hallway);

        apartment.getBathroom().addVecinos(bedroom);
        apartment.getBathroom().addVecinos(hallway);

        sauna.addVecinos(hallway);
        sauna.addVecinos(apartment.getKitchen());

        bedroom.addVecinos(hallway);
        bedroom.addVecinos(apartment.getBathroom());


        apartment.enter();
        System.out.println("You leave the apartment.");
    }
}