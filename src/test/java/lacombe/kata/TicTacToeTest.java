package lacombe.kata;

import org.junit.jupiter.api.Test;

import static lacombe.kata.PlayState.PLAYER_O_TURN;
import static lacombe.kata.Player.PLAYER_X;
import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeTest {
    @Test
    void player_X_plays_should_change_state_to_player_0_turn() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(PLAYER_X);

        assertThat(ticTacToe.state()).isEqualTo(PLAYER_O_TURN);
    }
}
