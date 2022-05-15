/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Assignment 1
    File Name: ListNode.java
    Author: Dustin McClure
    Lab: Phone Book
    Modified Date: 05/14/2022

    This method defines the phone book node, provides its data members, provides constructors, and provides
    accessor/mutator methods.
*/

// begin class PBNode
public class PBNode {
    /* enum not implemented
    private enum field {
        LAST,
        FIRST,
        ADDRESS,
        CITY,
        STATE,
        ZIP,
        PHONE;
    }
     */

    String lName;
    String fName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    public PBNode next;

    // Default(empty) phone book node constructor
    public PBNode() {
        this(null, null, null, null, null, null, null, null);
    }

    // Constructor that sets next to null
    public PBNode(String lName, String fName, String address, String city, String state, String zip, String phone) {
        this(lName, fName, address, city, state, zip, phone, null);
    }

    // Constructor that sets a reference to the next reference
    public PBNode(String lName, String fName, String address, String city, String state, String zip, String phone, PBNode next) {
        this.lName = lName;
        this.fName = fName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.next = next;
    }

    // Accessor method that returns first name
    public String getFirst() {
        return fName;
    }

    // Accessor method that returns last name
    public String getLast() {
        return lName;
    }
    // Accessor method that returns address
    public String getAddress() {
        return address;
    }

    // Accessor method that returns city
    public String getCity() {
        return city;
    }

    // Accessor method that returns state
    public String getState() {
        return state;
    }

    // Accessor method that returns zip
    public String getZip() {
        return zip;
    }

    // Accessor method that returns phone number
    public String getPhone() {
        return phone;
    }

    // Accessor method that returns the next node
    public PBNode getPBNode() {
        return next;
    }

    // mutator method that changes first name (accepts string)
    public void setfName(String fName) {
        this.fName = fName;
    }

    // mutator method that changes last name (accepts string)
    public void setlName(String lName) {
        this.lName = lName;
    }

    // mutator method that changes address (accepts string)
    public void setAddress(String address) {
        this.address = address;
    }

    // mutator method that changes city (accepts string)
    public void setCity(String city) {
        this.city = city;
    }

    // mutator method that changes state (accepts string)
    public void setState(String state) {
        this.state = state;
    }

    // mutator method that changes zip (accepts string)
    public void setZip(String zip) {
        this.zip = zip;
    }

    // mutator method that changes phone (accepts string)
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // mutator method that changes node (accepts PBNode)
    public void setPBNode(PBNode next) {
        this.next = next;
    }
}
