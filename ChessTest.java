package ChessVersion4;

import Project1.SimpleDate;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**********************************************************************
 * JUnit testing for chess.
 *
 * @author Amela Aganovic, Emily Linderman, Xue Hua
 * @version Winter 2019
 *********************************************************************/

public class ChessTest {

	@Test
	public void movePawnsOnce(){
		ChessModel game = new ChessModel();

		// moving black pawns
		game.move(new Move(1, 0, 2, 0));
		game.move(new Move(1, 1, 2, 1));
		game.move(new Move(1, 2, 2, 2));
		game.move(new Move(1, 3, 2, 3));
		game.move(new Move(1, 4, 2, 4));
		game.move(new Move(1, 5, 2, 5));
		game.move(new Move(1, 6, 2, 6));
		game.move(new Move(1, 7, 2, 7));

		// moving white pawns
		game.move(new Move(6, 0, 5, 0));
		game.move(new Move(6, 1, 5, 1));
		game.move(new Move(6, 2, 5, 2));
		game.move(new Move(6, 3, 5, 3));
		game.move(new Move(6, 4, 5, 4));
		game.move(new Move(6, 5, 5, 5));
		game.move(new Move(6, 6, 5, 6));
		game.move(new Move(6, 7, 5, 7));

		// checking black pawns
		assertTrue(game.pieceAt(2, 0).type().equals("Pawn"));
		assertTrue(game.pieceAt(2, 0).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(2, 1).type().equals("Pawn"));
		assertTrue(game.pieceAt(2, 1).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(2, 2).type().equals("Pawn"));
		assertTrue(game.pieceAt(2, 2).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(2, 3).type().equals("Pawn"));
		assertTrue(game.pieceAt(2, 3).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(2, 4).type().equals("Pawn"));
		assertTrue(game.pieceAt(2, 4).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(2, 5).type().equals("Pawn"));
		assertTrue(game.pieceAt(2, 5).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(2, 6).type().equals("Pawn"));
		assertTrue(game.pieceAt(2, 6).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(2, 7).type().equals("Pawn"));
		assertTrue(game.pieceAt(2, 7).player().equals(Player.BLACK));

		// checking white pawns
		assertTrue(game.pieceAt(5, 0).type().equals("Pawn"));
		assertTrue(game.pieceAt(5, 0).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(5, 1).type().equals("Pawn"));
		assertTrue(game.pieceAt(5, 1).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(5, 2).type().equals("Pawn"));
		assertTrue(game.pieceAt(5, 2).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(5, 3).type().equals("Pawn"));
		assertTrue(game.pieceAt(5, 3).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(5, 4).type().equals("Pawn"));
		assertTrue(game.pieceAt(5, 4).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(5, 5).type().equals("Pawn"));
		assertTrue(game.pieceAt(5, 5).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(5, 6).type().equals("Pawn"));
		assertTrue(game.pieceAt(5, 6).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(5, 7).type().equals("Pawn"));
		assertTrue(game.pieceAt(5, 7).player().equals(Player.WHITE));
	}

	@Test
	public void movePawnsTwice(){
		ChessModel game = new ChessModel();

		// moving black pawns
		game.move(new Move(1, 0, 3, 0));
		game.move(new Move(1, 1, 3, 1));
		game.move(new Move(1, 2, 3, 2));
		game.move(new Move(1, 3, 3, 3));
		game.move(new Move(1, 4, 3, 4));
		game.move(new Move(1, 5, 3, 5));
		game.move(new Move(1, 6, 3, 6));
		game.move(new Move(1, 7, 3, 7));

		// moving white pawns
		game.move(new Move(6, 0, 4, 0));
		game.move(new Move(6, 1, 4, 1));
		game.move(new Move(6, 2, 4, 2));
		game.move(new Move(6, 3, 4, 3));
		game.move(new Move(6, 4, 4, 4));
		game.move(new Move(6, 5, 4, 5));
		game.move(new Move(6, 6, 4, 6));
		game.move(new Move(6, 7, 4, 7));

		// checking black pawns
		assertTrue(game.pieceAt(3, 0).type().equals("Pawn"));
		assertTrue(game.pieceAt(3, 0).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(3, 1).type().equals("Pawn"));
		assertTrue(game.pieceAt(3, 1).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(3, 2).type().equals("Pawn"));
		assertTrue(game.pieceAt(3, 2).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(3, 3).type().equals("Pawn"));
		assertTrue(game.pieceAt(3, 3).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(3, 4).type().equals("Pawn"));
		assertTrue(game.pieceAt(3, 4).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(3, 5).type().equals("Pawn"));
		assertTrue(game.pieceAt(3, 5).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(3, 6).type().equals("Pawn"));
		assertTrue(game.pieceAt(3, 6).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(3, 7).type().equals("Pawn"));
		assertTrue(game.pieceAt(3, 7).player().equals(Player.BLACK));

		// checking white pawns
		assertTrue(game.pieceAt(4, 0).type().equals("Pawn"));
		assertTrue(game.pieceAt(4, 0).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(4, 1).type().equals("Pawn"));
		assertTrue(game.pieceAt(4, 1).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(4, 2).type().equals("Pawn"));
		assertTrue(game.pieceAt(4, 2).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(4, 3).type().equals("Pawn"));
		assertTrue(game.pieceAt(4, 3).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(4, 4).type().equals("Pawn"));
		assertTrue(game.pieceAt(4, 4).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(4, 5).type().equals("Pawn"));
		assertTrue(game.pieceAt(4, 5).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(4, 6).type().equals("Pawn"));
		assertTrue(game.pieceAt(4, 6).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(4, 7).type().equals("Pawn"));
		assertTrue(game.pieceAt(4, 7).player().equals(Player.WHITE));
	}

