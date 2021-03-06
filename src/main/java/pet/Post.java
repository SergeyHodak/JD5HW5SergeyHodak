package pet;

import com.google.gson.Gson;
import models.ApiResponse;
import models.Pet;
import okhttp3.*;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

public class Post {
    private final String BASE_URL;
    private static final String PET_URL = "/pet";
    private static final String POST_UPLOAD_IMAGE = "/uploadImage";
    private static final String FILE = "file";
    private static final String ADDITIONAL_METADATA = "additionalMetadata";
    private static final String MEDIA_TYPE = "image/*";
    private static final String NAME_RESPONSE_TYPE = "accept";
    private static final String FORM_JSON = "application/json";
    private static final String NAME_REQUEST_TYPE = "Content-Type";
    private static final String TEXT_ENCODING = "charset=utf-8";
    private static final String NAME = "name";
    private static final String STATUS = "status";
    private static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";

    public Post(String baseURL) {
        BASE_URL = baseURL;
    }

    public ApiResponse uploadImage(long id, String additionalMetadata, File file) {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
        RequestBody fileBody = RequestBody.create(file, MediaType.parse(MEDIA_TYPE));
        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(FILE, file.getName(), fileBody)
                .addFormDataPart(ADDITIONAL_METADATA, additionalMetadata)
                .build();
        Request request = new Request.Builder()
                .url(BASE_URL + PET_URL + "/" + id + POST_UPLOAD_IMAGE)
                .post(multipartBody)
                .build();
        okhttp3.Response response;
        try {
            response = okHttpClient.newCall(request).execute();
            if (HttpURLConnection.HTTP_OK == response.code()) {
                Type type = ApiResponse.class;
                String message = response.body().string();
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pet addANewPetToTheStore(Pet pet) {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
        MediaType JSON = MediaType.parse(FORM_JSON + "; " + TEXT_ENCODING);
        String json = new Gson().toJson(pet);
        okhttp3.RequestBody body = RequestBody.create(json, JSON);
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(BASE_URL + PET_URL)
                .addHeader(NAME_RESPONSE_TYPE, FORM_JSON)
                .addHeader(NAME_REQUEST_TYPE, FORM_JSON)
                .post(body)
                .build();
        okhttp3.Response response;
        try {
            response = okHttpClient.newCall(request).execute();
            if (HttpURLConnection.HTTP_OK == response.code()) {
                Type type = Pet.class;
                String message = response.body().string();
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ApiResponse updateStorePetWithFormData(long id, String name, Pet.Status status) {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
        MediaType URL = MediaType.parse(FORM_URL_ENCODED + "; " + TEXT_ENCODING);
        String text = NAME + "=" + name + "&" + STATUS + "=" + status.name().toLowerCase();
        okhttp3.RequestBody body = RequestBody.create(text, URL);
        Request request = new Request.Builder()
                .url(BASE_URL + PET_URL + "/" + id)
                .addHeader(NAME_REQUEST_TYPE, FORM_URL_ENCODED)
                .addHeader(NAME_RESPONSE_TYPE, FORM_JSON)
                .post(body)
                .build();
        okhttp3.Response response;
        try {
            response = okHttpClient.newCall(request).execute();
            if (HttpURLConnection.HTTP_OK == response.code()) {
                Type type = ApiResponse.class;
                String message = response.body().string();
                System.out.println("message = " + message);
                return new Gson().fromJson(message, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}