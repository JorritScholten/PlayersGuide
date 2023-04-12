package game;

public class TicTacToe {
    private TileState[] board = {
            TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
            TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
            TileState.EMPTY, TileState.EMPTY, TileState.EMPTY
    };

    public void printBoard() {
        System.out.printf(" %c | %c | %c \n",
                board[0].charRepresentation,
                board[1].charRepresentation,
                board[2].charRepresentation);
        System.out.printf("---|---|---\n");
        System.out.printf(" %c | %c | %c \n",
                board[3].charRepresentation,
                board[4].charRepresentation,
                board[5].charRepresentation);
        System.out.printf("---|---|---\n");
        System.out.printf(" %c | %c | %c \n",
                board[6].charRepresentation,
                board[7].charRepresentation,
                board[8].charRepresentation);
    }

    public void printNumberedBoard() {
        System.out.printf("1%c |2%c |3%c \n",
                board[0].charRepresentation,
                board[1].charRepresentation,
                board[2].charRepresentation);
        System.out.printf("---|---|---\n");
        System.out.printf("4%c |5%c |6%c \n",
                board[3].charRepresentation,
                board[4].charRepresentation,
                board[5].charRepresentation);
        System.out.printf("---|---|---\n");
        System.out.printf("7%c |8%c |9%c \n",
                board[6].charRepresentation,
                board[7].charRepresentation,
                board[8].charRepresentation);
    }

    public void printWhichTurn() {
        int turns = 0;
        for (TileState tile : board) {
            turns = tile != TileState.EMPTY ? turns + 1 : turns;
        }
        System.out.printf("It is currently %c's turn.\n", (turns % 2 == 0) ? 'X' : 'O');
    }

    /**
     * Place next mark in the game, X goes first.
     * @param position location on the board of where to place the next mark.
     * @return false if position already occupied.
     */
    public boolean commitMove(int position) {
        if (position < 1 || position > 9) {
            throw new IllegalArgumentException("position should be between 1 and 9");
        }
        if (board[position - 1] != TileState.EMPTY) {
            return false;
        } else {
            int turns = 0;
            for (TileState tile : board) {
                turns = tile != TileState.EMPTY ? turns + 1 : turns;
            }
            board[position - 1] = (turns % 2 == 0) ? TileState.CROSS : TileState.CIRCLE;
            return true;
        }
    }

    public boolean getGameComplete() {
        // check if a player has won
        if (testPlayer(TileState.CIRCLE) || testPlayer(TileState.CROSS)) {
            return true;
        }
        // if no player has won yet, check if another action can be taken
        for (TileState tile : board) {
            if (tile == TileState.EMPTY) {
                return false;
            }
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
            if (board[i] == player && board[3 + i] == player && board[6 + i] == player) {
                return true;
            }
            //horizontal rows
            if (board[i * 3] == player && board[1 + (i * 3)] == player && board[2 + (i * 3)] == player) {
                return true;
            }
        }
        //diagonal rows
        if (board[0] == player && board[4] == player && board[8] == player) {
            return true;
        } else if (board[2] == player && board[4] == player && board[6] == player) {
            return true;
        }
        return false;
    }

    private enum TileState {
        EMPTY(' '),
        CROSS('X'),
        CIRCLE('O');
        public final char charRepresentation;

        TileState(char charRepresentation) {
            this.charRepresentation = charRepresentation;
        }
    }
}
