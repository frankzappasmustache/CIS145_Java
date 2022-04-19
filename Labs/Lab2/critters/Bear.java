/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Lab 2
    File Name: Bear.java
    Author: Dustin McClure
    Lab: Critters
    Modified Date: 04/18/2022

    This class creates a Bear critter that is either black or white
    depending on whether or not it is a polar bear or black bear, and
    displays as a forward slash or backslash depending on which move it
    is on.
*/

import java.awt.*;

public class Bear extends Critter {
    private boolean polarBear; // boolean declaration for bear color
    private boolean slash; // boolean declaration for string representation

    // create constructor for Bear that accepts bool polarBear
    public Bear(boolean polarBear) { // begin constructor
        this.polarBear = polarBear;
    } // end constructor

    @Override
    // This method tells the Bear what to do depending on what is to
    // the front, left, or right of it and counts each move
    public Action getMove(CritterInfo info) { // begin method getMove
        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.SAME || info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    } // end method getMove

    @Override
    // This method checks to see if polarBear evaluates to true
    // if so it returns white, otherwise it returns black
    public Color getColor() { // begin method getColor
        if(polarBear) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    } // end method getColor

    @Override
    // This method checks to see if slash evaluates to true
    // if so it returns a slash "/", otherwise it returns a backslash "\"
    public String toString() { // begin method toString
        slash = !slash;

        if(slash) {
            return "/";
        } else {
            slash = slash;
            return "\\";
        }
    } // end method toString
}