package datter.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerFixtures {
    @SerializedName(value = "history")
    private List<PlayerHistoryFixture> playerHistoryFixtureList;

    @SerializedName(value = "fixtures")
    private List<PlayerRemainingFixture> playerRemainingFixtures;
}
