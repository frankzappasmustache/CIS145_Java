/*
    Copyright 2022 <Dustin McClure>
    Project Name: CS145_Java
    Sub-project: Lab 2
    File Name: Giant.java
    Author: Dustin McClure
    Lab: Critters
    Modified Date: 04/18/2022

    This class creates a Giant critter that has a color of gray, and
    says fee, fie, foe, or fum depending on the current move.
*/

import java.awt.*;
public class Giant extends Critter {
    private String giantArr[] = {"fee", "fie", "foe", "fum"}; // declaration of String Array
    private int move; // integer declaration for move counter

    @Override
    // This method tells the Giant what to do depending on what is to
    // the front, left, or right of it and counts each move
    public Action getMove(CritterInfo info) { // begin method getMove
        move++;
        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.SAME || info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    } // end method getMove

    @Override
    public Color getColor() { // begin method getColor
        return Color.GRAY;
    } // end method getColor

    @Override
    // This method returns one of 4 giant words depending on
    // what move it is currently, and if it is move 24 it resets
    // the move counter
    public String toString() { // begin method toString
        if (move <= 6) {
            return giantArr[0];
        } else if (move >= 7 && move <= 12) {
            return giantArr[1];
        } else if (move >= 13 && move <= 18) {
            return giantArr[2];
        } else if (move >= 19 && move <= 23) {
            return giantArr[3];
        } else {
            move = 0;
            return giantArr[3];
        }
    } // end method toString
}