package cli.input_loops;

import models.Category;
import models.Pet;
import models.Tag;

import java.util.Arrays;
import java.util.Scanner;

public class GetPet {
    private final Scanner scanner;

    public GetPet(Scanner scanner) {
        this.scanner = scanner;
    }

    public Pet input() {
        System.out.println("Fill 6 variables to create object Pet.");
        long id = new GetLong(scanner).input("petId");
        System.out.println("id = " + id);
        Category category = new GetCategory(scanner).input();
        System.out.println("category = " + category);
        String name = new GetString(scanner).input("petName");
        System.out.println("name = " + name);
        String[] photoUrls = new GetArrayString(scanner).input("petPhotoUrls");
        System.out.println("photoUrls = " + Arrays.toString(photoUrls));
        Tag[] tags = new GetListTag(scanner).input().toArray(new Tag[0]);
        System.out.println("tags = " + Arrays.toString(tags));
        Pet.Status status = new GetPetStatus(scanner).input();
        System.out.println("status = " + status);
        Pet result = new Pet();
        result.setId(id);
        result.setCategory(category);
        result.setName(name);
        result.setPhotoUrls(photoUrls);
        result.setTags(tags);
        result.setStatus(status);
        return result;
    }
}