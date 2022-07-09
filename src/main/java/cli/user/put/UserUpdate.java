package cli.user.put;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetString;
import cli.input_loops.GetUser;
import models.User;
import user.Put;

import java.util.Scanner;

public class UserUpdate extends MainState {
    public UserUpdate(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(UserUpdate.class.getName() + ". #Follow the clues#\n");
        String username = new GetString(scanner).input("username");
        User user = new GetUser(scanner).input();
        System.out.println(new Put(baseURL).userUpdate(username, user));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}