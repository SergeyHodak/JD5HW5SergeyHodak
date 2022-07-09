package cli.user.get;

import cli.MainState;
import cli.PetStore;
import user.Get;

import java.util.Scanner;

public class LogOutOfTheCurrentSessionOfTheLoggedInUser extends MainState {
    public LogOutOfTheCurrentSessionOfTheLoggedInUser(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(LogOutOfTheCurrentSessionOfTheLoggedInUser.class.getName() + "\n");
        System.out.println(new Get(baseURL).logOutOfTheCurrentSessionOfTheLoggedInUser());
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}