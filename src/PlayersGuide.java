import item.door.Door;
import item.door.DoorState;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 26.");
        int code = TerminalInteraction.askForInt("Choose pass code for new door:");
        Door door = new Door(code, true);
        door.open();
        door.lock();
        door.close();
        door.lock();
        System.out.println("Setting new code to 1234");
        door.reKey(code, 1234);
        do {
            int unlockCode = TerminalInteraction.askForInt("Enter pass code to unlock door:");
            door.unlock(unlockCode);
        } while (door.getState() == DoorState.LOCKED);
    }
}
