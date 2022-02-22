package main.com.example001.radek;
import java.util.Random;

public class RandomNumberApplication {

    public static void main(String[] args) {

        randomGenerator(5);
    }

    static void randomGenerator(int numbers){
        
        Random rng = new Random();
        for(int i = 0; i < numbers; i++) {
            System.out.print(rng.nextInt(100) + " " );
        }
        System.out.println();
    }
}
