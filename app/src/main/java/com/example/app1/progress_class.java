package com.example.app1;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class progress_class {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Map<String, Object> result = new HashMap<>();

    public  progress_class(String subject, String level, String marks, String skip){
        result.put("Subject",subject);
        result.put("level",level);
        result.put("marks",marks);
        result.put("skip",skip);

        db.collection("users").document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .collection("index")
                .document()
                .set(result)
                .addOnSuccessListener(unused -> {

                })
                .addOnFailureListener(e -> {

                });
    }
}
