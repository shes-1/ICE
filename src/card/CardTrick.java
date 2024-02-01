

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * Author: sheshmani 991716306
 */

package card;


import java.util.Scanner;
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // Fill the magicHand array with random cards
        fillMagicHand(magicHand);

        // Ask the user to pick a card
        Card userCard = promptUserForCard();

        // Search for the user's card in the magicHand
        boolean foundMatch = searchForCard(magicHand, userCard);

        // Report the result
        if (foundMatch) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    // Helper method to fill the magicHand array with random cards
    private static void fillMagicHand(Card[] magicHand) {
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
            magicHand[i] = c;
        }
    }

    // Helper method to prompt the user for a card
    private static Card promptUserForCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of your card: ");
        int userValue = scanner.nextInt();
        System.out.print("Enter the suit of your card (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = scanner.next();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        return userCard;
    }

    // Helper method to search for a card in the magicHand array
    private static boolean searchForCard(Card[] magicHand, Card targetCard) {
        for (Card card : magicHand) {
            if (card.isEqual(targetCard)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to generate a random number between min (inclusive) and max (exclusive)
    private static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    // Helper method to generate a random card value between 1 and 13
    private static int generateRandomValue() {
        return generateRandomNumber(1, 14);
    }
}