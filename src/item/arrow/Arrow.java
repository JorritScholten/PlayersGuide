package item.arrow;

public class Arrow {
    static private final double VALUE_PER_CM_LENGTH = 0.05;
    private final int length;
    private final ArrowHead arrowHead;
    private final Fletching fletching;

    public Arrow(int length, ArrowHead arrowHead, Fletching fletching)
            throws IllegalArgumentException {
        if (length <= 0)
            throw new IllegalArgumentException("Length should be positive.");
        if (length < 60 || length > 100)
            throw new IllegalArgumentException("Length should be between 60 and a 100.");
        this.length = length;
        this.arrowHead = arrowHead;
        this.fletching = fletching;
    }

    public int getLength() {
        return length;
    }

    public ArrowHead getArrowHead() {
        return arrowHead;
    }

    public Fletching getFletching() {
        return fletching;
    }

    public String toString() {
        return "Arrow is " + length + " cm long" +
                " with an arrow head made from " + arrowHead.name().toLowerCase() +
                " and fletching made from " + fletching.name().toLowerCase();
    }

    public double getValue() {
        return arrowHead.VALUE + fletching.VALUE + (length * VALUE_PER_CM_LENGTH);
    }
}
