package pet;

import com.google.gson.Gson;
import models.ApiResponse;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

public class Delete {
    private final String BASE_URL;
    private static final String FORM_JSON = "application/json";
    private static final String TEXT_ENCODING = "charset=utf-8";
    private static final String PET_URL = "/pet";
    private static final String NAME_RESPONSE_TYPE = "accept";
    private static final String NAME_API_KEY = "api_key";

    public Delete(String baseURL) {
        BASE_URL = baseURL;
    }

    public ApiResponse deletePet(long id, String apiKey) {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(BASE_URL + PET_URL + "/" + id)
                .addHeader(NAME_RESPONSE_TYPE, FORM_JSON)
                .addHeader(NAME_API_KEY, apiKey)
                .delete()
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