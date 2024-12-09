/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da fila de prioridades que utiliza um heap ternário máximo.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TernaryMaxPriorityQueueTest {

    @Test
    public void test10Keys() {
        
        System.out.println( "test 10 keys" );
        
        TernaryMaxPriorityQueue<Integer> tpq = new TernaryMaxPriorityQueue<>();
        List<Integer> values = new ArrayList<>();
        List<Integer> removedValues = new ArrayList<>();
        
        values.add( 4 );
        values.add( 8 );
        values.add( 9 );
        values.add( 49 );
        values.add( 21 );
        values.add( 1 );
        values.add( 2 );
        values.add( 7 );
        values.add( 8 );
        values.add( 21 );
        
        for ( int i : values ) {
            tpq.insert( i );
        }
        
        while ( !tpq.isEmpty() ) {
            removedValues.add( tpq.delete() );
        }
        
        Collections.sort( values );
        Collections.reverse( values );
        
        assertEquals( values, removedValues );
        
    }
    
    @Test
    public void test100RandomKeys() {
        
        System.out.println( "test 100 random keys" );
        
        TernaryMaxPriorityQueue<Integer> tpq = new TernaryMaxPriorityQueue<>();
        List<Integer> values = new ArrayList<>();
        List<Integer> removedValues = new ArrayList<>();
        
        for ( int i = 0; i < 100; i++ ) {
            values.add( (int) ( Math.random() * 1000 ) + 1 );
        }
        
        for ( int i : values ) {
            tpq.insert( i );
        }
        
        while ( !tpq.isEmpty() ) {
            removedValues.add( tpq.delete() );
        }
        
        Collections.sort( values );
        Collections.reverse( values );
        
        assertEquals( values, removedValues );
        
    }
    
}
