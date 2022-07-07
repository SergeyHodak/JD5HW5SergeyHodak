package pet;

import models.Category;
import models.Pet;
import models.Tag;

public class PutTest {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Put put = new Put(baseURL);

        Pet pet = new Pet();
        pet.setId(9L);
        Category category = new Category();
        category.setName("string");
        pet.setCategory(category);
        pet.setName("doggie");
        pet.setPhotoUrls(new String[]{"string"});
        Tag tag = new Tag();
        tag.setName("string");
        pet.setTags(new Tag[]{tag});
        pet.setStatus(Pet.Status.AVAILABLE);

        Pet pet1 = put.updateAnExistingPet(pet);
        System.out.println("pet = " + pet1);
    }
}