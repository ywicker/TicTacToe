package lacombe.kata.cells;

import lacombe.kata.Cell;
import lacombe.kata.Cells;
import org.junit.jupiter.api.Test;

import static lacombe.kata.Player.PLAYER_X;
import static org.assertj.core.api.Assertions.assertThat;

public class CellsTest {
    @Test
    void set_X_at_the_coordinate_1_1_should_change_content_of_cell_only() {
        var cells = new Cells();

        cells.set(PLAYER_X, 1, 1);
        Cell cell = cells.get(1, 1);

        assertThat(cell.wasPlayedBy()).isEqualTo(PLAYER_X);
    }
}
