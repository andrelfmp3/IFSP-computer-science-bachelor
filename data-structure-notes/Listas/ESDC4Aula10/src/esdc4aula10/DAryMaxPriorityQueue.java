package esdc4aula10;

import aesd.ds.interfaces.PriorityQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementação de uma fila de prioridades máxima usando um heap d-ário máximo.
 * 
 * @param <Key> Tipo das chaves que serão armazenadas na fila de prioridades.
 *
 * @author Prof. Dr. David Buzatto
 */
public class DAryMaxPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue<Key> {

    // Heap d-ário das chaves da fila de prioridades, posições 1 até n (size)
    private Key[] pq;

    // Quantidade de itens na fila de prioridades
    private int n;

    // Quantidade máxima de filhos (aridade do heap)
    private int d;

    // Construtor padrão (aridade 2 - binário)
    public DAryMaxPriorityQueue() {
        this(1, 2);
    }

    // Construtor com aridade específica
    public DAryMaxPriorityQueue(int d) throws IllegalArgumentException {
        this(1, d);
    }

    // Construtor com capacidade inicial e aridade específica
    @SuppressWarnings("unchecked")
    public DAryMaxPriorityQueue(int initCapacity, int d) throws IllegalArgumentException {
        if (d < 2) {
            throw new IllegalArgumentException("A aridade deve ser maior ou igual a 2");
        }
        pq = (Key[]) new Comparable[initCapacity + 1];
        this.d = d;
    }

    // Redimensiona o array para uma nova capacidade
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    @Override
    public void insert(Key key) {
        // Dobra o tamanho se atingir a capacidade máxima
        if (n == pq.length - 1) {
            resize(d * pq.length);
        }

        // Insere a chave no final e ajusta a propriedade do heap
        pq[++n] = key;
        swim(n);
    }

    @Override
    public Key peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila de prioridade vazia");
        }
        return pq[1];
    }

    @Override
    public Key delete() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila de prioridade vazia");
        }

        Key max = pq[1]; // O maior elemento
        exchange(1, n--); // Troca a raiz com o último
        sink(1); // Ajusta a propriedade do heap
        pq[n + 1] = null; // Marca o último como null para coleta de lixo

        // Reduz o tamanho do array se necessário
        if ((n > 0) && (n == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }

        return max;
    }

    // Método para ajustar a propriedade do heap (flutuar)
    private void swim(int k) {
        while (k > 1 && less(dAryParent(k), k)) {
            exchange(k, dAryParent(k));
            k = dAryParent(k);
        }
    }

    // Método para ajustar a propriedade do heap (afundar)
    private void sink(int k) {
        while (true) {
            int firstChild = dAryFirstChild(k);
            int maxIndex = k;

            // Encontra o maior filho entre os d filhos
            for (int i = 0; i < d; i++) {
                int child = firstChild + i;
                if (child <= n && less(maxIndex, child)) {
                    maxIndex = child;
                }
            }

            // Se não há necessidade de trocar, sai do loop
            if (maxIndex == k) {
                break;
            }

            exchange(k, maxIndex);
            k = maxIndex;
        }
    }

    // Retorna o índice do pai de um nó no heap
    private int dAryParent(int k) {
        return (k - 2) / d + 1;
    }

    // Retorna o índice do primeiro filho de um nó no heap
    private int dAryFirstChild(int k) {
        return d * (k - 1) + 2;
    }

    // Compara se o elemento na posição i é menor que o da posição j
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // Troca os elementos nas posições i e j
    private void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    @Override
    public void clear() {
        for (int i = 0; i < pq.length; i++) {
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

    // Iterador para percorrer os elementos do heap
    private class HeapIterator implements Iterator<Key> {
        private DAryMaxPriorityQueue<Key> copy;

        public HeapIterator() {
            copy = new DAryMaxPriorityQueue<>(getSize());
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Key next() {
            if (!hasNext()) {
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

        if (!isEmpty()) {
            preOrder(1, "", sb);
        } else {
            sb.append("Fila de prioridade vazia!\n");
        }

        return sb.toString();
    }

    // Método para representar o heap como string (ordem pré-fixada)
    private void preOrder(int i, String ident, StringBuilder sb) {
        if (i <= n && pq[i] != null) {
            String rootIdent = "";
            String leafIdent = "";

            if (i != 1) {
                rootIdent = ident + "|--";
                leafIdent = ident + "|  ";
            }

            sb.append(rootIdent);
            sb.append(pq[i]);
            if (i == 1) {
                sb.append(" <- max (raiz)");
            }
            sb.append("\n");

            int start = dAryFirstChild(i);

            for (int j = start; j < start + d; j++) {
                preOrder(j, leafIdent, sb);
            }
        }
    }
}
