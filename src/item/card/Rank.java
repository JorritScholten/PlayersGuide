package item.card;

public enum Rank {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    DOLLAR(11),
    PERCENT(12),
    CARET(13),
    AMPERSAND(14);
    public final int POWER;

    Rank(int rank) {
        if (rank < 1 || rank > 14)
            throw new IllegalArgumentException("Rank should be between 1 and 10.");
        POWER = rank;
    }

    /**
     * Gets the amount of options this Enum has.
     * @return amount of options.
     */
    public static int options() {
        return Rank.values().length;
    }

    public boolean isSymbol() {
        return POWER > 10;
    }

    public boolean isNumber() {
        return POWER <= 10;
    }
}
