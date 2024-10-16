/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula03;

import aesd.ds.implementations.linear.LinkedQueue;
import aesd.ds.interfaces.Queue;
import java.util.Arrays;

/**
 * Resolução do Exercício i3.1
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi3p1 {
    
    /**
     * A partir da quantidade n de pessoas e de uma posição m, deve gerar um
     * array de inteiros com a ordem em que as pessoas serão eliminadas,
     * contendo assim, em sua última posição, o lugar aonde Josefo deveria se
     * sentar. 
     * 
     * @param n A quantidade de pessoas.
     * @param m A posição da pessoa que será eliminada.
     * @return Um array de inteiros com a ordem em que as pessoas serão eliminadas.
     * @throws IllegalArgumentException Caso n ou m não sejam inteiros positivos.
     */
    public static int[] josephus( int n, int m ) 
            throws IllegalArgumentException {
        
        if ( n <= 0 || m <= 0 ) {
            throw new IllegalArgumentException( "n and m must be positive integers" );
        }
        
        int[] ordem = new int[n]; // ARRAY de tamanho 7
        LinkedQueue<Integer> fila = new LinkedQueue(); // via aloisinho
        
        // N = 7
        // M = 2
       
        for(int i = 0; i < n; i++){ // roda 7 vezes 
            fila.enqueue(i);
        }
        
        // problema: tirar algo que nn está no topo da fila. solução: deixar ela no topo da fila
        // circularmente, a b c e b c a é a mesma coisa.
        //  move oq não precisa pro fim (m vezes), oq tiver primeiro, desempilha. faz isso n vezes 
        int  k = 0;
        while (fila.isEmpty() == false){ 
            for(int j = 0; j < m-1; j++){ //  2 vezes
                fila.enqueue(fila.dequeue());
            }
            
            ordem[k++] = fila.dequeue();
            
        }
                
        return ordem;
        
    }
    
}