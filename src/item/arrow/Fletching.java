package item.arrow;

import concept.HasValue;
import concept.HasWeight;

public enum Fletching implements HasValue, HasWeight {
    PLASTIC(10),
    TURKEY_FEATHER(5),
    GOOSE_FEATHER(3);
    private final double value;
    static private final double WEIGHT = 0.01;

    Fletching(double value) {
        this.value = value;
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }

    @Override
    public double getValue() {
        return value;
    }
}
