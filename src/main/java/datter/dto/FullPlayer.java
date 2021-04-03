package datter.dto;

public class FullPlayer {
    private Player player;
    private PlayerDetails playerDetails;

    public FullPlayer(final Player player, final PlayerDetails playerDetails) {
        this.player = player;
        this.playerDetails = playerDetails;
    }

    public Player getPlayer() {
        return player;
    }
}
