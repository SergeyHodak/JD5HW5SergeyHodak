package cli.store.delete;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetLong;
import store.Delete;

import java.util.Scanner;

public class DeletePurchaseOrderById extends MainState {
    public DeletePurchaseOrderById(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(DeletePurchaseOrderById.class.getName() + ". #Follow the clues#\n");
        long id = new GetLong(scanner).input("orderId");
        System.out.println(new Delete(baseURL).deletePurchaseOrderById(id));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}