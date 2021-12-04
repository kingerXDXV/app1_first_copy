package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button beginner, intermediate, advanced;
        beginner=findViewById(R.id.beginner);
        intermediate=findViewById(R.id.middle);
        advanced=findViewById(R.id.advanced);
        Intent pre_intent = getIntent();
        int create = pre_intent.getExtras().getInt("create");
        the_parent_class obj=new the_parent_class();

        Intent intent;
        if(create==1){
            intent = new Intent(getApplicationContext(),Create_custom_test.class);
            flag=true;
        }else{
            intent = new Intent(getApplicationContext(),MainActivity3.class);
        }


        beginner.setOnClickListener(view -> {
            if(flag)
            obj.setTest_code2("211");
            obj.setLevel("Easy");
            obj.setCategory("&difficulty=Easy&limit=15");
            startActivity(intent);
        });

        intermediate.setOnClickListener(view -> {
            if(flag)
            obj.setTest_code2("222");
            obj.setLevel("Medium");
            obj.setCategory("&difficulty=Medium&limit=15");
            startActivity(intent);
        });

        advanced.setOnClickListener(view -> {
            if(flag)
            obj.setTest_code2("233");
            obj.setLevel("Hard");
            obj.setCategory("&difficulty=Hard&limit=15");
            startActivity(intent);
        });

    }
}