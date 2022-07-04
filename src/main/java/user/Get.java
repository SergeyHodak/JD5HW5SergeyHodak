package user;

import com.google.gson.Gson;
import general_classes.Method;
import general_classes.Response;
import general_classes.URLBuilder;
import models.ApiResponse;
import models.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Get {
    private final String RESOURCE_URL;
    private static final String GET_FIND_USER_BY_USER_NAME_URL = "/v2/user/";
    private static final String GET_REGISTER_USER_IN_SYSTEM_URL = "/v2/user/login";
    private static final String GET_LOG_OUT_OF_THE_CURRENT_SESSION_OF_THE_LOGGED_IN_USER = "/v2/user/logout";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public Get(String resourceUrl){
        RESOURCE_URL = resourceUrl;
    }

    public static void main(String[] args) {
        String resourceUrl = "https://petstore.swagger.io";
        Get get = new Get(resourceUrl);

        User user = get.findUserByUserName("string");
        System.out.println(user);
        System.out.println("-----------------------------------");

        ApiResponse apiResponse = get.registerUserInSystem("string", "string");
        System.out.println(apiResponse);
        System.out.println("-----------------------------------");

        ApiResponse apiResponse1 = get.logOutOfTheCurrentSessionOfTheLoggedInUser();
        System.out.println(apiResponse1);
    }

    public User findUserByUserName(String name) {
        try {
            URL url = new URL(RESOURCE_URL + GET_FIND_USER_BY_USER_NAME_URL + name);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.GET.name());
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = User.class;
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ApiResponse registerUserInSystem(String username, String password) {
        try {
            URL url = new URLBuilder(RESOURCE_URL + GET_REGISTER_USER_IN_SYSTEM_URL)
                    .withParam(USERNAME, new ArrayList<>(){{add(username);}})
                    .withParam(PASSWORD, new ArrayList<>(){{add(password);}})
                    .build();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.GET.name());
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = ApiResponse.class;
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ApiResponse logOutOfTheCurrentSessionOfTheLoggedInUser() {
        try {
            URL url = new URL(RESOURCE_URL + GET_LOG_OUT_OF_THE_CURRENT_SESSION_OF_THE_LOGGED_IN_USER);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.GET.name());
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = ApiResponse.class;
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}