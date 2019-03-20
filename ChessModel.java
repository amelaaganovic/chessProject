package ChessVersion2;

/*	XUE :
	ChessModel.java
This class is responsible for
1. storing the chessboard
2. implementing game logic
3. implement methods from IChessModel interface
 */

import java.util.ArrayList;
public class ChessModel implements IChessModel {	 
    private IChessPiece[][] board;
	private Player player;

	private BoardState boardState;
	private ArrayList<String> deletedPiece;
	private ArrayList<Integer> previousRow;
	private ArrayList<Integer> previousColumn;
	private ArrayList<Player> capturedPlayer;
	private ArrayList<Integer> newRow;
	private ArrayList<Integer> newCol;

	// declare other instance variables as needed

	public ChessModel() {
		board = new IChessPiece[8][8];
		player = Player.WHITE;

		boardState = new BoardState(false, false, false, false,
				false, false);

		deletedPiece = new ArrayList<>();
		previousRow = new ArrayList<>();
		previousColumn = new ArrayList<>();
		capturedPlayer = new ArrayList<>();
		newRow = new ArrayList<>();
		newCol = new ArrayList<>();

		board[7][0] = new Rook(Player.WHITE);
		board[7][1] = new Knight(Player.WHITE);
		board[7][2] = new Bishop(Player.WHITE);
		board[7][3] = new Queen(Player.WHITE);
		board[7][4] = new King(Player.WHITE);
		board[7][5] = new Bishop(Player.WHITE);
		board[7][6] = new Knight (Player.WHITE);
		board[7][7] = new Rook(Player.WHITE);
		board[6][0] = new Pawn(Player.WHITE, true);
		board[6][1] = new Pawn(Player.WHITE, true);
		board[6][2] = new Pawn(Player.WHITE, true);
		board[6][3] = new Pawn(Player.WHITE, true);
		board[6][4] = new Pawn(Player.WHITE, true);
		board[6][5] = new Pawn(Player.WHITE, true);
		board[6][6] = new Pawn(Player.WHITE, true);
		board[6][7] = new Pawn(Player.WHITE, true);

		board[0][0] = new Rook(Player.BLACK);
		board[0][1] = new Knight(Player.BLACK);
		board[0][2] = new Bishop(Player.BLACK);
		board[0][3] = new Queen(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
		board[0][5] = new Bishop(Player.BLACK);
		board[0][6] = new Knight (Player.BLACK);
		board[0][7] = new Rook(Player.BLACK);
		board[1][0] = new Pawn(Player.BLACK, true);
		board[1][1] = new Pawn(Player.BLACK, true);
		board[1][2] = new Pawn(Player.BLACK, true);
		board[1][3] = new Pawn(Player.BLACK, true);
		board[1][4] = new Pawn(Player.BLACK, true);
		board[1][5] = new Pawn(Player.BLACK, true);
		board[1][6] = new Pawn(Player.BLACK, true);
		board[1][7] = new Pawn(Player.BLACK, true);

	}

	public void newGame(){

		System.out.println("NEW GAME");
		player = Player.WHITE;
		for (int r = 0; r < 8; r++) {
			if(r == 1)
				for (int c = 0; c < 8; c++) {
					setPiece(r, c, new Pawn(Player.BLACK, true));
				}
			if(r == 6)
				for (int c = 0; c < 8; c++) {
					setPiece(r, c, new Pawn(Player.WHITE, true));
				}
			if(r < 6 && r >1)
				for (int c = 0; c < 8; c++) {
					setPiece(r, c, null);
				}
		}
			setPiece(7, 0, new Rook(Player.WHITE));
			setPiece(7, 1, new Knight(Player.WHITE));
			setPiece(7, 2, new Bishop(Player.WHITE));
			setPiece(7, 3, new Queen(Player.WHITE));
			setPiece(7, 4, new King(Player.WHITE));
			setPiece(7, 5, new Bishop(Player.WHITE));
			setPiece(7, 6, new Knight (Player.WHITE));
			setPiece(7, 7, new Rook (Player.WHITE));

		setPiece(0, 0, new Rook(Player.BLACK));
		setPiece(0, 1, new Knight(Player.BLACK));
		setPiece(0, 2, new Bishop(Player.BLACK));
		setPiece(0, 3, new Queen(Player.BLACK));
		setPiece(0, 4, new King(Player.BLACK));
		setPiece(0, 5, new Bishop(Player.BLACK));
		setPiece(0, 6, new Knight (Player.BLACK));
		setPiece(0, 7, new Rook (Player.BLACK));
	}

	public void undo() {
		if (previousRow.isEmpty())
			return;
		int index = 0;
		int fromRow = 0;
		int fromCol = 0;
		int toRow = 0;
		int toCol = 0;
		String deleted = "";

		while (index < previousRow.size()-1 && previousRow.get(index) != null)
			index++;

		fromRow = newRow.get(index);
		fromCol = newCol.get(index);
		toRow = previousRow.get(index);
		toCol = previousColumn.get(index);

		move(new Move(fromRow, fromCol, toRow, toCol));
		board[fromRow][fromCol] = null;
		setPiece(fromRow, fromCol, null);
		if (board[toRow][toCol].type().equals("Pawn"))
			if (toRow == 1 || toRow == 6)
				setPiece(toRow, toCol, new Pawn(player.next(), true));

		if (deletedPiece.get(index) != null) {
			deleted = deletedPiece.get(index);
			if (deleted.equals("King"))
				setPiece(fromRow, fromCol, new King(capturedPlayer.get(index)));
			if (deleted.equals("Queen"))
				setPiece(fromRow, fromCol, new Queen(capturedPlayer.get(index)));
			if (deleted.equals("Knight"))
				setPiece(fromRow, fromCol, new Knight(capturedPlayer.get(index)));
			if (deleted.equals("Rook"))
				setPiece(fromRow, fromCol, new Rook(capturedPlayer.get(index)));
			if (deleted.equals("Pawn")) {
				if (fromCol == 6 || fromCol == 1)
					setPiece(fromRow, fromCol, new Pawn(capturedPlayer.get(index), true));
				setPiece(fromRow, fromCol, new Pawn(capturedPlayer.get(index), false));
			}
			if (deleted.equals("Bishop"))
				setPiece(fromRow, fromCol, new Bishop(capturedPlayer.get(index)));
		}
		setNextPlayer();

		deleteMove(index);
	}

	public void saveMove(int row, int col, int nextRow, int nextCol) {
		previousRow.add(row);
		previousColumn.add(col);
		newRow.add(nextRow);
		newCol.add(nextCol);
		if (board[nextRow][nextCol] != null) {
			deletedPiece.add(board[nextRow][nextCol].type());
			capturedPlayer.add(board[nextRow][nextCol].player());
		}
		else {
			deletedPiece.add(null);
			capturedPlayer.add(null);
		}
	}

	private void deleteMove(int index) {
		previousRow.remove(index);
		previousColumn.remove(index);
		newRow.remove(index);
		newCol.remove(index);
		deletedPiece.remove(index);
		capturedPlayer.remove(index);
	}

	// XUE : Displays Joption panel when game is complete
	// XUE : HAS JUNIT testing
	// XUE : Uses inCheck(); //Fixme : not confident :(
	public boolean isComplete() {
		boolean valid = false;
		if (inCheck(currentPlayer())) {
			valid = true;
		}

		return valid;
	}

	public boolean isValidMove(Move move) {
		boolean valid = false;

		/*IChessPiece fromPiece = board[move.toRow][move.toColumn];
		IChessPiece toPiece = board[move.toRow][move.toColumn];*/

		Move moveBack = new Move(move.toRow, move.toColumn, move.fromRow, move.fromColumn);

		if (board[move.fromRow][move.fromColumn] != null)
			if ((board[move.fromRow][move.fromColumn].player().equals(currentPlayer()))
					&& board[move.fromRow][move.fromColumn].isValidMove(move, board)){

				if (inCheck(player) == false) {
					// move the piece
					move(move);

					if (inCheck(player) == true){
						// the player cannot move into check
						valid = false;
						boardState.setMovingIntoCheck(true);

						// move piece back
						move(moveBack);

					}
					else {
						valid = true;
						boardState.setMovingIntoCheck(false);
					}
				}
				else {
					// if the player is in check, they must move out of check
					boardState.setInCheck(true); // FIXME should this go in the inCheck method instead?

					move(move);

					if (inCheck(player) == true){
						// still in check; can't move there

						// move piece back
						move(moveBack);

						valid = false;
					}
					else {
						valid = true;
					}
				}
			}
/*		if (valid == true)
			saveMove(move.fromRow, move.fromColumn, move.toRow, move.toColumn);*/

		return valid;
	}

	public void move(Move move) {
		board[move.toRow][move.toColumn] =  board[move.fromRow][move.fromColumn];
		board[move.fromRow][move.fromColumn] = null;
	}

	//  XUE : Displays a JOPtion Panel when King is inCheck
	public boolean inCheck(Player p) {
		boolean valid = false;
		int fromRow = 0;
		int fromColumn = 0;
		int toRow = 0;
		int toColumn = 0;

		for (int r = 0; r < numRows(); r++) {
			for (int c = 0; c < numColumns(); c++) {
				if (board[r][c] != null && board[r][c].type().equals("King")
						&& board[r][c].player().equals(p)) {
					toRow = r;
					toColumn = c;
					break;
				}
			}
		}

		for (int r = 0; r < numRows(); r++)
			for (int c = 0; c < numColumns(); c++) {
				if (board[r][c] != null)
					if (!board[r][c].player().equals(p)) {
						fromRow = r;
						fromColumn = c;
						if (board[r][c].isValidMove(new Move (fromRow, fromColumn, toRow, toColumn), board))
							valid = true;
					}
			}

		return valid;
	}

	public Player currentPlayer() {
		return player;
	}

	public int numRows() {
		return 8;
	}

	public int numColumns() {
		return 8;
	}

	public IChessPiece pieceAt(int row, int column) {		
		return board[row][column];
	}

	public boolean isOccupied(int r, int c){
		if(board[r][c] != null)
			return true;
		return false;

	}

	public void setNextPlayer() {
		player = player.next();
	}


	public void setPiece(int row, int column, IChessPiece piece) {
		board[row][column] = piece;
	}

	public void AI() {
		/*
		 * Write a simple AI set of rules in the following order. 
		 * a. Check to see if you are in check.
		 * 		i. If so, get out of check by moving the king or placing a piece to block the check 
		 * 
		 * b. Attempt to put opponent into check (or checkmate). 
		 * 		i. Attempt to put opponent into check without losing your piece
		 *		ii. Perhaps you have won the game. 
		 *
		 *c. Determine if any of your pieces are in danger, 
		 *		i. Move them if you can. 
		 *		ii. Attempt to protect that piece. 
		 *
		 *d. Move a piece (pawns first) forward toward opponent king 
		 *		i. check to see if that piece is in danger of being removed, if so, move a different piece.
		 */

		}
}
