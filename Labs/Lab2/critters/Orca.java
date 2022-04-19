/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Lab 2
    File Name: Orca.java
    Author: Dustin McClure
    Lab: Critters
    Modified Date: 04/18/2022

    This class creates an Orca critter that alternates between multiple colors
    on the rgb color spectrum and displays as a whale emoji.
*/
import java.awt.*;
import java.util.*;

public class Orca extends Critter {

    @Override
    // This method tells the Orca what to do depending on what is to
    // the front, left, or right of it
    public Action getMove(CritterInfo info) { // begin method getMove
        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.SAME || info.getLeft() == Neighbor.SAME || info.getRight() == Neighbor.SAME) {
            return Action.LEFT;
        } else if(info.getFront() == Neighbor.WALL && info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if(info.getFront() == Neighbor.EMPTY || info.getRight() == Neighbor.EMPTY || info.getLeft() == Neighbor.EMPTY) {
            return Action.RIGHT;
        } else {
            return Action.INFECT;
        }
    } // end method getMove

    @Override
    // This method generates a random color on the rbg color spectrum
    // and returns that color
    public Color getColor() { // begin method getColor
        Random rnum = new Random();
        int a = rnum.nextInt(255);
        int b = rnum.nextInt(255);
        int c = rnum.nextInt(255);
        Color rcolor = new Color(a, b, c);
        return rcolor;
    } // end method getColor

    @Override
    // This method returns the unicode emoji of a whale
    public String toString() { // begin method toString
        return "\uD83D\uDC0B";
    } // end method toString
}