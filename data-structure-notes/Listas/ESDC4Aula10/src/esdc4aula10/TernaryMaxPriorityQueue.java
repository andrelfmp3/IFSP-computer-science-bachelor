/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula10;

import aesd.ds.interfaces.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementação de uma fila de prioridades máxima usando um heap ternário máximo.
 * 
 * Critério de ordenação:
 *     - MaxHeap:
 *         * Chave do elemento pai sempre maior ou igual aos filhos
 *     – Chaves armazenadas em um array.
 *
 * Construção:
 *     – Heap ternário (até três filhos)
 *     – Completa: elementos sem filhos apenas no último nível
 *      (e anterior, quando o último nível não está completo)
 *
 * Árvore ternária completa:
 *     – Armazenamento direto em array!
 *     - Raiz na posição 1
 *     - Último elemento na posição tamanho do array - 1
 *     – Manipulação dos índices:
 *          * Pai: floor((k+1)/3)
 *          * Filho 1: 3k - 1
 *          * Filho 2: 3k
 *          * Filho 3: 3k + 1
 *
 * Elemento violando a condição heap máximo
 *     – Chave maior que a chave do pai
 *        * O elemento precisa "subir" na árvore
 *        * Bottom-Up heapify (swim => flutuar)
 *     – Chave menor que a chave dos filhos (um ou dois)
 *        * O elemento precisa "descer" na árvore
 *        * Top-Down heapify (sink => afundar)
 *
 *
 * @param <Key> Tipo das chaves que serão armazenadas na fila de prioridades.
 *
 * @author Prof. Dr. David Buzatto
 */
public class TernaryMaxPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue<Key> {

    // heap ternário das chaves da fila de prioridades, nas posições 1 até n (size)
    private Key[] pq;
    
    // quantidade de itens na fila de prioridades
    private int n;

    public TernaryMaxPriorityQueue() {
        this( 1 );
    }
    
    @SuppressWarnings( "unchecked" )
    public TernaryMaxPriorityQueue( int initCapacity ) {
        pq = (Key[]) new Comparable[initCapacity + 1];
    }

    @SuppressWarnings( "unchecked" )
    private void resize( int capacity ) {
        
        Key[] temp = (Key[]) new Comparable[capacity];
        
        for ( int i = 1; i <= n; i++ ) {
            temp[i] = pq[i];
        }
        
        pq = temp;
        
    }

    @Override
    public void insert( Key key ) {

        // triplica o tamanho se chegou no limite da capacidade
        if ( n == pq.length - 1 ) {
            resize( 3 * pq.length );
        }

        // insere a chave e a flutua, mantendo a invariante do heap máximo
        pq[++n] = key;
        swim( n );
        
    }
    
    @Override
    public Key peek() throws NoSuchElementException {
        
        if ( isEmpty() ) {
            throw new NoSuchElementException( "Priority queue underflow" );
        }
        
        return pq[1];
        
    }
    
    @Override
    public Key delete() throws NoSuchElementException {
        
        if ( isEmpty() ) {
            throw new NoSuchElementException( "Priority queue underflow" );
        }
        
        Key max = pq[1];
        
        // troca a raiz com o último
        exchange( 1, n-- );
        
        // afunda a nova raiz, mantendo a invariante do heap máximo
        sink( 1 );
        
        pq[n + 1] = null;     // marca como null para coleta de lixo
        
        // se o tamanho é igual à um quarto da capacidade
        if ( ( n > 0 ) && ( n == ( pq.length - 1 ) / 4 ) ) {
            // diminui a capacidade pela metade
            resize( pq.length / 2 );
        }
        
        return max;
        
    }
    
    private void swim( int k ) {
        
        while (k > 1 && less(((k+1)/3), k)) {
            exchange(k, ((k+1)/3)); // sem "dAryParent", implementado direto, transforamr em funcao 
            k = ((k+1)/3);
        }
        
    }

    private void sink( int k ) {
        
        Boolean loop = true;
        
        while (loop = true) {
            
            int max = k;
            int primeiroFilho = ((3*k)-1);
            
            for (int i = 0; i < 3; i++) {
                
                int filho = primeiroFilho + i;
                
                if (filho <= n && less(max, filho)) {
                    max = filho;
                }
            }
            
            if (max == k){
                break;
            } 
            
            exchange(k, max);
            k = max;
            
        }
    }

    private boolean less( int i, int j ) {
        return pq[i].compareTo( pq[j] ) < 0;
    }

    private void exchange( int i, int j ) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    
    @Override
    public void clear() {
        for ( int i = 0; i < pq.length; i++ ) {
            pq[i] = null;
        }
        n = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return n == 0;
    }
    
    @Override
    public int getSize() {
        return n;
    }
    
    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        private TernaryMaxPriorityQueue<Key> copy;

        public HeapIterator() {
            copy = new TernaryMaxPriorityQueue<>( getSize() );
            for ( int i = 1; i <= n; i++ ) {
                copy.insert( pq[i] );
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        
        @Override
        public Key next() {
            if ( !hasNext() ) {
                throw new NoSuchElementException();
            }
            return copy.delete();
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        if ( !isEmpty()) {
            
            preOrder( 1, "", sb );
            
        } else {
            sb.append( "empty max priority queue!\n" );
        }
        
        return sb.toString();
        
    }
    
    private void preOrder( int i, String ident, StringBuilder sb ) {
        
        if ( i <= n && pq[i] != null ) {
            
            String rootIdent = "";
            String leafIdent = "";
            
            if ( i != 1 ) {
                rootIdent = ident + "|--";
                leafIdent = ident + "|  ";
            }
            
            sb.append( rootIdent );
            sb.append( pq[i] );
            if ( i == 1 ) {
                sb.append(  " <- max (root)" );
            }
            sb.append( "\n" );
            
            preOrder( i * 3 - 1, leafIdent, sb );
            preOrder( i * 3, leafIdent, sb );
            preOrder( i * 3 + 1, leafIdent, sb );
            
        }
        
    }
    
    public static void main( String[] args ) {
        
        TernaryMaxPriorityQueue<Integer> tpq = new TernaryMaxPriorityQueue<>();
        List<Integer> values = new ArrayList<>();
        List<Integer> removedValues = new ArrayList<>();
        
        for ( int i = 0; i < 100; i++ ) {
            values.add( (int) ( Math.random() * 1000 ) + 1 );
        }
        
        for ( int i : values ) {
            tpq.insert( i );
        }
        
        System.out.println( tpq );
        
        while ( !tpq.isEmpty() ) {
            removedValues.add( tpq.delete() );
        }
        
        Collections.sort( values );
        Collections.reverse( values );
        
        for ( int i = 0; i < values.size(); i++ ) {
            int v = values.get( i );
            int rv = removedValues.get( i );
        }
        
        System.out.println( values.equals( removedValues ) );
        
    }

}
