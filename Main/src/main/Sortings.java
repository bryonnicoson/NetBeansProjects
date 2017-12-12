/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author bryon
 */
public class Sortings {
    
    int[] ar = {1, 0, -1, 315, 42, -42, 6, 7, 19, 1024, 5, 308056, 1, 2, 56789};
    
    public void main(String[] args){
        bubbleSort(ar);
        printSorted(ar);
    }
    
    
    
    // O(n2)
    void bubbleSort(int ar[]){
        for (int i = (ar.length -1); i >= 0; i--){
            for (int j = 1; j <= i; j++) {
                if (ar[j-1] > ar [j])
                {
                    int temp = ar[j-1];
                    ar[j-1] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }
    
    void printSorted(int ar[]){
        for (int i = 0; i < (ar.length -1); i++){
            System.out.printf("%d, ", ar[i]);
        }
        System.out.println();
        
    }  
}
