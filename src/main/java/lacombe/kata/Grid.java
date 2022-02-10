package lacombe.kata;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
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

    public List<FieldSequence> rows() {
        return Stream.of(1, 2, 3).map(y ->
                new FieldSequence(cellList.stream()
                        .filter(cell -> cell.getCoordinate().y() == y)
                        .collect(Collectors.toSet()))
        ).toList();
    }
    public List<FieldSequence> columns() {
        return Stream.of(1, 2, 3).map(x ->
                new FieldSequence(cellList.stream()
                        .filter(cell -> cell.getCoordinate().x() == x)
                        .collect(Collectors.toSet()))
        ).toList();
    }
    public List<FieldSequence> diagonals() {
        return List.of(
                new FieldSequence(cellList.stream()
                    .filter(cell -> cell.getCoordinate().x() == cell.getCoordinate().y())
                        .collect(Collectors.toSet())),
                new FieldSequence(cellList.stream()
                    .filter(cell -> (cell.getCoordinate().x() + cell.getCoordinate().y()) == 4)
                        .collect(Collectors.toSet()))
        );
    }
}
