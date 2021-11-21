package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button linux,bash,sql,code;
        linux=findViewById(R.id.linux);
        bash=findViewById(R.id.bash);
        sql=findViewById(R.id.sql);
        code=findViewById(R.id.code);

        Intent intent =new Intent(getApplicationContext(), choice_activity.class);
        the_parent_class obj = new the_parent_class();

        linux.setOnClickListener(view -> {
            obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=linux");
            startActivity(intent);
        });

        bash.setOnClickListener(view -> {
            obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=bash");
            startActivity(intent);
        });

        sql.setOnClickListener(view -> {
            obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=sql");
            startActivity(intent);
        });

        code.setOnClickListener(view -> {
            obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=code");
            startActivity(intent);
        });


    }
}