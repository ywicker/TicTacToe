package lacombe.kata;

import static lacombe.kata.Player.PLAYER_O;
import static lacombe.kata.Player.PLAYER_X;

public enum PlayState {
    PLAYER_X_TURN(PLAYER_X) {
        public PlayState defaultNextState(){
            return PLAYER_O_TURN;
        }
    },
    PLAYER_O_TURN(PLAYER_O) {
        public PlayState defaultNextState(){
            return PLAYER_X_TURN;
        }
    },
    IS_OVER(null);

    private final Player player;

    PlayState(Player player) {
        this.player = player;
    }

    public PlayState defaultNextState(){
        return null;
    }

    public Player getPlayer() {
        return player;
    }
}
