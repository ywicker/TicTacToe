package lacombe.kata;

import java.util.List;

public class Cells {
    private final List<Cell> cellList;

    public Cells() {
        this.cellList = List.of(
                new Cell(1, 1),
                new Cell(1, 2),
                new Cell(1, 3),
                new Cell(2, 1),
                new Cell(2, 2),
                new Cell(2, 3),
                new Cell(1, 1),
                new Cell(2, 2),
                new Cell(3, 3));
    }

    public void set(Player player, int x, int y) {
        this.get(x, y).setWasPlayedBy(player);
    }

    public Cell get(int x, int y) {
        return cellList.stream()
                .filter(cell -> x == cell.getX() && y == cell.getY())
                .findAny()
                .orElse(null);
    }
}
