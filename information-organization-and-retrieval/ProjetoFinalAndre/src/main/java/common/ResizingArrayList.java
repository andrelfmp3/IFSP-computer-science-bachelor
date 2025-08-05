package common;

import java.util.Iterator;

public class ResizingArrayList<Type> implements List<Type> {

    private Type[] values;
    
    private int end;
    
    private int size;
    
    @SuppressWarnings( "unchecked" )
    public ResizingArrayList() {
        values = (Type[]) new Object[1];
        end = -1;
    }
    
    @SuppressWarnings( "unchecked" )
    private void resize( int max ) {
        
        Type[] temp = (Type[]) new Object[max];
        
        for ( int i = 0; i < size; i++ ) {
            temp[i] = values[i];
        }
        
        values = temp;
        
    }
    
    @Override
    public void add( Type value ) {
        
        if ( size == values.length ) {
            resize( 2 * values.length );
        }
        
        end++;
        values[end] = value;
        size++;
        
    }
    
    @Override
    public void add( int index, Type value ) 
            throws ListIndexOutOfBoundsException {
        
        if ( index < 0 || index > size ) {
            throw new ListIndexOutOfBoundsException( 
                    "index must be between 0 and " + size + ", but it's " + index );
        }
        
        if ( isEmpty() || index == size ) {
            
            add( value );
            
        } else { 
            
            if ( size == values.length ) {
                resize( 2 * values.length );
            }
            
            for ( int i = end; i >= index; i-- ) {
                values[i+1] = values[i];
            }

            values[index] = value;
            end++;
            size++;
            
        }
        
    }

    @Override
    public Type get( int index ) 
            throws ListIndexOutOfBoundsException, EmptyListException {
        
        if ( isEmpty() ) {
            throw new EmptyListException();
        }
        
        if ( index < 0 || index >= size ) {
            throw new ListIndexOutOfBoundsException( 
                    "index must be between 0 and " + size + ", but it's " + index );
        }
        
        return values[index];
        
    }

    @Override
    public void set( int index, Type value ) 
            throws EmptyListException, ListIndexOutOfBoundsException {
        
        if ( isEmpty() ) {
            throw new EmptyListException();
        }
        
        if ( index < 0 || index >= size ) {
            throw new ListIndexOutOfBoundsException( 
                    "index must be between 0 and " + size + ", but it's " + index );
        }
        
        values[index] = value;
        
    }
    
    @Override
    public Type remove( int index ) 
            throws ListIndexOutOfBoundsException, EmptyListException {
        
        if ( isEmpty() ) {
            throw new EmptyListException();
        }
        
        if ( index < 0 || index >= size ) {
            throw new ListIndexOutOfBoundsException( 
                    "index must be between 0 and " + size + ", but it's " + index );
        }
        
        Type value = values[index];
        end--;
        size--;
        
        for ( int i = index; i <= end; i++ ) {
            values[i] = values[i+1];
        }
        
        values[end+1] = null;      

        if ( size > 0 && size == values.length / 4 ) {
            resize( values.length / 2 );
        }
        
        return value;
        
    }

    @Override
    public void clear() {
        
        while ( !isEmpty() ) {
            remove( size - 1 );
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
            
            private int current = 0;
            
            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Type next() {
                return values[current++];
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
            
            for ( int i = 0; i <= end; i++ ) {
                
                sb.append( String.format( "[%d] - ", i ) )
                        .append( values[i] );
                         
                if ( size == 1 ) {
                    sb.append( " <- start/end\n" );
                } else if ( i == 0 ) {
                    sb.append( " <- start\n" );
                } else if ( i == end ) {
                    sb.append( " <- end\n" );
                } else {
                    sb.append( "\n" );
                }

            }
            
        } else {
            sb.append( "empty list!\n" );
        }
        
        return sb.toString();
        
    }
    
}