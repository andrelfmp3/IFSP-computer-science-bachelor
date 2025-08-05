package dependents;

public interface Queue<Type> extends Iterable<Type> {
    
    public void enqueue( Type value );
    
    public Type peek();
    
    public Type dequeue();
    
    public void clear();
    
    public boolean isEmpty();
    
    public int getSize();
    
}