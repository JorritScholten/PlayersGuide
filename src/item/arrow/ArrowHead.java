package item.arrow;

public enum ArrowHead {
    STEEL(10),
    WOOD(3),
    OBSIDIAN(5);
    public final double VALUE;

    ArrowHead(double value) {
        this.VALUE = value;
    }
}
