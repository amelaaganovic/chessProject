package ChessVersion3;

public class BoardState {

    private boolean isComplete, isInCheck, isValidForPiece, isValidForBoard, movingIntoCheck, moveTookPlace;

    public BoardState(boolean isComplete, boolean isInCheck, boolean isValidForPiece, boolean isValidForBoard, boolean movingIntoCheck, boolean moveTookPlace) {
        this.isComplete = isComplete;
        this.isInCheck = isInCheck;
        this.isValidForPiece = isValidForPiece;
        this.isValidForBoard = isValidForBoard;
        this.movingIntoCheck = movingIntoCheck;
        this.moveTookPlace = moveTookPlace;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isInCheck() {
        return isInCheck;
    }

    public void setInCheck(boolean inCheck) {
        isInCheck = inCheck;
    }

    public boolean isValidForPiece() {
        return isValidForPiece;
    }

    public void setValidForPiece(boolean validForPiece) {
        isValidForPiece = validForPiece;
    }

    public boolean isValidForBoard() {
        return isValidForBoard;
    }

    public void setValidForBoard(boolean validForBoard) {
        isValidForBoard = validForBoard;
    }

    public boolean isMovingIntoCheck() {
        return movingIntoCheck;
    }

    public void setMovingIntoCheck(boolean movingIntoCheck) {
        this.movingIntoCheck = movingIntoCheck;
    }

    public boolean isMoveTookPlace() {
        return moveTookPlace;
    }

    public void setMoveTookPlace(boolean moveTookPlace) {
        this.moveTookPlace = moveTookPlace;
    }
}
