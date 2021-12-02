package com.example.app1;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class dataBase {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Map<String, Object> user = new HashMap<>();

    public dataBase(String username, String user_mail){
        user.put("user_name",username);
        user.put("user_mail",user_mail);

        db.collection("users").document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .set(user)
                .addOnSuccessListener(unused -> {

                })
                .addOnFailureListener(e -> {

                });
    }
}
