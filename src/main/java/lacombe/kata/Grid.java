package lacombe.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

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

    public void set(Player player, Coordinate coordinate) {
        var cell = this.get(coordinate);

        assert cell != null;

        cell.setWasPlayedBy(player);
    }

    public Cell get(Coordinate coordinate) {
        return cellList.stream()
                .filter(cell -> coordinate.equals(cell.getCoordinate()))
                .findAny()
                .orElse(null);
    }

    public boolean allFieldsAreTaken() {
        return cellList.stream()
                .map(Cell::getWasPlayedBy)
                .noneMatch(Objects::isNull);
    }

    public boolean rowOrColumnIsTakenBy(Player player) {
        List<List<Cell>> rowsOrColumns = new ArrayList<>();
        rowsOrColumns.addAll(rows());
        rowsOrColumns.addAll(columns());
        return rowsOrColumns.stream().anyMatch(cells ->
                cells.stream()
                        .map(Cell::getWasPlayedBy)
                        .allMatch(player::equals)
        );
    }

    public boolean diagonalIsTakenBy(Player player) {
        return diagonals().stream().anyMatch(cells ->
                cells.stream()
                        .map(Cell::getWasPlayedBy)
                        .allMatch(player::equals)
        );
    }

    private List<List<Cell>> rows() {
        return Stream.of(1, 2, 3).map(y ->
                cellList.stream()
                        .filter(cell -> cell.getCoordinate().y() == y)
                        .toList()
        ).toList();
    }
    private List<List<Cell>> columns() {
        return Stream.of(1, 2, 3).map(x ->
                cellList.stream()
                        .filter(cell -> cell.getCoordinate().x() == x)
                        .toList()
        ).toList();
    }
    private List<List<Cell>> diagonals() {
        return List.of(
                cellList.stream()
                    .filter(cell -> cell.getCoordinate().x() == cell.getCoordinate().y())
                    .toList(),
                cellList.stream()
                    .filter(cell -> (cell.getCoordinate().x() + cell.getCoordinate().y()) == 4)
                    .toList()
        );
    }
}
