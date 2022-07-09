package cli.pet.get;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetLong;
import pet.Get;

import java.util.Scanner;

public class GetPetById extends MainState {
    public GetPetById(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(GetPetById.class.getName() + ". #Follow the clues#\n");
        long petId = new GetLong(scanner).input("petId");
        System.out.println(new Get(baseURL).findById(petId));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}