package algoritmos.implementation;

import algoritmos.dependents.btree.BTree;

public class BTree_Impl {

    public static void main(String[] args) {

        BTree<Character, Integer> bTree = new BTree<>();

        String nome = "ANDRELF";

        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);

            if (letra != ' ') {
                bTree.put(letra, i); 
            }
        }

        System.out.println(bTree);
    }
}
