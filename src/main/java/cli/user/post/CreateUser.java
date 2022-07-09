package cli.user.post;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetUser;
import models.User;
import user.Post;

import java.util.Scanner;

public class CreateUser extends MainState {
    public CreateUser(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(CreateUser.class.getName() + ". #Follow the clues#\n");
        User user = new GetUser(scanner).input();
        System.out.println(new Post(baseURL).createUser(user));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}