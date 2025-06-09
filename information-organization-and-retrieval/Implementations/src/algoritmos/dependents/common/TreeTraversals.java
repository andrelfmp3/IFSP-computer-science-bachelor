package algoritmos.dependents.common;

import algoritmos.dependents.common.BinaryTree;
import algoritmos.dependents.common.BinaryTree.Entry;
import algoritmos.dependents.common.BinaryTree.Node;
import algoritmos.dependents.common.TraversalTypes;
import algoritmos.dependents.common.LinkedQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementações de algoritmos de percurso de árvores.
 *
 * @author Prof. Dr. David Buzatto
 */
public class TreeTraversals {

    public static <K extends Comparable<K>, V> Iterable<Entry<K, V>> traverse(
        Node<K, V> root,
        TraversalTypes type
    ) {
        List<Entry<K, V>> items = new ArrayList<>();

        switch (type) {
            case PREORDER:
                preOrder(root, items);
                break;
            case INORDER:
                inOrder(root, items);
                break;
            case POSTORDER:
                postOrder(root, items);
                break;
            case LEVEL_ORDER:
                levelOrder(root, items);
                break;
        }

        return items;
    }

    private static <K extends Comparable<K>, V> void preOrder(
        Node<K, V> node,
        List<Entry<K, V>> items
    ) {
        if (node != null) {
            items.add(new BinaryTree.Entry<>(node.key, node.value));
            preOrder(node.left, items);
            preOrder(node.right, items);
        }
    }

    private static <K extends Comparable<K>, V> void inOrder(
        Node<K, V> node,
        List<Entry<K, V>> items
    ) {
        if (node != null) {
            inOrder(node.left, items);
            items.add(new BinaryTree.Entry<>(node.key, node.value));
            inOrder(node.right, items);
        }
    }

    private static <K extends Comparable<K>, V> void postOrder(
        Node<K, V> node,
        List<Entry<K, V>> items
    ) {
        if (node != null) {
            postOrder(node.left, items);
            postOrder(node.right, items);
            items.add(new BinaryTree.Entry<>(node.key, node.value));
        }
    }

    private static <K extends Comparable<K>, V> void levelOrder(
        Node<K, V> node,
        List<Entry<K, V>> items
    ) {
        if (node != null) {
            LinkedQueue<Node<K, V>> queue = new LinkedQueue<>();
            queue.enqueue(node);

            while (!queue.isEmpty()) {
                Node<K, V> current = queue.dequeue();
                items.add(new BinaryTree.Entry<>(current.key, current.value));

                if (current.left != null) {
                    queue.enqueue(current.left);
                }
                if (current.right != null) {
                    queue.enqueue(current.right);
                }
            }
        }
    }
}
