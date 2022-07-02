package models;

import lombok.Data;

@Data
public class Order {
    private long id;
    private long petId;
    private long quantity;
    private String shipDate;
    private Status status;
    private boolean complete;

    public enum Status {
        PLACED,
        APPROVED,
        DELIVERED
    }
}