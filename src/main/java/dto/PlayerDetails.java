package dto;

import java.util.List;

public class PlayerDetails {

    private List<PlayerHistoryFixture> playerHistoryFixtureList;

    private List<PlayerRemainingFixture> playerRemainingFixtures;

    public List<PlayerHistoryFixture> getPlayerHistoryFixtureList() {
        return playerHistoryFixtureList;
    }

    public void setPlayerHistoryFixtureList(List<PlayerHistoryFixture> playerHistoryFixtureList) {
        this.playerHistoryFixtureList = playerHistoryFixtureList;
    }

    public List<PlayerRemainingFixture> getPlayerRemainingFixtures() {
        return playerRemainingFixtures;
    }

    public void setPlayerRemainingFixtures(List<PlayerRemainingFixture> playerRemainingFixtures) {
        this.playerRemainingFixtures = playerRemainingFixtures;
    }

    public PlayerDetails(List<PlayerHistoryFixture> playerHistoryFixtureList, List<PlayerRemainingFixture> playerRemainingFixtures) {
        this.playerHistoryFixtureList = playerHistoryFixtureList;
        this.playerRemainingFixtures = playerRemainingFixtures;
    }
}
