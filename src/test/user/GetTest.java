package user;

import models.ApiResponse;
import models.User;

public class GetTest {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Get get = new Get(baseURL);

        User user = get.findUserByUserName("string");
        System.out.println(user);
        System.out.println("-----------------------------------");

        ApiResponse apiResponse = get.registerUserInSystem("string", "string");
        System.out.println(apiResponse);
        System.out.println("-----------------------------------");

        ApiResponse apiResponse1 = get.logOutOfTheCurrentSessionOfTheLoggedInUser();
        System.out.println(apiResponse1);
    }
}