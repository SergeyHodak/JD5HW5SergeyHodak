package cli;

import lombok.Getter;

import java.util.List;
import java.util.Scanner;

public class PetStore {
    @Getter
    private MainState state;
    @Getter
    private final Scanner scanner;
    @Getter
    private final String baseURL;

    private static final String EXIT = "exit";
    private static final String SHOW = "show";
    private static final String GET_PET_BY_STATUS = "getPetByStatus";
    private static final String GET_PET_BY_TAGS = "getPetByTags";
    private static final String GET_PET_BY_ID = "getPetById";
    private static final String PET_UPLOAD_IMAGE = "petUploadImage";
    private static final String ADD_A_NEW_PET_TO_THE_STORE = "addANewPetToTheStore";
    private static final String UPDATE_STORE_PET_WITH_FORM_DATA = "updateStorePetWithFormData";
    private static final String UPDATE_AN_EXISTING_PET = "updateAnExistingPet";
    private static final String DELETE_PET = "deletePet";
    private static final String FIND_PURCHASE_ORDER_BY_ID = "findPurchaseOrderById";
    private static final String RETURNS_PET_INVENTORIES_BY_STATUS = "returnsPetInventoriesByStatus";
    private static final String PLACE_AN_ORDER_FOR_A_PET = "placeAnOrderForAPet";
    private static final String DELETE_PURCHASE_ORDER_BY_ID = "deletePurchaseOrderById";
    private static final String FIND_USER_BY_USERNAME = "findUserByUsername";
    private static final String REGISTER_USER_IN_SYSTEM = "registerUserInSystem";
    private static final String LOG_OUT_OF_THE_CURRENT_SESSION_OF_THE_LOGGED_IN_USER = "logOutOfTheCurrentSessionOfTheLoggedInUser";
    private static final String CREATE_USER_WITH_ARRAY = "createUserWithArray";
    private static final String CREATE_USER_WITH_LIST = "createUserWithList";
    private static final String CREATE_USER = "createUser";
    private static final String USER_UPDATE = "userUpdate";
    private static final String DELETE_USER = "deleteUser";

    List<String> availableCmd = List.of(
            EXIT,
            SHOW,
            GET_PET_BY_STATUS,
            GET_PET_BY_TAGS,
            GET_PET_BY_ID,
            PET_UPLOAD_IMAGE,
            ADD_A_NEW_PET_TO_THE_STORE,
            UPDATE_STORE_PET_WITH_FORM_DATA,
            UPDATE_AN_EXISTING_PET,
            DELETE_PET,
            FIND_PURCHASE_ORDER_BY_ID,
            RETURNS_PET_INVENTORIES_BY_STATUS,
            PLACE_AN_ORDER_FOR_A_PET,
            DELETE_PURCHASE_ORDER_BY_ID,
            FIND_USER_BY_USERNAME,
            REGISTER_USER_IN_SYSTEM,
            LOG_OUT_OF_THE_CURRENT_SESSION_OF_THE_LOGGED_IN_USER,
            CREATE_USER_WITH_ARRAY,
            CREATE_USER_WITH_LIST,
            CREATE_USER,
            USER_UPDATE,
            DELETE_USER
    );


    public PetStore(Scanner scanner, String baseURL) {
        state = new IdleState(this, scanner, baseURL);
        this.scanner = scanner;
        this.baseURL = baseURL;
        inputLoop();
    }

    public void init() {
        inputLoop();
    }

    public void inputLoop() {
        String command = "";
        while (true) {
            System.out.println("PetStore. Enter command:");
            command = scanner.nextLine();
            if (availableCmd.contains(command)) {
                if (SHOW.equals(command)) {
                    System.out.println(availableCmd);
                } else if (EXIT.equals(command)) {
                    scanner.close();
                    System.exit(0);
                } else {
                    break;
                }
            } else {
                unknownCommand(command);
            }
        }
        switch (command) {
            case GET_PET_BY_STATUS: {
                getPetByStatus();
                break;
            }
            case GET_PET_BY_TAGS: {
                getPetByTags();
                break;
            }
            case GET_PET_BY_ID: {
                getPetById();
                break;
            }
            case PET_UPLOAD_IMAGE: {
                petUploadImage();
                break;
            }
            case ADD_A_NEW_PET_TO_THE_STORE: {
                addANewPetToTheStore();
                break;
            }
            case UPDATE_STORE_PET_WITH_FORM_DATA: {
                updateStorePetWithFormData();
                break;
            }
            case UPDATE_AN_EXISTING_PET: {
                updateAnExistingPet();
                break;
            }
            case DELETE_PET: {
                deletePet();
                break;
            }
            case FIND_PURCHASE_ORDER_BY_ID: {
                findPurchaseOrderById();
                break;
            }
            case RETURNS_PET_INVENTORIES_BY_STATUS: {
                returnsPetInventoriesByStatus();
                break;
            }
            case PLACE_AN_ORDER_FOR_A_PET: {
                placeAnOrderForAPet();
                break;
            }
            case DELETE_PURCHASE_ORDER_BY_ID: {
                deletePurchaseOrderById();
                break;
            }
            case FIND_USER_BY_USERNAME: {
                findUserByUsername();
                break;
            }
            case REGISTER_USER_IN_SYSTEM: {
                registerUserInSystem();
                break;
            }
            case LOG_OUT_OF_THE_CURRENT_SESSION_OF_THE_LOGGED_IN_USER: {
                logOutOfTheCurrentSessionOfTheLoggedInUser();
                break;
            }
            case CREATE_USER_WITH_ARRAY: {
                createUserWithArray();
                break;
            }
            case CREATE_USER_WITH_LIST: {
                createUserWithList();
                break;
            }
            case CREATE_USER: {
                createUser();
                break;
            }
            case USER_UPDATE: {
                userUpdate();
                break;
            }
            case DELETE_USER: {
                deleteUser();
                break;
            }
        }
    }

    public void getPetByStatus() {
        state.getPetByStatus();
    }

    public void getPetByTags() {
        state.getPetByTags();
    }

    public void getPetById() {
        state.getPetById();
    }

    public void petUploadImage() {
        state.petUploadImage();
    }

    public void addANewPetToTheStore() {
        state.addANewPetToTheStore();
    }

    public void updateStorePetWithFormData() {
        state.updateStorePetWithFormData();
    }

    public void updateAnExistingPet() {
        state.updateAnExistingPet();
    }

    public void deletePet() {
        state.deletePet();
    }

    public void findPurchaseOrderById() {
        state.findPurchaseOrderById();
    }

    public void returnsPetInventoriesByStatus() {
        state.returnsPetInventoriesByStatus();
    }

    public void placeAnOrderForAPet() {
        state.placeAnOrderForAPet();
    }

    public void deletePurchaseOrderById() {
        state.deletePurchaseOrderById();
    }

    public void findUserByUsername() {
        state.findUserByUsername();
    }

    public void registerUserInSystem() {
        state.registerUserInSystem();
    }

    public void logOutOfTheCurrentSessionOfTheLoggedInUser() {
        state.logOutOfTheCurrentSessionOfTheLoggedInUser();
    }

    public void createUserWithArray() {
        state.createUserWithArray();
    }

    public void createUserWithList() {
        state.createUserWithList();
    }

    public void createUser() {
        state.createUser();
    }

    public void userUpdate() {
        state.userUpdate();
    }

    public void deleteUser() {
        state.deleteUser();
    }

    public void unknownCommand(String cmd) {
        state.unknownCommand(cmd);
    }

    public void setState(MainState state) {
        this.state = state;
        state.init();
    }
}