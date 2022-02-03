package lacombe.kata;

import static lacombe.kata.PlayState.PLAYER_X_TURN;

public class TicTacToe {
    PlayState state;

    public TicTacToe() {
        state = PlayState.PLAYER_X_TURN;
    }

    public void play(Player playerX) {
        state = state.changeState();
    }

    public PlayState state() {
        return state;
    }
}
