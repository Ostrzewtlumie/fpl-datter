package datter.dto;

public class Player {
    private PlayerDetails playerDetails;

    private PlayerFixtures playerFixtures;

    public Player(final PlayerDetails playerDetails, final PlayerFixtures playerFixtures) {
        this.playerDetails = playerDetails;
        this.playerFixtures = playerFixtures;
    }

    public PlayerDetails getPlayer() {
        return playerDetails;
    }
}
