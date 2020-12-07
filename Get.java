import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Get {
    public static void main (String[] args) {
        try {
            Get.call();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void call() throws Exception {
        String url = "https://reqbin.com/echo/get/json";
        URL objeto = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) objeto.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();

        System.out.println("\nEnviando solicitação 'GET' para URL: " + url);
        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream())
        );
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("\nResposta da solicitação: ");
        System.out.println(response.toString());
    }     
}