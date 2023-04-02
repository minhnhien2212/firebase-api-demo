package com.demo.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FirebaseInitialize {

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream("./ServiceAccount.json");
            FirebaseOptions options = null;
            try {
                options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            FirebaseApp.initializeApp(options);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
