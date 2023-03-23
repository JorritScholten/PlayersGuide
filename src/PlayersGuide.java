import item.arrow.ArrowHead;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 21.");
        ArrowHead arrowHead = TerminalInteraction.chooseFromEnum("Arrowhead options:", ArrowHead.values());
        System.out.println("choice: " + arrowHead);
    }
}
