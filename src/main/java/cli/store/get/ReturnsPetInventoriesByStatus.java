package cli.store.get;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetListOrderStatus;
import models.Order;
import store.Get;

import java.util.List;
import java.util.Scanner;

public class ReturnsPetInventoriesByStatus extends MainState {
    public ReturnsPetInventoriesByStatus(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(ReturnsPetInventoriesByStatus.class.getName() + ". #Follow the clues#\n");
        List<Order.Status> status = new GetListOrderStatus(scanner).input("OrderStatus");
        System.out.println(new Get(baseURL).returnsPetInventoriesByStatus(status));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}