package store;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import general_classes.Method;
import general_classes.Response;
import models.Order;
import general_classes.URLBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Get {
    private final String BASE_URL;
    private static final String GET_FIND_PURCHASE_ORDER_BY_ID_URL = "/store/order/";
    private static final String GET_RETURNS_PET_INVENTORIES_BY_STATUS_URL = "/store/inventory";
    private static final String STATUS = "status";

    public Get(String baseURL) {
        BASE_URL = baseURL;
    }

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

    public Order findPurchaseOrderById(long id) {
        try {
            URL url = new URL(BASE_URL + GET_FIND_PURCHASE_ORDER_BY_ID_URL + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.GET.name());
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = Order.class;
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedHashMap<String, Integer> returnsPetInventoriesByStatus(List<Order.Status> status) {
        try {
            List<String> params = new ArrayList<>();
            for (Order.Status status1 : status) {
                params.add(status1.name().toLowerCase());
            }

            URL url = new URLBuilder(BASE_URL + GET_RETURNS_PET_INVENTORIES_BY_STATUS_URL)
                    .withParam(STATUS, params)
                    .build();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.GET.name());
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = new TypeToken<LinkedHashMap<String, Integer>>() {}.getType();
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}