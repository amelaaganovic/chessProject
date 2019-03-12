package Project3;

public class Pawn extends ChessPiece {

    /* Checks if this is Pawn's first move */

    private boolean firstMove;

    public Pawn(Player player, boolean firstMove) {
        super(player);
        this.firstMove = firstMove;
    }

    public String type() {
        return "Pawn";
    }

    // determines if the move is valid for a pawn piece

    public boolean isValidMove(Move move, IChessPiece[][] board) {

        boolean valid = false;

        System.out.print("...moving PAWN");

        if (super.isValidMove(move, board)) { // AMELA

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
                            valid = true;
                            System.out.println("...1 space... SUCCESS");
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
                            valid = true;
                            System.out.println("...1 space... SUCCESS");
                        }
                    }
            }

            // MOVING TO CAPTURE //

            if (ifCapture(move))
                valid = true;

            if (!valid)
                System.out.println("...invalid move!");
        }

        return valid;

    }

    private boolean ifCapture(Move move) {

        if (player() == Player.BLACK) {
            if (move.toRow == move.fromRow + 1)
                if ((move.toColumn == move.fromColumn - 1) || (move.toColumn == move.fromColumn + 1)) {
                    if (ChessModel.board[move.toRow][move.toColumn] != null) {
                        return true;
                    }
                }
        }

        if (player() == Player.WHITE) {
            if (move.toRow == move.fromRow - 1)
                if ((move.toColumn == move.fromColumn - 1) || (move.toColumn == move.fromColumn + 1)) {
                    if (ChessModel.board[move.toRow][move.toColumn] != null) {
                        return true;
                    }
                }
        }
        return false;
    }


}
