package item.arrow;

import concept.HasDescription;
import concept.HasValue;
import concept.HasVolume;
import concept.HasWeight;

public enum ArrowHead implements HasValue, HasWeight, HasVolume, HasDescription {
    STEEL(10, 0.04),
    WOOD(3, 0.01),
    OBSIDIAN(5, 0.05);
    static private final double VOLUME = 0.05;
    private final double value;
    private final double weight;

    ArrowHead(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public double getVolume() {
        return VOLUME;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return getShortDescription() + " arrowhead";
    }

    @Override
    public String getShortDescription() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
