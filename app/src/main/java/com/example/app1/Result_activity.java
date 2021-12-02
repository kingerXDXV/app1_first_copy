package com.example.app1;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class Result_activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model_data_result_firebase> model_data_result_firebaseArrayList;
    get_result_adapter getResultAdapter;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int correct_answer,skip;
        String subject, level;

        the_parent_class obj = new the_parent_class();
        correct_answer=obj.getAnswer_correct();
        subject=obj.getSubject();
        skip=obj.getSkip();
        level=obj.getLevel();
        new progress_class(subject,level,correct_answer,skip);

        recyclerView = findViewById(R.id.result_recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model_data_result_firebaseArrayList = new ArrayList<model_data_result_firebase>();
        getResultAdapter = new get_result_adapter(Result_activity.this,model_data_result_firebaseArrayList);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .collection("index")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        assert value != null;
                        for(DocumentChange dc : value.getDocumentChanges()){
                            if(dc.getType() == DocumentChange.Type.ADDED){
                                model_data_result_firebaseArrayList.add(dc.getDocument().toObject(model_data_result_firebase.class));
                            }
                        }
                        getResultAdapter.notifyDataSetChanged();

                    }
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