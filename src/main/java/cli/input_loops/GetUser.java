package cli.input_loops;

import models.User;

import java.util.Scanner;

public class GetUser {
    private final Scanner scanner;

    public GetUser(Scanner scanner) {
        this.scanner = scanner;
    }

    public User input() {
        System.out.println("Fill 8 variables to create object Pet.");
        long id = new GetLong(scanner).input("userId");
        String username = new GetString(scanner).input("username");
        String firstName = new GetString(scanner).input("firstName");
        String lastName = new GetString(scanner).input("lastName");
        String email = new GetString(scanner).input("email");
        String password = new GetString(scanner).input("password");
        String phone = new GetString(scanner).input("phone");
        int userStatus = new GetUserStatus(scanner).input();
        User result = new User();
        result.setId(id);
        result.setUsername(username);
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setEmail(email);
        result.setPassword(password);
        result.setPhone(phone);
        result.setUserStatus(userStatus);
        return result;
    }
}