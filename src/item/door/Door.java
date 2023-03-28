package item.door;

public class Door {
    public final boolean DEBUG;
    private DoorState state;
    private int passCode;

    /**
     * Construct a door without debugging.
     * @param passCode Initial pass code of door.
     */
    public Door(int passCode) {
        this.state = DoorState.CLOSED;
        this.passCode = passCode;
        this.DEBUG = false;
    }

    /**
     * Construct a door whilst setting debug state.
     * @param passCode Initial pass code of door.
     * @param debug    Set true to print debug statements.
     */
    public Door(int passCode, boolean debug) {
        this.state = DoorState.CLOSED;
        this.passCode = passCode;
        this.DEBUG = debug;
    }

    /**
     * Closes door if it is currently open.
     */
    public void close() {
        if (DEBUG)
            System.out.println("Attempting to open door, currently it is " + state + ".");
        if (state == DoorState.OPEN) {
            state = DoorState.CLOSED;
            System.out.println("Door successfully closed.");
        } else
            System.out.println("Failed to close door.");
    }

    /**
     * Opens door if it is currently closed.
     */
    public void open() {
        if (DEBUG)
            System.out.println("Attempting to open door, currently it is " + state + ".");
        if (state == DoorState.CLOSED) {
            state = DoorState.OPEN;
            System.out.println("Door successfully opened.");
        } else
            System.out.println("Failed to open door.");
    }

    /**
     * Locks door if it currently closed.
     */
    public void lock() {
        if (DEBUG)
            System.out.println("Attempting to open door, currently it is " + state + ".");
        if (state == DoorState.CLOSED) {
            state = DoorState.LOCKED;
            System.out.println("Door successfully locked.");
        } else
            System.out.println("Failed to lock door.");
    }

    /**
     * Unlocks door if it is currently locked and the right pass code is supplied.
     * @param passCode
     */
    public void unlock(int passCode) {
        if (DEBUG)
            System.out.println("Attempting to unlock door, currently it is " + state + ".");
        if (state == DoorState.LOCKED && this.passCode == passCode) {
            state = DoorState.CLOSED;
            if (DEBUG)
                System.out.println("Door successfully unlocked.");
        } else if (DEBUG) {
            if (this.passCode != passCode)
                System.out.println(passCode + " doesn't match internal pass code (" + this.passCode + ").");
            else
                System.out.println("Failed to unlock door.");
        }
    }

    /**
     * Changes pass code of door if passCode matches current pass code.
     * @param passCode    current pass code of door.
     * @param newPassCode new pass code of door.
     */
    public void reKey(int passCode, int newPassCode) {
        if (DEBUG)
            System.out.println("Attempting to change pass code to " + newPassCode + ".");
        if (this.passCode == passCode) {
            this.passCode = newPassCode;
            if (DEBUG)
                System.out.println("Successfully changed pass code.");
        } else if (DEBUG)
            System.out.println("Failed to change pass code because supplied pass code doesn't match stored value.");
    }

    public DoorState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Door is " + state + " and has passcode " + passCode + ".";
    }
}
