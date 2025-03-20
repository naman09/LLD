public class Move {
    private Position start;
    private Position end;
    private Piece pieceCaptured;
    private Boolean isPromotion;
    private Piece promotionPiece;
    private Boolean isCastling;
    private Boolean isEnPassant;

    Move(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public void setIsCastling(Boolean isCastling) {
        this.isCastling = isCastling;
    }
}
