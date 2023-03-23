import item.arrow.Arrow;
import item.arrow.ArrowHead;
import item.arrow.Fletching;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 22.");
        final String[] arrowOptions = {"Elite Arrow", "Marksman Arrow", "Beginner Arrow", "Custom Arrow"};
        int choice = TerminalInteraction.chooseFromArray("Please choose which type of arrow to construct.", arrowOptions);

        Arrow arrow;
        switch (choice) {
            case 0:
                arrow = Arrow.createEliteArrow();
                break;
            case 1:
                arrow = Arrow.createMarksmanArrow();
                break;
            case 2:
                arrow = Arrow.createBeginnerArrow();
                break;
            case 3:
                ArrowHead arrowHead = TerminalInteraction.chooseFromEnum("Arrowhead options:", ArrowHead.values());
                Fletching fletching = TerminalInteraction.chooseFromEnum("Choice of fletching:", Fletching.values());
                int length = TerminalInteraction.chooseIntInRange(60, 100);
                arrow = new Arrow(length, arrowHead, fletching);
                break;
            default:
                return;
        }

        System.out.println("Constructed arrow: " + arrow);
        System.out.printf("The arrow costs %.2f gold pieces.\n", arrow.getValue());
    }
}
