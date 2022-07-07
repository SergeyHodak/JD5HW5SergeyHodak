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
    private int userStatus;

    public enum Status {
        ZERO(0),
        ONE(1);

        private final int value;

        private Status(int value) {
            this.value = value;
        }

        public int getInt() {
            return value;
        }
    }
}