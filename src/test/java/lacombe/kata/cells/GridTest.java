package lacombe.kata.cells;

import lacombe.kata.Cell;
import lacombe.kata.Coordinate;
import lacombe.kata.FieldSequences;
import lacombe.kata.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static lacombe.kata.Player.PLAYER_O;
import static lacombe.kata.Player.PLAYER_X;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GridTest {
    @Test
    void set_X_at_the_coordinate_1_1_should_change_content_of_cell_only() {
        var cells = new Grid();

        cells.set(PLAYER_X, new Coordinate(1, 1));
        Cell cell_1_1 = cells.get(new Coordinate(1, 1));
        Cell cell_1_2 = cells.get(new Coordinate(1, 2));

        assertThat(cell_1_1.getWasPlayedBy()).isEqualTo(PLAYER_X);
        assertThat(cell_1_2.getWasPlayedBy()).isNull();
    }
    @Test
    void set_O_at_the_coordinate_1_2_should_change_content_of_cell_only() {
        var cells = new Grid();

        cells.set(PLAYER_O, new Coordinate(1, 2));
        Cell cell_1_1 = cells.get(new Coordinate(1, 1));
        Cell cell_1_2 = cells.get(new Coordinate(1, 2));

        assertThat(cell_1_1.getWasPlayedBy()).isNull();
        assertThat(cell_1_2.getWasPlayedBy()).isEqualTo(PLAYER_O);
    }
    @Test
    void set_X_at_the_coordinate_3_3_should_change_content_of_cell() {
        var cells = new Grid();

        cells.set(PLAYER_O, new Coordinate(3, 3));
        Cell cell_1_1 = cells.get(new Coordinate(1, 1));
        Cell cell_1_2 = cells.get(new Coordinate(1, 2));
        Cell cell_3_3 = cells.get(new Coordinate(3, 3));

        assertThat(cell_1_1.getWasPlayedBy()).isNull();
        assertThat(cell_1_2.getWasPlayedBy()).isNull();
        assertThat(cell_3_3.getWasPlayedBy()).isEqualTo(PLAYER_O);
    }
    @Test
    void set_X_to_a_cell_already_taken_should_return_error() {
        var cells = new Grid();

        cells.set(PLAYER_X, new Coordinate(2, 2));

        assertThatThrownBy(() -> cells.set(PLAYER_O, new Coordinate(2, 2)))
                .isInstanceOf(AssertionError.class);
    }
    @Test
    void set_X_to_a_coordinate_does_not_exist_should_return_error() {
        var cells = new Grid();

        assertThatThrownBy(() -> cells.set(PLAYER_O, new Coordinate(4, 2)))
                .isInstanceOf(AssertionError.class);
    }
    @Test
    void all_fields_are_taken_when_all_cells_were_set() {
        var cells = new Grid();

        cells.set(PLAYER_X, new Coordinate(1, 1));
        cells.set(PLAYER_O, new Coordinate(2, 2));
        cells.set(PLAYER_X, new Coordinate(1, 2));
        cells.set(PLAYER_O, new Coordinate(1, 3));
        cells.set(PLAYER_X, new Coordinate(3, 1));
        cells.set(PLAYER_O, new Coordinate(2, 1));
        cells.set(PLAYER_X, new Coordinate(2, 3));
        cells.set(PLAYER_O, new Coordinate(3, 2));
        cells.set(PLAYER_X, new Coordinate(3, 3));

        Assertions.assertTrue(cells.allFieldsAreTaken());
    }
    @Test
    void all_fields_are_not_taken_when_only_one_cell_was_set() {
        var cells = new Grid();

        cells.set(PLAYER_X, new Coordinate(1, 1));

        Assertions.assertFalse(cells.allFieldsAreTaken());
    }
    @Test
    void all_fields_in_a_line_are_taken_by_the_player_X_when_the_first_line_has_been_filled_by_player_X() {
        var cells = new Grid();
        var fieldSequences = new FieldSequences(cells);

        cells.set(PLAYER_X, new Coordinate(1, 1));
        cells.set(PLAYER_O, new Coordinate(2, 2));
        cells.set(PLAYER_X, new Coordinate(2, 1));
        cells.set(PLAYER_O, new Coordinate(3, 2));
        cells.set(PLAYER_X, new Coordinate(3, 1));

        Assertions.assertTrue(fieldSequences.anyIsCompletelyTokenBy(PLAYER_X));
    }
    @Test
    void all_fields_in_a_line_are_taken_by_the_player_O_when_the_third_line_has_been_filled_by_player_O() {
        var cells = new Grid();
        var fieldSequences = new FieldSequences(cells);

        cells.set(PLAYER_X, new Coordinate(1, 1));
        cells.set(PLAYER_O, new Coordinate(1, 3));
        cells.set(PLAYER_X, new Coordinate(2, 2));
        cells.set(PLAYER_O, new Coordinate(3, 3));
        cells.set(PLAYER_X, new Coordinate(3, 1));
        cells.set(PLAYER_O, new Coordinate(2, 3));

        Assertions.assertTrue(fieldSequences.anyIsCompletelyTokenBy(PLAYER_O));
    }
    @Test
    void all_fields_in_a_column_are_taken_by_the_player_X_when_the_first_column_has_been_filled_by_player_X() {
        var cells = new Grid();
        var fieldSequences = new FieldSequences(cells);

        cells.set(PLAYER_X, new Coordinate(1, 1));
        cells.set(PLAYER_O, new Coordinate(2, 2));
        cells.set(PLAYER_X, new Coordinate(1, 2));
        cells.set(PLAYER_O, new Coordinate(2, 3));
        cells.set(PLAYER_X, new Coordinate(1, 3));

        Assertions.assertTrue(fieldSequences.anyIsCompletelyTokenBy(PLAYER_X));
    }
    @Test
    void all_fields_in_a_column_are_not_taken_by_the_player_X_when_no_column_has_been_filled_by_player_X() {
        var cells = new Grid();
        var fieldSequences = new FieldSequences(cells);

        cells.set(PLAYER_X, new Coordinate(1, 1));
        cells.set(PLAYER_O, new Coordinate(2, 2));
        cells.set(PLAYER_X, new Coordinate(2, 1));
        cells.set(PLAYER_O, new Coordinate(3, 2));

        Assertions.assertFalse(fieldSequences.anyIsCompletelyTokenBy(PLAYER_X));
    }
    @Test
    void all_fields_in_a_column_are_taken_by_the_player_O_when_the_third_column_has_been_filled_by_player_O() {
        var cells = new Grid();
        var fieldSequences = new FieldSequences(cells);

        cells.set(PLAYER_X, new Coordinate(1, 1));
        cells.set(PLAYER_O, new Coordinate(3, 1));
        cells.set(PLAYER_X, new Coordinate(2, 2));
        cells.set(PLAYER_O, new Coordinate(3, 3));
        cells.set(PLAYER_X, new Coordinate(2, 3));
        cells.set(PLAYER_O, new Coordinate(3, 2));

        Assertions.assertTrue(fieldSequences.anyIsCompletelyTokenBy(PLAYER_O));
    }
    @Test
    void all_fields_in_a_diagonal_are_taken_by_the_player_X_when_the_first_diagonal_has_been_filled_by_player_X() {
        var cells = new Grid();
        var fieldSequences = new FieldSequences(cells);

        cells.set(PLAYER_X, new Coordinate(1, 1));
        cells.set(PLAYER_O, new Coordinate(1, 2));
        cells.set(PLAYER_X, new Coordinate(2, 2));
        cells.set(PLAYER_O, new Coordinate(1, 3));
        cells.set(PLAYER_X, new Coordinate(3, 3));

        Assertions.assertTrue(fieldSequences.anyIsCompletelyTokenBy(PLAYER_X));
    }
    @Test
    void all_fields_in_a_diagonal_are_not_taken_by_the_player_X_when_the_first_diagonal_has_not_been_filled_by_player_X() {
        var cells = new Grid();
        var fieldSequences = new FieldSequences(cells);

        cells.set(PLAYER_X, new Coordinate(1, 1));
        cells.set(PLAYER_O, new Coordinate(1, 2));
        cells.set(PLAYER_X, new Coordinate(2, 2));
        cells.set(PLAYER_O, new Coordinate(3, 3));
        cells.set(PLAYER_X, new Coordinate(1, 3));

        Assertions.assertFalse(fieldSequences.anyIsCompletelyTokenBy(PLAYER_X));
    }
    @Test
    void all_fields_in_a_diagonal_are_taken_by_the_player_X_when_the_second_diagonal_has_been_filled_by_player_X() {
        var cells = new Grid();
        var fieldSequences = new FieldSequences(cells);

        cells.set(PLAYER_X, new Coordinate(1, 3));
        cells.set(PLAYER_O, new Coordinate(1, 2));
        cells.set(PLAYER_X, new Coordinate(2, 2));
        cells.set(PLAYER_O, new Coordinate(3, 3));
        cells.set(PLAYER_X, new Coordinate(3, 1));

        Assertions.assertTrue(fieldSequences.anyIsCompletelyTokenBy(PLAYER_X));
    }

}
