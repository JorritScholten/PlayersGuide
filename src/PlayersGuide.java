import item.*;
import item.arrow.Arrow;
import item.storage.Pack;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 33.");
        System.out.println("Created empty storage container, choose what to fill it with. " +
                "Upon exiting contents will be displayed.");
        Pack pack = new Pack(50, 10, 20);
        final String[] options = {"Beginner's arrow",
                "Marksman's arrow",
                "Elite arrow",
                "Sword",
                "Bow",
                "Ration",
                "Rope",
                "Water bottle",
                "exit"};
        while (true) {
            int choice = TerminalInteraction.chooseFromArray("Choose item to add to pack:", options);
            if (choice == options.length - 1) {
                break;
            }
            int amount = 1;
            switch (choice) {
                case 0, 1, 2, 5, 7:
                    amount = TerminalInteraction.askForInt("Enter amount to pack multiple:");
                default:
            }
            if (!pack.add(switch (choice) {
                case 0 -> Arrow.createBeginnerArrow();
                case 1 -> Arrow.createMarksmanArrow();
                case 2 -> Arrow.createEliteArrow();
                case 3 -> new Sword();
                case 4 -> new Bow();
                case 5 -> new Ration();
                case 6 -> new Rope();
                case 7 -> new WaterBottle();
                default -> throw new RuntimeException("switch expression buggy");
            }, amount)) {
                System.out.println("Container is full!");
                break;
            }
            pack.printStatus();
        }
        System.out.printf("Finished packing. " +
                "Bag weighs %.2fkg and %.3fl is used. " +
                "It contains:\n", pack.getWeight(), pack.getVolume());
        pack.printContents();
    }
}
