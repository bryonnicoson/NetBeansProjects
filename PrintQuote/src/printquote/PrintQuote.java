/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printquote;

/**
 *
 * @author bryon
 */
public class PrintQuote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        
//        System.out.println("Java Rules!");
//        
//                System.out.println("5");
//        System.out.println("3 2\n-1 0 1");  
//        System.out.println("4 3\n-1 0 1 2");
//        System.out.println("5 3\n-1 0 0 2 3");
//        System.out.println("6 4\n-1 0 1 2 3 4");
//        System.out.println("7 5\n-1 0 0 0 0 4 5");
//        System.out.printf("%.3f", (10*9*8*7*6*5*4*3*2 / 8*7*6*5*4*3*2*2) * Math.pow(.12, 8) * Math.pow(.88, 2));

//        double n = 10;
//        double p = 0.88;
//        double q = 1 - p;

        // no more than 2: sum 8-10
        
        
        // at least 2: sum 0-8
        
        // b(x, n, p) = (n! / x!(n-x)!) * Math.pow(p, x) * Math.pow(q, n-x)
        // sample: 10 coin tosses - probability of 5 heads:
        
        int n = 10;
        double p = .12;
        double q = 1 - p;
        double prob1=0.0;
        double prob2=0.0;
        
        for (int x = 0; x < 3; x++){
            prob1 += factorial(n)/(factorial(x) * factorial(n-x)) * Math.pow(p, x) * Math.pow(q, n-x);
        }
        for (int x = 2; x < 10; x++){
            prob2 += factorial(n)/(factorial(x) * factorial(n-x)) * Math.pow(p, x) * Math.pow(q, n-x);
        }
        
        System.out.printf("%.3f\n%.3f\n", prob1, prob2);
        
        geometricDistribution();
    }
    private static double factorial(int n){
        double nFactorial = 1;
        for (int i = n; i > 0; i--) {
            nFactorial *= i;
        }
        return nFactorial;
    }
    
    private static void geometricDistribution(){
        double p = 1/3;
        double q = 1 - p;
        int n = 5;
        System.out.print(p);
        System.out.printf("%.3f\n", Math.pow(q, n-1) * p);
        System.out.printf("%.3f\n", Math.pow(.667, 4) * .333);
    }
    
    
}
