package item.card;

import concept.Color;

public enum CardColor {
    RED(Color.createRed()),
    GREEN(0, 255, 0),
    BLUE(Color.createBlue()),
    YELLOW(Color.createYellow());
    private final Color color;

    CardColor(int red, int green, int blue) {
        color = new Color(red, green, blue);
    }

    CardColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the amount of options this Enum has.
     * @return amount of options.
     */
    public static int options() {
        return CardColor.values().length;
    }

    public Color getColor() {
        return color;
    }
}
