package concept;

import java.util.HashSet;
import java.util.Set;

public class RoomCoordinate {
    /** Keeping track of all created coordinates using a static Set ensures coordinates are immutable. */
    private static final Set<Coordinate> coordinates = new HashSet<>();
    /** Position of room. */
    private final Coordinate coordinate;
    /** Name of room for identification purposes. */
    private final String name;

    /**
     * Create RoomCoordinate, a named room with a unique location.
     * @param x    Location of room on X-axis.
     * @param y    Location of room on Y-axis.
     * @param name Name of room for identification purposes.
     * @throws IllegalArgumentException when a room already exists at the specified location.
     */
    public RoomCoordinate(int x, int y, String name) throws IllegalArgumentException {
        coordinate = new Coordinate(x, y);
        if (!coordinates.add(coordinate)) {
            throw new IllegalArgumentException(
                    String.format("Coordinate (%d,%d) already in use, \"%s\" must be unique.", x, y, name)
            );
        }
        this.name = name;
    }

    /**
     * Checks if another room is directly adjacent (not diagonal) to itself.
     * @param otherRoomCoordinate Other room to check against.
     * @return true if other room is adjacent.
     */
    public boolean isAdjacent(RoomCoordinate otherRoomCoordinate) {
        var otherCoordinate = otherRoomCoordinate.getCoordinate();
        return Math.abs(coordinate.x - otherCoordinate.x) + Math.abs(coordinate.y - otherCoordinate.y) == 1;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return String.format("RoomCoordinate \"%s\"(%d,%d)", name, coordinate.x, coordinate.y);
    }

    /**
     * Type container for 2D coordinate system.
     * @param x position on X-axis.
     * @param y position on Y-axis.
     */
    public record Coordinate(int x, int y) {
    }
}
