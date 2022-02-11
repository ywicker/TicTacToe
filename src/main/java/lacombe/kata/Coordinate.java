package lacombe.kata;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Coordinate(int x, int y) {

    public static @NotNull Set<Coordinate> coordinateListOfSizeGrid(List<Integer> gridRange) {
        Set<Coordinate> coordinates = new HashSet<>();
        gridRange.forEach(x ->
                gridRange.forEach(y -> coordinates.add(new Coordinate(x, y)))
        );
        return coordinates;
    }
}
