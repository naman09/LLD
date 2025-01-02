public class Board {
    private Piece[][] board;
    public Board(Integer n, Integer m) {
        board = new Piece[n][m];
        for (Integer i=0;i<n;i++) {
            for(Integer j=0;j<m;j++) board[i][j] = null;
        }
    }

    public Piece getPiece(Position position) {
        if (position.x >=0 && position.x<board.length && position.y>=0 && board.length > 0 && position.y < board[0].length) {
            return this.board[position.x][position.y];
        }
        return null;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public void move(Position start, Position target) throws BadMoveException {
        Piece piece = getPiece(start);
        if(!piece.isValidMove(start, target, this)) {
            throw new BadMoveException("invalid move");
        }
        this.board[start.x][start.y] = null;
        this.board[target.x][target.y] = piece;
    }
}
