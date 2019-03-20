package chess;

/*****************************************************************
 * A Queen piece in a chess game.
 *
 * @author Emily Linderman
 * @version Winter 2019
 *****************************************************************/
public class Queen extends ChessPiece {

	/*****************************************************************
	 * Constructor for the queen piece
	 *
	 * @param player the player
	 *****************************************************************/
	public Queen(Player player) {
		super(player);
	}

	/*****************************************************************
	 * Returns the type of chess piece the piece is
	 *
	 * @return queen
	 *****************************************************************/
	public String type() {
		return "Queen";
	}

	/*****************************************************************
	 * Determining valid moves for the selected queen piece
	 *
	 * @param move the move
	 * @param board the chest board
	 * @return true if move is valid
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		System.out.print("moving Queen ");

		// queen follows bishop and rook's rules combined
		Bishop move1 = new Bishop(board[move.fromRow][move.fromColumn].player());
		Rook move2 = new Rook(board[move.fromRow][move.fromColumn].player());

		if (move.toRow == move.fromRow || move.toColumn == move.fromColumn)
			return move2.isValidMove(move, board);
		else
			return move1.isValidMove(move,board);
	}
}