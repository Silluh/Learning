package main.com.example010.daniel.v2.fighters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointerExampleApplication {

    public static void main(String[] args) {

        var names = new ArrayList<>(Arrays.asList("Radek", "Daniel", "daniel"));
        printNames(names);

        removeNameFromList("daniel", names);
        printNames(names);

        removeNameFromList("Radek", names);
        printNames(names);
    }

    private static void removeNameFromList(String name, List<String> names) {

        names.remove(name);
    }

    private static void printNames(List<String> names) {

        for (String name : names) {
            System.out.print(name + "\t");
        }
        System.out.println();
    }
}
