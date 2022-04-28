import java.util.ArrayList;
import java.util.Scanner;
// import cardGame.*;

public class War {

    private static ArrayList<String> players = new ArrayList<>();
    public static void play() {
        Scanner input = new Scanner(System.in);
        String m = menu(input);
        DeckOfCards gameDeck = new DeckOfCards();
        Player p = new Player();

        while(!m.equalsIgnoreCase("q")) {
            if(m.equalsIgnoreCase("a")) {
                ArrayList<> hand = new ArrayList<>();
                p.addPlayer();

            }
        }
    }

    public static String menu(Scanner console) {
        System.out.println("Press \"A\" to add a player");
        System.out.println("Press \"P\" to play a game of war");
        System.out.println("Press \"Q\" to quit");
        String choice = console.nextLine();
        return choice;
    }

    public static String dealer() {

    }
}
