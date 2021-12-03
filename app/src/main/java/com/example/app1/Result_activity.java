package com.example.app1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;

public class Result_activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model_data_result_firebase> model_data_result_firebaseArrayList;
    MyAdapter getResultAdapter;



    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        recyclerView = findViewById(R.id.result_recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model_data_result_firebaseArrayList = new ArrayList<>();
        getResultAdapter = new MyAdapter(Result_activity.this,model_data_result_firebaseArrayList);
        recyclerView.setAdapter(getResultAdapter);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .collection("index")
                .addSnapshotListener((value, error) -> {
                    assert value != null;
                    for(DocumentChange dc : value.getDocumentChanges()){
                            model_data_result_firebaseArrayList.add(dc.getDocument().toObject(model_data_result_firebase.class));
                    }
                    getResultAdapter.notifyDataSetChanged();

                });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Result_activity.this,Home_activity.class);
        startActivity(intent);
        finish();
    }
}