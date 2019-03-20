package ChessVersion2;

public abstract class ChessPiece implements IChessPiece {

    private Player owner;

    protected ChessPiece(Player player) {
        this.owner = player;
    }

    public abstract String type();

    public Player player() {
        return owner;
    }



    public boolean isValidMove(Move move, IChessPiece[][] board) {
        // Check turn
        if (move.toRow >= 8 || move.toColumn >= 8)
            return false;
        if (move.toRow == move.fromRow && move.toColumn == move.fromColumn)
            return false;
        if (board[move.toRow][move.toColumn] != null &&
                board[move.toRow][move.toColumn].player().equals(player()))
            return false;

        return true;
    }




    // return true if boards are different
    public boolean compareBoard(Move move) {
        return false;
    }
}
