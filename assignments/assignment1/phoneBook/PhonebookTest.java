/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Assignment 1
    File Name: PhonebookTest.java
    Author: Dustin McClure
    Lab: Phone Book
    Modified Date: 05/14/2022

    This test class implements a test of all of the built in functions of the phone book manager. It allows you to select
    an operation from the menu, complete that operation, and/or exit the program.
*/

import java.lang.reflect.InvocationTargetException;
import java.util.*;

// begin class PhonebookTest
public class PhonebookTest {

    // begin method main
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        PhonebookManager manager = new PhonebookManager();
        Scanner input = new Scanner(System.in);
        int instructions = manager.printInstructions(input);

        // while loop that goes through instructions until user selects option 5, which is exit
        while(instructions != 5) {
            switch (instructions) { // take int instructinos as an argument for case
                case 1:
                    /*
                    The commented section below is for entering in your contact information manually. For the
                    purposes of testing manager.addEntry is called with prefilled contact information.

                    input.nextLine();
                    System.out.println("Please enter first name: ");
                    String fName;
                    fName = input.nextLine();

                    System.out.println("Please enter last name: ");
                    String lName;
                    lName = input.nextLine();

                    System.out.println("Please enter street address: ");
                    String addr;
                    addr = input.nextLine();

                    System.out.println("Please enter city: ");
                    String city = "";
                    city = input.nextLine();

                    System.out.println("Please enter state(FORMAT XX): ");
                    String state = input.next();

                    System.out.println("Please enter 5 digit zip: ");
                    String zip = input.next();

                    System.out.println("Please enter phone number(FORMAT xxx-xxx-xxxx): ");
                    String phone = input.next();

                    manager.addEntry(lName, fName, addr, city, state, zip, phone);
                    */

                    manager.addEntry("McClure", "Dustin", "113 Test Street", "Testville", "WA", "98226", "444-444-4444");
                    manager.addEntry("Strickland", "Kristen", "114 Test Street", "Testville", "WA", "98226", "555-555-5555");
                    manager.addEntry("Doe", "John", "115 Test Street", "Testville", "WA", "98226", "666-666-6666");
                    manager.addEntry("Doe", "Jane", "116 Test Street", "Testville", "WA", "98226", "777-777-7777");

                    System.out.println("This contact has been added to the phonebook.");
                    break;
                case 2:
                    manager.printBook(); // print out current phone book linkedlist
                    break;
                case 3:
                    System.out.println("Choose what you would like to edit below: ");
                    manager.changeEntry(); // edit any data fields of an entry based on last name
                    manager.printBook(); // print newly edited phone book
                    break;
                case 4:
                    System.out.println("Please enter the last name of the contact you would like to delete: ");
                    String last = input.next();
                    manager.deleteEntry(last); // pass last name to deleteEntry method to delete node at indexOf last name
                    System.out.println("This entry has been deleted from your contacts");
                    System.out.println("Below is your updated list of contacts");
                    manager.printBook(); // print new iteration of phone book without entry
                    break;
                case 5:
                    instructions = 5; // exit program
            }
            instructions = manager.printInstructions(input);
        }
    }
} // end method main
