package pet;

import com.google.gson.Gson;
import general_classes.Method;
import general_classes.Response;
import models.ApiResponse;
import models.Pet;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Post {
    private final String BASE_URL;
    private static final String PET_CLASS_URL = "/pet/";
    private static final String POST_UPLOAD_IMAGE = "uploadImage";
    private static final String ADDITIONAL_METADATA = "additionalMetadata";
    private static final String FILE = "file";
    private static final String USER_AGENT = "User-Agent";
    private static final String MOZILLA = "Mozilla/5.0";
    private static final String ACCEPT = "accept";
    private static final String FORM_JSON = "application/json";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String FORM_DATA = "multipart/form-data";

    public Post(String baseURL){
        BASE_URL = baseURL;
    }

    public static void main(String[] args) {
        String baseURL = "https://petstore.swagger.io/v2";
        Post post = new Post(baseURL);

        File file = new File("src/main/java/img/test.jpg");
        ApiResponse apiResponse = post.uploadImage(9, "test", file);
        System.out.println("apiResponse = " + apiResponse);

//        Pet pet = new Pet();
//        Pet pet1 = post.AddANewPetToTheStore(pet);
//        System.out.println("pet1 = " + pet1);
    }



    public ApiResponse uploadImage(long id, String additionalMetadata, File file) {
        
//        try {
//            Map<String, String> parameters = new HashMap<>();
//            parameters.put(ADDITIONAL_METADATA, additionalMetadata);
//            parameters.put(FILE, "{{file}}");
//            byte[] out = parameters.toString().getBytes();
//
//
//            URL url = new URL("https://petstore.swagger.io/v2/pet/9/uploadImage");
//            HttpURLConnection http = (HttpURLConnection)url.openConnection();
//            http.setRequestMethod("POST");
//            http.setDoOutput(true);
//            http.setRequestProperty("accept", "application/json");
//            http.setRequestProperty("Content-Type", "multipart/form-data");
//            http.setRequestProperty("Content-Length", "UTF-8");
//
//            try {
//                OutputStream outputStream = http.getOutputStream();
//                outputStream.write(out);
//
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } catch (Exception e) {
//                System.err.print(e.getMessage());
//            }
//
//            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
//            http.disconnect();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        try {
            InputStream bis = new FileInputStream(file);
            byte[] allBytes = bis.readAllBytes();
            String img = Base64.getEncoder().encodeToString(allBytes);

            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Map<String, String> parameters = new HashMap<>();
            parameters.put(ADDITIONAL_METADATA, additionalMetadata);
            parameters.put(FILE, "{{file}}");// + "; type=image/jpeg");
            byte[] out = parameters.toString().getBytes();

            URL url = new URL(BASE_URL + PET_CLASS_URL + id + POST_UPLOAD_IMAGE);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.POST.name());
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.addRequestProperty(USER_AGENT, MOZILLA);
            //connection.addRequestProperty(CONTENT_TYPE, FORM_JSON);
            //connection.addRequestProperty(CONTENT_TYPE, FORM_DATA);

            //connection.addRequestProperty("Content-Type", "text/html; charset=utf-8");
            // вообще не допустимое сочитание: connection.addRequestProperty("media-type", "base64");
            // вообще не допустимое сочитание: connection.addRequestProperty("Media-Type", "multipart/form-data");

            connection.addRequestProperty("accept", "application/json");
            connection.addRequestProperty("Content-Type", "multipart/form-data+base64");

            //connection.addRequestProperty("Authorization", "1657047357794");

            //connection.addRequestProperty("Content-Type", "multipart/form-data; boundary=---011000010111000001101001")
            //connection.addRequestProperty("Media-Type", "image/jpeg");
            //connection.addRequestProperty("Content-Transfer-Encoding", "base64data");
            //connection.addRequestProperty("Content-Encoding", "base64");
            //connection.addRequestProperty("Transfer-Encoding", "base64");
            connection.connect();

            try {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(out);

                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.err.print(e.getMessage());
            }

            System.out.println("connection.getResponseCode() = " + connection.getResponseCode());
            System.out.println("connection.getResponseMessage() = " + connection.getResponseMessage());

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = ApiResponse.class;
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
        return null;
        //!!!!!!!!!! 415
    }

    public Pet AddANewPetToTheStore(Pet pet) {
        try {
            byte[] out = pet.toString().getBytes();

            URL url = new URL("https://petstore.swagger.io/v2/pet");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.POST.name());
            connection.addRequestProperty(USER_AGENT, MOZILLA);
            connection.addRequestProperty("accept", "application/json; charset=utf-8");
            connection.addRequestProperty("Content-Type", "application/json; charset=utf-8");

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();

            try {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(out);

                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.err.print(e.getMessage());
            }

            System.out.println("connection.getResponseCode() = " + connection.getResponseCode());
            System.out.println("connection.getResponseMessage() = " + connection.getResponseMessage());

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = Pet.class;
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
        return null;
        //!!!!!!!!!! 400
    }
}