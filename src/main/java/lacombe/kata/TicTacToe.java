package lacombe.kata;

import static lacombe.kata.PlayState.IS_OVER;

public class TicTacToe {
    PlayState state;
    Grid grid;

    public TicTacToe() {
        state = PlayState.PLAYER_X_TURN;
        grid = new Grid();
    }

    public void play(Player player, int x, int y) {
        grid.set(player, new Coordinate(x, y));

        state = changeState(player);
    }

    private PlayState changeState(Player player) {
        assert !state.equals(IS_OVER);
        assert player.equals(state.getPlayer());

        if(grid.allFieldsAreTaken()
                || grid.sequenceOfFieldsIsTokenBy(player)) {
            return IS_OVER;
        }
        return state.defaultNextState();
    }

    public PlayState state() {
        return state;
    }
}
