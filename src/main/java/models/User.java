package models;

import lombok.Data;

@Data
public class User {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Status userStatus;

    public enum Status {
    }
}