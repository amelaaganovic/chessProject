package chess;

/**********************************************************************
 * A class that contains the functionality of a chess piece.
 *
 * @author Amela Aganovic, Emily Linderman, Xue Hua
 * @version Winter 2019
 **********************************************************************/
public abstract class ChessPiece implements IChessPiece {

    /* the player */
    private Player owner;

    /*****************************************************************
     * Constructor for the chess piece
     *
     * @param player the player
     *****************************************************************/
    protected ChessPiece(Player player) {
        this.owner = player;
    }

    /*****************************************************************
     * Returns the type of chess piece the piece is
     *****************************************************************/
    public abstract String type();

    /*****************************************************************
     * Returns the player using the piece
     *
     * @return the piece's player
     *****************************************************************/
    public Player player() {
        return owner;
    }

    /*****************************************************************
     * Checks if the piece's move is valid
     *
     * @param move the move being attempted
     * @board the chess board
     * @return true if move is valid
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        // Check turn
        if (move.toRow >= 8 || move.toColumn >= 8)
            return false;
        if (move.toRow == move.fromRow && move.toColumn == move.fromColumn)
            return false;
        if (board[move.toRow][move.toColumn] != null &&
                !board[move.toRow][move.toColumn].player().equals(player().next()))
            return false;

        return true;
    }

    /*****************************************************************
     * Compares boards
     *
     * @param move the move
     * @return true if the boards are different
     *****************************************************************/
    public boolean compareBoard(Move move) {
        // return true if boards are different
            // FIXME not sure what this method is for
        return false;
    }
}
