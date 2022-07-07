package user;

import models.ApiResponse;
import models.User;

public class PutTest {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Put put = new Put(baseURL);

        User user = new User();
        user.setId(0);
        user.setUsername("string");
        user.setFirstName("string");
        user.setLastName("string");
        user.setEmail("string2");
        user.setPassword("string");
        user.setPhone("string");
        user.setUserStatus(User.Status.ZERO.getInt());

        ApiResponse userUpdate = put.userUpdate("string", user);
        System.out.println("userUpdate = " + userUpdate);
    }
}