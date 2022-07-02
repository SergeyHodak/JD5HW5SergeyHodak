package pet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

public class Response {
    public List<Pet> getList(HttpURLConnection connection) {
        return new Gson().fromJson(getResponse(connection), new TypeToken<List<Pet>>(){}.getType());
    }

    public Pet get(HttpURLConnection connection) {
        return new Gson().fromJson(getResponse(connection), Pet.class);
    }

    private String getResponse(HttpURLConnection connection) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            try {
                bufferedReader.close();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }

            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}