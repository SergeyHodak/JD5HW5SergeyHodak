package pet;

import models.ApiResponse;

public class DeleteTest {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Delete delete = new Delete(baseURL);

        ApiResponse apiResponse = delete.deletePet(2L , "");
        System.out.println("apiResponse = " + apiResponse);
    }
}