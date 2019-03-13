package Project3;

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
		//  XUE : ignore because it is inherited
		// AMELA: updated after lecture

		boolean valid = false;

		// check if space exists
		if (board[move.fromRow][move.fromColumn] != null)
			//if (board[move.fromRow][move.fromColumn].isValidMove(move, board))
				valid = true;

		return valid;

		// AMELA: need to figure out distinction between ChessPiece and ChessModel
	}

	// return true if boards are different
	public boolean compareBoard(Move move) {
		return false;
	}

	// AMELA:

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
}