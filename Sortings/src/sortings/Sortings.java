/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

/**
 *
 * @author bryon
 */
public class Sortings {
    public static int[] ar = {1, 0, -1, 315, 42, -42, 6, 7, 19, 1024, 5, 308056, 1, 2, 56789};

    public static void main(String[] args) {
        bubbleSort(ar);
        printSorted(ar);
    }
    
    // O(n2) bubbleSort "bubbles" the biggest value to the top via iterative comparison of adjacent elements
    private static void bubbleSort(int ar[]){
        for (int i = (ar.length -1); i >= 0; i--){      // the following will be done array.length times 
            for (int j = 1; j <= i; j++) {              // compare j to j-1  
                if (ar[j-1] > ar [j])                   // if the guy to my left is bigger than me, 
                {
                    int temp = ar[j-1];                 // we need to swap spots
                    ar[j-1] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }
    
    private static void selectionSort(int ar[]){
        
    }
    
    public static void printSorted(int ar[]){
        for (int i = 0; i < (ar.length -1); i++){
            System.out.printf("%d", ar[i]);
            if (i < (ar.length -2))
                System.out.printf(", ");
        }
        System.out.println(); 
    }      
}
