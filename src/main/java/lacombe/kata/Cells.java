package lacombe.kata;

import java.util.Set;

public class Cells {
    private final Set<Cell> cellList;

    public Cells() {
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

        cell.setWasPlayedBy(player);
    }

    public Cell get(int x, int y) {
        return cellList.stream()
                .filter(cell -> x == cell.getX() && y == cell.getY())
                .findAny()
                .orElse(null);
    }
}
