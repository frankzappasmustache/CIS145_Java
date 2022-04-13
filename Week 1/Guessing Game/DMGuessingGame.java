/*
    Copyright 2021 <Dustin McClure>
    Project Name: CS140_Java
    Sub-project: Lab 4
    File Name: DMGuessingGame.java
    Author: Dustin McClure
    Lab: Guessing Game
    Modified Date: 05/21/2021

    A program that generates a random number, asks the user to guess what that number is
    between 1 and 100, tells them whether their guess is higher or lower than the correct
    number, and then alerts them when they guess the correct number.

    The program then tells them how many guesses it took to get the right answer, and tabulates results.

    NOTE: I did not get the results to tabulate correctly before turning this in
*/
import java.util.*;

// Begin Class DMGuessing Game
public class DMGuessingGame
{
    // Method main begins execution
    public static void main(String[] args)
    {
        // call instructions method to read instructions
        instructions();
        // create string onceMore outside of do/while so it is recognized by while
        String onceMore;
        do {
            int lowestGuess = 9999; // declare int lowestGuess
            int sum = 0; // declare int sum
            int guessCount = playGame(); // declare int guesscount equal to playGame which returns guesses
            int gameCount = 1; // declare int gamecount
            onceMore = playAgain(); // assign new value to onceMore that initiates playAgain method

            // check to see if play var returned from playAgain is a yes, if so increment gamecount and
            // add guessCount to total sum of guesses
            if(onceMore.equalsIgnoreCase("y")) {
                gameCount++;
                sum += guessCount;
                
                continue; // continue to next iteration of loop
            } else {
                results(sum, gameCount); // calculate results if playGame returns no
                int best = bestGame(sum, lowestGuess); // calculate best game
                System.out.println("Your best game was " + best + " guesses."); // print results from best game
                
                break; // break out of while loop and transfer exectution back to method main
            }
        } while(onceMore.equalsIgnoreCase("y"));
    } // end method main

    // begin method instructions which prints instructions
    public static void instructions()
    {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and 100, and I ");
        System.out.println("will allow you to guess until you get it.");
        System.out.println("For each guess, I will tell you whether the right answer");
        System.out.println("is higher or lower than your guess.");
        System.out.println();
    } // end method instructions

    // method playGame controls the logic of the game
    public static int playGame()
    {
        final int MAX_NUMBER = 100; // declare local constant for maximum number
        Random randNum = new Random(); //create object to generate new random
        int correctAnswer = randNum.nextInt(100) + 1; // generate new random number between 1-100 and assign to int
        int guesses = 0; // declare guesses int
        int guess; // declare guess int
        Scanner input = new Scanner(System.in); // create scanner to capture user input

        // do/while loop that prompts user to enter a random number and then compares
        // it to the random number generated to tell the user if their guess is higher or lower
        // until they guess the correct number
        do {
            System.out.println("Please enter a number between 1-100: ");
            guess = input.nextInt();
            if(guess > correctAnswer) {
                System.out.println("This number is too high");
                guesses++;
            } else if(guess < correctAnswer) {
                System.out.println("This number is too low");
                guesses++;
            }
        } while(guess != correctAnswer);

        System.out.println("The number " + guess + " is the correct number!!"); // lets user know they guessed correctly
        guesses++; // increments guesses by 1 to account for correct answer guess
        System.out.println("You got the answer in " + guesses + " attempts"); // tells number of attempts

        return guesses; // returns total number of guesses in game
    } // end method playGame

    // Begin method playAgain
    public static String playAgain()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play this game?");
        String play = input.next();
        return play;
    } // end method playAgain

    // begin method bestgame
    public static int bestGame(int guessCount, int lowestGuess)
    {
        if(guessCount < lowestGuess) {
            return guessCount;
        } else {
            return lowestGuess;
        }
    } // end method bestGame

    // begin method results
    public static void results(int guesses, int gameCount)
    {
        int guessAverage = guesses / gameCount;
        
        System.out.println("Total Games: " + gameCount);
        System.out.println("Total Guesses: " + guesses);
        System.out.println("Average Guesses: " + guessAverage);
    } // end method results
}
