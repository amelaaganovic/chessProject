package chess;
/*	ChessPanel.java
This class is responsible for
1. presenting the GUI
2. respond to user actions
3. updates view
4. allows white to move before black
5. allows only valid moves
 */

import java.awt.*;
import java.awt.event.*;
import java.net.SocketOption;
import javax.swing.*;
import java.awt.BorderLayout;

/**********************************************************************
 * A panel that displays the chess board.
 *
 * @author Amela Aganovic, Emily Linderman, Xue Hua
 * @version Winter 2019
 **********************************************************************/
public class ChessPanel extends JPanel {

    /* the board */
    private JButton[][] board;

    /* the model */
    private ChessModel model;

    /* image of white rook */
    private ImageIcon wRook;

    /* image of white bishop */
    private ImageIcon wBishop;

    /* image of white queen */
    private ImageIcon wQueen;

    /* image of white king */
    private ImageIcon wKing;

    /* image of white pawn */
    private ImageIcon wPawn;

    /* image of white knight */
    private ImageIcon wKnight;

    /* image of black rook */
    private ImageIcon bRook;

    /* image of black bishop */
    private ImageIcon bBishop;

    /* image of black queen */
    private ImageIcon bQueen;

    /* image of black king */
    private ImageIcon bKing;

    /* image of black pawn */
    private ImageIcon bPawn;

    /* image of black knight */
    private ImageIcon bKnight;

    /* flagging first turn */
    private boolean firstTurnFlag;

    /* initial row */
    private int fromRow;

    /* row being moved to */
    private int toRow;

    /* initial column */
    private int fromCol;

    /* column being moved to */
    private int toCol;

    /* undo button */
    private JButton undo;

    /* new game button */
    private JButton newGame;

    /* last move */
    private JLabel lastMove;

    /* current turn */ // FIXME just for testing purposes?
    private JLabel currentTurn;

    /* listener for action performed */
    private listener listener;

    /*****************************************************************
     * Constructor that initializes the chess panel.
     *****************************************************************/
    public ChessPanel() {
        // creating the game
        model = new ChessModel();
        board = new JButton[model.numRows()][model.numColumns()];
        listener = new listener();

        // Buttons and JLabels
        undo = new JButton("Undo");
        undo.addActionListener(listener);
        newGame = new JButton("New Game");
        newGame.addActionListener(listener);

        lastMove = new JLabel("Last Move:  none");
        currentTurn = new JLabel("Turn:  White");

        // Panels
        JPanel boardpanel = new JPanel();
        JPanel buttonpanel = new JPanel();
        buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.Y_AXIS));
        buttonpanel.add(Box.createRigidArea(new Dimension(30, 40)));
        setLayout(new BorderLayout());
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastMove.setAlignmentX(Component.CENTER_ALIGNMENT);
        undo.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentTurn.setAlignmentX(Component.CENTER_ALIGNMENT);

        // adding to panel
        buttonpanel.add(newGame);
        buttonpanel.add(lastMove);
        buttonpanel.add(undo);
        buttonpanel.add(currentTurn);

        // sets the game layout
        boardpanel.setLayout(new GridLayout(model.numRows(), model.numColumns(), 1, 1));

        // creates images for pieces
        createIcons();

        // placing pieces
        for (int r = 0; r < model.numRows(); r++) {
            for (int c = 0; c < model.numColumns(); c++) {
                if (model.pieceAt(r, c) == null) {
                    board[r][c] = new JButton("", null);
                    board[r][c].addActionListener(listener);
                } else if (model.pieceAt(r, c).player() == Player.WHITE)
                    placeWhitePieces(r, c);
                else if (model.pieceAt(r, c).player() == Player.BLACK)
                    placeBlackPieces(r, c);

                setBackGroundColor(r, c);
                boardpanel.add(board[r][c]);
            }
        }
        boardpanel.setPreferredSize(new Dimension(600, 550));

        add(boardpanel, BorderLayout.WEST);
        add(buttonpanel, BorderLayout.CENTER);

        firstTurnFlag = true;
    }

    /*****************************************************************
     * Sets the background color of a spot on the board.
     *
     * @param r the row
     * @param c the column
     *****************************************************************/
    private void setBackGroundColor(int r, int c) {
        if ((c % 2 == 1 && r % 2 == 0) || (c % 2 == 0 && r % 2 == 1)) {
            board[r][c].setBackground(Color.LIGHT_GRAY);
        } else if ((c % 2 == 0 && r % 2 == 0) || (c % 2 == 1 && r % 2 == 1)) {
            board[r][c].setBackground(Color.WHITE);
        }
    }

    /*****************************************************************
     * Places the white pieces on the board.
     *
     * @param r the row
     * @param c the column
     *****************************************************************/
    private void placeWhitePieces(int r, int c) {
        if (model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, wPawn);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, wRook);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, wKnight);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, wBishop);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, wQueen);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, wKing);
            board[r][c].addActionListener(listener);
        }
    }

    /*****************************************************************
     * Places the black pieces on the board.
     *
     * @param r the row
     * @param c the column
     *****************************************************************/
    private void placeBlackPieces(int r, int c) {
        if (model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, bPawn);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, bRook);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, bKnight);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, bBishop);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, bQueen);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, bKing);
            board[r][c].addActionListener(listener);
        }
    }

    /*****************************************************************
     * Creates the icons for the pieces.
     *****************************************************************/
    private void createIcons() {
        // Sets the Image for white player pieces
        wRook = new ImageIcon("./src/chess/images/wRook.png");
        wBishop = new ImageIcon("./src/chess/images/wBishop.png");
        wQueen = new ImageIcon("./src/chess/images/wQueen.png");
        wKing = new ImageIcon("./src/chess/images/wKing.png");
        wPawn = new ImageIcon("./src/chess/images/wPawn.png");
        wKnight = new ImageIcon("./src/chess/images/wKnight.png");

        bRook = new ImageIcon("./src/chess/images/bRook.png");
        bBishop = new ImageIcon("./src/chess/images/bBishop.png");
        bQueen = new ImageIcon("./src/chess/images/bQueen.png");
        bKing = new ImageIcon("./src/chess/images/bKing.png");
        bPawn = new ImageIcon("./src/chess/images/bPawn.png");
        bKnight = new ImageIcon("./src/chess/images/bKnight.png");
    }

    /*****************************************************************
     * Highlights a selected spot on the board.
     *
     * @param r the row
     * @param c the column
     * @param select if the spot is selected
     *****************************************************************/
    private void toggleSpace(int r, int c, boolean select) {
        if (select) {
            board[r][c].setBackground(Color.PINK);
            System.out.println("Highlighting" + " [ " + r + " ] " + " [ " + c + " ] ");
        } else {
            setBackGroundColor(r, c);
            System.out.println("Un-Highlighting" + " [ " + r + " ] " + " [ " + c + " ] ");
        }
    }

    /*****************************************************************
     * Updates the display of the board.
     *****************************************************************/
    private void displayBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++)
                if (model.pieceAt(r, c) == null)
                    board[r][c].setIcon(null);
                else if (model.pieceAt(r, c).player() == Player.WHITE) {
                    if (model.pieceAt(r, c).type().equals("Pawn"))
                        board[r][c].setIcon(wPawn);

                    if (model.pieceAt(r, c).type().equals("Rook"))
                        board[r][c].setIcon(wRook);

                    if (model.pieceAt(r, c).type().equals("Knight"))
                        board[r][c].setIcon(wKnight);

                    if (model.pieceAt(r, c).type().equals("Bishop"))
                        board[r][c].setIcon(wBishop);

                    if (model.pieceAt(r, c).type().equals("Queen"))
                        board[r][c].setIcon(wQueen);

                    if (model.pieceAt(r, c).type().equals("King"))
                        board[r][c].setIcon(wKing);

                } else {
                    if (model.pieceAt(r, c).type().equals("Pawn"))
                        board[r][c].setIcon(bPawn);

                    if (model.pieceAt(r, c).type().equals("Rook"))
                        board[r][c].setIcon(bRook);

                    if (model.pieceAt(r, c).type().equals("Knight"))
                        board[r][c].setIcon(bKnight);

                    if (model.pieceAt(r, c).type().equals("Bishop"))
                        board[r][c].setIcon(bBishop);

                    if (model.pieceAt(r, c).type().equals("Queen"))
                        board[r][c].setIcon(bQueen);

                    if (model.pieceAt(r, c).type().equals("King"))
                        board[r][c].setIcon(bKing);
                }
        }

        repaint();
