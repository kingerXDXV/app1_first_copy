package com.example.app1;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class dataBase {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String username;
    private String user_mail;
    private String subject= "";
    private int marks=0;

    Map<String, Object> user = new HashMap<>();
    Map<String, Object> progress = new HashMap<>();

    public void collect_data(){
        user.put("user_name",username);
        user.put("user_mail",user_mail);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

        progress_data();
    }

    public void progress_data(){
        user.put("progress",progress);
        db.collection("progress")
                .add(progress)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }

    // setter methods
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }
}
