/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeapplication;

import java.util.Scanner;

/**
 *
 * @author bryon
 */
public class TicTacToeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean doYouWantToPlay = true;
        
        while (doYouWantToPlay) {
            System.out.println("Welcome to Tic Tac Toe!  You are about to play "
                + "a weak AI that picks randomly.  Pick the characters we will use.");
            System.out.println("\nEnter a single character for you: ");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single character for AI: ");
            char aiToken = sc.next().charAt(0);
            
            TicTacToe game = new TicTacToe(playerToken, aiToken);
            AI ai = new AI();
            
          
            System.out.println("\nEnter a number corresponding to your move.\n");
            TicTacToe.printIndexBoard();
            System.out.println();
            
            while (game.gameOver().equals("notOver")) {
                if (game.currentMarker == game.userMarker) {
                    // user turn
                    System.out.println("It's your turn. Enter a number: ");
                    int spot = sc.nextInt();
                    while(!game.playTurn(spot)){
                        System.out.println("Try again. " + spot + " is taken or invalid.");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                } else {
                    // ai turn
                    System.out.println("It's my turn!");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + "!");
                }
                // display board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            System.out.println("Do you want ot play again? [Y/N] ");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'Y');
            
        }
    }
    
}
