package cli.input_loops;

import java.time.LocalDateTime;
import java.util.Scanner;

public class GetStringDate {
    private final Scanner scanner;

    public GetStringDate(Scanner scanner) {
        this.scanner = scanner;
    }

    public LocalDateTime input(String name) {
        String message = "Enter a string for: " + name + ". In the form: yyyy/MM/ddTh:m:s.ms/. For example: 2022-07-09T12:15:11.346Z";
        LocalDateTime result;
        while (true) {
            System.out.println("\n" + message);
            String input = scanner.nextLine();
            try {
                if ("now".equals(input)) {
                    result = LocalDateTime.now();
                    return result;
                } else {
                    return LocalDateTime.parse(input);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Or use the command <now>");
            }
        }
    }
}