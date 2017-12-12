/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanapplication;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bryon
 */
public class HangManApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hangman.\nI will choose a word.\nYou get "
                + " six turns to guess a letter to solve the word.");
        System.out.println("\n\nI have chosen a word.");
        
        boolean youWantToPlay = true;
        while (youWantToPlay) {
            
            Hangman game = new Hangman();
            
            do {
                // draw ui
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                // debug System.out.println(game.mysteryWord);
            
                // get guess
                System.out.println("Enter a letter: ");
                char guess = (sc.next().toLowerCase().charAt(0));
                System.out.println();
                
                // check if guess is new
                while (game.isGuessedAlready(guess)) {
                    System.out.println("Already guessed.  Guess again.");
                    guess = (sc.next().toLowerCase().charAt(0));
                }
                
                if (game.playGuess(guess)) {
                    System.out.println("Good guess. 8D" );
                } else {
                    System.out.println("Sorry. :( ");
                }
            }
            while(!game.gameOver());
                
            System.out.println();
            System.out.println("Do you want to play again? [Y/N]");
            Character response = (sc.next().toUpperCase().charAt(0));
            youWantToPlay = (response == 'Y');
        }
    }
    
}
