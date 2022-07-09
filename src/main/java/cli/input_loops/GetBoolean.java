package cli.input_loops;

import java.util.Scanner;

public class GetBoolean {
    private final Scanner scanner;

    public GetBoolean(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean input(String name) {
        String message = "Enter stringBoolean for: " + name;
        while (true) {
            System.out.println("\n" + message);
            String input = scanner.nextLine();
            if ("true".equals(input)) {
                return true;
            } else if ("false".equals(input)) {
                return false;
            } else {
                System.out.println("Enter <true> or <false>.");
            }
        }
    }
}