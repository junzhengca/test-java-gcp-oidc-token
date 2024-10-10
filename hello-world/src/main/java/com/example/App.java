package com.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ImpersonatedCredentials;
import com.google.auth.oauth2.IdTokenCredentials;
import com.google.auth.oauth2.IdTokenProvider;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            // Get the default credentials
            GoogleCredentials sourceCredentials = GoogleCredentials.getApplicationDefault();

            // Create impersonated credentials
            ImpersonatedCredentials impersonatedCredentials = ImpersonatedCredentials.create(
                    sourceCredentials,
                    "test-service-account@test-impersonation-438218.iam.gserviceaccount.com",
                    null,
                    Arrays.asList("https://www.googleapis.com/auth/cloud-platform"),
                    300);

            // Create ID token credentials using the impersonated credentials
            IdTokenCredentials idTokenCredentials = IdTokenCredentials.newBuilder()
                    .setIdTokenProvider((IdTokenProvider) impersonatedCredentials)
                    .setTargetAudience("https://junzheng.dev")
                    .build();

            // Get the ID token
            String idToken = idTokenCredentials.refreshAccessToken().getTokenValue();
            System.out.println("Generated ID token using impersonation: " + idToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}