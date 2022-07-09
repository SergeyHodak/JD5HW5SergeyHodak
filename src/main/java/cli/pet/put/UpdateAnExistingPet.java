package cli.pet.put;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetPet;
import models.Pet;
import pet.Put;

import java.util.Scanner;

public class UpdateAnExistingPet extends MainState {
    public UpdateAnExistingPet(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(UpdateAnExistingPet.class.getName() + ". #Follow the clues#\n");
        Pet pet = new GetPet(scanner).input();
        System.out.println(new Put(baseURL).updateAnExistingPet(pet));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}