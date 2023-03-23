package concept;

public class Color {
    /** Amount of red, 0 means completely off; 255 means completely on. */
    private final int red;
    /** Amount of green, 0 means completely off; 255 means completely on. */
    private final int green;
    /** Amount of blue, 0 means completely off; 255 means completely on. */
    private final int blue;

    public Color(int red, int green, int blue)
            throws IllegalArgumentException {
        if (red < 0 || red > 255)
            throw new IllegalArgumentException("red should be between 0 and 255.");
        if (green < 0 || green > 255)
            throw new IllegalArgumentException("green should be between 0 and 255.");
        if (blue < 0 || blue > 255)
            throw new IllegalArgumentException("blue should be between 0 and 255.");
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static Color createRed() {
        return new Color(255, 0, 0);
    }

    @Override
    public String toString() {
        return String.format("Color(%3d,%3d,%3d)", red, green, blue);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
