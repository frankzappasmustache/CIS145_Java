import java.security.SecureRandom;
import java.util.*;
import java.lang.String;

// package cardGame;
public class DeckOfCards {

    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;
    private ArrayList<String> player = new ArrayList<>();

    private Card[] deck = new Card[NUMBER_OF_CARDS];
    private int currentCard = 0;

    public DeckOfCards() {
        String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
                "Q", "K"};
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};

        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }
    }

    public String menu(Scanner console) {
        System.out.println("Press \"A\" to add a player");
        System.out.println("Press \"P\" to play a game of war");
        System.out.println("Press \"Q\" to quit");
        String choice = console.nextLine();
        return choice;
    }

    public void addPlayer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your first name");
        String fName = input.next();
        System.out.println("Please Enter your last name");
        String lName = input.next();
        player.add(0, "First Name: " + fName + "Last Name: " + lName);
    }

    public void shuffle() {

        currentCard = 0;

        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card dealCard() {
        if (currentCard < deck.length) {
            return deck[currentCard++];
        } else {
            return null;
        }
    }

    public Stack<String> hand() {
        shuffle();
        Stack<String> s = new Stack<>();

        for (int i = 0; i != deck.length; i++) {
            var c = dealCard().toString();
            s.push(c);
        }
        return s;
    }

    public Stack<String> house(Stack<String> stack) {
        Stack<String> h = new Stack<>();

        for (int i = 0; i < 2; i++) {
            h.push(stack.pop());
        }
        return h;
    }

    public Stack<String> cardShark(Stack<String> stack2) {
        Stack<String> p = new Stack<>();

        for(int i = 0; i < 2; i++) {
            p.push(stack2.pop());
        }
        return p;
    }

    /* public int addCards(String one, String two) {

        String a = one.substring(0,1);
        String b = two.substring(0,1);
        int card1 = 0;
        int card2 = 0;
        final String ace = "A";
        final String jack = "J";
        final String queen = "Q";
        final String king = "K";

        switch(a) {
            case ace:
                card1 = 11;
                break;
            case jack, queen, king:
                card1 = 10;
                break;
            case "2", "3", "4", "5", "6", "7", "8", "9", "10":
                card1 = Integer.parseInt(a);
                break;
        }

        switch(b) {
            case ace:
                card2 = 11;
                break;
            case jack, queen, king:
                card2 = 10;
                break;
            case "2", "3", "4", "5", "6", "7", "8", "9", "10":
                card2 = Integer.parseInt(b);
                break;
        }

        int total = card1 + card2;
        return total;
    } */

    public int addCards(Stack<String> three) {
        int a = three.size();
        int c = 0;
        int d = 0;
        final String ace = "A";
        final String jack = "J";
        final String queen = "Q";
        final String king = "K";

        for(int i = 0; i < a; i++) {
            String b = three.pop();
            String e = b.substring(0,1);
            switch(e) {
                case ace:
                    c = 11;
                    break;
                case jack, queen, king:
                    c = 10;
                    break;
                case "2", "3", "4", "5", "6", "7", "8", "9", "10":
                    c = Integer.parseInt(e);
                    break;
            }
            d += c;
        }
        return d;
    }
}
