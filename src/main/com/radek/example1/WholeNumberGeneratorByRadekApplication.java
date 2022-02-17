package main.com.radek.example1;

import java.util.Random;


public class WholeNumberGeneratorByRadekApplication {

    public static void main(String[] args) {
        RngGener(5);
        RngGener(8);
    }
    static void RngGener(int num){
        Random random = new Random();
        for(int i = 0; i < num; i++){
            System.out.print(random.nextInt(100) + " ");
        }
        System.out.println();
    }
}