package item.arrow;

public enum Fletching {
    PLASTIC(10),
    TURKEY_FEATHER(5),
    GOOSE_FEATHER(3);
    public final double VALUE;

    Fletching(double value) {
        this.VALUE = value;
    }
}
