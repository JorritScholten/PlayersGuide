package item.sword;

import concept.HasDescription;

public enum Material implements HasDescription {
    WOOD(),
    BRONZE(),
    IRON(),
    STEEL(),
    BINARIUM();

    @Override
    public String getDescription() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    @Override
    public String getShortDescription() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return "Material";
    }
}
