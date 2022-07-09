package cli;

import cli.pet.delete.DeletePet;
import cli.pet.get.GetPetById;
import cli.pet.get.GetPetByStatus;
import cli.pet.get.GetPetByTags;
import cli.pet.post.AddANewPetToTheStore;
import cli.pet.post.PetUploadImage;
import cli.pet.post.UpdateStorePetWithFormData;
import cli.pet.put.UpdateAnExistingPet;
import cli.store.delete.DeletePurchaseOrderById;
import cli.store.get.FindPurchaseOrderById;
import cli.store.get.ReturnsPetInventoriesByStatus;
import cli.store.post.PlaceAnOrderForAPet;
import cli.user.delete.DeleteUser;
import cli.user.get.FindUserByUsername;
import cli.user.get.LogOutOfTheCurrentSessionOfTheLoggedInUser;
import cli.user.get.RegisterUserInSystem;
import cli.user.post.CreateUser;
import cli.user.post.CreateUserWithArray;
import cli.user.post.CreateUserWithList;
import cli.user.put.UserUpdate;

import java.util.Scanner;

public class IdleState extends MainState {
    public IdleState(PetStore petStore, Scanner scanner, String baseURL) {
        super(petStore, scanner, baseURL);
    }

    @Override
    public void getPetByStatus() {
        petStore.setState(new GetPetByStatus(petStore, scanner, baseURL));
    }

    @Override
    public void getPetByTags() {
        petStore.setState(new GetPetByTags(petStore, scanner, baseURL));
    }

    @Override
    public void getPetById() {
        petStore.setState(new GetPetById(petStore, scanner, baseURL));
    }

    @Override
    public void petUploadImage() {
        petStore.setState(new PetUploadImage(petStore, scanner, baseURL));
    }

    @Override
    public void addANewPetToTheStore() {
        petStore.setState(new AddANewPetToTheStore(petStore, scanner, baseURL));
    }

    @Override
    public void updateStorePetWithFormData() {
        petStore.setState(new UpdateStorePetWithFormData(petStore, scanner, baseURL));
    }

    @Override
    public void updateAnExistingPet() {
        petStore.setState(new UpdateAnExistingPet(petStore, scanner, baseURL));
    }

    @Override
    public void deletePet() {
        petStore.setState(new DeletePet(petStore, scanner, baseURL));
    }

    @Override
    public void findPurchaseOrderById() {
        petStore.setState(new FindPurchaseOrderById(petStore, scanner, baseURL));
    }

    @Override
    public void returnsPetInventoriesByStatus() {
        petStore.setState(new ReturnsPetInventoriesByStatus(petStore, scanner, baseURL));
    }

    @Override
    public void placeAnOrderForAPet() {
        petStore.setState(new PlaceAnOrderForAPet(petStore, scanner, baseURL));
    }

    @Override
    public void deletePurchaseOrderById() {
        petStore.setState(new DeletePurchaseOrderById(petStore, scanner, baseURL));
    }

    @Override
    public void findUserByUsername() {
        petStore.setState(new FindUserByUsername(petStore, scanner, baseURL));
    }

    @Override
    public void registerUserInSystem() {
        petStore.setState(new RegisterUserInSystem(petStore, scanner, baseURL));
    }

    @Override
    public void logOutOfTheCurrentSessionOfTheLoggedInUser() {
        petStore.setState(new LogOutOfTheCurrentSessionOfTheLoggedInUser(petStore, scanner, baseURL));
    }

    @Override
    public void createUserWithArray() {
        petStore.setState(new CreateUserWithArray(petStore, scanner, baseURL));
    }

    @Override
    public void createUserWithList() {
        petStore.setState(new CreateUserWithList(petStore, scanner, baseURL));
    }

    @Override
    public void createUser() {
        petStore.setState(new CreateUser(petStore, scanner, baseURL));
    }

    @Override
    public void userUpdate() {
        petStore.setState(new UserUpdate(petStore, scanner, baseURL));
    }

    @Override
    public void deleteUser() {
        petStore.setState(new DeleteUser(petStore, scanner, baseURL));
    }

    @Override
    public void unknownCommand(String cmd) {
        System.out.println("Unknown command: " + cmd);
        System.out.println("To see the available commands type <show>.");
    }
}