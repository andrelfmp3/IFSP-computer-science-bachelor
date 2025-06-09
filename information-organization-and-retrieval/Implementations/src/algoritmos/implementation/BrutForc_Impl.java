package algoritmos.implementation;

import algoritmos.dependents.brutForcBoyerMoore.BoyerMoore;

public class BrutForc_Impl {

    public static void main(String[] args) {

        String nomeCompleto = "ANDRELF";

        String padrao = "LF";

        BoyerMoore bm = new BoyerMoore(padrao);

        int posicao = bm.search(nomeCompleto);

        if (posicao < nomeCompleto.length()) {
            System.out.println("Padrao \"" + padrao + "\" encontrado na posicao: " + posicao);
        } else {
            System.out.println("Padrao \"" + padrao + "\" nao encontrado no texto.");
        }
    }
}
