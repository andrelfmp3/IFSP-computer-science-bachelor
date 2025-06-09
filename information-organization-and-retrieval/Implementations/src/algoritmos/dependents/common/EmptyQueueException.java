package algoritmos.dependents.common;

/**
 * Exceção para quando uma fila está vazia.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class EmptyQueueException extends RuntimeException {
    
    /**
     * Construtor sem parâmetros.
     */
    public EmptyQueueException() {
        super( "The queue is empty!" );
    }
    
    /**
     * Construtor com mensagem.
     * 
     * @param message Mensagem da exceção.
     */
    public EmptyQueueException( String message ) {
        super( message );
    }
    
}
