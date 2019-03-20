package chess;
// Assume all comments were done by XUE unless otherwise stated

/*****************************************************************
 * A pawn piece in a chess game.
 *
 * @author Xue Ha
 * @version Winter 2019
 *****************************************************************/
public class Pawn extends ChessPiece {

    /* Checks if this is Pawn's first move */
    private boolean firstMove;

    /*****************************************************************
     * Constructor for the pawn piece
     *
     * @param player the player
     * @param firstMove whether or not it is the pawn's first move
     *****************************************************************/
    public Pawn(Player player, boolean firstMove) {
        super(player);
        this.firstMove = firstMove;
    }

    /*****************************************************************
     * Returns the type of chess piece the piece is
     *
     * @return king
     *****************************************************************/
    public String type() {
        return "Pawn";
    }

    /*****************************************************************
     * Determining valid moves for the selected king piece
     *
     * @param move the move
     * @param board the chest board
     * @return true if move is valid
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = false;

        System.out.print("...moving PAWN");

        //  MOVING FORWARD //
        if (move.toColumn == move.fromColumn) {
            if (player() == Player.WHITE)
                if (firstMove) {    // move 2 spaces if want to
                    if ((move.toRow == move.fromRow - 1) || (move.toRow == move.fromRow - 2)) {
                        valid = true;
                        System.out.println("...2 spaces... SUCCESS");
                    }
                    firstMove = false;      // disables the flag for remaining of the game
                } else {        // move once each time
                    if (move.toRow == move.fromRow - 1) {
                        if(board[move.toRow][move.toColumn] == null) {
                            valid = true;
                            System.out.println("...1 space... SUCCESS");
                        }
                    }
                }

            if (player() == Player.BLACK)
                if (firstMove) {
                    if ((move.toRow == move.fromRow + 1) || (move.toRow == move.fromRow + 2)) {
                        valid = true;
                        System.out.println("...2 spaces... SUCCESS");
                    }
                    firstMove = false;
                } else {
                    if (move.toRow == move.fromRow + 1) {
                        if(board[move.toRow][move.toColumn] == null) {
                            valid = true;
                            System.out.println("...1 space... SUCCESS");
                        }
                    }
                }
        }

        // MOVING TO CAPTURE //
        if (ifCapture(move, board))
            valid = true;
        if (!valid)
            System.out.println("...invalid move!");
        if(!super.isValidMove(move, board))
            valid = false;
        return valid;
    }

    private boolean ifCapture(Move move,IChessPiece[][] board) {
        if (player() == Player.BLACK) {
            if (move.toRow == move.fromRow + 1)
                if ((move.toColumn == move.fromColumn - 1) || (move.toColumn == move.fromColumn + 1)) {
                    if (board[move.toRow][move.toColumn] != null &&
                            board[move.toRow][move.toColumn].player() == Player.WHITE) {
                        return true;
                    }
                }
        }
        if (player() == Player.WHITE) {
            if (move.toRow == move.fromRow - 1)
                if ((move.toColumn == move.fromColumn - 1) || (move.toColumn == move.fromColumn + 1)) {
                    if (board[move.toRow][move.toColumn] != null &&
                            board[move.toRow][move.toColumn].player() == Player.BLACK) {
                        return true;
                    }
                }
        }
        return false;
    }
}
