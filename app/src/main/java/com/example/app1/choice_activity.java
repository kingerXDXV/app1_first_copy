package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class choice_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Button take_test, create_test, enter_quiz_code;
        take_test=findViewById(R.id.take_test);
        create_test=findViewById(R.id.create_test);
        enter_quiz_code=findViewById(R.id.enter_quiz_code);
        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);


        take_test.setOnClickListener(view -> {
            intent.putExtra("create",0);
            startActivity(intent);
        });
        create_test.setOnClickListener(view -> {
            intent.putExtra("create",1);
            startActivity(intent);
        });
        enter_quiz_code.setOnClickListener(view -> {
            Intent intent2 = new Intent(getApplicationContext(), com.example.app1.enter_code.class);
            startActivity(intent2);
        });

    }
}