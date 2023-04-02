package com.demo.service;

import com.demo.entity.User;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    @Autowired
    private FirebaseInitialize firebaseInitialize;

    public String saveUserDetails(User user) throws ExecutionException, InterruptedException, IOException {
        // Initialize Firebase app
        firebaseInitialize.initialize();

        Firestore dbFirestore = FirestoreClient.getFirestore();

        // Save user to Firestore
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("User").document(user.getName()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

//    public String saveUserDetails(User user) throws ExecutionException, InterruptedException {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        // Co the cho nay bi sai
//        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("User").document(user.getName()).set(user);
//        return collectionsApiFuture.get().getUpdateTime().toString();
//    }
}
