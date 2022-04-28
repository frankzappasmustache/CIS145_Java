import java.util.ArrayList;
import java.util.Scanner;

// package cardGame;

public class Player {

    private static ArrayList<String> players = new ArrayList<>();

    public void addPlayer() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your first name");
        String fName = input.next();
        System.out.println("Please Enter your last name");
        String lName = input.next();
        players.add(0, "First Name: " + fName + "Last Name: " + lName);
    }

    public static String players() {
        return players.toString();
    }
}