/*        if (model.inCheck(Player.BLACK))
            JOptionPane.showMessageDialog(null, "Black in Check");
        if (model.inCheck(Player.WHITE))
            JOptionPane.showMessageDialog(null, "White in Check");*/
        if (model.inCheck(model.currentPlayer()))
            JOptionPane.showMessageDialog(null, "King in Check");

    }

    /******************************************************************
     An action listener that processes action events.

     @author Amela Aganovic, Emily Linderman, Xue Hua
     @version Winter 2019
     *****************************************************************/
    private class listener implements ActionListener {

        /**************************************************************
         * Processes action events
         *
         * @param event the action event
         *************************************************************/
        public void actionPerformed(ActionEvent event) {

            if (newGame == event.getSource()) {
                model.newGame();
                displayBoard();
            }

            if (undo == event.getSource()){
                model.undo();
                displayBoard();
            }

            for (int r = 0; r < model.numRows(); r++)
                for (int c = 0; c < model.numColumns(); c++)
                    if (board[r][c] == event.getSource()) {

                        // Only execute if space is occupied and it is the piece's turn OR it is not the first Turn
                        if ((model.isOccupied(r, c) && model.pieceAt(r, c).player() == model.currentPlayer())
                                || !firstTurnFlag) {

                            if (firstTurnFlag == true) {
                                fromRow = r;
                                fromCol = c;
                                firstTurnFlag = false;
                                if (model.pieceAt(r, c).player() == model.currentPlayer())
                                    toggleSpace(fromRow, fromCol, true);

                            } else {
                                toRow = r;
                                toCol = c;
                                firstTurnFlag = true;

                                Move m = new Move(fromRow, fromCol, toRow, toCol);
                                toggleSpace(fromRow, fromCol, false);
                                if ((model.isValidMove(m)) == true) {

                                    //toggleSpace(fromRow, fromCol, false);
                                    model.saveMove(fromRow, fromCol, toRow, toCol); // FIXME
                                    model.move(m);
                                    //model.saveMove(fromRow, fromCol, toRow, toCol); //FIXME
                                    model.setNextPlayer();
                                }
                                lastMove.setText(m.toString()); // FIXME
                                currentTurn.setText("Turn : " + model.currentPlayer()); // FIXME
                                displayBoard();

                            }
                        }
                    }
        }
    }
}
