package main.com.example4;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DrawMeSquare {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How big square you wanna draw ? ");
        try{
            int size = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Which symbol you wanna use ?");
            String symbol = scanner.nextLine();
            System.out.println("Test all 3 variants by typing 1,2 or 3");
            int variant = scanner.nextInt();
            drawMeSquare(size, symbol, variant);
        }
        catch(InputMismatchException nfe){
            System.out.println("Insert number only!");
        }
    }

    static void drawMeSquare(int size, String symbol, int variant) {

        switch(variant){
            case 1:
                /*První varianta for cyklus a potom převod na IntStream a vykreslování pomocí forEach + lambda*/
                for (int i = 0; i < size; i++) {
                    final int finalI = i;
                    IntStream.range(0, size).forEach(result -> {
                        if(result == 0 || result == size - 1 || finalI == 0 || finalI == size - 1){
                            System.out.print(symbol);
                        }else{
                            System.out.print(" ");
                        }

                    });
                    System.out.println();
                }
                break;
            case 2:
                /*Druhá varianta převodu na IntStream a pomocí forEach + lambda vykreslit*/
                IntStream.range(0,size).forEach(result -> {
                    IntStream.range(0,size).forEach(result2 -> {if(result2 == 0 || result2 == size -1|| result == 0|| result == size -1){
                        System.out.print(symbol);
                    }
                    else{
                        System.out.print(" ");
                    }});
                    System.out.println();
                });
                break;
            case 3:
                /*Třetí varianta 2x for cyklus*/
                for(int i = 0; i < size; i++){
                    for(int j = 0; j < size; j++){
                        if((i == 0 || i == size -1) || (j == 0 || j == size -1)) {
                            System.out.print(symbol);
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Only variants 1,2 and 3 are valid!");
                break;
        }
    }
}

