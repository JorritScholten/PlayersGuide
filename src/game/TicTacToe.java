package game;

import java.util.Arrays;

public class TicTacToe {
    private final TileState[][] board = {
            {TileState.EMPTY, TileState.EMPTY, TileState.EMPTY},
            {TileState.EMPTY, TileState.EMPTY, TileState.EMPTY},
            {TileState.EMPTY, TileState.EMPTY, TileState.EMPTY}
    };

    /**
     * Get representation of board as printable String.
     * @param numberAxis Label axis with numbers for XY coordinates.
     * @return String representation of board.
     */
    public String getBoard(boolean numberAxis) {
        return String.format("%10$s" +
                        "%11$s %1$s | %2$s | %3$s \n" +
                        "%14$s---|---|---\n" +
                        "%12$s %4$s | %5$s | %6$s \n" +
                        "%14$s---|---|---\n" +
                        "%13$s %7$s | %8$s | %9$s \n",
                board[0][0], board[1][0], board[2][0],
                board[0][1], board[1][1], board[2][1],
                board[0][2], board[1][2], board[2][2],
                numberAxis ? "Coordinates " + ANSI.COLOUR_FG_BLUE + "X " + ANSI.COLOUR_FG_YELLOW + "Y" + ANSI.COLOUR_RESET + "\n" +
                        " " + ANSI.COLOUR_BG_BLUE + " 1 | 2 | 3 " + ANSI.COLOUR_RESET + "\n" : "",
                numberAxis ? ANSI.COLOUR_BG_YELLOW + 1 + ANSI.COLOUR_RESET : "",
                numberAxis ? ANSI.COLOUR_BG_YELLOW + 2 + ANSI.COLOUR_RESET : "",
                numberAxis ? ANSI.COLOUR_BG_YELLOW + 3 + ANSI.COLOUR_RESET : "",
                numberAxis ? ANSI.COLOUR_BG_YELLOW + "-" + ANSI.COLOUR_RESET : ""
        );
    }

    public void printWhichTurn() {
        long turns = Arrays.stream(board).flatMap(Arrays::stream).filter(t -> t != TileState.EMPTY).count();
        System.out.printf("It is currently %s's turn.\n", (turns % 2 == 0) ? TileState.CROSS : TileState.CIRCLE);
    }

