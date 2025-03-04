package org.example;                     // Change the package name
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AccessTokenFetcher {

    private static final String GRANT_TYPE = "password";
    private static final String CLIENT_ID = "resource_server"; // Replace it with your actual client ID
    private static final String CLIENT_SECRET = "resource_server"; // Replace it with your actual client secret

    public static void main(String[] args) {
        String token = getAccessToken("asp", "9649964096", "123456"); // Calling the method
        // to print the received access token
        System.out.println(token);
    }

    public static @Nullable String getAccessToken(String tenantCode, String username, String password) {
        String authTokenUrl = "https://sso.sg.cropin.in/auth/realms/" + tenantCode + "/protocol/openid-connect/token";

        try {
            URI uri = new URI(authTokenUrl);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            String parameters = "username=" + URLEncoder.encode(username, StandardCharsets.UTF_8.name()) +
                    "&password=" + URLEncoder.encode(password, StandardCharsets.UTF_8.name()) +
                    "&grant_type=" + GRANT_TYPE + "&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET;

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = parameters.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("Failed to retrieve access token: HTTP " + responseCode);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }
            reader.close();

            // Extract access_token manually
            return extractAccessToken(responseBody.toString());
        } catch (Exception e) {
            System.err.println("Failed to retrieve access token: " + e.getMessage());
            return null;
        }
    }

    private static @Nullable String extractAccessToken(@NotNull String response) {
        String tokenKey = "\"access_token\":\"";
        int startIndex = response.indexOf(tokenKey);
        if (startIndex == -1) {
            return null;
        }
        startIndex += tokenKey.length();
        int endIndex = response.indexOf("\"", startIndex);
        return (endIndex != -1) ? response.substring(startIndex, endIndex) : null;
    }
}

