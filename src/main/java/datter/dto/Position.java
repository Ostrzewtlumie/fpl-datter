package datter.dto;

import com.google.gson.annotations.SerializedName;

public class Position {
    private Integer id;

    @SerializedName(value = "plural_name")
    private String pluralName;

    public int getId() {
        return id;
    }
}
