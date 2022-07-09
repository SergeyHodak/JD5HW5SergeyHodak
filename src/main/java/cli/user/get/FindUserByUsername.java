package cli.user.get;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetString;
import user.Get;

import java.util.Scanner;

public class FindUserByUsername extends MainState {
    public FindUserByUsername(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(FindUserByUsername.class.getName() + ". #Follow the clues#\n");
        String name = new GetString(scanner).input("Username");
        System.out.println(new Get(baseURL).findUserByUsername(name));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}