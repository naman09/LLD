public class HumanPlayer implements Player {
    private Color color;
    HumanPlayer(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return this.color;
    }
}
