public record Coordinates(int row, int col) {
    public Coordinates add(int row, int col) {
        return new Coordinates(this.row + row, this.col + col);
    }

    @Override
    public String toString() {
        return String.format("%d, %d", row, col);
    }
}
