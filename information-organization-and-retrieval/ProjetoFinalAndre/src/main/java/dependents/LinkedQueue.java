package dependents;

//import aesd.ds.interfaces.Queue; // no mesmo pacote 
import common.EmptyQueueException;
import java.util.Iterator;

public class LinkedQueue<Type> implements Queue<Type> {

    private class Node {
        Type value;
        Node next;
    }
    
    private Node start;
    private Node end;
    
    private int size;
    
    public LinkedQueue() {
        start = null;   // redundante, apenas para mostrar o que acontece
        end = null;     // redundante também
        size = 0;       // redundante também
    }
    
    @Override
    public void enqueue( Type value ) {
        
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;  // redundante...
        
        if ( isEmpty()) {
            start = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        
        size++;
        
    }

    @Override
    public Type peek() throws EmptyQueueException {
        
        if ( !isEmpty() ) {
            return start.value;
        } else {
            throw new EmptyQueueException();
        }
        
    }

    @Override
    public Type dequeue() throws EmptyQueueException {
        
        if ( !isEmpty()) {
            
            Type value = start.value;
            
            if ( start == end ) {
                start = null;
                end = null;
            } else {
                Node temp = start;
                start = start.next;
                temp.next = null;
            }
            
            size--;
            return value;
            
        } else {
            throw new EmptyQueueException();
        }
        
    }

    @Override
    public void clear() {
        
        while ( !isEmpty() ) {
            dequeue();
        }
        
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Type> iterator() {
        
        return new Iterator<Type>() {
            
            private Node current = start;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Type next() {
                Type value = current.value;
                current = current.next;
                return value;
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException( "Not supported." );
            }
            
        };
        
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        if ( !isEmpty()) {
            
            // percorrendo o encadeamento
            Node current = start;
            
            while ( current != null ) {
                
                sb.append( current.value );
                
                if ( start == end ) {
                    sb.append( " <- start/end\n" );
                } else if ( current == start ) {
                    sb.append( " <- start\n" );
                } else if ( current == end ) {
                    sb.append( " <- end\n" );
                } else {
                    sb.append( "\n" );
                }
                
                current = current.next;

            }
            
        } else {
            sb.append( "empty queue!\n" );
        }
        
        return sb.toString();
        
    }
    
}