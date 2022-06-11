/*
    Author: Dustin McClure
    Project Name: Labs
    Sub-project: Lab 6
    File Name: QuestionTree.java
    Lab: 20 Questions
    Modified Date: 06/10/2022

    This class includes logic and data members to play a game of 20 questions.
*/
import java.io.*;
import java.util.*;

public class QuestionTree {
    private QuestionNode base;
    private int totalGames;
    private int wonGames;
    private final UserInterface gui;

    // Method to initialize a Tree of Questions
    public QuestionTree (UserInterface gui) {
        if (gui != null) {
            this.totalGames = 0;
            this.wonGames = 0;
            this.gui = gui;
            this.base = new QuestionNode("microphone");
        } else throw new IllegalArgumentException();

    }

    // Method to play a game of 20 questions
    public void play() {
        base = play(base);
        totalGames += 1; // increment totalGames each time play is called
    }

    // Method checks if the current Question Node is null, if not it asks a question for clarification or makes a guess
    // about what the object is.
    private QuestionNode play(QuestionNode present) {
        if (present == null) {
            throw new IllegalArgumentException();
        }

        if (!correct(present)) {
            gui.print(present.nData);
            if (gui.nextBoolean()) {
                present.yes = play(present.yes);
            } else {
                present.no = play(present.no);
            }
        } else {
            gui.print("Would your object happen to be " + present.nData + "?");
            if (gui.nextBoolean()) {
                gui.println("I win!");
                wonGames += 1;
            } else {
                present = youLose(present);
            }
        }

        return present;
    }

    // Method saves the Question Tree to a file
    public void save (PrintStream output) {
        assert output != null;
        save(output, base);
    }

    // Method that provides formatting for the file that question tree is saved to
    private void save(PrintStream output, QuestionNode present) {
        assert present != null;

        if(!correct(present)) {
            output.println("Q: " + present.nData);
            save(output, present.yes);
            save(output, present.no);
        } else {
            output.println("A: " + present.nData);
        }
    }

    // Method to replace current tree by reading in tree from a specified file
    public void load(Scanner console) {
        assert console != null;
        base = construct(console);
    }

    // Method to return a new Question Node with the Questions and Answers given
    private QuestionNode construct(Scanner input) {
        QuestionNode thisNode = null;
        if(input.hasNextLine()) {
            String[] thisDat = "[:]".split(input.nextLine());
            thisNode = thisDat[0].equals("Q") ? new QuestionNode((construct(input)), construct(input), thisDat[1].trim()) : new QuestionNode(thisDat[1].trim());
        }
        return thisNode;
    }

    // Method to return total games
    public int totalGames() {
        return totalGames;
    }

    // Method to return total games won
    public int gamesWon() {
        return wonGames;
    }

    // Method that determines if a node is null or an answer and if it is an answer returns that node
    private boolean correct(QuestionNode qNode) {
        assert qNode != null;
        return (qNode.no == null && qNode.yes == null);
    }

    // Method that is called when the computer loses. It stores the correct answer in a new question node, asks
    // for a distinguishing question about the correct object, and asks for an answer to that question. These are all
    // stored in the newly generated question tree.
    private QuestionNode youLose(QuestionNode incorrect) {
        gui.print("I lose. What is your object? ");
        QuestionNode right = new QuestionNode(gui.nextLine().trim());
        gui.print("Type a yes/no question to distinguish your item from " + incorrect.nData + ": ");
        String inquiry = gui.nextLine().trim();
        gui.print("And what is the answer for your object? ");
        return gui.nextBoolean() ? new QuestionNode(right, incorrect, inquiry) : new QuestionNode(incorrect, right, inquiry);
    }
}
