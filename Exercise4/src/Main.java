/* Presented by:
Jorge Elías Aponte Trejos - 108023117942
Laura Valentina Moreno Castro - 108023117955
Daniel Santiago Robayo Rico - 108023117968 */

public class Main {
    public static void main(String[] args) {
        Apartment apartment = new Apartment(); // An instance of the class apartment is created.

        Room hallway = new Room("Hallway", false); // Three objects of the room class are created that correspond to the following rooms.
        Room bedroom = new Room("Bedroom", false);
        Room sauna   = new Room("Sauna",   false);

        apartment.addNewRoom(hallway);  // The three rooms are added to the list of the apartment.
        apartment.addNewRoom(bedroom);
        apartment.addNewRoom(sauna);

        hallway.addNeighbor(sauna);      // The neighbors of all rooms are added to the list.
        hallway.addNeighbor(bedroom);
        hallway.addNeighbor(apartment.getBathroom());
        hallway.addNeighbor(apartment.getKitchen());

        apartment.getKitchen().addNeighbor(sauna);
        apartment.getKitchen().addNeighbor(hallway);

        apartment.getBathroom().addNeighbor(bedroom);
        apartment.getBathroom().addNeighbor(hallway);

        sauna.addNeighbor(hallway);
        sauna.addNeighbor(apartment.getKitchen());

        bedroom.addNeighbor(hallway);
        bedroom.addNeighbor(apartment.getBathroom());

        apartment.initialStatus(); // Method of starting the tour of the apartment
        System.out.println("You leave the apartment.");
    }
}