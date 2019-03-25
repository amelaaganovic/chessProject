package ChessVersion5;

/**********************************************************************
 * Class that handles game manipulation of queen.
 *
 * @author Emily Linderman
 * @version Winter 2019
 *********************************************************************/
public class Queen extends ChessPiece {

    /** Checks if queen has moved */
    public boolean moved;

    /*****************************************************************
     * Constructor for the queen piece.
     *
     * @param player the current player.
     *****************************************************************/
    public Queen(Player player) {
        super(player);

    }

    /*****************************************************************
     * Returns the type of chess piece the piece is as a String.
     *
     * @return "Queen"
     *****************************************************************/
    public String type() {
        return "Queen";
    }

    /*****************************************************************
     * Returns if queen has moved.
     *
     * @return true if piece has moved, false if piece has not moved
     *****************************************************************/
    public boolean hasMoved() {
        return false;
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
     * Determining valid moves for the selected piece, calls on Rook
     * and Bishop to determine.
     *
     * @param move the move
     * @param board the chess board
     * @return true if move is valid, false if move is invalid
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        System.out.print("moving Queen ");

        if (super.isValidMove(move, board)) {
            Bishop move1 = new Bishop(board[move.fromRow]
                    [move.fromColumn].player());
            Rook move2 = new Rook(board[move.fromRow][move.fromColumn]
                    .player());

            if (move.toRow == move.fromRow || move.toColumn ==
                    move.fromColumn)
                return move2.isValidMove(move, board);
            else
                return move1.isValidMove(move, board);
        }
        return false;
    }
}
