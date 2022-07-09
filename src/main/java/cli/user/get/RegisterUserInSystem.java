package cli.user.get;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetString;
import user.Get;

import java.util.Scanner;

public class RegisterUserInSystem extends MainState {
    public RegisterUserInSystem(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(RegisterUserInSystem.class.getName() + ". #Follow the clues#\n");
        String username = new GetString(scanner).input("username");
        String password = new GetString(scanner).input("password");
        System.out.println(new Get(baseURL).registerUserInSystem(username, password));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}