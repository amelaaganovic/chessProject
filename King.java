package ChessVersion4;

// Assume all comments were done by XUE unless otherwise stated
import java.lang.Math;
public class King extends ChessPiece {
    public boolean moved;

    public King(Player player) {
        super(player);
        moved = false;
    }

    public String type() {
        return "King";
    }

    public boolean hasMoved() {
        return moved;
    }

    public void setHasMoved(boolean setMoved) {
        moved = setMoved;
    }


    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = false;

        System.out.print("...moving KING" +Math.abs(move.fromRow - move.toRow));

        if (super.isValidMove(move, board)) {
            // MOVING FORWARD //
            if (player() == Player.BLACK)
                if (Math.abs(move.fromRow - move.toRow) == 0 || Math.abs(move.fromRow - move.toRow) == 1) {
                    if (Math.abs(move.toColumn - move.fromColumn) == 1 || (move.toColumn - move.fromColumn) == 0) {
                        if (board[move.toRow][move.toColumn] == null ||
                                board[move.toRow][move.toColumn].player() == Player.WHITE) {
                            valid = true;
                            moved = true;
                            System.out.println("...moving 1 space...successful");
                        }
                    }
                }
            if (player() == Player.WHITE)
                if (Math.abs(move.fromRow - move.toRow) == 0 || Math.abs(move.fromRow - move.toRow) == 1) {
                    if (Math.abs(move.toColumn - move.fromColumn) == 1 || (move.toColumn - move.fromColumn) == 0) {
                        if (board[move.toRow][move.toColumn] == null ||
                                board[move.toRow][move.toColumn].player() == Player.BLACK) {
                            valid = true;
                            moved = true;
                            System.out.println("...moving 1 space...successful");
                        }
                    }
                }
            if (move.fromRow == move.toRow && move.fromColumn == move.toColumn)
                valid = false;
            if (!valid)
                System.out.println("... invalid move");
        }
        return valid ;
    }
}
