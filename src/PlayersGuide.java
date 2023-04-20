import game.TicTacToe;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 28.");
        TicTacToe game = new TicTacToe();
        System.out.print(game.getBoard(true));
        do {
            game.printWhichTurn();
            int[] position;
            do {
                position = TerminalInteraction.askForInts("Enter the next move by indicating its " +
                        "position as a space separated XY coordinate," +
                        " prompt will be repeated if position is already taken: ", " ", 2);
            } while (!game.commitMove(position[0], position[1]));
            System.out.print(game.getBoard(true));
        } while (!game.getGameComplete());
        System.out.println("\n\nGame has completed.");
        if (game.getWinnerIsO()) {
            System.out.println("O is the winner.");
        } else if (game.getWinnerIsX()) {
            System.out.println("X is the winner.");
        } else {
            System.out.println("Game has drawn.");
        }
        System.out.print(game.getBoard(false));
    }
}
