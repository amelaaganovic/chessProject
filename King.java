package ChessVersion5;

/**********************************************************************
 * Class that handles game manipulation of king.
 *
 * @author Xue Hua
 * @version Winter 2019
 *********************************************************************/
public class King extends ChessPiece {

    /** Checks if king has moved */
    public boolean moved;

    /*****************************************************************
     * Constructor for the king piece
     *
     * @param player the current player.
     *****************************************************************/
    public King(Player player) {
        super(player);
        moved = false;
    }

    /*****************************************************************
     * Returns the type of chess piece the piece is as a String
     *
     * @return "King"
     *****************************************************************/
    public String type() {
        return "King";
    }

    /*****************************************************************
     * Returns if king has moved
     *
     * @return true if piece has moved, false if piece has not moved.
     *****************************************************************/
    public boolean hasMoved() {
        return moved;
    }

    /*****************************************************************
     * Helper method to set move state of piece
     *
     * @param setMoved boolean argument to set state of piece.
     *****************************************************************/
    public void setHasMoved(boolean setMoved) {
        moved = setMoved;
    }

    /*****************************************************************
     * Determining valid moves for the selected piece
     *
     * @param move the move
     * @param board the chess board
     * @return true if move is valid, false if move is invalid
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = false;

        if (super.isValidMove(move, board)) {
            // MOVING FORWARD //
            if (player() == Player.BLACK)
                if (Math.abs(move.fromRow - move.toRow) == 0 ||
                        Math.abs(move.fromRow - move.toRow) == 1) {
                    if (Math.abs(move.toColumn - move.fromColumn) == 1
                            || (move.toColumn - move.fromColumn) == 0) {
                        if (board[move.toRow][move.toColumn] == null ||
                                board[move.toRow][move.toColumn]
                                        .player() == Player.WHITE) {
                            valid = true;
                            moved = true;
                        }
                    }
                }
            if (player() == Player.WHITE)
                if (Math.abs(move.fromRow - move.toRow) == 0 ||
                        Math.abs(move.fromRow - move.toRow) == 1) {
                    if (Math.abs(move.toColumn - move.fromColumn) == 1
                            || (move.toColumn - move.fromColumn) == 0) {
                        if (board[move.toRow][move.toColumn] == null ||
                                board[move.toRow][move.toColumn]
                                        .player() == Player.BLACK) {
                            valid = true;
                            moved = true;
                        }
                    }
                }
            if (move.fromRow == move.toRow && move.fromColumn ==
                    move.toColumn)
                valid = false;

        }

        return valid ;
    }
}
