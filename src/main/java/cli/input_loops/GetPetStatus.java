package cli.input_loops;

import models.Pet;

import java.util.Arrays;
import java.util.Scanner;

public class GetPetStatus {
    private final Scanner scanner;

    public GetPetStatus(Scanner scanner) {
        this.scanner = scanner;
    }

    public Pet.Status input() {
        String message = "Enter namePetStatus:";
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            try {
                return Pet.Status.valueOf(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Enter one of:");
                System.out.println(Arrays.toString(Pet.Status.values()));
            }
        }
    }
}