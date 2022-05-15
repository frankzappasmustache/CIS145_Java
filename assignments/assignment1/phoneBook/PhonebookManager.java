/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Assignment 1
    File Name: PhonebookManager.java
    Author: Dustin McClure
    Lab: Phone Book
    Modified Date: 05/14/2022

    This class provides management for the various operations for the phone book (add entry, print phonebook, delete
    entry, and change entry). It also includes the main menu and some helper methods that act in conjunction with the
    primary methods.
*/

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.*;
import java.lang.reflect.Method;

// begin class PhoneBookManager
public class PhonebookManager {
    public PBNode front; // Declare new object of type PBNode

    // Method that allows you to add a new entry to the current phonebook
    public void addEntry(String lName, String fName, String address, String city, String state, String zip, String phone) {
        if(front == null) {
            front = new PBNode(lName, fName, address, city, state, zip, phone, front);
        } else {
            PBNode newEntry = front;
            while(newEntry.next != null) {
                newEntry = newEntry.next;
            }
            newEntry.next = new PBNode(lName, fName, address, city, state, zip, phone, newEntry.next);
        }
    }

    // Method that allows you to print the current phone book in its entirety
    public void printBook() {
        String entry = this.toString();
        System.out.print(entry);
    }

    // Method that looks up a list node by last name and then deletes that list node along with its associated elements
    public void deleteEntry(String last) {
        if(front.lName.equalsIgnoreCase(last)) { // compare last name to first element lName in front
            front = front.next;
        } else {
            int b = indexOf(last); // set b equal to the indexOf the node that begins with last name
            PBNode current = nodeAt(b -1); // create new PBNode equal to node before indexOf node
            current.next = current.next.next; // set current.next equal to current.next.next to unlink node
        }
    }

    // Method that allows you to change any of the data fields associated with an entry
    public void changeEntry() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the last name of the person whose information you would like to edit: ");
        String edit = input.nextLine();

        int a = indexOf(edit);

        System.out.println("1 - Last Name\n2 - First Name\n3 - Address\n4 - City\n5 - State\n6 - ZIP\n7 - Phone\n8 - Save Contact");
        int choice = input.nextInt();

        // while loop that goes through edit options until user selects option 8, which is save
        while(choice != 8) {
            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.println("Please enter a new last name: ");
                    String newLast = input.nextLine(); // store new last name in string
                    String l = "setlName"; // store mutator method name in string
                    setNode(a, l, newLast); // call setNode to invoke mutator on element in node at indexOf last name
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Please enter a new first name: ");
                    String newFirst = input.nextLine();
                    String f = "setfName";
                    setNode(a, f, newFirst);
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Please enter a new address: ");
                    String newAddr = input.nextLine();
                    String ad = "setAddress";
                    setNode(a, ad, newAddr);
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Please enter a new city: ");
                    String newCity = input.nextLine();
                    String c = "setCity";
                    setNode(a, c, newCity);
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("Please enter a new state: ");
                    String newState = input.nextLine();
                    String s = "setState";
                    setNode(a, s, newState);
                    break;
                case 6:
                    input.nextLine();
                    System.out.println("Please enter a new zip code: ");
                    String newZip = input.nextLine();
                    String z = "setZip";
                    setNode(a, z, newZip);
                    break;
                case 7:
                    input.nextLine();
                    System.out.println("Please enter a new phone number: ");
                    String newPhone = input.nextLine();
                    String p = "setPhone";
                    setNode(a, p, newPhone);
                    break;
                case 8:
                    choice = 8; // exit change entry method and transfer execution back to calling method
            }
            System.out.println("1 - Last Name\n2 - First Name\n3 - Address\n4 - City\n5 - State\n6 - ZIP\n7 - Phone\n8 - Save Contact");
            choice = input.nextInt();
        }
    }

    // unemplemented method to sort entries alphabetically by last name
    public void sortEntries() {

    }

    // unemplemented method to move an entry
    public void moveEntry() {

    }

    // Method to print the menu options for the phone book program
    public int printInstructions(Scanner input) {
        int menu = 0;

        System.out.println("Press \"1\" to add a new contact");
        System.out.println("Press \"2\" to view your contacts");
        System.out.println("Press \"3\" to edit a contact");
        System.out.println("Press \"4\" to delete a contact");
        System.out.println("Press \"5\" to exit the phonebook");
        menu = input.nextInt();

        return menu;
    }

    // Method that takes the current phone book node and prints it to string in a nicely formatted way
    public String toString() {
        if(front == null) {
            return "[]";
        } else {
            String result = MessageFormat.format("{0}, {1}\n{2}\n{3}, {4} {5}\n{6}\n\n", front.lName, front.fName, front.address, front.city, front.state, front.zip, front.phone);
            PBNode current = front.next;
            while(current != null) {
                String s = MessageFormat.format("{0}, {1}\n{2}\n{3}, {4} {5}\n{6}\n\n", current.lName, current.fName, current.address, current.city, current.state, current.zip, current.phone);
                result += s;
                current = current.next;
            }
            return result;
        }
    }

    // Method that returns the index of a node based on the last name of the contact entry
    public int indexOf(String last) {
        PBNode current = front;
        int index = 0;
        while(current != null) {
            if(current.lName.equalsIgnoreCase(last)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // Method that returns a node along with all of its elements based on the index of that node
    private PBNode nodeAt(int index) {
        PBNode current = front;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Method that takes the index, a stringified method name, and a String parameter and uses this input to invoke
    // the method specified in the string only on the specified element (editField) for the node at the specified index
    public void setNode(int index, String edit, String editField) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        PBNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Method m = current.getClass().getMethod(edit, String.class);
        m.invoke(current, editField);
    }

}
