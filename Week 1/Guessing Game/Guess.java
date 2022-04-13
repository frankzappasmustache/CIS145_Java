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

public class Guess {
    // Method main begins execution
    public static void main(String[] args)
    {
        int lowestGuess = 9999; // declare int lowestGuess
        int sum = 0; // declare int sum
        int gameCount = 0; // declare int gamecount
        // call instructions method to read instructions
        instructions();
        System.out.println("Would you like to play this game?");

        Scanner input = new Scanner(System.in);
        // create string onceMore outside of do/while so it is recognized by while
        String onceMore = input.next(); // assign new value to onceMore that initiates playAgain method

        while(onceMore.equalsIgnoreCase("yes")) {

            // check to see if play var returned from playAgain is a yes, if so increment gamecount and
            // add guessCount to total sum of guesses;
            int guessCount = playGame(); // declare int guesscount equal to playGame which returns guesses
            if(guessCount < lowestGuess) {
                lowestGuess = guessCount;
            }
            sum+= guessCount;
            gameCount++;
            // continue;  // continue to next iteration of loop
            System.out.println("Would you like to play this game?");

            onceMore = input.next();
        }
        results(sum, gameCount, lowestGuess); // calculate results if playGame returns no
    }// end method main

    // begin method instructions which prints instructions
    public static void instructions()
    {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println("100, and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();
    } // end method instructions

    // method playGame controls the logic of the game
    public static int playGame()
    {
        final int MAX_NUMBER = 100; // declare local constant for maximum number
        Random randNum = new Random(); //create object to generate new random
        int correctAnswer = randNum.nextInt(MAX_NUMBER) + 1;  // generate new random number between 1-100 and assign to int
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

    // begin method results
    public static void results(int guesses, int gameCount, int lowestGuess)
    {
        double guessAverage = guesses / gameCount;

        System.out.println("Total Games: " + gameCount);
        System.out.println("Total Guesses: " + guesses);
        System.out.printf("Average Guesses: %.1f\n", guessAverage);
        System.out.println("Your best game was " + lowestGuess + " guesses."); // print results from best game
    } // end method results
}


