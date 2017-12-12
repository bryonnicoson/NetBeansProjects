package binarysearchtree;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bryon
 */
public class Testers {
    
    // random integers
    public static int rndInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max-min) + 1) + min;
    }
   
    // random binary search trees
    public static Tree rndTree(int count) {
        if (count == 0) {
            return new EmptyBST();
        } else {
            return rndTree(count -1).add(rndInt(0, 100));
        }
    }
    
    
    public static void checkIsEmpty(Tree t) throws Exception {
        // if the tree t is an instance of EmptyBST --> t.isEmpty --> true
        
        if (t instanceof EmptyBST) {
            if (!t.isEmpty()) {
                throw new Exception("Test failed: Tree is type EmptyBST and is not empty.");
                } 
        } //else if (t instanceof NonEmptyBST) {
          //  if (t.isEmpty()) {
          //      System.out.println("Test failed: Tree is type NonEmptyBST and is empty.");
          //  }
        //}
    }
    
    public static void checkAddMemberCardinality(Tree t, int x) throws Exception {
        int nT = t.add(x).cardinality();
        // something added, cardinality +1
        if (nT == (t.cardinality() + 1)) {
            if (t.member(x)) {
                throw new Exception("Cardinality increased, but x was already a member");
            } //else {
              //  System.out.println("All is good.  Cardinality increased with addition of new element");
            //}
        // x not added b/c already member - cardinality same    
        } else if (nT == t.cardinality()) {
            if (!t.member(x)) {
                throw new Exception("Cardinality did not increase, but new element added");
            } //else {
              //  System.out.println("All is good.  Cardinality did not increase with attempt to add existing element");
           // }
                        
        } else {
            throw new Exception("Something is wrong.");
        }
    }
    
}