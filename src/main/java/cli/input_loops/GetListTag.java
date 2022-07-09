package cli.input_loops;

import models.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetListTag {
    private final Scanner scanner;

    public GetListTag(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Tag> input() {
        String message = "Enter a list of tags. Tag ID and name, separated by <:>. Separate tags by <;>. Example of two tags <0:tag name1; 1:tag name2>";
        while (true) {
            System.out.println("\n" + message);
            List<Tag> result = new ArrayList<>();
            String input = scanner.nextLine();
            try {
                for (String tag : input.split(";")) {
                    String[] values = tag.split(":");
                    long id = Long.parseLong(values[0].strip());
                    String name = values[1].strip();
                    Tag newTeg = new Tag();
                    newTeg.setId(id);
                    newTeg.setName(name);
                    result.add(newTeg);
                }
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}