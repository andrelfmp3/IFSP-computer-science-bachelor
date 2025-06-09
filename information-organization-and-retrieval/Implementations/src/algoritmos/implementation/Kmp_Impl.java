package algoritmos.implementation;

import algoritmos.dependents.kmp.KMP;

public class Kmp_Impl {

    public static void main(String[] args) {

        String texto = "ANDRELYRAFERANDNES";
        String padrao = "LYRA";

        KMP kmp = new KMP(padrao);
        int pos = kmp.search(texto);

        if (pos == texto.length()) {
            System.out.println("Padrao nao encontrado no texto.");
        } else {
            System.out.println("Padrao encontrado na posicao: " + pos);
        }

    }

}
