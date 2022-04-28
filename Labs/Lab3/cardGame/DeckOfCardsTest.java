import java.security.SecureRandom;
import java.util.*;
import java.lang.String;

public class DeckOfCardsTest {

    private ArrayList<String> player = new ArrayList<>();

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        Scanner input = new Scanner(System.in);
        String answer = myDeckOfCards.menu(input);

        while(!answer.equalsIgnoreCase("q")) {
            if(answer.equalsIgnoreCase("A")) {
                myDeckOfCards.addPlayer();

            } else if(answer.equalsIgnoreCase("p")) {
                Stack<String> hand = myDeckOfCards.hand();

                Stack<String> house = myDeckOfCards.house(hand);
                System.out.println("The dealer's cards are: " + house);
                int houseTotal = myDeckOfCards.addCards(house);
                System.out.println("Dealer Total = " + houseTotal);

                Stack<String> playerHand = myDeckOfCards.cardShark(hand);
                System.out.println("Your cards are: " + playerHand);
                int playerTotal = myDeckOfCards.addCards(playerHand);
                System.out.println("Player Total = " + playerTotal);

                if(playerTotal == 21) {
                    System.out.println("You win!");
                } else if(playerTotal >= houseTotal && houseTotal <= 17) {
                    house.addAll(myDeckOfCards.house(hand));
                    System.out.println("The dealer's cards are: " + house);
                    houseTotal += myDeckOfCards.addCards(house);
                    System.out.println("Dealer Total = " + houseTotal);
                    if(houseTotal > 21) {
                        System.out.println("You Win!");
                    } else if(houseTotal == 21) {
                        continue;
                    }
                }

                System.out.println("Would you like to stay or hit? (type stay or hit)");
                String playerChoice = input.next();
                while(playerChoice.equalsIgnoreCase("hit")) {

                    switch(playerChoice) {
                        case "stay":
                            System.out.println("Your total is: " + playerTotal);
                            if(playerTotal >= houseTotal && houseTotal <= 17) {
                                house.addAll(myDeckOfCards.house(hand));
                                System.out.println("The dealer's cards are: " + house);
                                houseTotal += myDeckOfCards.addCards(house);
                                System.out.println("Dealer Total = " + houseTotal);
                                continue;
                            } else if(playerTotal > houseTotal && houseTotal >= 17) {
                                System.out.println("You beat the house!");
                                break;
                            } else if(playerTotal < houseTotal) {
                                System.out.println("The house beat you");
                                break;
                            }
                        case "hit":
                            playerHand.addAll(myDeckOfCards.cardShark(hand));
                            System.out.println("Your cards are: " + playerHand);
                            playerTotal += myDeckOfCards.addCards(playerHand);
                            System.out.println("Player Total = " + playerTotal);
                            if(playerTotal == 21) {
                                System.out.println("Blackjack!!");
                                break;
                            } else if(playerTotal <= 20) {
                                System.out.println("Would you like to stay or hit? (type stay or hit)");
                                playerChoice = input.next();
                                continue;
                            } else {
                                System.out.println("You busted!!");
                                break;
                            }
                    }
                }
            }
            answer = myDeckOfCards.menu(input);
        }
    }
}
