public class Game {
    public Board board;
    public PieceColor turn;
    
    Game(Board board) {
        this.board = board;
        turn = PieceColor.WHITE;
    }

    void playMove(Position start, Position target) {
        try {
            board.move(start, target);
        } catch (BadMoveException e) {
            System.out.println("Try different move");
        }
        turn = (turn == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE);
    }
}
