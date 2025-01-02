public class Pawn extends Piece {
    Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    public Boolean isValidMove(Position start, Position target, Board board) {
        return true;
    }
}
