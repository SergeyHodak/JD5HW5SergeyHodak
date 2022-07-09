package cli.store.post;

import cli.MainState;
import cli.PetStore;
import cli.input_loops.GetOrder;
import models.Order;
import store.Post;

import java.util.Scanner;

public class PlaceAnOrderForAPet extends MainState {
    public PlaceAnOrderForAPet(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void init() {
        inputLoop();
    }

    private void inputLoop() {
        System.out.println(PlaceAnOrderForAPet.class.getName() + ". #Follow the clues#\n");
        Order order = new GetOrder(scanner).input();
        System.out.println(new Post(baseURL).placeAnOrderForAPet(order));
        closeMethod();
    }

    private void closeMethod() {
        new PetStore(scanner, baseURL);
    }
}