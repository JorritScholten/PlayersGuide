package item.arrow;

import concept.HasValue;
import item.InventoryItem;

public class Arrow extends InventoryItem implements HasValue {
    static private final double VALUE_PER_CM_LENGTH = 0.05;
    static private final double WEIGHT_PER_CM_LENGTH = 0.002;
    static private final double VOLUME_PER_CM_LENGTH = 0.000785398;
    private final int length;
    private final ArrowHead arrowHead;
    private final Fletching fletching;

    public Arrow(int length, ArrowHead arrowHead, Fletching fletching)
            throws IllegalArgumentException {
        super(length * WEIGHT_PER_CM_LENGTH + arrowHead.getWeight() + fletching.getWeight(),
                length * VOLUME_PER_CM_LENGTH);
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be positive.");
        }
        if (length < 60 || length > 100) {
            throw new IllegalArgumentException("Length should be between 60 and a 100.");
        }
        this.length = length;
        this.arrowHead = arrowHead;
        this.fletching = fletching;
    }

    static public Arrow createMarksmanArrow() {
        return new Arrow(65, ArrowHead.STEEL, Fletching.GOOSE_FEATHER);
    }

    static public Arrow createBeginnerArrow() {
        return new Arrow(75, ArrowHead.WOOD, Fletching.GOOSE_FEATHER);
    }

    static public Arrow createEliteArrow() {
        return new Arrow(95, ArrowHead.STEEL, Fletching.PLASTIC);
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

    @Override
    public String toString() {
        return "Arrow is " + length + " cm long" +
                " with an arrow head made from " + arrowHead.name().toLowerCase() +
                " and fletching made from " + fletching.name().toLowerCase().replace('_', ' ') + ".";
    }

    @Override
    public double getValue() {
        return arrowHead.getValue() + fletching.getValue() + (length * VALUE_PER_CM_LENGTH);
    }
}
