package algoritmos.implementation;

import algoritmos.dependents.lsd.LSD;

public class Lsd_Impl {

    public static void main(String[] args) {

        String[] arr = {
            "bca",
            "acb",
            "abc",
            "cab",
            "cba",
            "bac"
        };

        int w = arr[0].length();

        System.out.println("Antes da ordenacao:");
        for (String s : arr) {
            System.out.println(s);
        }

        LSD.sort(arr, w);

        System.out.println("\nDepois da ordenacao:");
        for (String s : arr) {
            System.out.println(s);
        }

    }

}
