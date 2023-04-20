import concept.RoomCoordinate;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 36.");

        System.out.println("\ntesting coordinate creation and print information:");
        var origin = new RoomCoordinate(0, 0, "origin");
        System.out.println("Created " + origin);
        var coordinate1 = new RoomCoordinate(1, 2, "room 1");
        System.out.println("Created " + coordinate1);
        var coordinate2 = new RoomCoordinate(0, 1, "room 2");
        System.out.println("Created " + coordinate2);
        var coordinate3 = new RoomCoordinate(1, 1, "room 3");
        System.out.println("Created " + coordinate3);
        var coordinate4 = new RoomCoordinate(0, -1, "room 4");
        System.out.println("Created " + coordinate4);

        System.out.println("\ntesting coordinate adjacency and print results:");
        compareCoordinates(origin, coordinate1);
        compareCoordinates(origin, coordinate2);
        compareCoordinates(origin, coordinate3);
        compareCoordinates(coordinate2, coordinate3);
        compareCoordinates(origin, coordinate4);
        compareCoordinates(coordinate3, coordinate4);

        System.out.println("\ntest creation of duplicate coordinate, " +
                "program should raise Exception and stop before printing information:");
        var newOrigin = new RoomCoordinate(0, 0, "new origin");
        System.out.println("Created " + newOrigin);
    }

    private static void compareCoordinates(RoomCoordinate coordinate1, RoomCoordinate coordinate2) {
        if (coordinate1.isAdjacent(coordinate2)) {
            System.out.printf("\033[32m%s and %s are adjacent.\033[0m\n",
                    coordinate1.getName(), coordinate2.getName());
        } else {
            System.out.printf("\033[31m%s and %s are not adjacent.\033[0m\n",
                    coordinate1.getName(), coordinate2.getName());
        }
    }
}
