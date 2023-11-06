/*

Code in Modula-2

Name: RANDOM.MOD

IMPLEMENTATION MODULE RnDm;
    FROM TimeDate IMPORT Time, GetTime;
    VAR  max:CARDINAL; factor: CARDINAL; increment: CARDINAL;
         start: CARDINAL; actualrandom: CARDINAL;
    PROCEDURE Initialize();
    BEGIN
        max            := 1000;
        factor         := 623;
        increment      := 525;
        start          := 157;
        actualrandom   := ((factor*start)+increment) MOD max;
    END: Initialize;
    PROCEDURE Random(): CARDINAL;
    BEGIN
        actualrandom := ((factor * actualrandom) + increment) MOD max;
        RETURN (actualrandom);
    END Random;
    PROCEDURE RandomSeed();
    VAR time : Time;
    BEGIN
        GetTime(time);
        actualrandom := CARDINAL(CARDINAL(time.millisec DIV 10) MOD max);
    END RandomSeed;
END Rndm.


 */

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        // Task 1.1
        // This task can be done only with one if branch and with no loops. The closest thing to an implementation would be:

        int actualrandom=0;
        int max = 1000;

        Scanner reader = new Scanner(System.in);
        System.out.println("Random seed the generator (y/n)? y");
        char s = reader.next().charAt(0);
        if (s=='y'){
            actualrandom= Math.abs((int)((int)(System.currentTimeMillis() / 10) % max));
            System.out.println(actualrandom);
        }
        System.out.println("Program finished.");

        /* As it's not possible to use another branch to evaluate the user's input
            or a while loop to keep asking until the user sends a negative answer, the
            program has to finish. Because of that, the implementation of this exercise
            using these constraints is not possible.
         */


    }
}