	@Test
	public void moveRooks(){
		ChessModel game = new ChessModel();

		// get pawns out of the way
		game.move(new Move(6, 0, 4, 0));
		game.move(new Move(1, 0, 3, 0));
		game.move(new Move(6, 7, 4, 7));
		game.move(new Move(1, 7, 3, 7));

		// white and black vertical
		game.move(new Move(7, 0, 5, 0));
		game.move(new Move(0, 0, 2, 0));
		game.move(new Move(7, 7, 5, 7));
		game.move(new Move(0, 7, 2, 7));

		// checking
		assertTrue(game.pieceAt(5, 0).type().equals("Rook"));
		assertTrue(game.pieceAt(5, 0).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(2, 0).type().equals("Rook"));
		assertTrue(game.pieceAt(2, 0).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(5, 7).type().equals("Rook"));
		assertTrue(game.pieceAt(5, 7).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(2, 7).type().equals("Rook"));
		assertTrue(game.pieceAt(2, 7).player().equals(Player.BLACK));

		// white and black horizontal
		game.move(new Move(5, 0, 5, 3));
		game.move(new Move(2, 0, 2, 3));
		game.move(new Move(5, 7, 5, 4));
		game.move(new Move(2, 7, 2, 4));

		// checking
		assertTrue(game.pieceAt(5, 3).type().equals("Rook"));
		assertTrue(game.pieceAt(5, 3).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(2, 3).type().equals("Rook"));
		assertTrue(game.pieceAt(2, 3).player().equals(Player.BLACK));
		assertTrue(game.pieceAt(5, 4).type().equals("Rook"));
		assertTrue(game.pieceAt(5, 4).player().equals(Player.WHITE));
		assertTrue(game.pieceAt(2, 4).type().equals("Rook"));
		assertTrue(game.pieceAt(2, 4).player().equals(Player.BLACK));

	}

	@Test
	public void moveBishops(){
		ChessModel game = new ChessModel();

		// get pawns out of the way
		game.move(new Move(6, 3, 4, 3));
		game.move(new Move(1, 3, 3, 3));
		game.move(new Move(6, 4, 4, 4));
		game.move(new Move(1, 4, 3, 4));

		// move

	}

	@Test
	public void moveQueens(){

	}

	@Test
	public void moveKings(){

	}

	@Test
	public void castleWhite(){

	}

	@Test
	public void castleBlack(){

	}

	@Test
	public void whiteInCheck(){

	}

	@Test
	public void blackInCheck(){
		ChessModel game = new ChessModel();
		BoardState state = new BoardState();

		game.move(new Move(6, 4, 5, 4));
		game.move(new Move(1, 5, 2, 5));
		game.move(new Move(7, 3, 3, 7));

		//assertEquals(game.inCheck(game.currentPlayer()), true);
		assertTrue(game.inCheck(game.currentPlayer()));
		//assertTrue(state.isInCheck());
		//assertEquals(state.isInCheck(), true);

		// FIXME
	}

	@Test
	public void whiteCheckmate(){
		ChessModel game = new ChessModel();

		game.move(new Move(6, 6, 4, 6));
		game.move(new Move(1, 4, 3, 4));
		game.move(new Move(6, 5, 4, 5));
		game.move(new Move(0, 3, 4, 7));

		assertTrue(game.isComplete());
	}

	@Test
	public void blackCheckmate(){
		ChessModel game = new ChessModel();


	}

	// Example tests to reference for syntax FIXME delete these later

	/*@Test
	public void testIsLeapYearAA() {
		SimpleDate d = new SimpleDate("3/1/2013");
		assertFalse(d.isLeapYear());

		d = new SimpleDate("3/1/2000");
		assertTrue(d.isLeapYear());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectYearAA() {
		SimpleDate d1 = new SimpleDate("3/1/1752");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectDayAA() {
		SimpleDate d1 = new SimpleDate("3/-1/1800");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectMonthAA() {
		SimpleDate d1 = new SimpleDate("-3/1/1800");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEqualsWithNull2AA() {
		SimpleDate d1 = new SimpleDate("005/15/2015");
		SimpleDate d2 = null;
		SimpleDate.equals(d1, d2);
	}*/


}

