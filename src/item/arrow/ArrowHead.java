package item.arrow;

import concept.HasValue;

public enum ArrowHead implements HasValue {
    STEEL(10),
    WOOD(3),
    OBSIDIAN(5);
    private final double value;

    ArrowHead(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
