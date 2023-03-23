import item.Point;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 23.");
        Point[] points = {new Point(), new Point(2, 3), new Point(-4, 0)};
        for (Point point : points) {
            System.out.println(point);
        }
    }
}
