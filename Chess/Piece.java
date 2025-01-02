public abstract class Piece {
    public Position position;
    public final PieceColor pieceColor;
    
    public Piece(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }
    
    public abstract Boolean isValidMove(Position start, Position target, Board board);
}
