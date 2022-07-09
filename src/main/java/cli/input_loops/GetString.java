package cli.input_loops;

import java.util.Scanner;

public class GetString {
    private final Scanner scanner;

    public GetString(Scanner scanner) {
        this.scanner = scanner;
    }

    public String input(String name) {
        String message = "Enter String for: " + name;
        String result;
        while (true) {
            System.out.println("\n" + message);
            String input = scanner.nextLine();
            try {
                result = input;
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}