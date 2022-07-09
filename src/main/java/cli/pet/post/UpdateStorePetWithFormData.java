package cli.pet.post;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetLong;
import cli.input_loops.GetPetStatus;
import cli.input_loops.GetString;
import models.Pet;
import pet.Post;

import java.util.Scanner;

public class UpdateStorePetWithFormData extends MainState {
    public UpdateStorePetWithFormData(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(UpdateStorePetWithFormData.class.getName() + ". #Follow the clues#\n");
        long id = new GetLong(scanner).input("petId");
        String name = new GetString(scanner).input("petName");
        Pet.Status status = new GetPetStatus(scanner).input();
        System.out.println(new Post(baseURL).updateStorePetWithFormData(id, name, status));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}