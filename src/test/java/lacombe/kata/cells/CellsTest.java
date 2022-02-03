package lacombe.kata.cells;

import lacombe.kata.Cell;
import lacombe.kata.Cells;
import org.junit.jupiter.api.Test;

import static lacombe.kata.Player.PLAYER_O;
import static lacombe.kata.Player.PLAYER_X;
import static org.assertj.core.api.Assertions.assertThat;

public class CellsTest {
    @Test
    void set_X_at_the_coordinate_1_1_should_change_content_of_cell_only() {
        var cells = new Cells();

        cells.set(PLAYER_X, 1, 1);
        Cell cell_1_1 = cells.get(1, 1);
        Cell cell_1_2 = cells.get(1, 2);

        assertThat(cell_1_1.getWasPlayedBy()).isEqualTo(PLAYER_X);
        assertThat(cell_1_2.getWasPlayedBy()).isNull();
    }
    @Test
    void set_O_at_the_coordinate_1_2_should_change_content_of_cell_only() {
        var cells = new Cells();

        cells.set(PLAYER_O, 1, 2);
        Cell cell_1_1 = cells.get(1, 1);
        Cell cell_1_2 = cells.get(1, 2);

        assertThat(cell_1_1.getWasPlayedBy()).isNull();
        assertThat(cell_1_2.getWasPlayedBy()).isEqualTo(PLAYER_O);
    }
}
