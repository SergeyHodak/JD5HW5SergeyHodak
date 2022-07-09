package cli;

import java.util.Scanner;

public class MainState {
    protected PetStore petStore;
    protected Scanner scanner;
    protected String baseURL;

    public MainState(PetStore petStore, Scanner scanner, String baseURL) {
        this.petStore = petStore;
        this.scanner = scanner;
        this.baseURL = baseURL;
    }

    public void init() {}
    public void getPetByStatus() {}
    public void getPetByTags() {}
    public void getPetById() {}
    public void petUploadImage() {}
    public void addANewPetToTheStore() {}
    public void updateStorePetWithFormData() {}
    public void updateAnExistingPet() {}
    public void deletePet() {}
    public void findPurchaseOrderById() {}
    public void returnsPetInventoriesByStatus() {}
    public void placeAnOrderForAPet() {}
    public void deletePurchaseOrderById() {}
    public void findUserByUsername() {}
    public void registerUserInSystem() {}
    public void logOutOfTheCurrentSessionOfTheLoggedInUser() {}
    public void createUserWithArray() {}
    public void createUserWithList() {}
    public void createUser() {}
    public void userUpdate() {}
    public void deleteUser() {}
    public void unknownCommand(String cmd) {}
}