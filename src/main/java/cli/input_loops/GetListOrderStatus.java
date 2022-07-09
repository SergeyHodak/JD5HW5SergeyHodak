package cli.input_loops;

import models.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GetListOrderStatus {
    private final Scanner scanner;

    public GetListOrderStatus(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Order.Status> input(String name) {
        String message = "Enter a list of Statuses separated by commas<,> for: " + name;
        while (true) {
            System.out.println("\n" + message);
            List<Order.Status> result = new ArrayList<>();
            String input = scanner.nextLine();
            try {
                for (String value : input.split(",")) {
                    result.add(Order.Status.valueOf(value.strip()));
                }
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Use available enums:");
                System.out.println(Arrays.toString(Order.Status.values()));
            }
        }
    }
}