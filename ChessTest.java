package ChessVersion5;

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

        // check
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

        // check
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

        // move white bishop
        game.move(new Move(7, 2, 4, 5));

        // move black bishop
        game.move(new Move(0, 5, 3, 2));

        // check
        assertTrue(game.pieceAt(4, 5).type().equals("Bishop"));
        assertTrue(game.pieceAt(4, 5).player().equals(Player.WHITE));

        assertTrue(game.pieceAt(3, 2).type().equals("Bishop"));
        assertTrue(game.pieceAt(3, 2).player().equals(Player.BLACK));

    }

    @Test
    public void moveQueens(){
        ChessModel game = new ChessModel();

        // move pawns out of the way
        game.move(new Move(6, 4, 5, 4));
        game.move(new Move(1, 2, 2, 2));

        // move white queen diagonally
        game.move(new Move(7, 3, 4, 6));

        // move black queen diagonally
        game.move(new Move(0, 3, 3, 3));

        // check
        assertTrue(game.pieceAt(4, 6).type().equals("Queen"));
        assertTrue(game.pieceAt(4, 6).player().equals(Player.WHITE));

        assertTrue(game.pieceAt(3, 3).type().equals("Queen"));
        assertTrue(game.pieceAt(3, 3).player().equals(Player.BLACK));

        // move white queen horizontally
        game.move(new Move(4, 6, 4, 2));

        // move black queen horizontally
        game.move(new Move(3, 3, 3, 7));

        // check
        assertTrue(game.pieceAt(4, 2).type().equals("Queen"));
        assertTrue(game.pieceAt(4, 2).player().equals(Player.WHITE));

        assertTrue(game.pieceAt(3, 7).type().equals("Queen"));
        assertTrue(game.pieceAt(3, 7).player().equals(Player.BLACK));
    }

    @Test
    public void moveKings(){
        ChessModel game = new ChessModel();

        // move pawns out of the way
        game.move(new Move(6, 4, 4, 4));
        game.move(new Move(1, 4, 3, 4));

        // moving kings vertically
        game.move(new Move(7, 4, 6, 4));
        game.move(new Move(0, 4, 1, 4));
        game.move(new Move(6, 4, 5, 4));
        game.move(new Move(1, 4, 2, 4));

        // check
        assertTrue(game.pieceAt(5, 4).type().equals("King"));
        assertTrue(game.pieceAt(5, 4).player().equals(Player.WHITE));

        assertTrue(game.pieceAt(2, 4).type().equals("King"));
        assertTrue(game.pieceAt(2, 4).player().equals(Player.BLACK));

        // moving kings horizontally
        game.move(new Move(5, 4, 5, 3));
        game.move(new Move(2, 4, 2, 5));

        // check
        assertTrue(game.pieceAt(5, 3).type().equals("King"));
        assertTrue(game.pieceAt(5, 3).player().equals(Player.WHITE));

        assertTrue(game.pieceAt(2, 5).type().equals("King"));
        assertTrue(game.pieceAt(2, 5).player().equals(Player.BLACK));
    }

    @Test
    public void testUndo() {
        ChessModel game = new ChessModel();
        if (game.isValidMove(new Move(6,6,4,6))) {
            game.saveMove(6,6,4,6);
            game.move(new Move(6, 6, 4, 6));
            game.setNextPlayer();
        }
        game.undo();
        assertEquals("Pawn", game.pieceAt(6,6).type());
    }

    @Test
    public void testSetPassantable() {
        ChessModel game = new ChessModel();
        if (game.isValidMove(new Move(6,6,4,6))) {
            game.saveMove(6,6,4,6);
            game.move(new Move(6, 6, 4, 6));
            game.setNextPlayer();
            game.setPassantable();
        }
        assertTrue(game.pieceAt(4,6).hasMoved());
        if (game.isValidMove(new Move(1,5,3,5))) {
            game.saveMove(1,5,3,5);
            game.move(new Move(1,5,3,5));
            game.setNextPlayer();
            game.setPassantable();
        }
        assertTrue(game.pieceAt(3,5).hasMoved());
        assertFalse(game.pieceAt(4,6).hasMoved());

    }

    @Test
    public void castleWhite(){
        ChessModel game = new ChessModel();
        if (game.isValidMove(new Move(7,6,5,5)))
            game.move(new Move(7,6,5,5));
        if (game.isValidMove(new Move(6,6,5,6)))
            game.move(new Move(6,6,5,5));
        if (game.isValidMove(new Move(7,5,6,6)))
            game.move(new Move(7,5,6,6));
        assertTrue(game.castleKingSide());

    }

    @Test
    public void castleBlack(){
        ChessModel game = new ChessModel();
        game.setNextPlayer();
        if (game.isValidMove(new Move(0,1,2,2)))
            game.move(new Move(0,1,2,2));
        if (game.isValidMove(new Move(1,1,2,1)))
            game.move(new Move(1,1,2,1));
        if (game.isValidMove(new Move(0,2,1,1)))
            game.move(new Move(0,2,1,1));
        if (game.isValidMove(new Move(1,3,2,3)))
            game.move(new Move(1,3,2,3));
        if (game.isValidMove(new Move(0,3,1,3)))
            game.move(new Move(0,3,1,3));
        assertTrue(game.castleQueenSide());

    }

    @Test
    public void whiteEnPassant() {
        ChessModel game = new ChessModel();
        if (game.isValidMove(new Move(6,6,4,6)))
            game.move(new Move(6,6,4,6));
        game.setNextPlayer();
        if (game.isValidMove(new Move(1,5,3,5)))
            game.move(new Move(1,5,3,5));
        game.setNextPlayer();
        if (game.isValidMove(new Move(4,6,3,6)))
            game.move(new Move(4,6,3,6));
        game.setNextPlayer();
        if (game.isValidMove(new Move(1,7,3,7)))
            game.move(new Move(1,7,3,7));
        game.setNextPlayer();
        if (game.isValidMove(new Move(3,6,2,7)))
            game.move(new Move(3,6,2,7));
        assertEquals("Pawn", game.pieceAt(2, 7).type());
        assertNull(game.pieceAt(3, 7));
    }

    @Test
    public void blackEnPassant() {
        ChessModel game = new ChessModel();
        if (game.isValidMove(new Move(6,4,4,4)))
            game.move(new Move(6,4,4,4));
        game.setNextPlayer();
        if (game.isValidMove(new Move(1,5,3,5)))
            game.move(new Move(1,5,3,5));
        game.setNextPlayer();
        if (game.isValidMove(new Move(4,4,3,4)))
            game.move(new Move(4,4,3,4));
        game.setNextPlayer();
        if (game.isValidMove(new Move(3,5,4,5)))
            game.move(new Move(3,5,4,5));
        game.setNextPlayer();
        if (game.isValidMove(new Move(6,6,4,6)))
            game.move(new Move(6,6,4,6));
        game.setNextPlayer();
        if (game.isValidMove(new Move(4,5,5,6)))
            game.move(new Move(4,5,5,6));
        assertEquals("Pawn", game.pieceAt(5, 6).type());
        assertNull(game.pieceAt(4, 5));
    }

    @Test
    public void whiteInCheck(){

        ChessModel game = new ChessModel();

        // moving pawns
        game.move(new Move(6, 3, 4, 3));
        game.move(new Move(1, 3, 3, 3));
        game.move(new Move(6, 4, 4, 4));
        game.move(new Move(1, 4, 3, 4));

        // move white bishop
        game.move(new Move(7, 2, 4, 5));

        // move black bishop
        game.move(new Move(0, 5, 4, 1));

        assertTrue(game.inCheck(game.currentPlayer()));
    }

    @Test
    public void blackInCheck(){
        ChessModel game = new ChessModel();
        BoardState state = new BoardState(false,false,false,false,false,false);

        game.move(new Move(6, 4, 5, 4));
        game.move(new Move(1, 5, 2, 5));
        game.move(new Move(7, 3, 3, 7));

        assertTrue(game.inCheck(game.currentPlayer().next()));
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

        game.move(new Move(6, 4, 4, 4));
        game.move(new Move(0, 1, 2, 0));
        game.move(new Move(7, 5, 4, 2));
        game.move(new Move(2, 0, 0, 1));
        game.move(new Move(7, 3, 3, 7));
        game.move(new Move(0, 1, 2, 0));
        game.move(new Move(3, 7, 1, 5));

        game.setNextPlayer();
        assertTrue(game.isComplete());
    }

    @Test
    public void startNewGame(){
        ChessModel game = new ChessModel();

        // move pieces
        game.move(new Move(6, 3, 4, 3));
        game.move(new Move(1, 3, 3, 3));

        // start a new game
        game.newGame();

        // check positions
        assertTrue(game.pieceAt(6, 3).type().equals("Pawn"));
        assertTrue(game.pieceAt(6, 3).player().equals(Player.WHITE));

        assertTrue(game.pieceAt(1, 3).type().equals("Pawn"));
        assertTrue(game.pieceAt(1, 3).player().equals(Player.BLACK));
    }

    @Test
    public void promotePawn(){
        ChessModel game = new ChessModel();

        game.move(new Move(6, 2, 4, 2));
        game.move(new Move(1, 2, 3, 2));
        game.move(new Move(6, 1, 4, 1));
        game.move(new Move(3, 2, 4, 1));
        game.move(new Move(4, 2, 3, 2));
        game.move(new Move(4, 1, 5, 1));
        game.move(new Move(7, 1, 5, 2));
        game.move(new Move(5, 1, 6, 1));
        game.move(new Move(3, 2, 2, 2));
        game.move(new Move(6, 1, 7, 1));
        game.setNextPlayer();

        assertTrue(game.ifPromote());
        game.toPromote(7, 1); // FIXME not sure how else to test this without the promotion window popping up
        assertTrue(game.pieceAt(7, 1).player().equals(Player.BLACK));
    }
}
