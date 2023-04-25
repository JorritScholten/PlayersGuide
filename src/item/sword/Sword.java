package item.sword;

import concept.HasDescription;
import item.InventoryItem;

public class Sword extends InventoryItem implements HasDescription {
    private final Material material;
    private final Gemstone gemstone;
    private final int length;
    private final int crossguardWidth;

    public Sword(double weight, double volume, int length, int crossguardWidth, Material material, Gemstone gemstone) {
        super(weight, volume);
        this.length = length;
        this.crossguardWidth = crossguardWidth;
        this.material = material;
        this.gemstone = gemstone;
    }

    static public Sword createDefaultSword() {
        double DEFAULT_VOLUME = 3;
        double DEFAULT_WEIGHT = 5;
        int DEFAULT_CROSSGUARD_WIDTH = 20;
        int DEFAULT_LENGTH = 130;
        return new Sword(DEFAULT_WEIGHT, DEFAULT_VOLUME, DEFAULT_LENGTH, DEFAULT_CROSSGUARD_WIDTH, Material.IRON, null);
    }

    public Sword createModifiedCopy(Material material) {
        return new Sword(getWeight(), getVolume(), length, crossguardWidth, material, gemstone);
    }

    public Sword createModifiedCopy(Gemstone gemstone) {
        return new Sword(getWeight(), getVolume(), length, crossguardWidth, material, gemstone);
    }

    @Override
    public String toString() {
        return getShortDescription();
    }

    @Override
    public String getDescription() {
        return String.format("%s sword with %s gem inset, %d cm long and a crossguard %d cm wide.",
                material.getDescription(), gemstone == null ? "no" : gemstone.getShortDescription(), length, crossguardWidth);
    }

    @Override
    public String getShortDescription() {
        return String.format("%s sword, %d cm long, %d cm crossguard width%s",
                material.getDescription(), length, crossguardWidth, gemstone == null ? "" : ", " + gemstone.getDescription());
    }
}
