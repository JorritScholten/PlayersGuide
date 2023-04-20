package concept;

import java.util.HashSet;
import java.util.Set;

public class RoomCoordinate {
    private static Set<Coordinate> coordinates = new HashSet<>();
    private final Coordinate coordinate;
    private final String name;

    public RoomCoordinate(int x, int y, String name) throws IllegalArgumentException {
        coordinate = new Coordinate(x, y);
        if (!coordinates.add(coordinate)) {
            throw new IllegalArgumentException(String.format("Coordinate (%d,%d) already in use, \"%s\" must be unique.", x, y, name));
        }
        this.name = name;
        System.out.printf("Created RoomCoordinate \"%s\"(%d,%d)\n", name, x, y);
    }

    public boolean isAdjacent(RoomCoordinate otherRoomCoordinate) {
        var otherCoordinate = otherRoomCoordinate.getCoordinate();
        return ((coordinate.x == (otherCoordinate.x - 1)) && (coordinate.y == otherCoordinate.y)) ||
                ((coordinate.x == (otherCoordinate.x + 1)) && (coordinate.y == otherCoordinate.y)) ||
                ((coordinate.y == (otherCoordinate.y - 1)) && (coordinate.x == otherCoordinate.x)) ||
                ((coordinate.y == (otherCoordinate.y + 1)) && (coordinate.x == otherCoordinate.x));
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public record Coordinate(int x, int y) {
    }
}
