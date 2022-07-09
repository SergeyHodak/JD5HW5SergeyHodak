package cli.input_loops;

import java.util.Scanner;

public class GetLong {
    private final Scanner scanner;

    public GetLong(Scanner scanner) {
        this.scanner = scanner;
    }

    public long input(String name) {
        String message = "Enter long for: " + name;
        long result;
        while (true) {
            System.out.println("\n" + message);
            String input = scanner.nextLine();
            try {
                result = Long.parseLong(input);
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}