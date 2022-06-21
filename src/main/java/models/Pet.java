package models;

import lombok.Data;

@Data
public class Pet {
    private int id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private Status status;

    public enum Status {
        AVAILABLE,
        PENDING,
        SOLD
    }
}