package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class enter_code extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);
        EditText editCode = findViewById(R.id.editCode);
        Button enter_code = findViewById(R.id.enterQuiz);

        enter_code.setOnClickListener(view -> {
            String code = editCode.getText().toString();
            String[] parts = code.split("-");
            the_parent_class obj = new the_parent_class();
            Intent code_intent = new Intent(getApplicationContext(),MainActivity4.class);

            switch (parts[0]) {
                case "100":
                    obj.setSubject("Linux");
                    obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=linux");
                    break;
                case "101":
                    obj.setSubject("Linux");
                    obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=bash");
                    break;
                case "102":
                    obj.setSubject("Linux");
                    obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=sql");
                    break;
                case "103":
                    obj.setSubject("Linux");
                    obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=code");
                    break;
            }
            switch (parts[1]){
                case "211":
                    obj.setCategory("&difficulty=Easy&limit=15");
                    break;
                case "222":
                    obj.setCategory("&difficulty=Medium&limit=15");
                    break;
                case "233":
                    obj.setCategory("&difficulty=Hard&limit=15");
                    break;
            }
            startActivity(code_intent);
        });
    }
}