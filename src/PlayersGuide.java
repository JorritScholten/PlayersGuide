import item.card.Card;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 25.");
        Card[] deck = Card.createDeck();
        for (Card card : deck) {
            System.out.println("The " + card);
        }
    }
}
