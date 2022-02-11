package lacombe.kata;

import lacombe.kata.errors.GameStateIsOverException;
import lacombe.kata.errors.PlayerTurnException;

import java.util.List;

import static lacombe.kata.GameState.*;

public class TicTacToe {
    GameState state;
    Grid grid;
    FieldSequences fieldSequences;

    public TicTacToe() {
        state = GameState.PLAYER_X_TURN;
        grid = new Grid();
        fieldSequences = new FieldSequences(grid);
    }

    public void play(Player player, int x, int y) throws Exception {
        assert !state.equals(IS_OVER);
        if(List.of(IS_OVER, PLAYER_O_WINS, PLAYER_X_WINS).contains(state)) {
            throw new GameStateIsOverException();
        }
        if(!player.equals(state.getPlayer())) {
            throw new PlayerTurnException(player);
        }
        assert player.equals(state.getPlayer());

        grid.set(player, new Coordinate(x, y));

        state = changeState(player);
    }

    private GameState changeState(Player player) {
        if(grid.allFieldsAreTaken()) {
            return IS_OVER;
        } else if(fieldSequences.anyIsCompletelyTokenBy(player)){
            return state.gameWonBy(player);
        }
        return state.defaultNextState();
    }

    public GameState state() {
        return state;
    }
}
