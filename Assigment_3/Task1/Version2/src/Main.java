/*
As a theory of the team, we think that the language feature 'X' might be the ability of changing
the global state (value) of a variable inside a branch, as some early versions of some languages
(like C) do not support this feature. We give it a try as it follows:
 */

import java.lang.Math;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int max = 1000;
        int factor = 623;
        int increment = 525;

        /*
        Not using global variables that can change inside functions restricts optimization.
        To minimize the impact, an array to return two values is used.
         */

        int[] affirm_seed=new int[2];
        affirm_seed=userSeed(max);


        while (affirm_seed[1]==1){
            affirm_seed = user_loop(factor, affirm_seed[0], increment, max);
        }

        System.out.println("Program finished.");


    }


    public static int[] userSeed(int max){
        int[] response= new int[2];
        Scanner reader = new Scanner(System.in);
        System.out.println("Random seed the generator (y/n)? y");
        char s = reader.next().charAt(0);
        if (s=='y') {
            response[0] = Math.abs((int)((int)(System.currentTimeMillis() / 10) % max));
            System.out.println(response[0]);
            response[1]=1;
        }
        return response;
    }

    public static int[] user_loop(int factor, int actualrandom, int increment, int max){
        int response[]= new int[2];
        response[1]=0;
        Scanner reader = new Scanner(System.in);
        System.out.println("Another random number (y/n)? y");
        char s = reader.next().charAt(0);
        if (s=='y') {
            response[0] = Math.abs((int) (((factor * actualrandom) + increment) % max));
            System.out.println(response[0]);
            response[1]=1;
        }
        return response;
    }
}

