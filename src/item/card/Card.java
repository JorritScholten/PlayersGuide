package item.card;

public class Card {
    private final Rank rank;
    private final CardColor color;

    public Card(Rank rank, CardColor color) {
        this.rank = rank;
        this.color = color;
    }

    public static Card[] createDeck() {
        Card[] retval = new Card[CardColor.options() * Rank.options()];
        int i = 0;
        for (CardColor color : CardColor.values()) {
            for (Rank rank : Rank.values()) {
                retval[i] = new Card(rank, color);
                i++;
            }
        }
        return retval;
    }

    public Rank getRank() {
        return rank;
    }

    public CardColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color.toString().charAt(0) + color.toString().substring(1).toLowerCase() +
                " " +
                rank.toString().charAt(0) + rank.toString().substring(1).toLowerCase();
    }
}
