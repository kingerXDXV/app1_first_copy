package com.example.app1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
        the_parent_class.test_code1="";
        dataBase obj10 = new dataBase();
        obj10.progress_data();
        linux.setOnClickListener(view -> {
            obj.setTest_code1("100");
            obj.setSubject("Linux");
            obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=linux");
            startActivity(intent);
        });

        bash.setOnClickListener(view -> {
            obj.setTest_code1("101");
            obj.setSubject("Bash");
            obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=bash");
            startActivity(intent);
        });

        sql.setOnClickListener(view -> {
            obj.setTest_code1("102");
            obj.setSubject("SQL");
            obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=sql");
            startActivity(intent);
        });

        code.setOnClickListener(view -> {
            obj.setTest_code1("103");
            obj.setSubject("Code");
            obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=code");
            startActivity(intent);
        });
    }
}