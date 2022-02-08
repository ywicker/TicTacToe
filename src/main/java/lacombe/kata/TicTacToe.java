package lacombe.kata;

public class TicTacToe {
    PlayState state;
    Grid grid;

    public TicTacToe() {
        state = PlayState.PLAYER_X_TURN;
        grid = new Grid();
    }

    public void play(Player player, int x, int y) {
        grid.set(player, x, y);

        var isEndGame = grid.allFieldsAreTaken()
                || grid.rowOrColumnIsTakenBy(player);

        state = state.changeState(player, isEndGame);
    }

    public PlayState state() {
        return state;
    }
}
