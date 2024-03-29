package item.storage;

import concept.HasDescription;
import item.InventoryItem;

import java.util.LinkedList;

public class Pack extends InventoryItem {
    /** Weight of empty pack. */
    private static final double WEIGHT = 1;
    /** Volume of empty pack. */
    private static final double VOLUME = 1.4;
    private final double max_weight;
    private final double max_volume;
    private final int max_items;
    private final LinkedList<ItemStack> inventory;

    public Pack(double max_weight, double max_volume, int max_items) throws IllegalArgumentException {
        super(WEIGHT, VOLUME);
        if (max_weight < 0 || max_volume < 0 || max_items < 0)
            throw new IllegalArgumentException("Pack() arguments should greater than or equal to zero.");
        this.max_weight = max_weight;
        this.max_volume = max_volume;
        this.max_items = max_items;
        inventory = new LinkedList<>();
    }

    public boolean add(InventoryItem item, int amount) {
        if ((getVolume() + (item.getVolume() * amount)) > max_volume) {
            return false;
        } else if ((getWeight() + (item.getWeight() * amount)) > max_weight) {
            return false;
        } else if ((getItemCount() + amount) > max_items) {
            return false;
        }
        inventory.add(new ItemStack(item, amount));
        return true;
    }

    public boolean add(InventoryItem item) {
        return add(item, 1);
    }

    public void printStatus() {
        System.out.printf("%8s%d/%d\n", "Items: ", getItemCount(), getMax_items());
        System.out.printf("%8s%.2f/%.2f kg\n", "Weight: ", getWeight(), getMax_weight());
        System.out.printf("%8s%.3f/%.3f l\n", "Volume: ", getVolume(), getMax_volume());
    }

    public void printContents() {
        System.out.println(" Amount | Item");
        System.out.println("--------|---------------------------------------------");
        for (ItemStack stack : inventory) {
            if (stack.item() instanceof HasDescription) {
                System.out.printf(" %4d   | %s\n", stack.amount(), ((HasDescription) stack.item()).getShortDescription());
            } else {
                System.out.printf(" %4d   | %s\n", stack.amount(), stack.item());
            }
        }
    }

    @Override
    public String toString() {
        if (inventory.isEmpty()) {
            return "Empty pack.";
        }
        String retval = "Pack containing ";
        for (ItemStack stack : inventory) {
            if (stack.amount == 1) {
                retval = retval.concat(stack.item() + ", ");
            } else {
                retval = retval.concat(String.format("%d %ss, ", stack.amount(), stack.item()));
            }
        }
        if (inventory.size() == 1) {
            retval = retval.replaceAll("(, )\\Z", ".");
        } else {
            retval = retval.replaceAll("(, )([\\w ]+)(, )$", " and $2.");
        }
        return retval;
    }

    public int getItemCount() {
        int count = 0;
        for (ItemStack stack : inventory) {
            count += stack.amount();
        }
        return count;
    }

    @Override
    public double getVolume() {
        double volume = VOLUME;
        for (ItemStack stack : inventory) {
            volume += stack.item().getVolume() * stack.amount();
        }
        return volume;
    }

    @Override
    public double getWeight() {
        double weight = WEIGHT;
        for (ItemStack stack : inventory) {
            weight += stack.item().getWeight() * stack.amount();
        }
        return weight;
    }

    public double getMax_weight() {
        return max_weight;
    }

    public double getMax_volume() {
        return max_volume;
    }

    public int getMax_items() {
        return max_items;
    }

    record ItemStack(InventoryItem item, int amount) {

    }

}
