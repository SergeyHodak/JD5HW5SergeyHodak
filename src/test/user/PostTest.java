package user;

import models.ApiResponse;
import models.User;

import java.util.List;

public class PostTest {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Post post = new Post(baseURL);

        User user = new User();
        user.setUsername("string");
        user.setFirstName("string");
        user.setLastName("string");
        user.setEmail("string");
        user.setPassword("string");
        user.setPhone("string");
        user.setUserStatus(User.Status.ZERO.getInt());

        ApiResponse array = post.createWithArray(new User[]{user});
        System.out.println("array = " + array);
        System.out.println("----------------------------------------");

        ApiResponse list = post.createWithList(List.of(user));
        System.out.println("list= " + list);
        System.out.println("----------------------------------------");

        ApiResponse user1 = post.createUser(user);
        System.out.println("user = " + user1);
    }
}