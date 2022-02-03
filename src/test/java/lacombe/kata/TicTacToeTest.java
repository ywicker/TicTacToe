package lacombe.kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lacombe.kata.PlayState.PLAYER_O_TURN;
import static lacombe.kata.PlayState.PLAYER_X_TURN;
import static lacombe.kata.Player.PLAYER_O;
import static lacombe.kata.Player.PLAYER_X;
import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeTest {
    @Test
    void player_X_is_playing_should_change_state_to_player_0_turn() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(PLAYER_X, 1, 1);

        assertThat(ticTacToe.state()).isEqualTo(PLAYER_O_TURN);
    }
    @Test
    void player_0_is_playing_after_player_X_should_change_state_to_player_X_turn() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(PLAYER_X, 1, 1);
        ticTacToe.play(PLAYER_O, 1, 2);

        assertThat(ticTacToe.state()).isEqualTo(PLAYER_X_TURN);
    }
    @Test
    void player_O_plays_first_should_return_error() {
        var ticTacToe = new TicTacToe();

        Assertions.assertThatThrownBy(() -> ticTacToe.play(PLAYER_O, 1, 1))
                .isInstanceOf(AssertionError.class);
    }
    @Test
    void player_X_is_playing_twice_should_return_error() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(PLAYER_X, 1, 1);

        Assertions.assertThatThrownBy(() -> ticTacToe.play(PLAYER_X, 1, 2))
                .isInstanceOf(AssertionError.class);
    }
}
