/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author bryon
 */
public class EmptyBST<D extends Comparable> implements Tree<D>{
    
    public EmptyBST() {
        
    }
    
    public boolean isEmpty() {
        return true;
    }
    
    public int cardinality() {
        return 0;
    }
    
    public boolean member(D elt) {
        return false;
    }
    
    public NonEmptyBST<D> add(D elt) {
        return new NonEmptyBST<D>(elt);
    }
}
