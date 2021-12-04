package com.example.app1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home_activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button linux,bash,sql,code;
        TextView user_profile;
        linux=findViewById(R.id.linux);
        bash=findViewById(R.id.bash);
        sql=findViewById(R.id.sql);
        code=findViewById(R.id.code);
        user_profile=findViewById(R.id.user_profile);

        Intent intent =new Intent(getApplicationContext(), choice_activity.class);
        the_parent_class obj = new the_parent_class();
        the_parent_class.test_code1="";

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        user_profile.setText("Hello "+user.getDisplayName());

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