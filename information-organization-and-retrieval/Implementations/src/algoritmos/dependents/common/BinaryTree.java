package algoritmos.dependents.common;

import algoritmos.dependents.common.TraversalTypes;


/**
 * Interface para árvores binárias de busca genéricas.
 * 
 * @param <Key> Tipo das chaves que serão armazenadas na árvore.
 * @param <Value> Tipo dos valores associados às chaves armazenadas na árvore.
 * 
 * @author Prof. Dr. David Buzatto
 */
public interface BinaryTree<Key extends Comparable<Key>, Value> extends Iterable<BinaryTree.Entry<Key, Value>> {
    
    /**
     * Insere uma chave e seu valor associado na árvore.
     * Se a chave já existir, o valor antigo é substituído.
     * 
     * @param key A chave
     * @param value O valor associado
     * @throws IllegalArgumentException Caso a chave seja null
     */
    public void put( Key key, Value value ) throws IllegalArgumentException;
    
    /**
     * Obtém o valor associado à chave.
     * 
     * @param key A chave
     * @return O valor associado ou null caso a chave não esteja na árvore
     * @throws IllegalArgumentException Caso a chave seja null
     */
    public Value get( Key key ) throws IllegalArgumentException;
    
    /**
     * Remove uma chave e seu valor associado da árvore.
     * 
     * @param key A chave
     * @throws IllegalArgumentException Caso a chave seja null
     */
    public void delete( Key key ) throws IllegalArgumentException;
    
    /**
     * Verifica se há determinada chave na árvore.
     * 
     * @param key A chave
     * @return true caso a chave esteja na árvore, false caso contrário
     * @throws IllegalArgumentException Caso a chave seja null
     */
    public boolean contains( Key key ) throws IllegalArgumentException;
    
    /**
     * Esvazia a árvore.
     */
    public void clear();
    
    /**
     * Verifica se a árvore está vazia.
     * 
     * @return true caso a árvore esteja vazia, false caso contrário
     */
    public boolean isEmpty();
    
    /**
     * Quantidade de elementos na árvore.
     * 
     * @return Quantidade de elementos na árvore
     */
    public int getSize();
    
    /**
     * Percorre a árvore no tipo de percurso específico.
     * 
     * @param type Tipo do percurso
     * @return Iterable contendo as entrada (chave/valor) da árvore
     */
    public Iterable<Entry<Key, Value>> traverse( TraversalTypes type );
    
    /**
     * Obtém um iterável contendo todas as chaves da árvore.
     * 
     * @return Iterável contendo as chaves
     */
    public Iterable<Key> getKeys();
    
    /**
     * Classe para armazenar as entradas da árvore.
     */
    public static class Entry<Key extends Comparable<Key>, Value> {
        
        private Key key;
        private Value value;

        public Entry( Key key, Value value ) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public Value getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            return key + " -> " + value;
        }
        
    }
    
    /**
     * Classe que define os nós da árvore.
     */
    public static class Node<Key extends Comparable<Key>, Value> {
        
        public Key key;
        public Value value;
        public Node<Key, Value> left;
        public Node<Key, Value> right;
        
        @Override
        public String toString() {
            return key + " -> " + value;
        }
        
    }
}