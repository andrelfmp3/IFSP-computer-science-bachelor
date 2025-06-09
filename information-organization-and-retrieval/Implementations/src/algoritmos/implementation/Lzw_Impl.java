package algoritmos.implementation;

import algoritmos.dependents.lzw.LZW;

public class Lzw_Impl {

    public static void main(String[] args) {
        
        System.out.println("Executando compressao LZW...");
        LZW.compress();
        
        System.out.println("Executando expansao LZW...");
        LZW.expand();
        
    }
    
}
