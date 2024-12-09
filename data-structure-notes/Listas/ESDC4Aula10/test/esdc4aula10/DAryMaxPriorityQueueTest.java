/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula10;

import aesd.ds.implementations.nonlinear.pq.MaxPriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da fila de prioridades que utiliza um heap d-ário máximo.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class DAryMaxPriorityQueueTest {

    @Test
    public void test10KeysAgainstBinaryHeap() {
        
        System.out.println( "test 10 keys against binary heap" );
        
        DAryMaxPriorityQueue<Integer> dpq = new DAryMaxPriorityQueue<>();
        MaxPriorityQueue<Integer> bpq = new MaxPriorityQueue<>();
        
        List<Integer> values = new ArrayList<>();
        List<Integer> dAryRemovedValues = new ArrayList<>();
        List<Integer> bRemovedValues = new ArrayList<>();
        
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
            dpq.insert( i );
            bpq.insert( i );
        }
        
        while ( !dpq.isEmpty() ) {
            dAryRemovedValues.add( dpq.delete() );
        }
        
        while ( !bpq.isEmpty() ) {
            bRemovedValues.add( bpq.delete() );
        }
        
        assertEquals( dAryRemovedValues, bRemovedValues );
        
    }
    
    @Test
    public void test100RandomKeysAgainstBinaryHeap() {
        
        System.out.println( "test 100 random keys against binary heap" );
        
        DAryMaxPriorityQueue<Integer> dpq = new DAryMaxPriorityQueue<>();
        MaxPriorityQueue<Integer> bpq = new MaxPriorityQueue<>();
        
        List<Integer> values = new ArrayList<>();
        List<Integer> dAryRemovedValues = new ArrayList<>();
        List<Integer> bRemovedValues = new ArrayList<>();
        
        for ( int i = 0; i < 100; i++ ) {
            values.add( (int) ( Math.random() * 1000 ) + 1 );
        }
        
        for ( int i : values ) {
            dpq.insert( i );
            bpq.insert( i );
        }
        
        while ( !dpq.isEmpty() ) {
            dAryRemovedValues.add( dpq.delete() );
        }
        
        while ( !bpq.isEmpty() ) {
            bRemovedValues.add( bpq.delete() );
        }
        
        assertEquals( dAryRemovedValues, bRemovedValues );
        
    }
    
    @Test
    public void test10KeysAgainstTernaryHeap() {
        
        System.out.println( "test 10 keys against ternary heap" );
        
        DAryMaxPriorityQueue<Integer> dpq = new DAryMaxPriorityQueue<>( 3 );
        MaxPriorityQueue<Integer> bpq = new MaxPriorityQueue<>();
        
        List<Integer> values = new ArrayList<>();
        List<Integer> dAryRemovedValues = new ArrayList<>();
        List<Integer> bRemovedValues = new ArrayList<>();
        
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
            dpq.insert( i );
            bpq.insert( i );
        }
        
        while ( !dpq.isEmpty() ) {
            dAryRemovedValues.add( dpq.delete() );
        }
        
        while ( !bpq.isEmpty() ) {
            bRemovedValues.add( bpq.delete() );
        }
        
        assertEquals( dAryRemovedValues, bRemovedValues );
        
    }
    
    @Test
    public void test100RandomKeysAgainstTernaryHeap() {
        
        System.out.println( "test 100 random keys against ternary heap" );
        
        DAryMaxPriorityQueue<Integer> dpq = new DAryMaxPriorityQueue<>( 3 );
        MaxPriorityQueue<Integer> bpq = new MaxPriorityQueue<>();
        
        List<Integer> values = new ArrayList<>();
        List<Integer> dAryRemovedValues = new ArrayList<>();
        List<Integer> bRemovedValues = new ArrayList<>();
        
        for ( int i = 0; i < 100; i++ ) {
            values.add( (int) ( Math.random() * 1000 ) + 1 );
        }
        
        for ( int i : values ) {
            dpq.insert( i );
            bpq.insert( i );
        }
        
        while ( !dpq.isEmpty() ) {
            dAryRemovedValues.add( dpq.delete() );
        }
        
        while ( !bpq.isEmpty() ) {
            bRemovedValues.add( bpq.delete() );
        }
        
        assertEquals( dAryRemovedValues, bRemovedValues );
        
    }
    
    @Test
    public void test10KeysWith5AryHeap() {
        
        System.out.println( "test 10 keys with 5-ary heap" );
        
        DAryMaxPriorityQueue<Integer> dpq = new DAryMaxPriorityQueue<>( 5 );
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
            dpq.insert( i );
        }
        
        while ( !dpq.isEmpty() ) {
            removedValues.add( dpq.delete() );
        }
        
        Collections.sort( values );
        Collections.reverse( values );
        
        assertEquals( values, removedValues );
        
    }
    
    @Test
    public void test100RandomKeysWith5AryHeap() {
        
        System.out.println( "test 100 random keys with 5-ary heap" );
        
        DAryMaxPriorityQueue<Integer> dpq = new DAryMaxPriorityQueue<>( 5 );
        List<Integer> values = new ArrayList<>();
        List<Integer> removedValues = new ArrayList<>();
        
        for ( int i = 0; i < 100; i++ ) {
            values.add( (int) ( Math.random() * 1000 ) + 1 );
        }
        
        for ( int i : values ) {
            dpq.insert( i );
        }
        
        while ( !dpq.isEmpty() ) {
            removedValues.add( dpq.delete() );
        }
        
        Collections.sort( values );
        Collections.reverse( values );
        
        assertEquals( values, removedValues );
        
    }
    
    @Test
    public void test100RandomKeysWith10AryHeap() {
        
        System.out.println( "test 100 random keys with 10-ary heap" );
        
        DAryMaxPriorityQueue<Integer> dpq = new DAryMaxPriorityQueue<>( 10 );
        List<Integer> values = new ArrayList<>();
        List<Integer> removedValues = new ArrayList<>();
        
        for ( int i = 0; i < 100; i++ ) {
            values.add( (int) ( Math.random() * 1000 ) + 1 );
        }
        
        for ( int i : values ) {
            dpq.insert( i );
        }
        
        while ( !dpq.isEmpty() ) {
            removedValues.add( dpq.delete() );
        }
        
        Collections.sort( values );
        Collections.reverse( values );
        
        assertEquals( values, removedValues );
        
    }
    
}
