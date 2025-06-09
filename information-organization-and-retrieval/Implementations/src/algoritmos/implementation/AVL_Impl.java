package algoritmos.implementation;

import algoritmos.dependents.avl.AVLTree;

public class AVL_Impl { 
    
    public static void main(String[] args) {
        
        AVLTree<Character, Integer> avlTree = new AVLTree<>();

        String nome = "ANDRELFS";

        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);

            if (letra != ' ') {
                avlTree.put(letra, i); 
            }
        }

        System.out.println(avlTree);
    }
}