/*
    Author: Dustin McClure
    Project Name: Assignments
    Sub-project: Assignment 3
    File Name: Anagrams.java
    Assignment: Anagrams
    Modified Date: 06/12/2022

    This class includes logic and data members to find and print all anagram phrases that match a
    given word or phrase
*/
import java.util.*;

public class Anagrams {
    // Data members
    private Set<String> dict;
    private Set<String> result = new TreeSet<>();
    public Set<String> words = new TreeSet<>();

    // constructor
    public Anagrams(Set<String> wordBook) {
        assert wordBook != null;
        this.dict = wordBook;
    }

    // Method to return the words from the dictionary
    public Set<String> getWords(String expression) {
        assert expression != null;
        LetterInventory single = new LetterInventory(expression);
        for (String w : dict) {
            if (single.contains(w)) {
                words.add(w);
            }
        }
        return words;
    }

    // Method to print anagrams given letters in word or phrase
    public void print(String expression) {
        assert expression != null;
        LetterInventory catalog = new LetterInventory(expression);
        for (String a : getWords(catalog.toString())) {
            if (catalog.contains(a)) {
                result.add(a);
                if(catalog.isEmpty()){
                    System.out.print(result);
                    result.clear();
                } else {
                    print(catalog.toString(), 0);
                }
            }
        }
    }

    // Method to print anagrams up to max number of words
    public void print(String expression, int high) {
        assert expression != null;
        if (words.size() > 0 && high > 0) {
            String bracket = "["; // start of square bracket
            // Add the words
            for (String word : words) {
                result.add(word);
                bracket = new StringBuilder().append(bracket).append(result).append(", ").toString();
                result.clear();
            }
        } else{
            System.out.println(words);
        }
    }
}
