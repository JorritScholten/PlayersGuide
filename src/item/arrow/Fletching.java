package item.arrow;

import concept.HasValue;

public enum Fletching implements HasValue {
    PLASTIC(10),
    TURKEY_FEATHER(5),
    GOOSE_FEATHER(3);
    private final double value;

    Fletching(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
