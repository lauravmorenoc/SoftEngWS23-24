import java.util.Scanner;

class RandomNumberADO {
    private static int max = 1000;
    private static int factor = 623;
    private static int increment = 525;
    private static int start= 157;
    private static int actual_random=((factor*start)+increment) % max;

    // Private constructor to prevent instantiation
    private RandomNumberADO() {}

    //Getters
    public static int getActual_random(){
        return actual_random;
    }

    /*
    Note: This ADO can't be instantiated. So, in order to access its methods
    from outside (main), they have to be static. This means that intern
    attributes and methods can't be used.
     */

    // Access function to get the random seed
    public static int randomSeed() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Random seed the generator (y/n)? ");
        char s = reader.next().charAt(0);
        int local_actualrandom=0;
        if (s == 'y') {
            local_actualrandom = Math.abs((int) ((int) (System.currentTimeMillis() / 10) % max));
            System.out.println(local_actualrandom);
        } else {
            local_actualrandom=((factor*start)+increment) % max; // This helps knowing
            // the response of the user from outside.
        }
        return local_actualrandom;
    }

    // Loop function
    public static void random(boolean response, int actualrandom) {
        boolean local_response=response;
        int local_actualrandom=actualrandom;
        while (local_response) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Another random number (y/n)? y");
            char s = reader.next().charAt(0);
            if (s == 'y') {
                local_actualrandom = Math.abs((int) (((factor * local_actualrandom) + increment) % max));
                System.out.println(local_actualrandom);
                local_response = true;
            } else {
                local_response = false;
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        int seed=RandomNumberADO.randomSeed();
        if (seed!=RandomNumberADO.getActual_random()){ // means the user wants a random number to be generated
            RandomNumberADO.random(true,seed);
        }
        System.out.println("Program finished.");
    }
}