package cli.pet.delete;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetLong;
import cli.input_loops.GetString;
import pet.Delete;

import java.util.Scanner;

public class DeletePet extends MainState {
    public DeletePet(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(DeletePet.class.getName() + ". #Follow the clues#\n");
        long petId = new GetLong(scanner).input("petId");
        String apiKey = new GetString(scanner).input("apiKey");
        System.out.println(new Delete(baseURL).deletePet(petId, apiKey));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}