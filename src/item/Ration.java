package item;

public class Ration extends InventoryItem {
    public Ration(double weight, double volume) {
        super(weight, volume);
    }

    public Ration() {
        super(1, 0.5);
    }

    @Override
    public String toString() {
        return "Ration";
    }
}
