public class CPUPlayer implements Player {
    private Color color;
    CPUPlayer(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return this.color;
    }
}
