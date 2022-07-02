import models.HttpRequest;
import models.HttpResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10_000); //localhost:10000

        ExecutorService executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket connection = server.accept();

            executor.submit(() -> handleConnection(connection));
        }
    }

    private static void handleConnection(Socket connection) {
        try {
            InputStream is = connection.getInputStream();

            HttpRequest request = HttpRequest.of(readAll(is));

            HttpResponse response = new HttpResponse();
            response.setStatusCode(200);
            response.setStatusText("OK");

            try {
                String content = Files.getFileByPath(request.getPath());
                response.setBody(new String(content.getBytes(), StandardCharsets.UTF_8));
            } catch (FileNotFoundException ex) {
                response.setStatusCode(404);
                response.setStatusText("NOT FOUND");
                response.setBody("Not found!");
            }

            String responseText = response.toString();
            byte[] responseBytes = responseText.getBytes(StandardCharsets.UTF_8);

            connection.getOutputStream().write(responseBytes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String readAll(InputStream is) throws InterruptedException, IOException {
        Thread.sleep(1_000L);

        byte[] buffer = new byte[1024 * 20];

        int len = 0;
        while (is.available() > 0) {
            int read = is.read(buffer, len, is.available());
            len += read;

            Thread.sleep(1_000L);
        }

        return new String(buffer, 0, len);
    }
}