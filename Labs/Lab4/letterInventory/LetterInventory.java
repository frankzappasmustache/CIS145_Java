/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Lab 3
    File Name: LetterInventory.java
    Author: Dustin McClure
    Lab: Letter Inventory
    Modified Date: 05/16/2022

    This defines the letter Inventory class that can be used to keep track of an
    inventory of letters of the alphabet.
*/

import java.util.*;

public class LetterInventory {
    private int size;
    private char letter;
    public static final int ALPHA_LETTERS = 26;
    private LetterInventory thisInventory;
    int[] count = new int[ALPHA_LETTERS];

    public LetterInventory(String data) {
        data = data.toLowerCase();
        for(int i = 0; i < data.length(); i++) {
            if (isEmpty()) {
                System.out.println("Your inventory is empty");
            } else {
                char letter = data.charAt(i);
                count[letter - 'a']++;
            }
            size = data.length();
        }
    }

    public int get(char letter) throws IllegalArgumentException {
        if(letter < 'a' || letter > 'z') {
            throw new IllegalArgumentException("The value must be a letter");
        } else {
            return count[letter - 'a'];
        }
    }

    public void set(char letter, int value) throws IllegalArgumentException {
        if(letter < 'a' || letter > 'z') {
            throw new IllegalArgumentException("The value must be a letter");
        } else {
            letter = Character.toLowerCase(letter);
            size = size - count[letter - 'a'];
            size += value;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder product = new StringBuilder();
        for(int i = 0; i < ALPHA_LETTERS; i++) {
            product.append(String.valueOf((char) ('a' + i)).repeat(Math.max(0, count[i])));
        }
        return "[" + product + "]";
    }

    public LetterInventory add(LetterInventory other) {
        thisInventory = new LetterInventory("");
        for(int i = 0; i < ALPHA_LETTERS; i++) {
            letter = (char) ('a' + i);
            thisInventory.set(letter, count[i] + other.get(letter));
        }
        return thisInventory;
    }

    public LetterInventory subtract(LetterInventory other) {
        thisInventory = new LetterInventory("");
        for(int i = 0; i < ALPHA_LETTERS; i++) {
            letter = (char) ('a' + i);
            if (count[i] - other.get(letter) < 0) {
                return null;
            } else {
                thisInventory.set(letter, count[i] - other.get(letter));
            }
        }
        return thisInventory;
    }
}
