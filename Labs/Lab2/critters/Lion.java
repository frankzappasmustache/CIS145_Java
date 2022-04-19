/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Lab 2
    File Name: Lion.java
    Author: Dustin McClure
    Lab: Critters
    Modified Date: 04/18/2022

    This class creates a Lion critter that is either Red, Green, or Blue and
    displays as a lion emoji.
*/
import java.awt.*;
import java.util.*;

public class Lion extends Critter {
    private int move; // integer declaration for move counter

    @Override
    // This method tells the Lion what to do depending on what is to
    // the front, left, or right of it and counts each move
    public Action getMove(CritterInfo info) { // begin method getMove
        move++;
        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if(info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    } // end method getMove

    @Override
    // This method returns 1 of 3 colors depending on the result
    // of move % 3
    public Color getColor() { // begin method getColor
        Random rnum = new Random();
        Color lionColors[] = {Color.RED, Color.GREEN, Color.BLUE};

        if (move % 3 == 0) {
            return lionColors[rnum.nextInt(3)];
        } else if (move % 3 == 1) {
            return lionColors[rnum.nextInt(3)];
        } else {
            return lionColors[rnum.nextInt(3)];
        }
    } // end method getColor

    @Override
    // THis method returns the unicode emoji of a lion
    public String toString() { // begin method toString
        return "\uD83E\uDD81";
    } // end method toString
}