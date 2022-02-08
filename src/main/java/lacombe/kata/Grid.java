package lacombe.kata;

import java.util.Objects;
import java.util.Set;

public class Grid {
    private final Set<Cell> cellList;

    public Grid() {
        this.cellList = Set.of(
                new Cell(1, 1),
                new Cell(1, 2),
                new Cell(1, 3),
                new Cell(2, 1),
                new Cell(2, 2),
                new Cell(2, 3),
                new Cell(3, 1),
                new Cell(3, 2),
                new Cell(3, 3));
    }

    public void set(Player player, int x, int y) {
        var cell = this.get(x, y);

        assert cell != null;

        cell.setWasPlayedBy(player);
    }

    public Cell get(int x, int y) {
        return cellList.stream()
                .filter(cell -> x == cell.getX() && y == cell.getY())
                .findAny()
                .orElse(null);
    }

    public boolean allFieldsAreTaken() {
        return cellList.stream()
                .map(Cell::getWasPlayedBy)
                .noneMatch(Objects::isNull);
    }

    public boolean rowIsTakenBy(Player player) {
        for(int i = 1; i<=3; i++) {
            if(yRowIsTokenBy(player, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean yRowIsTokenBy(Player player, int y) {
        return cellList.stream()
                .filter(cell -> cell.getY() == y)
                .map(Cell::getWasPlayedBy)
                .allMatch(player::equals);
    }
    public boolean columnIsTakenBy(Player player) {
        for(int i = 1; i<=3; i++) {
            if(xColumnIsTokenBy(player, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean xColumnIsTokenBy(Player player, int x) {
        return cellList.stream()
                .filter(cell -> cell.getX() == x)
                .map(Cell::getWasPlayedBy)
                .allMatch(player::equals);
    }
}
