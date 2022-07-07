package store;

import models.Order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GetTest {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Get get = new Get(baseURL);

        Order order = get.findPurchaseOrderById(24L);
        System.out.println(order);
        System.out.println("-----------------------------------");

        List<Order.Status> statuses = new ArrayList<>();
        statuses.add(Order.Status.APPROVED);
        LinkedHashMap<String, Integer> orders = get.returnsPetInventoriesByStatus(statuses);
        System.out.println(orders);
    }
}