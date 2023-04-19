package item.arrow;

import concept.HasDescription;
import concept.HasValue;
import concept.HasWeight;

public enum Fletching implements HasValue, HasWeight, HasDescription {
    PLASTIC(10),
    TURKEY_FEATHER(5),
    GOOSE_FEATHER(3);
    static private final double WEIGHT = 0.01;
    private final double value;

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


    @Override
    public String getDescription() {
        return getShortDescription() + " fletching";
    }

    @Override
    public String getShortDescription() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase().replace('_', ' ');
    }
}
