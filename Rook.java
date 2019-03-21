package ChessVersion3;

public class Rook extends ChessPiece {

    private int occupiedPlayer;
    public boolean moved;

    public Rook(Player player) {

        super(player);
        moved = false;

    }

    public String type() {

        return "Rook";

    }

    public boolean hasMoved() {
        return moved;
    }

    public void setHasMoved(boolean setMoved) {
        moved = setMoved;
    }

    // determines if the move is valid for a rook piece
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = false;

        if (super.isValidMove(move, board)) {

            occupiedPlayer = 0;

            if (Math.abs(move.toRow - move.fromRow) > 0 && move.toColumn - move.fromColumn == 0
                    && (!isOccupied(move, board) || occupiedPlayer == 1)) {
                valid = true;
                moved = true;
            }
            if (Math.abs(move.toColumn - move.fromColumn) > 0 && move.toRow - move.fromRow == 0
                    && (!isOccupied(move, board) || occupiedPlayer == 1)) {
                valid = true;
                moved = true;
            }

        }

        return valid;

    }

    private boolean isOccupied(Move move, IChessPiece[][] board) {
        boolean occupied = false;
        int occupation = 0;

        if (move.toRow == move.fromRow) {
            if (move.toColumn < move.fromColumn) {
                for (int c = move.fromColumn-1; c >= move.toColumn; c--) {
                    if (board[move.toRow][c] != null) {
                        occupied = true;
                        occupation++;
                    }
                }
            }
            else {
                for (int c = move.fromColumn+1; c <= move.toColumn; c++) {
                    if (board[move.toRow][c] != null) {
                        occupied = true;
                        occupation++;
                    }
                }
            }
        }

        if (move.toColumn == move.fromColumn) {
            if (move.toRow < move.fromRow) {
                for (int r = move.fromRow-1; r >= move.toRow; r--) {
                  if (board[r][move.toColumn] != null) {
                      occupied = true;
                      occupation++;
                  }
                }
            }
            else {
                for (int r = move.fromRow+1; r <= move.toRow; r++) {
                    if (board[r][move.toColumn] != null) {
                        occupied = true;
                        occupation++;
                    }
                }
            }
        }

        if (board[move.toRow][move.toColumn] != null && board[move.toRow]
                [move.toColumn].player().equals(player().next()) && occupation == 1)
            occupiedPlayer = 1;

        return occupied;
    }

}
