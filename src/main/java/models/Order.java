package models;

import lombok.Data;

@Data
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private Status status;
    private boolean complete;

    public enum Status {
        PLACED,
        APPROVED,
        DELIVERED
    }
}