    /**
     * Place next mark in the game, X goes first.
     * @param x X coordinate on the board of where to place the next mark.
     * @param y Y coordinate on the board of where to place the next mark.
     * @return false if position already occupied.
     */
    public boolean commitMove(int x, int y) {
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            throw new IllegalArgumentException("Coordinate out of bounds.");
        }
        if (board[y - 1][x - 1] != TileState.EMPTY) {
            return false;
        } else {
            long turns = Arrays.stream(board).flatMap(Arrays::stream).filter(t -> t != TileState.EMPTY).count();
            board[y - 1][x - 1] = (turns % 2 == 0) ? TileState.CROSS : TileState.CIRCLE;
            return true;
        }
    }

    public boolean getGameComplete() {
        // check if a player has won
        if (testPlayer(TileState.CIRCLE) || testPlayer(TileState.CROSS)) {
            return true;
        }
        // if no player has won yet, check if another action can be taken
        if (Arrays.stream(board).flatMap(Arrays::stream).anyMatch(t -> t == TileState.EMPTY)) {
            return false;
        }
        // game is gridlocked thus resulting in a draw
        return true;
    }

    public boolean getWinnerIsX() {
        return testPlayer(TileState.CROSS);
    }

    public boolean getWinnerIsO() {
        return testPlayer(TileState.CIRCLE);
    }

    private boolean testPlayer(TileState player) {
        for (int i = 0; i < 3; i++) {
            //vertical rows
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
            //horizontal rows
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        //diagonal rows
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        } else if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        }
        return false;
    }

    private enum TileState {
        EMPTY(" "),
        CROSS("X"),
        CIRCLE("O");
        private final String charRepresentation;

        TileState(String charRepresentation) {
            this.charRepresentation = charRepresentation;
        }

        @Override
        public String toString() {
            return charRepresentation;
        }
    }

    private class ANSI {
        static private final String ESCAPE = "\033[";
        static private final String FG_COLOUR = "3";
        static private final String BG_COLOUR = "4";
        static private final String COLOUR_END = "m";
        static public final String COLOUR_RESET = ESCAPE + 0 + COLOUR_END;
        static private final int COLOUR_8BIT_BLACK = 0;
        static public final String COLOUR_FG_BLACK = ESCAPE + FG_COLOUR + COLOUR_8BIT_BLACK + COLOUR_END;
        static public final String COLOUR_BG_BLACK = ESCAPE + BG_COLOUR + COLOUR_8BIT_BLACK + COLOUR_END;
        static private final int COLOUR_8BIT_RED = 1;
        static public final String COLOUR_FG_RED = ESCAPE + FG_COLOUR + COLOUR_8BIT_RED + COLOUR_END;
        static public final String COLOUR_BG_RED = ESCAPE + BG_COLOUR + COLOUR_8BIT_RED + COLOUR_END;
        static private final int COLOUR_8BIT_GREEN = 2;
        static public final String COLOUR_FG_GREEN = ESCAPE + FG_COLOUR + COLOUR_8BIT_GREEN + COLOUR_END;
        static public final String COLOUR_BG_GREEN = ESCAPE + BG_COLOUR + COLOUR_8BIT_GREEN + COLOUR_END;
        static private final int COLOUR_8BIT_YELLOW = 3;
        static public final String COLOUR_FG_YELLOW = ESCAPE + FG_COLOUR + COLOUR_8BIT_YELLOW + COLOUR_END;
        static public final String COLOUR_BG_YELLOW = ESCAPE + BG_COLOUR + COLOUR_8BIT_YELLOW + COLOUR_END;
        static private final int COLOUR_8BIT_BLUE = 4;
        static public final String COLOUR_FG_BLUE = ESCAPE + FG_COLOUR + COLOUR_8BIT_BLUE + COLOUR_END;
        static public final String COLOUR_BG_BLUE = ESCAPE + BG_COLOUR + COLOUR_8BIT_BLUE + COLOUR_END;
        static private final int COLOUR_8BIT_MAGENTA = 5;
        static public final String COLOUR_FG_MAGENTA = ESCAPE + FG_COLOUR + COLOUR_8BIT_MAGENTA + COLOUR_END;
        static public final String COLOUR_BG_MAGENTA = ESCAPE + BG_COLOUR + COLOUR_8BIT_MAGENTA + COLOUR_END;
        static private final int COLOUR_8BIT_CYAN = 6;
        static public final String COLOUR_FG_CYAN = ESCAPE + FG_COLOUR + COLOUR_8BIT_CYAN + COLOUR_END;
        static public final String COLOUR_BG_CYAN = ESCAPE + BG_COLOUR + COLOUR_8BIT_CYAN + COLOUR_END;
        static private final int COLOUR_8BIT_WHITE = 7;
        static public final String COLOUR_FG_WHITE = ESCAPE + FG_COLOUR + COLOUR_8BIT_WHITE + COLOUR_END;
        static public final String COLOUR_BG_WHITE = ESCAPE + BG_COLOUR + COLOUR_8BIT_WHITE + COLOUR_END;
        static private final int COLOUR_8BIT_DEFAULT = 9;
        static public final String COLOUR_FG_DEFAULT = ESCAPE + FG_COLOUR + COLOUR_8BIT_DEFAULT + COLOUR_END;
        static public final String COLOUR_BG_DEFAULT = ESCAPE + BG_COLOUR + COLOUR_8BIT_DEFAULT + COLOUR_END;
    }
}
