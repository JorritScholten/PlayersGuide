import concept.PasswordValidator;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 27.");
        while (true) {
            String password = TerminalInteraction.askForString("Enter password to test:");
            if (PasswordValidator.isValid(password))
                System.out.println("Password is valid.");
            else
                System.out.println("Password is not valid.");
        }
    }
}
