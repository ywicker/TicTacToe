package lacombe.kata;

import static lacombe.kata.GameState.*;

public class TicTacToe {
    GameState state;
    Grid grid;

    public TicTacToe() {
        state = GameState.PLAYER_X_TURN;
        grid = new Grid();
    }

    public void play(Player player, int x, int y) {
        grid.set(player, new Coordinate(x, y));

        state = changeState(player);
    }

    private GameState changeState(Player player) {
        assert !state.equals(IS_OVER);
        assert player.equals(state.getPlayer());

        if(grid.allFieldsAreTaken()) {
            return IS_OVER;
        } else if(grid.sequenceOfFieldsIsTokenBy(player)){
            return state.gameWonBy(player);
        }
        return state.defaultNextState();
    }

    public GameState state() {
        return state;
    }
}
