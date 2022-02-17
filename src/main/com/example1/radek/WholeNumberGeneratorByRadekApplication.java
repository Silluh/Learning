package main.com.example1.radek;

import java.util.Random;

public class WholeNumberGeneratorByRadekApplication {

    public static void main(String[] args) {
        randomGenerator(5);
        randomGenerator(8);
    }

    static void randomGenerator(int num){
        Random random = new Random();
        for(int i = 0; i < num; i++){
            System.out.print(random.nextInt(100) + " ");
        }
        System.out.println();
    }
}