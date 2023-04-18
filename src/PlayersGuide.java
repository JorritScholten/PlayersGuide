import item.arrow.Arrow;
import item.storage.Pack;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 32.");
        System.out.println("Created empty storage container, choose what to fill it with. " +
                "Upon exiting contents will be displayed.");
        Pack pack = new Pack(5, 2, 20);
        final String[] options = {"Beginner's arrow", "Marksman's arrow", "Elite arrow", "exit"};
        while (true) {
            int choice = TerminalInteraction.chooseFromArray("Choose item to add to pack:", options);
            if (choice == options.length - 1) {
                break;
            }
            if (!pack.add(switch (choice) {
                case 0 -> Arrow.createBeginnerArrow();
                case 1 -> Arrow.createMarksmanArrow();
                case 2 -> Arrow.createEliteArrow();
                default -> throw new RuntimeException("switch expression buggy");
            })) {
                System.out.println("Container is full!");
                break;
            }
        }
        System.out.println("Finished packing, printing contents:");
        pack.printContents();
    }
}
