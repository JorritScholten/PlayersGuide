import item.arrow.Arrow;
import item.arrow.ArrowHead;
import item.arrow.Fletching;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 21.");
        ArrowHead arrowHead = TerminalInteraction.chooseFromEnum("Arrowhead options:", ArrowHead.values());
        Fletching fletching = TerminalInteraction.chooseFromEnum("Choice of fletching:", Fletching.values());
        int length = TerminalInteraction.chooseIntInRange(60, 100);
        Arrow arrow = new Arrow(length, arrowHead, fletching);
        System.out.println("Constructed arrow: " + arrow);
        System.out.printf("Arrow costs %.2f gold pieces.\n", arrow.getValue());
    }
}
