package algoritmos.implementation;

import algoritmos.dependents.msd.MSD;

public class Msd_Impl {
    
    public static void main(String[] args) {
        
        String[] palavras = {
            "banana",
            "abacaxi",
            "laranja",
            "uva",
            "manga",
            "pera",
            "abacate"
        };
        
        System.out.println("Antes da ordenacao:");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
        
        MSD.sort(palavras);
        
        System.out.println("\nDepois da ordenacao:");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
        
    }
    
}
