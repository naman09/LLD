public class Main {
    public static void main(String[] args) {
        System.out.println("Game");
        Spot[][] spots = new Spot[8][8];
        spots[0][0] = new Spot(new Position(0, 0), new Pawn(), Color.BLACK);
        Board board = new Board(spots);

        Player p1 = new HumanPlayer(Color.BLACK);
        Player p2 = new HumanPlayer(Color.WHITE);
        Game g1 = new Game(board, p1, p2);

        g1.playMove(new Position(1,1), new Position(2, 2), p1);
        // g1.playMove(new Position(5,5), new Position(5, 6), p2);
    }
}
