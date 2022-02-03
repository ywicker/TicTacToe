package lacombe.kata;

public class TicTacToe {
    PlayState state;

    public TicTacToe() {
        state = PlayState.PLAYER_X_TURN;
    }

    public void play(Player player) {
        state = state.changeState(player);
    }

    public PlayState state() {
        return state;
    }
}
