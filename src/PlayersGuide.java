import concept.RoomCoordinate;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 36.");
        var origin = new RoomCoordinate(0, 0, "origin");
        var coordinate1 = new RoomCoordinate(1, 2, "room 1");
        var coordinate2 = new RoomCoordinate(0, 1, "room 2");
        var coordinate3 = new RoomCoordinate(1, 1, "room 3");
        compareCoordinates(origin, coordinate1);
        compareCoordinates(origin, coordinate2);
        compareCoordinates(origin, coordinate3);
        compareCoordinates(coordinate2, coordinate3);
        var newOrigin = new RoomCoordinate(0, 0, "new origin");
    }

    private static void compareCoordinates(RoomCoordinate coordinate1, RoomCoordinate coordinate2) {
        if (coordinate1.isAdjacent(coordinate2)) {
            System.out.printf("%s and %s are adjacent.\n", coordinate1.getName(), coordinate2.getName());
        } else {
            System.out.printf("\033[31m%s and %s are not adjacent.\033[0m\n", coordinate1.getName(), coordinate2.getName());
        }
    }
}
