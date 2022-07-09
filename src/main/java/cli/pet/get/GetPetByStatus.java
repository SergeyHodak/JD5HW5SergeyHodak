package cli.pet.get;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetListPetStatus;
import models.Pet;
import pet.Get;

import java.util.List;
import java.util.Scanner;

public class GetPetByStatus extends MainState {
    public GetPetByStatus(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(GetPetByStatus.class.getName() + ". #Follow the clues#\n");
        List<Pet.Status> listStatus = new GetListPetStatus(scanner).input("Pet.Status");
        System.out.println(new Get(baseURL).findByStatus(listStatus));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}