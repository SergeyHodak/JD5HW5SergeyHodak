package pet;

import models.ApiResponse;
import models.Category;
import models.Pet;
import models.Tag;

import java.io.File;

class PostTests {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Post post = new Post(baseURL);

        File file = new File("src/main/java/img/test.jpg");
        ApiResponse apiResponse = post.uploadImage(9, "test", file);
        System.out.println("apiResponse = " + apiResponse);
        System.out.println("------------------------------");

        Pet pet = new Pet();
        pet.setCategory(new Category() {{
            setId(0);
            setName("string");
        }});
        pet.setName("Капуста");
        pet.setStatus(Pet.Status.AVAILABLE);
        pet.setTags(new Tag[]{new Tag() {{
            setName("cow");
        }}});
        pet.setPhotoUrls(new String[]{"string"});
        Pet pet1 = post.AddANewPetToTheStore(pet);
        System.out.println("new Pet = " + pet1);
    }
}