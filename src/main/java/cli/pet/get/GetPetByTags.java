package cli.pet.get;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetListTag;
import models.Tag;
import pet.Get;

import java.util.List;
import java.util.Scanner;

public class GetPetByTags extends MainState {
    public GetPetByTags(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(GetPetByTags.class.getName() + ". #Follow the clues#\n");
        List<Tag> listTag = new GetListTag(scanner).input();
        System.out.println(new Get(baseURL).findByTags(listTag));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}