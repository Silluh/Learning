package main.com.example3.radek;

import java.security.SecureRandom;
import java.util.Arrays;

public class ArrayRandomNumberGeneratorApplication {

    public static void main(String[] args) {

        int[] array = new int[49];
        int[] array2 = new int[6];
        array = getFilledArray(false, array);
        Arrays.stream(array).forEach(result -> System.out.print(result + " "));
        System.out.println();
        array2 = getFilledArray(true, array2);
        Arrays.stream(array2).forEach(result -> System.out.print(result + " "));
    }

    static int[] getFilledArray(boolean fillRandom, int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = fillRandom ? getRandomNumber() + 1 : i + 1;
        }
        return array;
    }

    static int getRandomNumber() {

        SecureRandom randomNumber = new SecureRandom();
        return randomNumber.nextInt(49);
    }
}
