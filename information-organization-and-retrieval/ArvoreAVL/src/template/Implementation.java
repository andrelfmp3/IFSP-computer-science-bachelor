package template;

import aesd.ds.implementations.nonlinear.symtable.AVLTree;

public class Implementation { 
    
    public static void main(String[] args) {
        
        // Criação da árvore AVL para armazenar letras com seus índices como valores
        AVLTree<Character, Integer> avlTree = new AVLTree<>();

        // Nome completo
        String nome = "ANDRE LYRA FERNANDES";

        // Adiciona cada letra do nome à árvore AVL
        for (int i = 0; i < nome.length(); i++) {
            char letra = nome.charAt(i);

            // Ignora espaços
            if (letra != ' ') {
                avlTree.put(letra, i); // Aqui, usamos o índice como valor
            }
        }

        // Exibe a árvore AVL em pré-ordem
        System.out.println(avlTree);
    }
}
