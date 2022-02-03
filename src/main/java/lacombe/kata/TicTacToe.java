package lacombe.kata;

import static lacombe.kata.PlayState.PLAYER_O_TURN;
import static lacombe.kata.PlayState.PLAYER_X_TURN;

public class TicTacToe {
    PlayState state;

    public TicTacToe() {
        state = PlayState.PLAYER_X_TURN;
    }

    public void play(Player playerX) {
        if (playerX.equals(Player.PLAYER_O)) {
            state = PLAYER_X_TURN;
        } else if (playerX.equals(Player.PLAYER_X)) {
            state = PLAYER_O_TURN;
        }
    }

    public PlayState state() {
        return state;
    }
}
