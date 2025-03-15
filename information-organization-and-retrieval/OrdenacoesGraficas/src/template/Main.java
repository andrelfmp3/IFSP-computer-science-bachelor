package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.util.ArrayList;
import java.util.List;

public class Main extends EngineFrame {
    
    private int[] array;
    private List<int[]> lista;
    private int pos;
    
    private double tempoParaMudar;
    private double contadorTempo;
    
    public Main() {
        super ( 800, 450, "Ordenações - André L. F", 60, true );
    }
    
    @Override
    public void create() {
        array = new int[]{ 9, 10, 5, 6, 3, 1, 2, 8 };
        lista = new ArrayList<>();
        tempoParaMudar = 1;
        copiarArray( lista, array );
        
        ordenarSelection( array );
        ordenarInsertion( array );
    }

    @Override
    public void update( double delta ) {
        
        contadorTempo += delta;
        
        if ( contadorTempo > tempoParaMudar ) {
            contadorTempo = 0;
            if ( pos < lista.size() - 1 ) {
                pos++;
            }
        }
        
    }

    @Override
    public void draw() {
        
        clearBackground( GRAY );
        desenharArray( lista.get( pos ), 10 , getScreenHeight() / 2, 30, 10, 10 ); // Selection
        desenharArray( lista.get( pos ), 410, getScreenHeight() / 2, 30, 10, 10 ); // Insertion
        desenharArray( lista.get( pos ), 10 , (getScreenHeight() / 2) + 220, 30, 10, 10 ); // Bubble
        desenharArray( lista.get( pos ), 410, (getScreenHeight() / 2) + 220, 30, 10, 10 ); // Merge
        
        // linha horizontal 
        drawLine( 0, (getScreenHeight() / 2) + 1, 800, getScreenHeight() / 2 + 1, RED ); 
        drawLine( 0, (getScreenHeight() / 2) + 2, 800, getScreenHeight() / 2 + 2, RED ); 

        // linha vertical
        drawLine( 400, 0, 400, 450, RED );
        drawLine( 401, 0, 401, 450, RED ); 
        
        // linha embaixo
        drawLine( 0, 448, 800, 448, RED ); 
        drawLine( 0, 449, 800, 449, RED ); 
        
        // Títulos
        drawText( "Selection Sort: ", 50, 20, 20, BLACK );
        drawText( "Insertion Sort:", 450, 20, 20, BLACK );
        drawText( "Bubble Sort:   ", 50, 250, 20, BLACK );
        drawText( "Merge Sort:   ", 450, 250, 20, BLACK );

    }
    
    private void copiarArray( List<int[]> lista, int[] array ) {
        int[] novoArray = new int[array.length];
        System.arraycopy( array, 0, novoArray, 0, array.length );
        lista.add( novoArray );
    }
    
    private void desenharArray( 
            int[] array,
            int x, 
            int y, 
            int largura, 
            int espacamento, 
            int tamanhoPedaco ) {
        
        for ( int i = 0; i < array.length; i++ ) {
            fillRectangle( 
                    x + i * ( largura + espacamento ), 
                    y - array[i] * tamanhoPedaco, 
                    largura, 
                    array[i] * tamanhoPedaco, 
                    BLACK
            );
        }
        
    }
    
    private void ordenarSelection( int[] array ) {
        
        for ( int i = 0; i < array.length - 1; i++ ) {
            int menor = i;
            for ( int j = i + 1; j < array.length; j++ ) {
                if ( array[j] < array[menor] ) {
                    menor = j;
                }
            }
            int t = array[i];
            array[i] = array[menor];
            array[menor] = t;
            copiarArray( lista, array );
        }
        
    }
    
        private void ordenarInsertion( int[] array ) {
        
        for ( int i = 0; i < array.length - 1; i++ ) {
            int menor = i;
            for ( int j = i + 1; j < array.length; j++ ) {
                if ( array[j] < array[menor] ) {
                    menor = j;
                }
            }
            int t = array[i];
            array[i] = array[menor];
            array[menor] = t;
            copiarArray( lista, array );
        }
        
    }
    
    
    public static void main( String[] args ) {
        new Main();
    }
    
}
