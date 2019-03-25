package ChessVersion5;
import javax.swing.*;
import java.util.ArrayList;

/**********************************************************************
 * The logic behind the chess game.
 *
 * @author Amela Aganovic, Emily Linderman, Xue Hua
 * @version Winter 2019
 *********************************************************************/
public class ChessModel implements IChessModel {

    /** chess board */
    private IChessPiece[][] board;

    /** current player type */
    private Player player;

    /** deleted chess piece type */
    private ArrayList<String> deletedPiece;

    /** previous row co-ordinates of piece */
    private ArrayList<Integer> previousRow;

    /** previous column co-ordinates of piece */
    private ArrayList<Integer> previousColumn;

    /** player type of captured piece */
    private ArrayList<Player> capturedPlayer;

    /** future row co-ordinates of piece */
    private ArrayList<Integer> newRow;

    /** future column co-ordinates of piece */
    private ArrayList<Integer> newCol;

    /** row co-ordinates of captured piece */
    private ArrayList<Integer> capturedRow;

    /** column co-ordinates of captured piece */
    private ArrayList<Integer> capturedCol;

    /** keeps track of when a pawn is promoted */
    private ArrayList<Boolean> promoted;

    /** whether or not player is moving into check */
    private boolean movingIntoCheck;

    /*****************************************************************
     * Constructor for ChessModel. Sets up the game and spans the
     * pieces. Resets relevant flags, counters, turns and other
     * variables.
     *****************************************************************/
    public ChessModel() {
        board = new IChessPiece[8][8];
        player = Player.WHITE;

        movingIntoCheck = false;

        deletedPiece = new ArrayList<>();
        previousRow = new ArrayList<>();
        previousColumn = new ArrayList<>();
        capturedPlayer = new ArrayList<>();
        newRow = new ArrayList<>();
        newCol = new ArrayList<>();
        capturedRow = new ArrayList<>();
        capturedCol = new ArrayList<>();
        promoted = new ArrayList<>();

        board[7][0] = new Rook(Player.WHITE);
        board[7][1] = new Knight(Player.WHITE);
        board[7][2] = new Bishop(Player.WHITE);
        board[7][3] = new Queen(Player.WHITE);
        board[7][4] = new King(Player.WHITE);
        board[7][5] = new Bishop(Player.WHITE);
        board[7][6] = new Knight(Player.WHITE);
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
        board[0][6] = new Knight(Player.BLACK);
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

    /*****************************************************************
     * Helper methods that resets relevant flags, counters, turns and
     * other variables
     *****************************************************************/
    public void newGame() {

        System.out.println("NEW GAME");
        player = Player.WHITE;
        for (int r = 0; r < 8; r++) {
            if (r == 1)
                for (int c = 0; c < 8; c++) {
                    setPiece(r, c, new Pawn(Player.BLACK, true));
                }
            if (r == 6)
                for (int c = 0; c < 8; c++) {
                    setPiece(r, c, new Pawn(Player.WHITE, true));
                }
            if (r < 6 && r > 1)
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
        setPiece(7, 6, new Knight(Player.WHITE));
        setPiece(7, 7, new Rook(Player.WHITE));

        setPiece(0, 0, new Rook(Player.BLACK));
        setPiece(0, 1, new Knight(Player.BLACK));
        setPiece(0, 2, new Bishop(Player.BLACK));
        setPiece(0, 3, new Queen(Player.BLACK));
        setPiece(0, 4, new King(Player.BLACK));
        setPiece(0, 5, new Bishop(Player.BLACK));
        setPiece(0, 6, new Knight(Player.BLACK));
        setPiece(0, 7, new Rook(Player.BLACK));

        movingIntoCheck = false;
        deletedPiece = new ArrayList<>();
        previousRow = new ArrayList<>();
        previousColumn = new ArrayList<>();
        capturedPlayer = new ArrayList<>();
        newRow = new ArrayList<>();
        newCol = new ArrayList<>();
        capturedRow = new ArrayList<>();
        capturedCol = new ArrayList<>();
        promoted = new ArrayList<>();

    }

    /*****************************************************************
     * Checker method that determines if there is a pawn to promote.
     *****************************************************************/
    public boolean ifPromote() {
        int r;
        if (currentPlayer() == Player.WHITE)
            r = 0;
        else
            r = 7;
        for (int c = 0; c < numColumns(); c++) {
            if (board[r][c] != null && board[r][c].type().equals("Pawn")) {
                return true;
            }
        }
        return false;
    }

    /*****************************************************************
     * Helper method that handles promotion of pawn piece.
     *
     * @param toRow Row of promotion space
     * @param toCol Column of promotion space
     *****************************************************************/
    public void toPromote(int toRow, int toCol) {
        String[] choices = { "Queen", "Bishop", "Knight", "Rook"};
        String command = (String) JOptionPane.showInputDialog
                (null, "Choose now...",
                "Promoting the Pawn", JOptionPane.QUESTION_MESSAGE,
                        null, choices, choices[0]);
        if(command.equalsIgnoreCase(choices[0])){
            setPiece(toRow, toCol, new Queen(currentPlayer()));
        }
        else if(command.equalsIgnoreCase(choices[1])){
            setPiece(toRow, toCol, new Bishop(currentPlayer()));
        }
        else if(command.equalsIgnoreCase(choices[2])){
            setPiece(toRow, toCol, new Knight(currentPlayer()));
        }
        else if(command.equalsIgnoreCase(choices[3])){
            setPiece(toRow, toCol, new Rook(currentPlayer()));
        }

    }

    /*****************************************************************
     * Method that restores the previous move.
     *****************************************************************/
    public void undo() {
        // If there is no previous move, return
        if (previousRow.isEmpty()) {
            player = Player.WHITE;
            board[7][4].setHasMoved(false);
            board[7][7].setHasMoved(false);
            board[7][0].setHasMoved(false);
            board[0][4].setHasMoved(false);
            board[0][7].setHasMoved(false);
            board[0][0].setHasMoved(false);
            return;
        }

        int index = previousRow.size()-1;
        int fromRow = newRow.get(index);
        int fromCol = newCol.get(index);
        int toRow = previousRow.get(index);
        int toCol = previousColumn.get(index);
        int captiveRow = 0;
        int captiveCol = 0;
        String deleted = "";

        if (capturedRow.get(index) != null) {
            captiveRow = capturedRow.get(index);
            captiveCol = capturedCol.get(index);
            deleted = deletedPiece.get(index);
        }

        //if a piece was promoted, this sets it back to a pawn
        if (promoted.get(index) && player.equals(Player.BLACK)) {
            if (capturedRow.get(index) != null)
                setPiece(captiveRow, captiveCol,new Pawn(Player.WHITE,
                        false));
            else
                setPiece(fromRow,fromCol,new Pawn(Player.WHITE,
                        false));
        }
        if (promoted.get(index) && player.equals(Player.WHITE)) {
            if (capturedRow.get(index) != null)
                setPiece(captiveRow, captiveCol,new Pawn(Player.BLACK,
                        false));
            else
                setPiece(fromRow,fromCol,new Pawn(Player.BLACK,
                        false));
        }

        // Special cases that undo a castling move
        if (fromRow == 8) {
            if (fromCol == 4) {
                move(new Move(0, 2, 0, 4));
                move(new Move(0, 3, 0, 0));
                board[0][4].setHasMoved(false);
                board[0][0].setHasMoved(false);
            } else {
                move(new Move(0, 6, 0, 4));
                move(new Move(0, 5, 0, 7));
                board[0][4].setHasMoved(false);
                board[0][7].setHasMoved(false);
            }
            deleteMove(index);
            return;
        }
        if (fromRow == 14) {
            if (fromCol == 4) {
                move(new Move(7, 2, 7, 4));
                move(new Move(7, 3, 7, 0));
                board[7][4].setHasMoved(false);
                board[7][0].setHasMoved(false);
            } else {
                move(new Move(7, 6, 7, 4));
                move(new Move(7, 5, 7, 7));
                board[7][4].setHasMoved(false);
                board[7][7].setHasMoved(false);
            }
            deleteMove(index);
            return;
        }

        //move the piece back to where it was, make sure space it
        // occupied is null
        move(new Move(fromRow, fromCol, toRow, toCol));
        board[fromRow][fromCol] = null;

        // resets a pawn if it goes back to its' original spot
        if (board[toRow][toCol] != null && board[toRow][toCol].type().equals("Pawn")) {
            if (toRow == 1 && board[toRow][toCol].player().equals(Player.BLACK))
                setPiece(toRow, toCol, new Pawn(Player.BLACK, true));
            if (toRow == 6 && board[toRow][toCol].player().equals(Player.WHITE))
                setPiece(toRow, toCol, new Pawn(Player.WHITE, true));
        }

        // resets the state of the kings and rooks
        if (previousRow.size() <= 3) {
            board[7][4].setHasMoved(false);
            board[7][7].setHasMoved(false);
            board[7][0].setHasMoved(false);
            board[0][4].setHasMoved(false);
            board[0][7].setHasMoved(false);
            board[0][0].setHasMoved(false);
        }

        // if a piece was deleted, put it back
        if (deletedPiece.get(index) != null) {
            if (deleted.equals("King"))
                setPiece(captiveRow, captiveCol, new King(capturedPlayer.get(index)));
            if (deleted.equals("Queen"))
                setPiece(captiveRow, captiveCol, new Queen(capturedPlayer.get(index)));
            if (deleted.equals("Knight"))
                setPiece(captiveRow, captiveCol, new Knight(capturedPlayer.get(index)));
            if (deleted.equals("Rook"))
                setPiece(captiveRow, captiveCol, new Rook(capturedPlayer.get(index)));
            if (deleted.equals("Pawn")) {
                if (captiveRow == 6 || captiveRow == 1)
                    setPiece(captiveRow, captiveCol, new Pawn(capturedPlayer.get(index), true));
                setPiece(captiveRow, captiveCol, new Pawn(capturedPlayer.get(index), false));
                if (captiveRow == 3 || captiveRow == 4)
                    board[captiveRow][captiveCol].setHasMoved(true);
            }
            if (deleted.equals("Bishop"))
                setPiece(captiveRow, captiveCol, new Bishop(capturedPlayer.get(index)));
        }
        setNextPlayer();

        deleteMove(index);
    }

    /*****************************************************************
     * Helper method that handles saving of a move made by player.
     *
     * @param row the previous row of the piece.
     * @param col the previous column of the moved piece.
     * @param nextRow the row the piece moved to.
     * @param nextCol the column the piece moved to.
     *****************************************************************/
    public void saveMove(int row, int col, int nextRow, int nextCol) {
        previousRow.add(row);
        previousColumn.add(col);
        newRow.add(nextRow);
        newCol.add(nextCol);
        if (promoted.size() == previousRow.size()-1)
            promoted.add(false);
        if (nextRow < 8 && nextCol < 8 && board[nextRow][nextCol]
                != null) {
            deletedPiece.add(board[nextRow][nextCol].type());
            capturedPlayer.add(board[nextRow][nextCol].player());
            capturedRow.add(nextRow);
            capturedCol.add(nextCol);
        }
        if (capturedRow.size() == previousRow.size()) {
            return;
        } else {
            deletedPiece.add(null);
            capturedPlayer.add(null);
            capturedRow.add(null);
            capturedCol.add(null);
        }
    }

    /*****************************************************************
     * Helper method that handles the deletion of a move.
     * @param index index of where move was stored.
     *****************************************************************/
    private void deleteMove(int index) {
        previousRow.remove(index);
        previousColumn.remove(index);
        newRow.remove(index);
        newCol.remove(index);
        deletedPiece.remove(index);
        capturedPlayer.remove(index);
        capturedRow.remove(index);
        capturedCol.remove(index);
        promoted.remove(index);
    }

    /*****************************************************************
     * Helper method that deletes the previous move.
     *****************************************************************/
    private void deleteLastMove() {
        int index = previousRow.size()-1;
        int captiveRow = 0;
        int captiveCol = 0;
        String deleted = "";

        if (capturedRow.get(index) != null) {
            captiveRow = capturedRow.get(index);
            captiveCol = capturedCol.get(index);
        }

        if (promoted.get(index) != true) {
            promoted.remove(index);
        }
        if (deletedPiece.get(index) != null) {
            deleted = deletedPiece.get(index);
            if (deleted.equals("King"))
                setPiece(captiveRow, captiveCol, new King(capturedPlayer.get(index)));
            if (deleted.equals("Queen"))
                setPiece(captiveRow, captiveCol, new Queen(capturedPlayer.get(index)));
            if (deleted.equals("Knight"))
                setPiece(captiveRow, captiveCol, new Knight(capturedPlayer.get(index)));
            if (deleted.equals("Rook"))
                setPiece(captiveRow, captiveCol, new Rook(capturedPlayer.get(index)));
            if (deleted.equals("Pawn")) {
                if (captiveRow == 6 || captiveRow == 1)
                    setPiece(captiveRow, captiveCol, new Pawn(capturedPlayer.get(index), true));
                setPiece(captiveRow, captiveCol, new Pawn(capturedPlayer.get(index), false));
                if (captiveRow == 3 || captiveRow == 4)
                    board[captiveRow][captiveCol].setHasMoved(true);
            }
            if (deleted.equals("Bishop"))
                setPiece(captiveRow, captiveCol, new Bishop(capturedPlayer.get(index)));
        }

        previousRow.remove(index);
        previousColumn.remove(index);
        newRow.remove(index);
        newCol.remove(index);
        deletedPiece.remove(index);
        capturedPlayer.remove(index);
        capturedRow.remove(index);
        capturedCol.remove(index);
    }

    /*****************************************************************
     * Checks whether the game is complete (checkmate).
     *****************************************************************/
    public boolean isComplete() {
        boolean valid = true;
        int fromRow = 0;
        int fromColumn = 0;
        Move attemptMove;

        // first, is the player in check?
        if (inCheck(player)) {

            for (int r = 0; r < numRows(); r++)
                for (int c = 0; c < numColumns(); c++) {

                    // find a piece of the same color
                    if (board[r][c] != null && board[r][c].player()
                            .equals(player)) {

                        fromRow = r;
                        fromColumn = c;

                        // look for way to get out of check
                        for (int i = 0; i < numRows(); i++)
                            for (int j = 0; j < numColumns(); j++) {

                                attemptMove = new Move(fromRow,
                                        fromColumn, i, j);
                                if (isValidMove(attemptMove))
                                    valid = false;
                            }
                    }
                }
        } else // if they aren't in check, it can't be a checkmate
            valid = false;

        return valid;
    }

    /*****************************************************************
     * Checks if the player is attempting to move into check.
     *
     * @return true if player is trying to move into check.
     *****************************************************************/
    public boolean movingIntoCheck(){
        return movingIntoCheck;
    }

    /*****************************************************************
     * Checker method to verify that move is valid. Is called for
     * all pieces.
     *
     * @param move argument of class move
     * @return  true if move is valid, false if move is invalid.
     *****************************************************************/
    public boolean isValidMove(Move move) {
        boolean valid = false;

        Move moveBack = new Move(move.toRow, move.toColumn,
                move.fromRow, move.fromColumn);

        if (board[move.fromRow][move.fromColumn] != null) {
            if ((board[move.fromRow][move.fromColumn].player().
                    equals(currentPlayer()))
                    && board[move.fromRow][move.fromColumn].
                    isValidMove(move, board)) {

                if (!inCheck(player)) {
                    // move the piece
                    if ((move.toRow == 0 || move.toRow == 7)
                            && board[move.fromRow][move.fromColumn].
                            type().equals("Pawn")) {
                        promoted.add(true);
                    }
                    saveMove(move.fromRow, move.fromColumn, move.toRow,
                            move.toColumn);
                    move(move);

                    if (inCheck(player)) {
                        // the player cannot move into check
                        movingIntoCheck = true;
                        valid = false;

                        // move piece back
                        move(moveBack);
                        deleteLastMove();

                    } else {
                        valid = true;
                    }
                } else {
                    // if the player is in check, they must move out
                    // of check

                    saveMove(move.fromRow, move.fromColumn, move.toRow,
                            move.toColumn);
                    move(move);

                    if (inCheck(player) == true) {
                        // still in check; can't move there

                        // move piece back
                        move(moveBack);
                        deleteLastMove();

                        valid = false;
                    } else {
                        valid = true;
                    }
                }
            }
        }
        if (valid) {
            move(moveBack);
            deleteLastMove();
            movingIntoCheck = false;

            // deals with en passant
            if (player.equals(Player.WHITE)) {
                if (move.fromRow == 3 && board[move.fromRow]
                        [move.fromColumn] != null
                        && board[move.fromRow][move.fromColumn].type()
                        .equals("Pawn")) {
                    if (move.fromColumn + 1 < 8 && move.toColumn ==
                            move.fromColumn + 1) {
                        if (board[3][move.toColumn] != null && board[3]
                                [move.toColumn].hasMoved()) {
                            capturedRow.add(3);
                            capturedCol.add(move.toColumn);
                            capturedPlayer.add(Player.BLACK);
                            deletedPiece.add("Pawn");
                            board[3][move.toColumn] = null;
                        }
                    }
                    if (move.fromColumn - 1 >= 0 && move.toColumn ==
                            move.fromColumn - 1) {
                        if (board[3][move.toColumn] != null && board[3]
                                [move.toColumn].hasMoved()) {
                            capturedRow.add(3);
                            capturedCol.add(move.toColumn);
                            capturedPlayer.add(Player.BLACK);
                            deletedPiece.add("Pawn");
                            board[3][move.toColumn] = null;
                        }
                    }
                }
            }
            if (player.equals(Player.BLACK)) {
                if (move.fromRow == 4 && board[move.fromRow]
                        [move.fromColumn] != null &&
                        board[move.fromRow][move.fromColumn].type()
                        .equals("Pawn")) {
                    if (move.fromColumn + 1 < 8 && move.toColumn ==
                            move.fromColumn + 1) {
                        if (board[4][move.toColumn] != null && board[4]
                                [move.toColumn].hasMoved()) {
                            capturedRow.add(4);
                            capturedCol.add(move.toColumn);
                            capturedPlayer.add(Player.WHITE);
                            deletedPiece.add("Pawn");
                            board[4][move.toColumn] = null;
                        }
                    }
                    if (move.fromColumn - 1 >= 0 && move.toColumn ==
                            move.fromColumn - 1) {
                        if (board[4][move.toColumn] != null && board[4]
                                [move.toColumn].hasMoved()) {
                            capturedRow.add(4);
                            capturedCol.add(move.toColumn);
                            capturedPlayer.add(Player.WHITE);
                            deletedPiece.add("Pawn");
                            board[4][move.toColumn] = null;
                        }
                    }
                }
            }
        }


        return valid;
    }

    /*****************************************************************
     * Moves piece to a new space and sets the previous space to null.
     *****************************************************************/
    public void move(Move move) {
        board[move.toRow][move.toColumn] = board[move.fromRow]
                [move.fromColumn];
        board[move.fromRow][move.fromColumn] = null;
    }

    /*****************************************************************
     * Determines whether a king is in check
     *
     * @param p argument passes player type
     *****************************************************************/
    public boolean inCheck(Player p) {
        boolean valid = false;
        int fromRow = 0;
        int fromColumn = 0;
        int toRow = 0;
        int toColumn = 0;

        for (int r = 0; r < numRows(); r++) {
            for (int c = 0; c < numColumns(); c++) {
                if (board[r][c] != null && board[r][c].type().
                        equals("King")
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
                        if (board[r][c].isValidMove(new Move(fromRow,
                                fromColumn, toRow, toColumn), board)) {
                            valid = true;
                        }
                    }
            }

        return valid;
    }

    /*****************************************************************
     * Helper method to enable en Passant move. Sets the status
     * of whether a pawn has just moved.
     *****************************************************************/
    public void setPassantable() {
        int col = 0;
        while (col < 8) {
            if (board[3][col] != null && board[3][col].type().equals("Pawn")
                    && board[3][col].hasMoved() && newCol.get(newCol.size() - 1) != col)
                board[3][col].setHasMoved(false);
            if (board[4][col] != null && board[4][col].type().equals("Pawn")
                    && board[4][col].hasMoved() && newCol.get(newCol.size() - 1) != col)
                board[4][col].setHasMoved(false);

            col++;
        }
    }

    /*****************************************************************
     * Helper method to castle on the king side. Determines whether
     * the current player can castle, and if it can, does.
     *
     * @return true if can castle, false if not.
     *****************************************************************/
    public boolean castleKingSide() {
        if (player.equals(Player.WHITE)) {
            if (board[7][7] != null && board[7][4] != null) {
                if (board[7][7].type().equals("Rook") && board[7][4]
                        .type().equals("King")) {
                    if (!board[7][7].hasMoved() && !board[7][4]
                            .hasMoved()) {
                        if (board[7][5] == null && board[7][6] == null)
                        {
                            if (!canBeAttacked(player, 7, 5) &&
                                    !canBeAttacked(player, 7, 6)) {
                                saveMove(7, 4, 14, 11);
                                move(new Move(7, 4, 7, 6));
                                move(new Move(7, 7, 7, 5));
                                board[7][6].setHasMoved(true);
                                board[7][5].setHasMoved(true);
                                return true;
                            }

                        }
                    }
                }
            }
        }

        if (player.equals(Player.BLACK)) {
            if (board[0][7] != null && board[0][4] != null) {
                if (board[0][7].type().equals("Rook") && board[0][4]
                        .type().equals("King")) {
                    if (!board[0][7].hasMoved() && !board[0][4]
                            .hasMoved()) {
                        if (board[0][5] == null && board[0][6] == null)
                        {
                            if (!canBeAttacked(player, 7, 5) &&
                                    !canBeAttacked(player, 7, 6)) {
                                saveMove(0, 4, 8, 11);
                                move(new Move(0, 4, 0, 6));
                                move(new Move(0, 7, 0, 5));
                                board[0][5].setHasMoved(true);
                                board[0][6].setHasMoved(true);
                                return true;
                            }

                        }
                    }
                }
            }
        }
        return false;
    }

    /*****************************************************************
     * Helper method to castle on the queen side. Determines whether
     * the current player can castle, and if it can, does.
     *
     * @return true if can castle, false if not.
     *****************************************************************/
    public boolean castleQueenSide() {
        if (player.equals(Player.WHITE)) {
            if (board[7][0] != null && board[7][4] != null) {
                if (board[7][0].type().equals("Rook") && board[7][4]
                        .type().equals("King")) {
                    if (!board[7][0].hasMoved() && !board[7][4]
                            .hasMoved()) {
                        if (board[7][1] == null && board[7][2] == null
                                && board[7][3] == null) {
                            if (!canBeAttacked(player, 7, 1) &&
                                    !canBeAttacked(player, 7, 2)
                                    && !canBeAttacked(player, 7, 3)) {
                                saveMove(7, 4, 14, 4);
                                move(new Move(7, 4, 7, 2));
                                move(new Move(7, 0, 7, 3));
                                board[7][3].setHasMoved(true);
                                board[7][2].setHasMoved(true);
                                return true;
                            }
                        }
                    }
                }
            }
        }

        if (player.equals(Player.BLACK)) {
            if (board[0][0] != null && board[0][4] != null) {
                if (board[0][0].type().equals("Rook") && board[0][4]
                        .type().equals("King")) {
                    if (!board[0][0].hasMoved() && !board[0][4]
                            .hasMoved()) {
                        if (board[0][1] == null && board[0][2] == null
                                && board[0][3] == null) {
                            if (!canBeAttacked(player, 0, 1) &&
                                    !canBeAttacked(player, 0, 2)
                                    && !canBeAttacked(player, 0, 3)) {
                                saveMove(0, 4, 8, 4);
                                move(new Move(0, 4, 0, 2));
//                                saveMove(0,0,0,3);
                                move(new Move(0, 0, 0, 3));
                                board[0][3].setHasMoved(true);
                                board[0][2].setHasMoved(true);
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    /*****************************************************************
     * Determines whether a piece can be attacked at row, col.
     *
     * @return true if can be attacked, false if not.
     *****************************************************************/
    private boolean canBeAttacked(Player p, int row, int col) {
        int fromRow = 0;
        int fromColumn = 0;
        boolean dangerous = false;

        for (int r = 0; r < numRows(); r++)
            for (int c = 0; c < numColumns(); c++) {
                if (board[r][c] != null)
                    if (!board[r][c].player().equals(p)) {
                        fromRow = r;
                        fromColumn = c;
                        if (board[r][c].isValidMove(new Move(fromRow,
                                fromColumn, row, col), board))
                            dangerous = true;
                    }
            }

        return dangerous;
    }

    /*****************************************************************
     * Returns the current player.
     *
     * @return current player.
     *****************************************************************/
    public Player currentPlayer() {
        return player;
    }

    /*****************************************************************
     * Returns the number of rows.
     *
     * @return 8.
     *****************************************************************/
    public int numRows() {
        return 8;
    }

    /*****************************************************************
     * Returns the number of columns.
     *
     * @return 8.
     *****************************************************************/
    public int numColumns() {
        return 8;
    }

    /******************************************************************
     * Returns the piece at the specified row and column.
     *
     * @param row the row of the piece.
     * @param column the column of the piece.
     * @return the piece at row, col.
     *****************************************************************/
    public IChessPiece pieceAt(int row, int column) {
        return board[row][column];
    }

    /*****************************************************************
     * Checker method to verify if a space is occupied.
     *
     * @param r     argument row
     * @param c     argument column
     *****************************************************************/
    public boolean isOccupied(int r, int c) {
        if (board[r][c] != null)
            return true;
        return false;
    }

    /*****************************************************************
     * Method that sets the next player.
     *****************************************************************/
    public void setNextPlayer() {
        player = player.next();
    }

    /*****************************************************************
     * Method that sets a particular piece in argument's position.
     *
     * @param row   argument row of space.
     * @param column argument row of column.
     * @param  piece type of piece to set.
     *****************************************************************/
    public void setPiece(int row, int column, IChessPiece piece) {
        board[row][column] = piece;
    }

    /******************************************************************
     * An artificial intelligence that moves the black pieces of the
     * board when called.
     *****************************************************************/
    public void AI() {

        if (inCheck(Player.BLACK))
            getOutOfCheck();
        else if (attemptToTakeAPiece() == false)
            if (attemptToRemoveDanger() == false)
                if (attemptCheckmate() == false)
                    findAPlaceToMove();

    }

    /*****************************************************************
     * Finds a place to move a piece.
     *
     * @return true if pieces are able to move, false if not.
     *****************************************************************/
    private void findAPlaceToMove() {
        int blackRow;
        int blackCol;
        Move attemptMove;
        Move moveBack;

        if (canMovePawn())
            return;

        for (int r = 0; r < numRows(); r++) {
            for (int c = 0; c < numColumns(); c++) {

                // look for a black piece
                if (board[r][c] != null && board[r][c].player().equals(Player.BLACK)) {

                    blackRow = r;
                    blackCol = c;

                    // find a valid spot for black piece to move
                    for (int i = 0; i < numRows(); i++) {
                        for (int j = 0; j < numColumns(); j++) {

                            attemptMove = new Move(blackRow, blackCol, i, j);
                            moveBack = new Move(i, j, blackRow, blackCol);
                            if (isValidMove(attemptMove)) {
                                saveMove(r,c,i,j);
                                move(attemptMove);
                                if (!canBeAttacked(Player.BLACK, i, j))
                                    return;
                                else {
                                    move(moveBack);
                                    deleteLastMove();
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    /******************************************************************
     * Finds a place for a pawn to move, if it is able.
     *
     * @return true if a pawn can move, false if not.
     *****************************************************************/
    private boolean canMovePawn() {
        Move attemptMove;
        Move moveBack;
        int fromRow = 0;
        int fromCol = 0;

        for (int r = 0; r < numRows(); r++) {
            for (int c = 0; c < numColumns(); c++) {
                if (board[r][c] != null && board[r][c].type()
                        .equals("Pawn")
                        && board[r][c].player().equals(Player.BLACK)) {
                    fromRow = r;
                    fromCol = c;

                    for (int i = 0; i < numRows(); i++) {
                        for (int j = 0; j < numColumns(); j++) {
                            if (board[i][j] == null)
                                if (i+1 < numRows()) {
                                    attemptMove = new Move(fromRow,
                                            fromCol, i+1, j);
                                    if (isValidMove(attemptMove) &&
                                            !canBeAttacked(Player.BLACK, i+1, j)) {
                                        saveMove(r,c,i+1,j);
                                        move(attemptMove);
                                        return true;
                                    }
                                    else {
                                        attemptMove = new Move(fromRow,
                                                fromCol, i, j);
                                        moveBack = new Move(i, j,
                                                fromRow, fromCol);
                                        if (isValidMove(attemptMove)) {
                                            saveMove(r,c,i,j);
                                            move(attemptMove);
                                            if (!canBeAttacked(
                                                    Player.BLACK,
                                                    i, j))
                                                return true;
                                            else {
                                                move(moveBack);
                                                deleteLastMove();
                                            }
                                        }
                                    }

                                }
                                else {
                                    attemptMove = new Move(fromRow,
                                            fromCol, i, j);
                                    moveBack = new Move(i, j, fromRow,
                                            fromCol);
                                    if (isValidMove(attemptMove)) {
                                        move(attemptMove);
                                        if (!canBeAttacked(
                                                Player.BLACK, i, j))
                                            return true;
                                        else
                                            move(moveBack);
                                    }
                                }
                        }
                    }

                }
            }
        }

        return false;
    }

    /******************************************************************
     * Attempts to get Player Black out of check.
     *****************************************************************/
    private void getOutOfCheck() {

        Move attemptMove;
        int blackRow;
        int blackCol;

        for (int r = 0; r < numRows(); r++)
            for (int c = 0; c < numColumns(); c++) {

                if (board[r][c] != null && board[r][c].player().equals(
                        Player.BLACK)) {

                    blackRow = r;
                    blackCol = c;

                    for (int i = 0; i < numRows(); i++)
                        for (int j = 0; j < numColumns(); j++) {

                            attemptMove = new Move(blackRow, blackCol,
                                    i, j);

                            // the only valid move is moving out
                            // of check
                            if (isValidMove(attemptMove)) {
                                saveMove(r,c,i,j);
                                move(attemptMove);
                                return;
                            }
                        }

                }

            }

    }

    /******************************************************************
     * Attempts to put Player White in check.
     *
     * @return true if can put Player White in check safely.
     *****************************************************************/
    private boolean attemptCheckmate() {

        int whiteKingRow = 0;
        int whiteKingCol = 0;
        int blackRow;
        int blackCol;

        Move attemptMove;
        Move moveBack;

        // locate white king
        for (int r = 0; r < numRows(); r++)
            for (int c = 0; c < numColumns(); c++) {

                if (board[r][c] != null &&
                        board[r][c].player().equals(Player.WHITE))
                    if (board[r][c].type().equals("King")) {

                        whiteKingRow = r;
                        whiteKingCol = c;

                    }
            }

        for (int r = 0; r < numRows(); r++)
            for (int c = 0; c < numColumns(); c++) {

                if (board[r][c] != null && board[r][c].player().equals(
                        Player.BLACK)) {
                    blackRow = r;
                    blackCol = c;

                    for (int i = whiteKingRow-1; i < whiteKingRow+1;
                         i++)
                        for (int j = whiteKingCol-1; j < whiteKingCol+1
                                ; j++) {

                            if (i >= 0 && j >= 0 && i < numRows()
                                    && j < numColumns()) {
                                attemptMove = new Move(blackRow,
                                        blackCol, i, j);
                                moveBack = new Move(i, j, blackRow,
                                        blackCol);

                                if (isValidMove(attemptMove) &&
                                        !canBeAttacked(Player.BLACK, i, j)) {
                                    saveMove(r,c,i,j);
                                    move(attemptMove);

                                    if (inCheck(Player.WHITE))
                                        return true;
                                    else {
                                        move(moveBack);
                                        deleteLastMove();
                                    }
                                }
                            }

                        }
                }
            }

        return false;
    }

    /******************************************************************
     * Attempts to take the enemy's piece.
     *
     * @return true if possible, false if not.
     *****************************************************************/
    private boolean attemptToTakeAPiece() {
        boolean valid = false;

        int blackRow;
        int blackCol;
        Move attemptMove;

        // find a black piece
        for (int r = 0; r < numRows(); r++)
            for (int c = 0; c < numColumns(); c++) {

                if (board[r][c] != null && board[r][c].player().equals(Player.BLACK)) {

                    blackRow = r;
                    blackCol = c;

                    // find a white piece
                    for (int i = 0; i < numRows(); i++)
                        for (int j = 0; j < numColumns(); j++) {

                            if (board[i][j] != null && board[i][j].player().equals(Player.WHITE)) {

                                // if black can take white, take white
                                attemptMove = new Move(blackRow, blackCol, i, j);
                                if (isValidMove(attemptMove)) {
                                    saveMove(r,c,i,j);
                                    move(attemptMove);
                                    return true;
                                }
                            }
                        }
                }
            }

        return valid;
    }

    /******************************************************************
     * Attempts to remove a piece from danger of being taken.
     *
     * @return true if possible, false if not.
     *****************************************************************/
    private boolean attemptToRemoveDanger() {

        Move attemptMove;

        for (int r = 0; r < numRows(); r++) {
            for (int c  = 0; c < numColumns(); c++) {
                if (board[r][c] != null && board[r][c].player()
                        .equals(Player.BLACK))
                    if (canBeAttacked(Player.BLACK, r, c)) {
                        for (int i = 0; i < numRows(); i++) {
                            for (int j = 0; j < numColumns(); j++) {
                                attemptMove = new Move(r,c,i,j);
                                if (isValidMove(attemptMove) &&
                                        !canBeAttacked(Player.BLACK,
                                                i, j)) {
                                    saveMove(r,c,i,j);
                                    move(attemptMove);
                                    return true;
                                }
                            }
                        }
                    }
            }
        }

        return false;
    }
}
