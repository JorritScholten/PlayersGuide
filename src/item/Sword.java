package item;

public class Sword extends InventoryItem {
    public Sword(double weight, double volume) {
        super(weight, volume);
    }

    public Sword() {
        super(5, 3);
    }

    @Override
    public String toString() {
        return "Sword";
    }
}
