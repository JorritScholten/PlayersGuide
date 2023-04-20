import game.TicTacToe;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 28.");
        test();
        System.exit(0);
        TicTacToe game = new TicTacToe();
        game.printNumberedBoard();
        do {
            game.printWhichTurn();
            int position;
            do {
                position = TerminalInteraction.chooseIntInRange("Enter the next move by indicating its " +
                        "position, prompt will be repeated if position is already taken", 1, 9);
            } while (!game.commitMove(position));
            game.printNumberedBoard();
        } while (!game.getGameComplete());
        System.out.println("\n\nGame has completed.");
        if (game.getWinnerIsO()) {
            System.out.println("O is the winner.");
        } else if (game.getWinnerIsX()) {
            System.out.println("X is the winner.");
        } else {
            System.out.println("Game has drawn.");
        }
        game.printBoard();
    }

    private static void test() {
        System.out.println("\nrequesting unspecified amount of ints:");
        var arr = TerminalInteraction.askForInts("input multiple ints, space separated:", " ");
        for (var i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();

        System.out.println("\nrequesting 5 ints:");
        var arr2 = TerminalInteraction.askForInts("input multiple ints, space separated:", " ", 5);
        for (var i : arr2) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
