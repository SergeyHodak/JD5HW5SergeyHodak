package pet;

import models.Method;
import models.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Post {
//    public void PostFindByStatus() {
//        String urlAddress = "https://petstore.swagger.io/v2/pet/findByStatus";
//        URL url;
//        HttpURLConnection httpURLConnection;
//        OutputStream os = null;
//        InputStreamReader isR = null;
//        BufferedReader bfR = null;
//
//        try {
//            Map<String, String> getArgs = new HashMap<>();
//            getArgs.put("status", Pet.Status.AVAILABLE.name());
//            byte[] out = getArgs.toString().getBytes();
//
//            url = new URL(urlAddress);
//            httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod(Method.GET.name());
//            httpURLConnection.setDoOutput(true);
//            httpURLConnection.setDoInput(true);
//
//            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5,0");
//            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//            httpURLConnection.setConnectTimeout(1000);
//            httpURLConnection.setReadTimeout(1000);
//            httpURLConnection.connect();
//
//            try {
//                os = httpURLConnection.getOutputStream();
//                os.write(out);
//            } catch (Exception e) {
//                System.err.print(e.getMessage());
//            }
//
//            if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()) {
//                isR = new InputStreamReader(httpURLConnection.getInputStream());
//                bfR = new BufferedReader(isR);
//                StringBuilder result = new StringBuilder();
//                String line;
//                while ((line = bfR.readLine()) != null) {
//                    result.append(line);
//                }
//                System.out.println("result = " + result);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.err.print(e.getMessage());
//        } finally {
//            try {
//                assert isR != null;
//                isR.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                assert bfR != null;
//                bfR.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                assert os != null;
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static final String USER_AGENT = "Mozilla/5.0";
}

//        StringBuilder result = new StringBuilder();
//        BufferedReader in = null;
//        HttpURLConnection connection = null;
//        try {
//            URL getUrl = new URL("https://petstore.swagger.io" + path);
//            // Открываем соединение с URL
//            connection = (HttpURLConnection) getUrl.openConnection();
//
//            // Перед подключением устанавливаем общие атрибуты запроса
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent", USER_AGENT);
//            connection.setRequestProperty("Charset", "UTF-8");
//
//            // Настройте Content-type для этого соединения, форма формы - это "application / x-www-form-urlencoded", json - это "application / json" и т. Д.
//            // Настройте Content-type в соответствии с вашими потребностями
//            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            // Устанавливаем период ожидания для подключения к хост-серверу: 15000 миллисекунд
//            connection.setConnectTimeout(15000);
//            // Устанавливаем время чтения данных, возвращаемых удаленным устройством: 60000 миллисекунд
//            connection.setReadTimeout(60000);
//            // Устанавливаем способ подключения: get
//            connection.setRequestMethod(method);
//            // Устанавливаем фактическое соединение, обратите внимание, что connection.getOutputStream будет подключаться неявно.
//            connection.setDoOutput(true);
//            OutputStream outputStream = connection.getOutputStream();
//            outputStream.write(URLEncoder.encode("status=AVAILABLE", StandardCharsets.UTF_8).getBytes());
//            //connection.connect();
//
//            // Получаем все поля заголовка ответа
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // Обходим все поля заголовка ответа
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
//
//            // Определяем входной поток BufferedReader для чтения ответа URL
//            if (connection.getResponseCode() == 200) {
//                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
//                String line;
//                while ((line = in.readLine()) != null) {
//                    result.append(line);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//                if (connection != null) {
//                    // Закрываем соединение
//                    connection.disconnect();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//        System.out.println("result = " + result);