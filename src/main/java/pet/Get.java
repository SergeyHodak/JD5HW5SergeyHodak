package pet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import general_classes.Method;
import general_classes.Response;
import general_classes.URLBuilder;
import models.Pet;
import models.Tag;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Get {
    private final String BASE_URL;
    private static final String GET_FIND_BY_STATUS_URL = "/pet/findByStatus";
    private static final String GET_FIND_BY_TAGS_URL = "/pet/findByTags";
    private static final String GET_FIND_BY_ID_URL = "/pet/";
    private static final String STATUS = "status";
    private static final String TAGS = "tags";

    public Get(String baseURL){
        BASE_URL = baseURL;
    }

    public List<Pet> findByStatus(List<Pet.Status> status) {
        try {
            URLBuilder urlBuilder = new URLBuilder(BASE_URL + GET_FIND_BY_STATUS_URL);
            for (Pet.Status value : status) {
                urlBuilder.withParam(STATUS, value.name().toLowerCase());
            }
            URL url = urlBuilder.build();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.GET.name());
            connection.connect();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = new TypeToken<List<Pet>>(){}.getType();
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Pet> findByTags(List<Tag> tags) {
        try {
            URLBuilder urlBuilder = new URLBuilder(BASE_URL + GET_FIND_BY_TAGS_URL);
            for (Tag tag : tags) {
                urlBuilder.withParam(TAGS, tag.getName());
            }
            URL url = urlBuilder.build();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.GET.name());
            connection.connect();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = new TypeToken<List<Pet>>(){}.getType();
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Pet findById(long id) {
        try {
            URL url = new URL(BASE_URL + GET_FIND_BY_ID_URL + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Method.GET.name());
            connection.connect();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                Type type = Pet.class;
                String message = new Response().getResponse(connection);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}