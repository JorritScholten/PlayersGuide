package item;

public class Rope extends InventoryItem {
    public Rope(double weight, double volume) {
        super(weight, volume);
    }

    public Rope() {
        super(1, 1.5);
    }

    @Override
    public String toString() {
        return "Rope";
    }
}
