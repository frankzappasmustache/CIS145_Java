/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Lab 3
    File Name: LetterInventoryTest.java
    Author: Dustin McClure
    Lab: Letter Inventory
    Modified Date: 05/16/2022

    This test class implements a test of all of the built in functions of the phone book manager. It allows you to select
    an operation from the menu, complete that operation, and/or exit the program.
*/

import java.util.*;

public class LetterInventoryTest {

        public static void main(String[] args) {
            int n = 30;
            String testString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder s = new StringBuilder(n);

            for(int i = 0; i < n; i++) {
                int index = (int)(testString.length() * Math.random());
                s.append(testString.charAt(index));
            }
            String testInv = s.toString();
            System.out.println(testInv);

            LetterInventory testInventory = new LetterInventory(testInv);
            for(int i = 0; i <= n; i++) {
                int a = testInventory.get(testInv.charAt(i));
                System.out.println(a);
                testInventory.set(testInv.charAt(i), a);
                System.out.println(a);
            }

            int b = testInventory.size();
            System.out.println(b);

            int o = 30;
            String testString2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder t = new StringBuilder(o);

            for(int i = 0; i < o; i++) {
                int index2 = (int)(testString2.length() * Math.random());
                t.append(testString2.charAt(index2));
            }
            String testInv2 = t.toString();

            LetterInventory other = new LetterInventory(testInv2);

            LetterInventory otherOther = testInventory.add(other);

            System.out.println(otherOther.toString());

            LetterInventory otherOtherOther = testInventory.subtract(other);

            System.out.println(otherOtherOther.toString());
        }
    }
