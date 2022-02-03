package lacombe.kata;

public enum PlayState {
    PLAYER_X_TURN() {
        public PlayState changeState(){
            return PLAYER_O_TURN;
        }
    },
    PLAYER_O_TURN() {
        public PlayState changeState(){
            return PLAYER_X_TURN;
        }
    };

    public PlayState changeState(){
        return null;
    }
}
