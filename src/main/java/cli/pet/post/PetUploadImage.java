package cli.pet.post;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetFile;
import cli.input_loops.GetLong;
import cli.input_loops.GetString;
import pet.Post;

import java.io.File;
import java.util.Scanner;

public class PetUploadImage extends MainState {
    public PetUploadImage(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(PetUploadImage.class.getName() + ". #Follow the clues#\n");
        long id = new GetLong(scanner).input("petId");
        String additionalMetadata = new GetString(scanner).input("additionalMetadata");
        File file = new GetFile(scanner).input();
        System.out.println(new Post(baseURL).uploadImage(id, additionalMetadata, file));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}