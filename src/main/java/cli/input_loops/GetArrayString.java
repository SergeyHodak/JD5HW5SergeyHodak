package cli.input_loops;

import java.util.Scanner;

public class GetArrayString {
    private final Scanner scanner;

    public GetArrayString(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] input(String name) {
        System.out.println("Separate strings by <];>. Example: <String];String>. " + name);
        String input = scanner.nextLine();
        String[] split = input.split("];");
        String[] result = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = split[i].strip();
        }
        return result;
    }
}