import java.util.Scanner;

interface RandomNumberADT{
    public void randomSeed();
    public void random();
}

class randomGenerator implements RandomNumberADT{

    public static int max= 1000;
    public static int factor=623;
    public static int increment=525;
    public static int start=157;
    public int actualrandom= ((factor*start)+increment) % max;
    public long difference=0L;

    public void setDifference(long new_difference){
        this.difference=new_difference;
    }


    @Override
    public void randomSeed(){
        this.actualrandom = Math.abs((int) ((int) ((System.currentTimeMillis()+this.difference) / 10) % max));
        System.out.println(this.actualrandom);
    }

    @Override
    public void random(){
        this.actualrandom = Math.abs((int) (((factor * this.actualrandom) + increment) % max));
        System.out.println(this.actualrandom);
    }

}




public class Main {
    public static void main(String[] args) {

        randomGenerator Random1=new randomGenerator();
        randomGenerator Random2=new randomGenerator();
        Random2.setDifference(93000900000L);

        Scanner reader = new Scanner(System.in);
        System.out.print("Random seed the generator (y/n)?");
        char s = reader.next().charAt(0);
        if (s == 'y') {
            Random1.randomSeed();
            Random2.randomSeed();
            System.out.print("Another random number (y/n)?");
            s = reader.next().charAt(0);
        }

        while(s == 'y'){
            Random1.random();
            Random2.random();
            Scanner reader2 = new Scanner(System.in);
            System.out.print("Another random number (y/n)?");
            s = reader2.next().charAt(0);
        }
        System.out.println("Program finished.");

    }
}