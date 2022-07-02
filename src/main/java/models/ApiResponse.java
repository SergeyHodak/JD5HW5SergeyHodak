package models;

import lombok.Data;

@Data
public class ApiResponse {
    private long code;
    private String type;
    private String message;
}