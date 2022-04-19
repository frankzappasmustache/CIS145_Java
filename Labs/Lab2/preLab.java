import java.awt.*;
import java.util.*;

public class newCritter extends Critter {

    @Override

    public Action getMove(CritterInfo info) { // begin method getMove
        if(friend) {
            return Action;
        } else if(foe) {
            return Action2;
        }
    } // end method getMove

    @Override

    public Color getColor() { // begin method getColor
        return Color;
    } // end method getColor

    @Override
    public String toString() { // begin method toString
        return "on screen representation";
    } // end method toString
}