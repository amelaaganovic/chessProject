package chess;

// Assume all comments were done by XUE unless otherwise stated
import java.lang.Math;

/*****************************************************************
 * A King piece in a chess game.
 *
 * @author Xue Ha
 * @version Winter 2019
 *****************************************************************/
public class King extends ChessPiece {

	/*****************************************************************
	 * Constructor for the king piece
	 *
	 * @param player the player
	 *****************************************************************/
	public King(Player player) {
		super(player);
	}

	/*****************************************************************
	 * Returns the type of chess piece the piece is
	 *
	 * @return king
	 *****************************************************************/
	public String type() {
		return "King";
	}

	/*****************************************************************
	 * Determining valid moves for the selected king piece
	 *
	 * @param move the move
	 * @param board the chest board
	 * @return true if move is valid
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		boolean valid = false;

		System.out.print("...moving KING" +Math.abs(move.fromRow - move.toRow));

			// MOVING FORWARD //
			if (player() == Player.BLACK)
				if (Math.abs(move.fromRow - move.toRow) == 0 || Math.abs(move.fromRow - move.toRow) == 1) {
					if (Math.abs(move.toColumn - move.fromColumn) == 1 || (move.toColumn - move.fromColumn) == 0) {
						if(board[move.toRow][move.toColumn] == null ||
								board[move.toRow][move.toColumn].player() == Player.WHITE ) {
							valid = true;
							System.out.println("...moving 1 space...successful");
						}
					}
				}
			if (player() == Player.WHITE)
				if (Math.abs(move.fromRow - move.toRow) == 0 || Math.abs(move.fromRow - move.toRow) == 1) {
					if (Math.abs(move.toColumn - move.fromColumn) == 1 || (move.toColumn - move.fromColumn) == 0) {
						if(board[move.toRow][move.toColumn] == null||
								board[move.toRow][move.toColumn].player() == Player.BLACK) {
							valid = true;
							System.out.println("...moving 1 space...successful");
						}
					}
				}
		if(move.fromRow == move.toRow && move.fromColumn == move.toColumn)
			valid = false;
		if(!valid)
			System.out.println("... invalid move");
		return valid ;
	}
}
