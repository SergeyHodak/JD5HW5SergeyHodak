package cli.input_loops;

import models.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GetListPetStatus {
    private final Scanner scanner;

    public GetListPetStatus(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Pet.Status> input(String name) {
        String message = "Enter a list of Statuses separated by commas<,> for: " + name;
        while (true) {
            System.out.println("\n" + message);
            List<Pet.Status> result = new ArrayList<>();
            String input = scanner.nextLine();
            try {
                for (String value : input.split(",")) {
                    result.add(Pet.Status.valueOf(value.strip()));
                }
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Use available enums:");
                System.out.println(Arrays.toString(Pet.Status.values()));
            }
        }
    }
}