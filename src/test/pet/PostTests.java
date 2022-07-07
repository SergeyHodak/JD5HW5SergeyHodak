package pet;

import models.ApiResponse;
import models.Category;
import models.Pet;
import models.Tag;

import java.io.File;

class PostTests {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        pet.Post post = new pet.Post(baseURL);

        File file = new File("src/main/java/img/test.jpg");
        ApiResponse apiResponse = post.uploadImage(9L, "test", file);
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
        Pet pet1 = post.addANewPetToTheStore(pet);
        System.out.println("new Pet = " + pet1);
        System.out.println("------------------------------");

        ApiResponse apiResponse1 = post.updateStorePetWithFormData(9L, "mozilla2", Pet.Status.AVAILABLE);
        System.out.println("apiResponse1 = " + apiResponse1);
    }
}