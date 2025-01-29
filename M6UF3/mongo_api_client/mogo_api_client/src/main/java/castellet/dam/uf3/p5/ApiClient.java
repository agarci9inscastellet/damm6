package castellet.dam.uf3.p5;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiClient {

    public static void main(String[] args) {
        listAll();
        User user = userForm(args);  
        sendUserToApi(user); 


    }
    public static void listAll() {
        try {
            URL url = new URL("http://localhost:3030/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                System.out.println(inputLine);
                System.out.println(".........");
            }

            in.close();
            conn.disconnect();

            // Parse JSON response manually
            JSONArray jsonArray = new JSONArray(content.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                User user = new User();
                user.setName(jsonObject.getString("name"));
                user.setEmail(jsonObject.getString("email"));

                System.out.println("Name: " + user.getName());
                System.out.println("Email: " + user.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private static User userForm(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User user = new User(name, email);
        return user;
    }

    private static void sendUserToApi(User user) {
        try {
            URL url = new URL("http://localhost:3030/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", user.getName());
            jsonObject.put("email", user.getEmail());

            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonObject.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            System.out.println("Response from server: " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}