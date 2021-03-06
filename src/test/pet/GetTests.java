package pet;

import models.Pet;
import models.Tag;

import java.util.ArrayList;
import java.util.List;

class GetTests {
    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Get get = new Get(baseURL);

        List<Pet.Status> paramsStatus = new ArrayList<>();
        paramsStatus.add(Pet.Status.AVAILABLE);
        List<Pet> pets = get.findByStatus(paramsStatus);
        System.out.println(pets);
        System.out.println("---------------------------");

        List<Tag> paramsTags = new ArrayList<>();
        paramsTags.add(new Tag(){{setName("string");}});
        paramsTags.add(new Tag(){{setName("chili");}});
        List<Pet> pets2 = get.findByTags(paramsTags);
        System.out.println(pets2);
        System.out.println("---------------------------");

        Pet pet3 = get.findById(9);
        System.out.println(pet3);
    }
}