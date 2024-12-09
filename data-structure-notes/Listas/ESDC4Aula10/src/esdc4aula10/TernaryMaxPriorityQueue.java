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
 * @param <Key> Tipo das chaves que serão armazenadas na fila de prioridades.
 * 
 * Critério de ordenação:
 * - MaxHeap: Chave do elemento pai sempre maior ou igual aos filhos
 * - Árvore ternária armazenada em array:
 *   * Pai: floor((k+1)/3)
 *   * Filho 1: 3k - 1
 *   * Filho 2: 3k
 *   * Filho 3: 3k + 1
 * 
 * Construção do heap:
 * - Bottom-Up heapify (swim)
 * - Top-Down heapify (sink)
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TernaryMaxPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue<Key> {

    private Key[] pq; // heap ternário
    private int n;    // tamanho da fila

    // Construtor padrão
    public TernaryMaxPriorityQueue() {
        this(1);
    }

    // Construtor com capacidade inicial
    @SuppressWarnings("unchecked")
    public TernaryMaxPriorityQueue(int initCapacity) {
        pq = (Key[]) new Comparable[initCapacity + 1];
    }

    // Redimensiona o array para a nova capacidade
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
        if (n == pq.length - 1) {
            resize(3 * pq.length);
        }
        pq[++n] = key;
        swim(n);
    }

    @Override
    public Key peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }

    @Override
    public Key delete() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        Key max = pq[1];
        exchange(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exchange(k, parent(k));
            k = parent(k);
        }
    }

    private void sink(int k) {
        while (true) {
            int largest = k;
            int firstChild = firstChild(k);
            for (int i = 0; i < 3; i++) {
                int child = firstChild + i;
                if (child <= n && less(largest, child)) {
                    largest = child;
                }
            }
            if (largest == k) break;
            exchange(k, largest);
            k = largest;
        }
    }

    private int parent(int k) {
        return (k + 1) / 3;
    }

    private int firstChild(int k) {
        return 3 * k - 1;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= n; i++) {
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
            copy = new TernaryMaxPriorityQueue<>(getSize());
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
            sb.append("empty max priority queue!\n");
        }
        return sb.toString();
    }

    private void preOrder(int i, String indent, StringBuilder sb) {
        if (i <= n && pq[i] != null) {
            String rootIdent = "";
            String leafIdent = "";

            if (i != 1) {
                rootIdent = indent + "|--";
                leafIdent = indent + "|  ";
            }

            sb.append(rootIdent);
            sb.append(pq[i]);
            if (i == 1) {
                sb.append(" <- max (root)");
            }
            sb.append("\n");

            preOrder(i * 3 - 1, leafIdent, sb);
            preOrder(i * 3, leafIdent, sb);
            preOrder(i * 3 + 1, leafIdent, sb);
        }
    }

    public static void main(String[] args) {
        TernaryMaxPriorityQueue<Integer> tpq = new TernaryMaxPriorityQueue<>();
        List<Integer> values = new ArrayList<>();
        List<Integer> removedValues = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            values.add((int) (Math.random() * 1000) + 1);
        }

        for (int i : values) {
            tpq.insert(i);
        }

        System.out.println(tpq);

        while (!tpq.isEmpty()) {
            removedValues.add(tpq.delete());
        }

        Collections.sort(values);
        Collections.reverse(values);

        System.out.println(values.equals(removedValues));
    }
}

