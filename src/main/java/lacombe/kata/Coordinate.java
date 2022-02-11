package lacombe.kata;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public record Coordinate(int x, int y) {
    public static int START_COORDINATE = 1;

    public static @NotNull Set<Coordinate> coordinateListOfSizeGrid(int size) {
        Set<Coordinate> coordinates = new HashSet<>();
        for(int x = START_COORDINATE; x <= size; x++)
            for (int y = START_COORDINATE; y <= size; y++) {
                coordinates.add(new Coordinate(x, y));
            }

        return coordinates;
    }
}
