package item.sword;

import concept.HasDescription;
import item.InventoryItem;

public class Sword extends InventoryItem implements HasDescription {
    private Material material;
    private Gemstone gemstone;
    private int length;
    private int crossguardWidth;

    public Sword(double weight, double volume) {
        super(weight, volume);
    }

    public Sword(int length, int crossguardWidth) {
        super(5, 3);
        this.length = length;
        this.crossguardWidth = crossguardWidth;
        material = Material.IRON;
        gemstone = null;
    }

    @Override
    public String toString() {
        return "Sword";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getShortDescription() {
        return null;
    }
}
