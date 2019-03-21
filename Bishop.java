package ChessVersion3;

public class Bishop extends ChessPiece {
    public boolean moved;

    /*****************************************************************
     * Constructor for the bishop piece
     *
     * @param player the current player
     *****************************************************************/
    public Bishop(Player player) {
        super(player);
    }

    /*****************************************************************
     * Returns the type of chess piece the piece is
     *
     * @return bishop
     *****************************************************************/
    public String type() {
        return "Bishop";
    }

    public boolean hasMoved() {
        return false;
    }

    public void setHasMoved(boolean setMoved) {
        moved = setMoved;
    }


    /*****************************************************************
     * Determining valid moves for the selected bishop piece
     * @param move the move
     * @param board the chess board
     * @return true if move is valid
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = false;

        if (super.isValidMove(move, board)) {

            for (int x = 1; x < 8; x++) {
                //if (move.fromRow == move.toRow + x || move.fromRow == move.toRow - x)
                if (Math.abs(move.fromRow - move.toRow) == x)
                    if (Math.abs(move.fromColumn - move.toColumn) == x) {
                        if (!isOccupied(move, board)) {
                            valid = true;
                            System.out.println("Moving BISHOP");
                        }
                    }
            }

            if (valid == false)
                System.out.println("Invalid move for BISHOP");
        }

        return valid;
    }

    private boolean isOccupied(Move move, IChessPiece[][] board) {
        int row = move.fromRow;
        int col = move.fromColumn;
        int origRow = row;
        int origCol = col;

        if (move.toRow < origRow && move.toColumn < origCol) {
            while (row-1 > move.toRow && col-1 > move.toColumn) {
                row--;
                col--;
                if (board[row][col] != null)
                    return true;
            }
        }

        if (move.toRow < origRow && move.toColumn > origCol) {
            while (row-1 > move.toRow && col+1 < move.toColumn) {
                row--;
                col++;
                if (board[row][col] != null)
                    return true;
            }
        }

        if (move.toRow > origRow && move.toColumn < origCol) {
            while (row+1 < move.toRow && col-1 > move.toColumn) {
                row++;
                col--;
                if (board[row][col] != null)
                    return true;
            }
        }


        if (move.toRow > origRow && move.toColumn > origCol) {
            while (row+1 < move.toRow && col+1 < move.toColumn) {
                row++;
                col++;
                if (board[row][col] != null)
                    return true;
            }
        }

        return false;
    }

}