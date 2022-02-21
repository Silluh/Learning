package main.com.example3.radek;

import java.security.SecureRandom;
import java.util.Arrays;

public class ArrayRNGApplication {

    public static void main(String[] args) {

        int[] array = new int[49];
        int[] array2 = new int[6];
        array = getFilledArray(false, array);
        Arrays.stream(array).boxed().forEach(result -> System.out.print(result + " "));
        System.out.println();
        array2 = getFilledArray(true, array2);
        Arrays.stream(array2).boxed().forEach(result -> System.out.print(result + " "));

    }

    static int[] getFilledArray(boolean fillRandom, int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = fillRandom ? getRNG() + 1 : i + 1;
        }
        return array;
    }

    static int getRNG() {

        SecureRandom rng = new SecureRandom();
        return rng.nextInt(49);
    }
}
