package algoritmos.implementation;

import algoritmos.dependents.rabinkarp.RabinKarp;

public class RabinKarp_Impl {

    public static void main(String[] args) {
        
        String texto = "andrelf";
        String padrao = "lf";

        RabinKarp rk = new RabinKarp(padrao);
        int pos = rk.search(texto);

        if (pos < texto.length()) {
            System.out.println("Padrao encontrado na posicao: " + pos);
        } else {
            System.out.println("Padrao nao encontrado.");
        }
        
    }
    
}
