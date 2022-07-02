package models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Pet {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private Status status;

    public enum Status {
        @SerializedName("available")
        AVAILABLE,
        @SerializedName("pending")
        PENDING,
        @SerializedName("sold")
        SOLD
    }
}