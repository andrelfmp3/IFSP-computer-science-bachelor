package common; // utilizado pelo list

public class ListIndexOutOfBoundsException extends RuntimeException {
    
    public ListIndexOutOfBoundsException() {
    }
    
    public ListIndexOutOfBoundsException( String message ) {
        super( message );
    }
    
}