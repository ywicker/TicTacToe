package lacombe.kata;

public record Coordinate(int x, int y) {
    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
