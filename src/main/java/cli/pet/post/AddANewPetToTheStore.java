package cli.pet.post;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetPet;
import models.Pet;
import pet.Post;

import java.util.Scanner;

public class AddANewPetToTheStore extends MainState {
    public AddANewPetToTheStore(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(AddANewPetToTheStore.class.getName() + ". #Follow the clues#\n");
        Pet pet = new GetPet(scanner).input();
        System.out.println(new Post(baseURL).addANewPetToTheStore(pet));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}