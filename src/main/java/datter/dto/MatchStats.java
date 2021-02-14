package datter.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchStats {

    private String identifier;

    @SerializedName(value = "a")
    private List<Stat> awayStats;

    @SerializedName(value = "h")
    private List<Stat> homeStats;
}
