import item.door.Door;
import item.door.DoorState;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 26.");
        int code = TerminalInteraction.askForInt("Choose pass code for new door:");
        Door door = new Door(code, true);

        String[] choices = {"Open", "Close", "Lock", "Unlock", "Change pass code", "Exit program"};
        while (true) {
            int choice = TerminalInteraction.chooseFromArray("Choose what to do:", choices);
            switch (choice) {
                case 0:
                    door.open();
                    break;
                case 1:
                    door.close();
                    break;
                case 2:
                    door.lock();
                    break;
                case 3:
                    do {
                        int unlockCode = TerminalInteraction.askForInt("Enter pass code to unlock door:");
                        door.unlock(unlockCode);
                    } while (door.getState() == DoorState.LOCKED);
                    break;
                case 4:
                    int oldCode = TerminalInteraction.askForInt("Enter current pass code:");
                    int newCode = TerminalInteraction.askForInt("Enter new pass code:");
                    door.reKey(oldCode, newCode);
                    break;
                default:
                    return;
            }
        }
    }
}
