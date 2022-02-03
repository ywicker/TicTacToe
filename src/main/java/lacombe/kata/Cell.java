package lacombe.kata;

import static lacombe.kata.Player.PLAYER_X;

public class Cell {
    private final int x;
    private final int y;
    private Player player;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Player getWasPlayedBy() {
        return player;
    }

    public void setWasPlayedBy(Player player) {
        this.player = player;
    }
}
