package Project3;

public class Bishop extends ChessPiece {

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

	/*****************************************************************
	 * Determining valid moves for the selected bishop piece
	 * @param move the move
	 * @param board the chess board
	 * @return true if move is valid
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = false;

		for (int x = 1; x < 8; x++){
			if (move.fromRow == move.toRow + x || move.fromRow == move.toRow - x)
				if (move.fromColumn == move.toColumn + x || move.fromColumn == move.toColumn - x) {
					// if statements can probably be simplified FIXME
					valid = true;
					System.out.println("Moving BISHOP");
				}
		}

		if (valid == false)
			System.out.println("Invalid move for BISHOP");

		return valid;
	}
}
