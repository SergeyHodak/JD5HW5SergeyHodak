package cli.user.post;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetLong;
import cli.input_loops.GetUser;
import models.User;
import user.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateUserWithList extends MainState {
    public CreateUserWithList(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(CreateUserWithList.class.getName() + ". #Follow the clues#\n");
        System.out.println("Enter how many users you want to add!");
        long numberOfAddedUsers = new GetLong(scanner).input("numberOfAddedUsers");
        List<User> users = new ArrayList<>();
        for (int i = 0; i < numberOfAddedUsers; i++) {
            users.add(new GetUser(scanner).input());
        }
        System.out.println(new Post(baseURL).createWithList(users));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}