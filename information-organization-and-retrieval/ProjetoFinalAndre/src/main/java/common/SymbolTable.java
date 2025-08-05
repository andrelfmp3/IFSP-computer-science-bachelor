package common;

public interface SymbolTable<Key, Value> extends Iterable<SymbolTable.Entry<Key, Value>>  {
    
    public static class Entry<Key, Value> {
        
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
    
    public void put( Key key, Value value ) throws IllegalArgumentException;
    
    public Value get( Key key ) throws IllegalArgumentException;
    
    public void delete( Key key ) throws IllegalArgumentException;
    
    public boolean contains( Key key ) throws IllegalArgumentException;
    
    public void clear();

    public boolean isEmpty();
    
    public int getSize();
    
    public Iterable<Key> getKeys();
    
}