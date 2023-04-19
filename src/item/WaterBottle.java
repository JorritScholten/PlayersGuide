package item;

public class WaterBottle extends InventoryItem {
    public WaterBottle(double weight, double volume) {
        super(weight, volume);
    }

    public WaterBottle() {
        super(2, 3);
    }

    @Override
    public String toString() {
        return "WaterBottle";
    }
}
