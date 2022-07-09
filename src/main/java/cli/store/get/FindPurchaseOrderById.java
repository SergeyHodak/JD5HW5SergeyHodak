package cli.store.get;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetLong;
import store.Get;

import java.util.Scanner;

public class FindPurchaseOrderById extends MainState {
    public FindPurchaseOrderById(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(FindPurchaseOrderById.class.getName() + ". #Follow the clues#\n");
        long id = new GetLong(scanner).input("orderId");
        System.out.println(new Get(baseURL).findPurchaseOrderById(id));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}