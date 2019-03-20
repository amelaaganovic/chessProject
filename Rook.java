package chess;

/*****************************************************************
 * A rook piece in a chess game.
 *
 * @author Emily Linderman
 * @version Winter 2019
 *****************************************************************/
public class Rook extends ChessPiece {

	/* player that is occupying */ //FIXME i don't know if this description is accurate
	private int occupiedPlayer;

	/*****************************************************************
	 * Constructor for the rook piece
	 *
	 * @param player the player
	 *****************************************************************/
	public Rook(Player player) {
		super(player);
	}

	/*****************************************************************
	 * Returns the type of chess piece the piece is
	 *
	 * @return rook
	 *****************************************************************/
	public String type() {
		return "Rook";
	}

	/*****************************************************************
	 * Determining valid moves for the selected queen piece
	 *
	 * @param move the move
	 * @param board the chest board
	 * @return true if move is valid
	 *****************************************************************/
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		super.isValidMove(move, board);
		boolean valid = false;

		System.out.print("moving Rook... ");
		occupiedPlayer = 0;

		if (Math.abs(move.toRow-move.fromRow) > 0 && move.toColumn - move.fromColumn == 0
				&& (!isOccupied(move, board) || occupiedPlayer == 1)) {
			valid = true;
			System.out.println("Successful ");
		}
		else if (Math.abs(move.toColumn - move.fromColumn) > 0 && move.toRow - move.fromRow == 0
				&& (!isOccupied(move, board) || occupiedPlayer == 1)) {
			valid = true;
			System.out.println("Successful ");
		}

		if (!valid)
			System.out.println("Failure");

		return valid;

	}

	/*****************************************************************
	 * Checks if a rook is blocked in its path or not.
	 *
	 * @param move the move being attempted
	 * @param board the board
	 * @return true if rook is blocked
	 *****************************************************************/
	public boolean isOccupied(Move move, IChessPiece[][] board) {
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