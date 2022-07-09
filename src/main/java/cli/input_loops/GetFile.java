package cli.input_loops;

import java.io.File;
import java.util.Scanner;

public class GetFile {
    private final Scanner scanner;

    public GetFile(Scanner scanner) {
        this.scanner = scanner;
    }

    public File input() {
        while (true) {
            System.out.println("Enter the path to the file (image):");
            String path = new GetString(scanner).input("imagePath");
            try {
                return new File(path);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}