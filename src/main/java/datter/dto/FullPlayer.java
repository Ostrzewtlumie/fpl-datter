package datter.dto;

public class FullPlayer {
    private Player player;
    private PlayerDetails playerDetails;

    public FullPlayer(Player player, PlayerDetails playerDetails) {
        this.player = player;
        this.playerDetails = playerDetails;
    }

    public Player getPlayer() {
        return player;
    }
}
