/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula07;

/**
 * Ordenação usando árvore binária de busca.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class BinarySearchTreeSort {

    public static <Type extends Comparable<Type>> void sort( Type[] array ) {
        
        BinarySearchTreeDupKeys<Type> bst = new BinarySearchTreeDupKeys<>();
        
        
        for (Type element : array) {
            bst.put(element);
        }
        
        
        int index = 0;
        for (Type element : bst.traverse(TraversalTypes.INORDER)) {
            array[index++] = element;
        }
        
    }
    
}
