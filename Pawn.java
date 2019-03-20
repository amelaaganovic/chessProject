package ChessVersion2;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import javax.swing.*;

// Assume all comments were done by XUE unless otherwise stated
public class Pawn extends ChessPiece {

    /* Checks if this is Pawn's first move */
    private boolean firstMove;

    public Pawn(Player player, boolean firstMove) {
        super(player);
        this.firstMove = firstMove;
    }

    public String type() {
        return "Pawn";
    }


    // determines if the move is valid for a pawn piece
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = false;

        System.out.print("...moving PAWN");

        //  MOVING FORWARD //
        if (move.toColumn == move.fromColumn) {
            if (player() == Player.WHITE)
                if (firstMove) {    // move 2 spaces if want to
                    if ((move.toRow == move.fromRow - 1) || (move.toRow == move.fromRow - 2)) {
                        valid = true;
                        System.out.println("...2 spaces... SUCCESS");
                        firstMove = false;      // disables the flag for remaining of the game
                    }

                } else {        // move once each time
                    if (move.toRow == move.fromRow - 1) {
                        if (board[move.toRow][move.toColumn] == null) {
                            valid = true;
                            System.out.println("...1 space... SUCCESS");
                        }
                    }
                }

            if (player() == Player.BLACK)
                if (firstMove) {
                    if ((move.toRow == move.fromRow + 1) || (move.toRow == move.fromRow + 2)) {
                        valid = true;
                        System.out.println("...2 spaces... SUCCESS");
                        firstMove = false;
                    }

                } else {
                    if (move.toRow == move.fromRow + 1) {
                        if (board[move.toRow][move.toColumn] == null) {
                            valid = true;
                            System.out.println("...1 space... SUCCESS");

                        }
                    }
                }
        }

        // MOVING TO CAPTURE //
        if (ifCapture(move, board))
            valid = true;
        if (!valid)
            System.out.println("...invalid move!");
        else
            if(ifPromote(move)) {
                toPromote(move,board);
                /*board[move.toRow][move.toColumn] = new Rook(player());
                board[move.fromRow][move.fromColumn] = null;*/
            }
        if (!super.isValidMove(move, board))
            valid = false;

        return valid;
    }

    private boolean ifCapture(Move move, IChessPiece[][] board) {
        if (player() == Player.BLACK) {
            if (move.toRow == move.fromRow + 1)
                if ((move.toColumn == move.fromColumn - 1) || (move.toColumn == move.fromColumn + 1)) {
                    if (board[move.toRow][move.toColumn] != null &&
                            board[move.toRow][move.toColumn].player() == Player.WHITE) {
                        return true;
                    }
                }
        }
        if (player() == Player.WHITE) {
            if (move.toRow == move.fromRow - 1)
                if ((move.toColumn == move.fromColumn - 1) || (move.toColumn == move.fromColumn + 1)) {
                    if (board[move.toRow][move.toColumn] != null &&
                            board[move.toRow][move.toColumn].player() == Player.BLACK) {
                        return true;
                    }
                }
        }
        return false;
    }
private boolean ifPromote(Move move ){
        if(move.toRow == 0 || move.toRow == 7)
            return true ;
        return false;
}

    private void toPromote(Move move, IChessPiece[][] board) {
        final JFrame frame = new JFrame("Promoting the Pawn");

        // implement ItemListener interface
        class MyItemListener implements ItemListener {
            public void itemStateChanged(ItemEvent ev) {
                boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
                AbstractButton button = (AbstractButton) ev.getItemSelectable();
                String command = button.getActionCommand();
                if (selected) {
                    int optionType = -1;

                    if (command.equals("Queen")) {

                        board[move.toRow][move.toColumn] = new Queen(player());

                        System.out.println("meow");

                    } else if (command.equals("Bishop")) {
                        //optionType = JOptionPane.YES_NO_CANCEL_OPTION;
                        board[move.toRow][move.toColumn] = new Bishop(player());
                    }
                    else if (command.equals("Knight")) {
                        //optionType = JOptionPane.YES_NO_CANCEL_OPTION;
                        board[move.toRow][move.toColumn] = new Knight(player());
                    }
                    else if (command.equals("Rook")) {
                        //optionType = JOptionPane.YES_NO_CANCEL_OPTION;
                        board[move.toRow][move.toColumn] = new Rook(player());
                    }
                    board[move.fromRow][move.fromColumn] = null;

                    JOptionPane.showOptionDialog(frame,
                            "Are you sure to confirm the action you've made?",
                            "Promoting Pawn",
                            optionType,
                            JOptionPane.INFORMATION_MESSAGE, // icon
                            null,
                            null,
                            null);
                }
            }
        }
        JRadioButton queenRadio = new JRadioButton("Queen");
        queenRadio.setActionCommand("Queen");

        JRadioButton bishopRadio = new JRadioButton("Bishop");
        bishopRadio.setActionCommand("Bishop");

        JRadioButton knightRadio = new JRadioButton("Knight");
        knightRadio.setActionCommand("Knight");

        JRadioButton rookRadio = new JRadioButton("Rook");
        rookRadio.setActionCommand("Rook");

        // add event handlers
        MyItemListener myItemListener = new MyItemListener();
        queenRadio.addItemListener(myItemListener);
        bishopRadio.addItemListener(myItemListener);
        knightRadio.addItemListener(myItemListener);
        rookRadio.addItemListener(myItemListener);

        // add radio buttons to a ButtonGroup
        final ButtonGroup group = new ButtonGroup();
        group.add(queenRadio);
        group.add(bishopRadio);
        group.add(knightRadio);
        group.add(rookRadio);

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(300, 200);
        Container cont = frame.getContentPane();
        cont.setLayout(new GridLayout(0, 1));
        frame.add(new JLabel("Choose piece to promote to: "));
        frame.add(queenRadio);
        frame.add(bishopRadio);
        frame.add(knightRadio);
        frame.add(rookRadio);

        frame.setVisible(true);
    }

}
