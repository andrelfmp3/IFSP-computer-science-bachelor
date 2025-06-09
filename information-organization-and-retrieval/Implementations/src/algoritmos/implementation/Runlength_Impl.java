package algoritmos.implementation;

import algoritmos.dependents.runlenght.RunLength;

public class Runlength_Impl {

    public static void main(String[] args) {
      
        System.out.println("Executando compressão...");
        RunLength.compress();

        System.out.println("Executando expansão...");
        RunLength.expand();
    }

}
