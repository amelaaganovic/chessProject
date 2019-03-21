package ChessVersion3;
/*****************************************************************
 * A Knight piece in a chess game.
 *
 * @author Amela Aganovic
 * @version Winter 2019
 *****************************************************************/
public class Knight extends ChessPiece {
    public boolean moved;

    // AMELA: I'll make the comments better later

    /*****************************************************************
     * Constructor for the knight piece
     *
     * @param player the current player
     *****************************************************************/
    public Knight(Player player) {
        super(player);
    }

    /*****************************************************************
     * Returns the type of chess piece the piece is
     *
     * @return knight
     *****************************************************************/
    public String type() {
        return "Knight";
    }

    public boolean hasMoved() {
        return false;
    }

    public void setHasMoved(boolean setMoved) {
        moved = setMoved;
    }


    /*****************************************************************
     * Determining valid moves for the selected knight piece
     * @param move the move
     * @param board the chest board
     * @return true if move is valid
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board){

        boolean valid = false;
        if(super.isValidMove(move,board)) {
            System.out.println("... moving KNIGHT");

            // MOVING TWO VERTICALLY ONE HORIZONTALLY
            if (move.toColumn == move.fromColumn + 1 || move.toColumn == move.fromColumn - 1) {
                if (move.toRow == move.fromRow + 2 || move.toRow == move.fromRow - 2) {
                    valid = true;
                    System.out.println("... SUCCESS");
                }
            }

            // MOVING ONE VERTICALLY TWO HORIZONTALLY
            if (move.toColumn == move.fromColumn + 2 || move.toColumn == move.fromColumn - 2) {
                if (move.toRow == move.fromRow + 1 || move.toRow == move.fromRow - 1) {
                    valid = true;
                    System.out.println("... SUCCESS");
                }
            }
        }
        return valid;
    }
}
