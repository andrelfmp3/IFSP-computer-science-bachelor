package dependents;

/*
Implementação por Prof. Dr. David Buzzato
Modificado por André Lyra Fernandes (bv303139x)
    - Nomes de variaveis e métodos alterados
    - Comentários adicionais
Utilizou-se Grok by xAI apenas para revisão.
*/

/*

“Uma árvore binária de busca é uma árvore binária ordenada em que, 
para cada nó n, todas as chaves na subárvore esquerda são menores que n.key e 
todas as chaves na subárvore direita são maiores que n.key.”
    — Cormen, Leiserson, Rivest, Stein – Introduction to Algorithms (CLRS), 4ª ed., 2022, Cap. 12

“Em uma BST, o campo key de cada nó é maior do que todas as chaves armazenadas
em sua subárvore esquerda, e menor do que todas as chaves armazenadas
em sua subárvore direita.”
    — Donald E. Knuth – The Art of Computer Programming, Volume 3: Sorting and Searching, 2ª ed., 1998

*/

import java.util.Iterator;

// Importações comentadas (não importadas pois estão no pacote em dependents).

/*
import aesd.ds.implementations.linear.LinkedQueue;     
import aesd.algorithms.tree.TraversalTypes;            
import aesd.algorithms.tree.TreeTraversals;            
import aesd.ds.interfaces.BinaryTree;                  
import aesd.ds.interfaces.Queue;                       
*/

