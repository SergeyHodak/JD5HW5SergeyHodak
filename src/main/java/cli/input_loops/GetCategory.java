package cli.input_loops;

import models.Category;

import java.util.Scanner;

public class GetCategory {
    private final Scanner scanner;

    public GetCategory(Scanner scanner) {
        this.scanner = scanner;
    }

    public Category input() {
        System.out.println("Enter id and name for Category:");
        long id = new GetLong(scanner).input("categoryId");
        ;
        String name = new GetString(scanner).input("categoryName");
        Category result = new Category();
        result.setId(id);
        result.setName(name);
        return result;
    }
}