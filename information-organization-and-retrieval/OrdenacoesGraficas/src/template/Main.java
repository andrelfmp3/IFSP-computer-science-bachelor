package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.util.ArrayList;
import java.util.List;

public class Main extends EngineFrame {
    
    // arrays e listas
    private int[] array;
    private List<int[]> lista;
    
    private int[] array2;
    private List<int[]> lista2;
    
    private int[] array3;
    private List<int[]> lista3;
    
    private int[] array4;
    private List<int[]> lista4;
    
    // contador de posicões (?)
    private int pos; 
    private int pos2; 
    private int pos3; 
    private int pos4; 
    
    private double tempoParaMudar;
    private double contadorTempo;
    
    public Main() {
        super ( 800, 450, "Ordenações - André L. F", 60, true );
    }
    
    @Override
    public void create() {
        
        array = new int[]{ 9, 10, 5, 6, 3, 1, 2, 8 };
        lista = new ArrayList<>();
        
        array2 = new int[]{ 9, 10, 5, 6, 3, 1, 2, 8 };
        lista2 = new ArrayList<>();
        
        
        array3 = new int[]{ 9, 10, 5, 6, 3, 1, 2, 8 };
        lista3 = new ArrayList<>();
        
        array4 = new int[]{ 9, 10, 5, 6, 3, 1, 2, 8 };
        lista4 = new ArrayList<>();
        
        tempoParaMudar = 0.5;
        
        /*
        copiarArray( lista, array );
        copiarArray( lista2, array2 );
        copiarArray( lista3, array3 );
        copiarArray( lista4, array4 );
        */
        
        ordenarSelection( array );
        ordenarInsertion( array2 );
        ordenarBubble( array3 );        
        ordenarMerge( array4, 0, array4.length - 1);
    }

    @Override
    public void update( double delta ) {
        
        contadorTempo += delta;
        
        if ( contadorTempo > tempoParaMudar ) {
            contadorTempo = 0;
            if ( pos < lista.size() - 1 ) {
                pos++;
            }
            if ( pos2 < lista2.size() - 1 ) {
                pos2++;
            }
            if ( pos3 < lista3.size() - 1 ) {
                pos3++;
            }
            if ( pos4 < lista4.size() - 1 ) {
                pos4++;
            }
        }
        
        
    }

    @Override
    public void draw() {
        
        clearBackground( GRAY );
        desenharArray( lista.get( pos ), 10 , getScreenHeight() / 2, 30, 10, 10 ); // Selection
        desenharArray( lista2.get( pos2 ), 410, getScreenHeight() / 2, 30, 10, 10 ); // Insertion
        desenharArray( lista3.get( pos3 ), 10 , (getScreenHeight() / 2) + 220, 30, 10, 10 ); // Bubble
        desenharArray( lista4.get( pos4 ), 410, (getScreenHeight() / 2) + 220, 30, 10, 10 ); // Merge
        
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
        drawText( "Selection Sort:  ",050, 020, 020, BLACK );
        drawText( "Insertion Sort: ", 450, 020, 020, BLACK );
        drawText( "Bubble Sort:    ", 050, 250, 020, BLACK );
        drawText( "Merge Sort:    " , 450, 250, 020, BLACK );

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
            if (array[i] == 1){
                fillRectangle( 
                        x + i * ( largura + espacamento ), 
                        y - array[i] * tamanhoPedaco, 
                        largura, 
                        array[i] * tamanhoPedaco, 
                        RED
                );
            } else {
                fillRectangle( 
                        x + i * ( largura + espacamento ), 
                        y - array[i] * tamanhoPedaco, 
                        largura, 
                        array[i] * tamanhoPedaco, 
                        BLACK
                );
            }
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
    
    private void ordenarInsertion(int[] array) { // https://github.com/davidbuzatto/AlgoritmosEstruturasDeDados/blob/master/src/aesd/sorting/generic/InsertionSort.java
        
        int n = array.length;
        
        int i;
        int j;
        
        for (i = 1; i < n; i++) {

            j = i;

            while (j > 0 && array[j] < array[j - 1]) { // equivalente a compareTo (vai comparando)
                //  SortingUtils.swap adaptado. troca os elementos adjacentes
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                copiarArray(lista2, array);
                j--; // j vai para a esquerda. 
            }

        }
    }
    
    private void ordenarBubble(int[] array) { // https://github.com/davidbuzatto/AlgoritmosEstruturasDeDados/blob/master/src/aesd/sorting/generic/InsertionSort.java
        
        int n = array.length;
        boolean swapped;
        int i = 0;
        int j;

        do {
            swapped = false;

            for (j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) { // equivalente a compareTo (vai comparando)

                    //  SortingUtils.swap adaptado. troca os elementos adjacentes
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                    copiarArray(lista3, array);  
                }
            }

            i++; 
            
        } while (swapped && i < n); 
    }

        
  
    public void ordenarMerge(int[] array, int start, int end) { // left, right, middle. C adaptado (rever). TOP DOWN
                                                                // sem tempMS            
        
        if (start >= end) { // condição diferente
            return;
        } else {

            int middle = (start + end) / 2;
            ordenarMerge(array, start, middle);
            ordenarMerge(array, middle + 1, end);

            merge(array, start, middle, end);
            
            copiarArray(lista4, array);
        }

    }

    public void merge(int[] array, int start, int middle, int end) { // método auxiliar mergesort. combina metades do array ordenado
                                                                     // sem temp           
        int[] helper = new int[array.length];
        for (int i = start; i <= end; i++) {
            helper[i] = array[i];
        }

        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {

            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;

        }

        while (i <= middle) {
            array[k] = helper[i];
            i++;
            k++;
        }
    }
    
    
    public static void main( String[] args ) {
        new Main();
    }
    
}