/*
 * O principal objetivo da BST é permitir operações eficientes de inserção, busca e remoção,
 * com complexidade proporcional à altura da árvore (O(h)).
*/

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements BinaryTree<Key, Value> {

        // Campo de instância

    // Referência para o nó raiz da árvore.
    private Node<Key, Value> rootNode;

    // Contador de pares (chave, valor) atualmente armazenados na árvore. 
    private int numeroDePares;

        // Construrtor

    // Constrói uma árvore binária de busca inicialmente vazia.
    public BinarySearchTree() {
    }

        // Métodos

    // Insere ou atualiza um par (chave, valor) na árvore. @throws IllegalArgumentException se for null.
    @Override
    public void put(Key key, Value value) throws IllegalArgumentException {

        if (key == null) { // Verifica se a chave fornecida é nula.
            throw new IllegalArgumentException("first argument to put() is null");
        }

        if (value == null) { // se o valor for nulo, executa a remoção da chave correspondente.
            delete(key);
            return;
        }

        // Chamada da função recursiva auxiliar para inserir o par.
        rootNode = put(rootNode, key, value);
    }

    // Inserção recursiva de nó ou atualização de valor.
    private Node<Key, Value> put(Node<Key, Value> currentNode, Key key, Value value) {

        if (currentNode == null) { // Caso base: o nó atual é nulo, então cria-se um novo nó e atualiza o contador de pares.
            Node<Key, Value> newNode = new Node<>();
            newNode.key = key;
            newNode.value = value;
            newNode.left = null;
            newNode.right = null;
            numeroDePares++;
            return newNode;
        }

        // Compara a chave fornecida com a chave do nó atual.
        int comparisonResult = key.compareTo(currentNode.key);

        if (comparisonResult < 0) {
            // A chave é menor; segue pela subárvore esquerda.
            currentNode.left = put(currentNode.left, key, value);
        } else if (comparisonResult > 0) {
            // A chave é maior; segue pela subárvore direita.
            currentNode.right = put(currentNode.right, key, value);
        } else {
            // A chave já existe; apenas atualiza o valor.
            currentNode.value = value;
        }

        return currentNode;
    }

    // Retorna o valor associado à chave fornecida ou nul se não existir.
    @Override
    public Value get(Key key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        return get(rootNode, key); // Chamada à função auxiliar.
    }

    // Implementação iterativa da operação de busca por chave.
    private Value get(Node<Key, Value> currentNode, Key key) {
        while (currentNode != null) {
            int comparisonResult = key.compareTo(currentNode.key);
            if (comparisonResult < 0) {
                currentNode = currentNode.left;
            } else if (comparisonResult > 0) {
                currentNode = currentNode.right;
            } else {
                return currentNode.value; // Chave encontrada.
            }
        }
        return null; // Chave não encontrada.
    }

    // Remove o par associado à chave fornecida, se existir.
    @Override
    public void delete(Key key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        rootNode = delete(rootNode, key); // Chamada recursiva para remoção.
    }

    // Implementa a remoção de um nó usando a técnica de Hibbard (remoção recursiva).
    private Node<Key, Value> delete(Node<Key, Value> currentNode, Key key) {

        if (currentNode == null) {
            return null; // Caso base: chave não encontrada.
        }

        int comparisonResult = key.compareTo(currentNode.key);

        if (comparisonResult == 0) {
            numeroDePares--; // Atualiza contador de pares.

            // Caso 0 filhos (folha).
            if (currentNode.left == currentNode.right) {
                return null;
            }
            // Caso só filho à direita.
            else if (currentNode.left == null) {
                Node<Key, Value> rightSubtree = currentNode.right;
                currentNode.right = null;
                return rightSubtree;
            }
            // Caso só filho à esquerda.
            else if (currentNode.right == null) {
                Node<Key, Value> leftSubtree = currentNode.left;
                currentNode.left = null;
                return leftSubtree;
            }
            // Caso dois filhos: encontra o menor da subárvore direita.
            else {
                Node<Key, Value> successorSubtree = currentNode.right;
                Node<Key, Value> minimumNode = successorSubtree;
                while (minimumNode.left != null) {
                    minimumNode = minimumNode.left;
                }
                // Conecta a subárvore esquerda ao mínimo da subárvore direita.
                minimumNode.left = currentNode.left;
                currentNode.left = currentNode.right = null; // Desconecta o nó atual.
                return successorSubtree;
            }
        } else if (comparisonResult < 0) {
            currentNode.left = delete(currentNode.left, key); // Recurso à esquerda.
        } else {
            currentNode.right = delete(currentNode.right, key); // Recurso à direita.
        }

        return currentNode;
    }

    // Verifica se a chave está presente na árvore. Métodos com @Override não podem ser traduzidos
    @Override
    public boolean contains(Key key) throws IllegalArgumentException {
        return get(key) != null;
    }

    // Remove todos os elementos da árvore. Não pode ser traduzido
    @Override
    public void clear() {
        rootNode = clear(rootNode); // Chamada recursiva.
        numeroDePares = 0;          // Reinicializa o contador.
    }

    // Remoção recursiva de todos os nós (pós-ordem). Não pode ser traduzido
    private Node<Key, Value> clear(Node<Key, Value> currentNode) {
        if (currentNode != null) {
            currentNode.left = clear(currentNode.left);
            currentNode.right = clear(currentNode.right);
        }
        return null;
    }

    // Verifica se a árvore está vazia. Não pode ser traduzido
    @Override
    public boolean isEmpty() {
        return numeroDePares == 0;
    }

    // Retorna o número de pares armazenados na árvore. Não pode ser traduzido
    @Override
    public int getSize() {
        return numeroDePares;
    }

    // Retorna um Iterable com os pares ordenados conforme o tipo de percurso especificado. Não pode ser traduzido
    @Override
    public Iterable<Entry<Key, Value>> traverse(TraversalTypes type) {
        return TreeTraversals.traverse(rootNode, type);
    }

    // Iterador padrão: percurso em ordem (chaves ordenadas crescentemente). Não pode ser traduzido
    @Override
    public Iterator<BinaryTree.Entry<Key, Value>> iterator() {
        return traverse(TraversalTypes.INORDER).iterator();
    }

    // Retorna todas as chaves armazenadas em ordem crescente. Não pode ser traduzido
    @Override
    public Iterable<Key> getKeys() {
        Queue<Key> keyQueue = new LinkedQueue<>(); // Fila para armazenar as chaves.
        for (BinaryTree.Entry<Key, Value> entry : traverse(TraversalTypes.INORDER)) {
            keyQueue.enqueue(entry.getKey()); // Enfileira cada chave visitada.
        }
        return keyQueue;
    }

        // Representação textual

    // Retorna uma representação textual hierárquica da árvore (pré-ordem). Não pode ser traduzido
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!isEmpty()) {
            preOrdena(rootNode, "", null, stringBuilder);
        } else {
            stringBuilder.append("empty binary search tree!\n");
        }
        return stringBuilder.toString();
    }

    // Monta a string da árvore usando percurso pré-ordem, com indentação.     
    private void preOrdena(Node<Key, Value> currentNode, String indentation, String leftRightIndicator, StringBuilder stringBuilder) {
        if (currentNode != null) {
            String rootPrefix = "";
            String leafPrefix = "";
            if (currentNode != rootNode) {
                rootPrefix = indentation + "|--"; // Prefixo visual para ramos.
                leafPrefix = indentation + "|  "; // Indentação para subníveis.
            }
            stringBuilder.append(rootPrefix);
            if (leftRightIndicator != null) {
                stringBuilder.append("(").append(leftRightIndicator).append(") ");
            }
            stringBuilder.append(currentNode);
            if (currentNode == rootNode) {
                stringBuilder.append(" <- root"); // Marca a raiz.
            }
            stringBuilder.append("\n");
            preOrdena(currentNode.left, leafPrefix, "L", stringBuilder);
            preOrdena(currentNode.right, leafPrefix, "R", stringBuilder);
        }
    }
}
