import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private GameStatus gameStatus;
    private List<Move> moves;
    private Player currentPlayerTurn;

    Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.gameStatus = GameStatus.ONGOING;
        this.moves = new ArrayList<>();
    }

    public Boolean isValidMove() {
        return true;
    }

    public Boolean isCheckMate() {
        return true;
    }

    public void playMove(Position start, Position end, Player player) {
        // check if move is valid
        if (!isValidMove()) {
            System.out.println("invlalid move. try again w/ diff move");
            return;
        }
        if (isCheckMate()) {
            System.out.println("Player " + player.getColor().toString() + " wins by checkmate");
            if (player.getColor() == Color.BLACK) {
                this.gameStatus = GameStatus.BLACK_WINS_BY_CHECKMATE;
            } else {
                this.gameStatus = GameStatus.WHITE_WINS_BY_CHECKMATE;
            }
            return;
        }
        Move move = new Move(start, end);
        move.setIsCastling(false);
        moves.add(move);
     
        if (currentPlayerTurn == player1) {
            currentPlayerTurn = player2;
        } else {
            currentPlayerTurn = player1;
        }
    }
}
