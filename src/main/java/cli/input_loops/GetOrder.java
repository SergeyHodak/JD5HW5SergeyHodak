package cli.input_loops;

import models.Order;

import java.time.LocalDateTime;
import java.util.Scanner;

public class GetOrder {
    private final Scanner scanner;

    public GetOrder(Scanner scanner) {
        this.scanner = scanner;
    }

    public Order input() {
        System.out.println("Fill 6 variables to create object Order.");
        long id = new GetLong(scanner).input("orderId");
        long petId = new GetLong(scanner).input("petId");
        long quantity = new GetLong(scanner).input("quantity");
        LocalDateTime shipDate = new GetStringDate(scanner).input("shipDate");
        Order.Status status = new GetOrderStatus(scanner).input();
        boolean complete = new GetBoolean(scanner).input("complete");
        Order result = new Order();
        result.setId(id);
        result.setPetId(petId);
        result.setQuantity(quantity);
        result.setShipDate(shipDate.toString());
        result.setStatus(status);
        result.setComplete(complete);
        return result;
    }
}