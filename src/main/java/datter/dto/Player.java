package datter.dto;

public class Player {
    private final PlayerDetails playerDetails;

    private final PlayerFixtures playerFixtures;

    public Player(final PlayerDetails playerDetails, final PlayerFixtures playerFixtures) {
        this.playerDetails = playerDetails;
        this.playerFixtures = playerFixtures;
    }

    public PlayerDetails getPlayer() {
        return playerDetails;
    }
}
