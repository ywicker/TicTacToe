package lacombe.kata;

import static lacombe.kata.Player.PLAYER_O;
import static lacombe.kata.Player.PLAYER_X;

public enum PlayState {
    PLAYER_X_TURN(PLAYER_X) {
        public PlayState changeState(Player player){
            super.changeState(player);
            return PLAYER_O_TURN;
        }
    },
    PLAYER_O_TURN(PLAYER_O) {
        public PlayState changeState(Player player){
            super.changeState(player);
            return PLAYER_X_TURN;
        }
    },
    IS_OVER(null);

    private final Player player;

    PlayState(Player player) {
        this.player = player;
    }

    public PlayState changeState(Player player){
        assert this.player.equals(player);
        return null;
    }
}
