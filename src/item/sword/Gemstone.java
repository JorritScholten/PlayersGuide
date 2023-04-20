package item.sword;

import concept.HasDescription;

public enum Gemstone implements HasDescription {
    EMERALD(),
    AMBER(),
    SAPPHIRE(),
    DIAMOND(),
    BITSTONE();

    @Override
    public String getDescription() {
        return name().charAt(0) + name().substring(1).toLowerCase() + " gem";
    }

    @Override
    public String getShortDescription() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return "Gemstone";
    }
}
