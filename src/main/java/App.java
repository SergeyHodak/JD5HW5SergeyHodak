import cli.PetStore;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String baseURL = "https://petstore.swagger.io/v2";
        new PetStore(scanner, baseURL);
    }
}