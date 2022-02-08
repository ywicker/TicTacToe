package lacombe.kata;

import java.util.Objects;

public class Cell {
    private final Coordinate coordinate;
    private Player player;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Player getWasPlayedBy() {
        return player;
    }

    public void setWasPlayedBy(Player player) {
        assert this.player == null;
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return coordinate.equals(cell.getCoordinate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinate=" + coordinate +
                ", player=" + player +
                '}';
    }
}
