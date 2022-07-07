package store;

import models.Order;

public class PostTest {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Post post = new Post(baseURL);

        Order order = new Order();
        order.setShipDate("2022-07-07T10:01:50.478Z");
        order.setStatus(Order.Status.PLACED);
        order.setComplete(true);
        Order order1 = post.placeAnOrderForAPet(order);
        System.out.println("order1 = " + order1);
    }
}