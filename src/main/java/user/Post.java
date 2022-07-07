package user;

import com.google.gson.Gson;
import models.ApiResponse;
import models.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Post {
    private final String BASE_URL;
    private static final String FORM_JSON = "application/json";
    private static final String TEXT_ENCODING = "charset=utf-8";
    private static final String USER_URL = "/user";
    private static final String USER_POST_CREATE_WITH_ARRAY_URL = "/createWithArray";
    private static final String NAME_RESPONSE_TYPE = "accept";
    private static final String NAME_REQUEST_TYPE = "Content-Type";
    private static final String USER_POST_CREATE_WITH_LIST_URL = "/createWithList";

    public Post(String baseURL) {
        BASE_URL = baseURL;
    }

    public ApiResponse createWithArray(User[] users) {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
        MediaType JSON = MediaType.parse(FORM_JSON + "; " + TEXT_ENCODING);
        String json = new Gson().toJson(users);
        okhttp3.RequestBody body = RequestBody.create(json, JSON);
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(BASE_URL + USER_URL + USER_POST_CREATE_WITH_ARRAY_URL)
                .addHeader(NAME_RESPONSE_TYPE, FORM_JSON)
                .addHeader(NAME_REQUEST_TYPE, FORM_JSON)
                .post(body)
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

    public ApiResponse createWithList(List<User> users) {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
        MediaType JSON = MediaType.parse(FORM_JSON + "; " + TEXT_ENCODING);
        String json = new Gson().toJson(users);
        okhttp3.RequestBody body = RequestBody.create(json, JSON);
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(BASE_URL + USER_URL + USER_POST_CREATE_WITH_LIST_URL)
                .addHeader(NAME_RESPONSE_TYPE, FORM_JSON)
                .addHeader(NAME_REQUEST_TYPE, FORM_JSON)
                .post(body)
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

    public ApiResponse createUser(User user) {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
        MediaType JSON = MediaType.parse(FORM_JSON + "; " + TEXT_ENCODING);
        String json = new Gson().toJson(user);
        okhttp3.RequestBody body = RequestBody.create(json, JSON);
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(BASE_URL + USER_URL)
                .addHeader(NAME_RESPONSE_TYPE, FORM_JSON)
                .addHeader(NAME_REQUEST_TYPE, FORM_JSON)
                .post(body)
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
}