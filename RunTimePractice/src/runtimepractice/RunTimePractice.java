/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimepractice;

import java.util.HashMap;

/**
 *
 * @author bryon
 */
public class RunTimePractice {
    
    public static int findNumsOfRepetitions(String s, char c) {
        // Linear time: O(n) time
        int sum = 0;                                // 1
        for (int i = 0; i < s.length(); i++) {      // 1, n + 1, n
            if (s.charAt(i) == c) {                 // n
                sum++;                              // n
            }
        }
        return sum;                                 // 1
    }
    
    public static int[] findNumsOfRepetitionsv1(String s, char[] c) {
        // Quadratic time: O(n * m) time
        int[] sums = new int[c.length];             // 1
        for (int i = 0; i < s.length(); i++) {      // 1, n + 1, n
            for (int j = 0; j < c.length; j++) {    // n, n*m + 1, n*m
                if (s.charAt(i) == c[j]) {          // n*m
                    sums[j] = sums[j] + 1;          // n*m
                }
            }
        }
        return sums;                                // 1
    }
    
    public static int[] findNumsOfRepetitionsv2(String s, char[] c) {
        // Optimal time: O(n+m)  (Linear)
        int[] sums = new int[c.length];                     // 1
        HashMap<Character, Integer> map = new HashMap<>();  // 1
        for (int i = 0; i < s.length(); i++) {              // 1, n+1, n
            if (!map.containsKey(s.charAt(i))) {            // n
                map.put(s.charAt(i), 1);                    // n
            } else {
                int sum = map.get(s.charAt(i));
                map.put(s.charAt(i), sum+1);
            }
        }
        for (int j = 0; j < c.length; j++) {
            int sum;
            if(!map.containsKey(c[j])) {
                sums[j] = 0;
            } else {
                sums[j] = map.get(c[j]);
            }
        }
        return sums;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       long startTime = System.currentTimeMillis();
       System.out.println(findNumsOfRepetitions("abcdefghijklmnopqrstuvwxyza", 'a'));    
       long endTime = System.currentTimeMillis();
       long duration = endTime - startTime;
       System.out.println("Test 1: " + duration + " ms");
       
       char[] a = {'a', 'b'};
       
       startTime = System.currentTimeMillis();
       System.out.println(findNumsOfRepetitionsv1("ababcdefghijklmnopqrstuvwxyzaabcdefghijklmnopqrstuvwxyzaabcdefghijklmnopqrstuvwxyzaabcdefghijklmnopqrstuvwxyzaabcdefghijklmnopqrstuvwxyzacdefghijklmnopqrstuvwxyza", a));    
       endTime = System.currentTimeMillis();
       duration = endTime - startTime;
       System.out.println("Test 2a: " + duration + " ms");
       
       startTime = System.currentTimeMillis();
       System.out.println(findNumsOfRepetitionsv2("ababcdefghijklmnopqrstuvwxyzaabcdefghijklmnopqrstuvwxyzaabcdefghijklmnopqrstuvwxyzaabcdefghijklmnopqrstuvwxyzaabcdefghijklmnopqrstuvwxyzacdefghijklmnopqrstuvwxyza", a));
       endTime = System.currentTimeMillis();
       duration = endTime - startTime;
       System.out.println("Test 2b: " + duration + " ms");
       
    }
    
}
