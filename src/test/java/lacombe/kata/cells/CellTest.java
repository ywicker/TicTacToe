package lacombe.kata.cells;

import lacombe.kata.Cell;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lacombe.kata.Player.PLAYER_X;
import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {
    @Test
    void cell_1_1_is_not_equal_to_cell_1_2() {
        var cell_1_1 = new Cell(1, 1);

        var cell_1_2 = new Cell(1, 2);
        assertThat(cell_1_1).isNotEqualTo(cell_1_2);
    }
    @Test
    void filled_cell_1_1_is_equal_to_cell_1_1() {
        var filled_cell_1_1 = new Cell(1, 1);
        filled_cell_1_1.setWasPlayedBy(PLAYER_X);

        var cell_1_1 = new Cell(1, 1);
        assertThat(filled_cell_1_1).isEqualTo(cell_1_1);
    }
}
