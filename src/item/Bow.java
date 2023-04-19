package item;

public class Bow extends InventoryItem {
    public Bow(double weight, double volume) {
        super(weight, volume);
    }

    public Bow() {
        super(1, 4);
    }

    @Override
    public String toString() {
        return "Bow";
    }
}
