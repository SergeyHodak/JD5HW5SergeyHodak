package cli.input_loops;

import models.Order;

import java.util.Arrays;
import java.util.Scanner;

public class GetOrderStatus {
    private final Scanner scanner;

    public GetOrderStatus(Scanner scanner) {
        this.scanner = scanner;
    }

    public Order.Status input() {
        String message = "Enter nameOrderStatus:";
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            try {
                return Order.Status.valueOf(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Enter one of:");
                System.out.println(Arrays.toString(Order.Status.values()));
            }
        }
    }
}