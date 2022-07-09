package cli.input_loops;

import models.User;

import java.util.Arrays;
import java.util.Scanner;

public class GetUserStatus {
    private final Scanner scanner;

    public GetUserStatus(Scanner scanner) {
        this.scanner = scanner;
    }

    public int input() {
        String message = "Enter nameUserStatus:";
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            User.Status status;
            try {
                status = User.Status.valueOf(input);
                return status.getInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Enter one of:");
                System.out.println(Arrays.toString(User.Status.values()));
            }
        }
    }
}