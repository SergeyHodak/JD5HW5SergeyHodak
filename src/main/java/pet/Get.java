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
    private final String RESOURCE_URL;
    private static final String GET_FIND_BY_STATUS_URL = "/v2/pet/findByStatus";
    private static final String GET_FIND_BY_TAGS_URL = "/v2/pet/findByTags";
    private static final String GET_FIND_BY_ID_URL = "/v2/pet/";
    private static final String STATUS = "status";
    private static final String TAGS = "tags";

    public Get(String resourceUrl){
        RESOURCE_URL = resourceUrl;
    }

    public List<Pet> findByStatus(List<Pet.Status> status) {
        try {
            List<String> params = new ArrayList<>();
            for (Pet.Status status1 : status) {
                params.add(status1.name().toLowerCase());
            }

            URL url = new URLBuilder(RESOURCE_URL + GET_FIND_BY_STATUS_URL)
                    .withParam(STATUS, params)
                    .build();
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
            List<String> params = new ArrayList<>();
            for (Tag tag : tags) {
                params.add(tag.getName());
            }

            URL url = new URLBuilder(RESOURCE_URL + GET_FIND_BY_TAGS_URL)
                    .withParam(TAGS, params)
                    .build();
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
            URL url = new URL(RESOURCE_URL + GET_FIND_BY_ID_URL + id);
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