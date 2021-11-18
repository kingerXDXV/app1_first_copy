package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button beginner, intermediate, advanced;
        beginner=findViewById(R.id.beginner);
        intermediate=findViewById(R.id.middle);
        advanced=findViewById(R.id.advanced);

        the_parent_class obj=new the_parent_class();

        Intent intent = new Intent(getApplicationContext(),MainActivity3.class);



        beginner.setOnClickListener(view -> {
            obj.setCategory("Easy");
            startActivity(intent);
        });

        intermediate.setOnClickListener(view -> {
            obj.setCategory("Medium");
            startActivity(intent);
        });

        advanced.setOnClickListener(view -> {
            obj.setCategory("Hard");
            startActivity(intent);
        });

    }
}