package lacombe.kata;

import java.util.Objects;
import java.util.Set;

public class Grid {
    private final Set<Cell> cellList;

    public Grid() {
        this.cellList = Set.of(
                new Cell(new Coordinate(1, 1)),
                new Cell(new Coordinate(1, 2)),
                new Cell(new Coordinate(1, 3)),
                new Cell(new Coordinate(2, 1)),
                new Cell(new Coordinate(2, 2)),
                new Cell(new Coordinate(2, 3)),
                new Cell(new Coordinate(3, 1)),
                new Cell(new Coordinate(3, 2)),
                new Cell(new Coordinate(3, 3)));
    }

    public void set(Player player, int x, int y) {
        var cell = this.get(x, y);

        assert cell != null;

        cell.setWasPlayedBy(player);
    }

    public Cell get(int x, int y) {
        return cellList.stream()
                .filter(cell -> x == cell.getCoordinate().x() && y == cell.getCoordinate().y())
                .findAny()
                .orElse(null);
    }

    public boolean allFieldsAreTaken() {
        return cellList.stream()
                .map(Cell::getWasPlayedBy)
                .noneMatch(Objects::isNull);
    }

    public boolean rowOrColumnIsTakenBy(Player player) {
        for(int i = 1; i<=3; i++) {
            if(yRowIsTokenBy(player, i) || xColumnIsTokenBy(player, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean yRowIsTokenBy(Player player, int y) {
        return cellList.stream()
                .filter(cell -> cell.getCoordinate().y() == y)
                .map(Cell::getWasPlayedBy)
                .allMatch(player::equals);
    }

    private boolean xColumnIsTokenBy(Player player, int x) {
        return cellList.stream()
                .filter(cell -> cell.getCoordinate().x() == x)
                .map(Cell::getWasPlayedBy)
                .allMatch(player::equals);
    }

    public boolean diagonalIsTakenBy(Player player) {
        return cellList.stream()
                .filter(cell -> cell.getCoordinate().x() == cell.getCoordinate().y())
                .map(Cell::getWasPlayedBy)
                .allMatch(player::equals)
                || cellList.stream()
                .filter(cell -> (cell.getCoordinate().x() + cell.getCoordinate().y()) == 4)
                .map(Cell::getWasPlayedBy)
                .allMatch(player::equals);
    }
}
