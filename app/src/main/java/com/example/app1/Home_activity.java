package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button linux;
        linux=findViewById(R.id.linux);

        linux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                the_parent_class obj = new the_parent_class();
                obj.setUrl("https://quizapi.io/api/v1/questions?apiKey=Z48nBSLeMR7T0t9hmTcZvV4RhO4AR31vz9M6skEE&category=linux&limit=10");

                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}