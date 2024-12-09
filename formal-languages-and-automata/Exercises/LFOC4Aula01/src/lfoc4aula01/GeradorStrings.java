package lfoc4aula01;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections; // usar para exercicio
import java.util.List;

/**
 * Métodos para geração de strings de alfabetos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class GeradorStrings {

    public static void main( String[] args ) {
        
        System.setOut( new PrintStream( new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8 ) );
        System.setErr( new PrintStream( new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8 ) );
        
        int k = 3;
        char[] a = { '0', '1', };  
        testeGerarStringsK( k, a );
        testeGerarStringsAteK( k, a );
        
    }
    
    public static List<String> gerarStringsK(int k, char... a) throws IllegalArgumentException {
        
        if (k < 0) {
            throw new IllegalArgumentException("comprimento negativo");
        }
        
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("alfabeto vazio");
        }
        
       
       
        List<String> s = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        
        if (k == 0){
            s.add("");
            return s;
        }
        
        for (int i = 0; i < a.length; i++) {  // Inicializa a lista temp com caracteres do alfabeto. No ex, roda 2x
            temp.add(Character.toString(a[i]));
        }

        for (int i = 1; i < k; i++) { // Roda k-1 vezes (começa em zero).  Construir strings de comprimento k
            List<String> newTemp = new ArrayList<>(); // não perder informação
            for (int j = 0; j < a.length; j++) { // roda duas vezes, nesse alfabeto
                for (int l = 0; l < temp.size(); l++) {
                    newTemp.add(a[j] + temp.get(l));  // Adiciona o caractere no início da string
                }
            }
            temp = newTemp;
        }

        s.addAll(temp);

        return s;
    }
    
    public static List<String> gerarStringsAteK( int k, char... a ) throws IllegalArgumentException {
        
        if ( k < 0 ) {
            throw new IllegalArgumentException( "comprimento negativo" );
        }
        
        if ( a == null || a.length == 0 ) {
            throw new IllegalArgumentException( "alfabeto vazio" );
        }
        
        List<String> s = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        List<String> retornak = new ArrayList<>();
        
        s.add("");
        
        retornak.add("ε");
        
        for (int i = 0; i < a.length; i++) {  // Inicializa a lista temp com caracteres do alfabeto. No ex, roda 2x
            temp.add(Character.toString(a[i]));
        }
        retornak = temp;
        

        for (int i = 1; i < k; i++) { // Roda k-1 vezes (começa em zero).  Construir strings de comprimento k
            List<String> newTemp = new ArrayList<>(); // não perder informação
            for (int j = 0; j < a.length; j++) { // roda duas vezes, nesse alfabeto
                for (int l = 0; l < temp.size(); l++) {
                    newTemp.add(a[j] + temp.get(l));  // Adiciona o caractere no início da string
                }
            }
            retornak.addAll(newTemp);
            temp = newTemp;
        }

        s.addAll(retornak);
        
        return s;
        
    }

    private static void testeGerarStringsK( int k, char... a ) throws IllegalArgumentException {
        
        for ( int i = 0; i <= k; i++ ) {
            
            if ( i == 0 ) {
                System.out.println( "\u03A3^0 = {\u03B5}" ); // para i == 0. primeira 
            } else {
                
                System.out.printf( "\u03A3^%d = {", i );
                boolean primeiro = true;

                for ( String s : gerarStringsK( i, a ) ) {
                    if ( !primeiro ) {
                        System.out.print( ", " );
                    }
                    System.out.print( s );
                    primeiro = false;
                }

                System.out.print( "}" );
                System.out.println();
                
            }
            
        }
        
    }
    
    private static void testeGerarStringsAteK( int k, char... a ) throws IllegalArgumentException {
        
        System.out.print( "\u03A3*  = {\u03B5, " );

        for ( String s : gerarStringsAteK( k, a ) ) {
            System.out.print( s );
            System.out.print( ", " );
        }

        System.out.print( "...}" );
        System.out.println();
        
    }
    
}