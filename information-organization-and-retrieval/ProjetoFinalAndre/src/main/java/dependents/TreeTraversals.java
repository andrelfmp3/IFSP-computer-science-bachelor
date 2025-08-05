package dependents;

import common.List;
import common.Stack;
import common.ResizingArrayList;
import common.ResizingArrayStack;

public class TreeTraversals {
    

    public static <Key extends Comparable<Key>, Value> Iterable<BinaryTree.Entry<Key, Value>> traverse( BinaryTree.Node<Key, Value> node, TraversalTypes type ) {
        
        List<BinaryTree.Entry<Key, Value>> entries = new ResizingArrayList<>();
        
        switch ( type ) {
            case PREORDER:
                preOrder( node, entries );
                break;
            case INORDER:
                inOrder( node, entries );
                break;
            case POSTORDER:
                postOrder( node, entries );
                break;
            case LEVEL_ORDER:
                levelOrder( node, entries );
                break;
            case INVERSE_PREORDER:
                inversePreOrder( node, entries );
                break;
            case INVERSE_INORDER:
                inverseInOrder( node, entries );
                break;
            case INVERSE_POSTORDER:
                inversePostOrder( node, entries );
                break;
            case INVERSE_LEVEL_ORDER:
                inverseLevelOrder( node, entries );
                break;
        }
        
        
        return entries;
        
    }
    
    private static <Key extends Comparable<Key>, Value> void preOrder( BinaryTree.Node<Key, Value> node, List<BinaryTree.Entry<Key, Value>> entries ) {
        
        if ( node != null ) {
            entries.add( new BinaryTree.Entry<>( node.key, node.value ) );
            preOrder( node.left, entries );
            preOrder( node.right, entries );
        }
        
    }
    
    private static <Key extends Comparable<Key>, Value> void inOrder( BinaryTree.Node<Key, Value> node, List<BinaryTree.Entry<Key, Value>> entries ) {
        
        if ( node != null ) {
            inOrder( node.left, entries );
            entries.add( new BinaryTree.Entry<>( node.key, node.value ) );
            inOrder( node.right, entries );
        }
        
    }
    
    private static <Key extends Comparable<Key>, Value> void postOrder( BinaryTree.Node<Key, Value> node, List<BinaryTree.Entry<Key, Value>> entries ) {
        
        if ( node != null ) {
            postOrder( node.left, entries );
            postOrder( node.right, entries );
            entries.add( new BinaryTree.Entry<>( node.key, node.value ) );
        }
        
    }
    
    private static <Key extends Comparable<Key>, Value> void levelOrder( BinaryTree.Node<Key, Value> node, List<BinaryTree.Entry<Key, Value>> entries ) {
        
        if ( node != null ) {
            
            Queue<BinaryTree.Node<Key, Value>> queue = new LinkedQueue<>();
            queue.enqueue( node );

            while ( !queue.isEmpty() ) {

                BinaryTree.Node<Key, Value> current = queue.dequeue();
                entries.add( new BinaryTree.Entry<>( current.key, current.value ) );

                if ( current.left != null ) {
                    queue.enqueue( current.left );
                }

                if ( current.right != null ) {
                    queue.enqueue( current.right );
                }

            }
            
        }
        
    }
    
    private static <Key extends Comparable<Key>, Value> void inversePreOrder( BinaryTree.Node<Key, Value> node, List<BinaryTree.Entry<Key, Value>> entries ) {
        
        if ( node != null ) {
            entries.add( new BinaryTree.Entry<>( node.key, node.value ) );
            inversePreOrder( node.right, entries );
            inversePreOrder( node.left, entries );
        }
        
    }
    
    private static <Key extends Comparable<Key>, Value> void inverseInOrder( BinaryTree.Node<Key, Value> node, List<BinaryTree.Entry<Key, Value>> entries ) {
        
        if ( node != null ) {
            inverseInOrder( node.right, entries );
            entries.add( new BinaryTree.Entry<>( node.key, node.value ) );
            inverseInOrder( node.left, entries );
        }
        
    }
    
    private static <Key extends Comparable<Key>, Value> void inversePostOrder( BinaryTree.Node<Key, Value> node, List<BinaryTree.Entry<Key, Value>> entries ) {
        
        if ( node != null ) {
            inversePostOrder( node.right, entries );
            inversePostOrder( node.left, entries );
            entries.add( new BinaryTree.Entry<>( node.key, node.value ) );
        }
        
    }
    
    private static <Key extends Comparable<Key>, Value> void inverseLevelOrder( BinaryTree.Node<Key, Value> node, List<BinaryTree.Entry<Key, Value>> entries ) {
        
        if ( node != null ) {
            
            Queue<BinaryTree.Node<Key, Value>> queue = new LinkedQueue<>();
            Stack<BinaryTree.Entry<Key, Value>> stack = new ResizingArrayStack<>();
            queue.enqueue( node );

            while ( !queue.isEmpty() ) {

                BinaryTree.Node<Key, Value> current = queue.dequeue();
                stack.push( new BinaryTree.Entry<>( current.key, current.value ) );

                if ( current.left != null ) {
                    queue.enqueue( current.left );
                }

                if ( current.right != null ) {
                    queue.enqueue( current.right );
                }

            }

            while ( !stack.isEmpty() ) {
                entries.add( stack.pop() );
            }
        
        }
        
    }
    
}