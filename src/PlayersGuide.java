import game.TicTacToe;
import util.TerminalInteraction;

public class PlayersGuide {
    public static void main(String[] args) {
        System.out.println("Starting up Player's Guide, Day 28.");
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
}
