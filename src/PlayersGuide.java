import item.robot.*;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 35.");
        var robot = new Robot();
        final String[] commandOptions = {"on", "off", "north", "east", "south", "west"};
        Object command1 = convertChoice(TerminalInteraction.chooseFromArray("Choose 1st command:", commandOptions));
        Object command2 = convertChoice(TerminalInteraction.chooseFromArray("Choose 2nd command:", commandOptions));
        Object command3 = convertChoice(TerminalInteraction.chooseFromArray("Choose 3rd command:", commandOptions));
        robot.setCommands(command1, command2, command3);
        robot.run();
    }

    private static Object convertChoice(int choice) {
        return switch (choice) {
            case 0 -> new OnCommand();
            case 1 -> new OffCommand();
            case 2 -> new NorthCommand();
            case 3 -> new EastCommand();
            case 4 -> new SouthCommand();
            case 5 -> new WestCommand();
            default -> throw new RuntimeException("Choice out of bounds.");
        };
    }
}
