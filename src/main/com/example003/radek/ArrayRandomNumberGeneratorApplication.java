package main.com.example003.radek;

import java.security.SecureRandom;

public class ArrayRandomNumberGeneratorApplication {

    public static void main(String[] args) {

        int[] array = new int[49];
        int[] array2 = new int[6];
        array = getFilledArray(false, array);
        printArray(array);
        array2 = getFilledArray(true, array2);
        printArray(array2);
        //Nebo též
        //printArray(getFilledArray(true, array2));
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

    static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
