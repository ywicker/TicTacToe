package lacombe.kata;

import java.util.Objects;

public class Cell {
    private final Coordinate coordinate;
    private Player player;

    public int getX() {
        return coordinate.x();
    }

    public int getY() {
        return coordinate.y();
    }

    public Cell(int x, int y) {
        coordinate = new Coordinate(x, y);
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
        return getX() == cell.getX() && getY() == cell.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
