package item;

import concept.HasVolume;
import concept.HasWeight;

public abstract class InventoryItem implements HasVolume, HasWeight {
    protected final double weight;
    protected final double volume;

    protected InventoryItem(double weight, double volume) {
        this.weight = weight;
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
