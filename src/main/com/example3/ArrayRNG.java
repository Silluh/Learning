package main.com.example3;

import java.util.Arrays;
import java.util.Random;

public class ArrayRNG {

    public static void main(String[] args) {

        int array[] = new int[49];
        int array2[] = new int[6];
        array = fillArray(false,array);
        Arrays.stream(array).boxed().forEach(result -> System.out.print(result  + " "));
        System.out.println();
        array2 = fillArray(true, array2);
        Arrays.stream(array2).boxed().forEach(result -> System.out.print(result + " "));

    }

    static int[] fillArray(boolean fillRandom, int[] array){

        for(int i = 0; i < array.length; i ++){
            if(fillRandom == false) {
                array[i] = i + 1;
            }else {
                array[i] = getRNG() + 1;
            }
        }
        return array;
    }

    static int getRNG(){

        Random rng = new Random();
        return rng.nextInt(49);
    }
}
