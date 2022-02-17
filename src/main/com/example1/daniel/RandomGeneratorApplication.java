package main.com.example1.daniel;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomGeneratorApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        generateRandomNumbers(5);
        generateRandomNumbers(10);
        generateRandomNumbers(2);
    }

    private static void generateRandomNumbers(int number) throws NoSuchAlgorithmException {

        SecureRandom random = SecureRandom.getInstanceStrong();

        for(int i = 0; i < number; i++) {
            int generatedNumber = random.nextInt(100);
            System.out.print(generatedNumber + "\t");
        }

        System.out.println();
    }
}
