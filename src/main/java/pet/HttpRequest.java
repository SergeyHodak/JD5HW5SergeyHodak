package pet;

import com.google.gson.Gson;
import lombok.Data;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

@Data
public class HttpRequest {
    private Method method;
    private String path;
    private String protocol;
    private Map<String, String> headers = new LinkedHashMap<>();
    private String body;

    public enum Method {
        GET,
        POST,
        PUT,
        DELETE
    }

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

//    public static HttpRequest addUser(String url, HttpRequest user) {
//        URI uri = URI.create(url+ "/users");
//        String requestBody = GSON.toJson(user);
//        HttpRequest request = HttpRequest.newBuilder().uri(uri)
//                .header("Content-type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
//        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
//
//        return GSON.fromJson(response.body(), User.class);
//    }
//
//    private static java.net.http.HttpRequest newBuilder() {
//    }


    public static HttpRequest of(String text) {
        HttpRequest request = new HttpRequest();

        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace("\r", "");
        }

        String startLine = lines[0];
        String[] startLineParts = startLine.split(" ");
        request.setMethod(Method.valueOf(startLineParts[0]));
        request.setPath(startLineParts[1]);
        request.setProtocol(startLineParts[2]);

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];

            if (line.equals("")) {
                StringJoiner body = new StringJoiner("\n");
                for (int j = i; j < lines.length; j++) {
                    body.add(lines[j]);
                }
                request.setBody(body.toString());
            } else {
                String[] keyValue = line.split(": ");

                request.getHeaders().put(
                        keyValue[0].strip(),
                        keyValue[1].strip()
                );
            }
        }

        return request;
    }
}