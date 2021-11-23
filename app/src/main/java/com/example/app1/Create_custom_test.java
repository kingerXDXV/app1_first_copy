package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Create_custom_test extends AppCompatActivity {

    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_custom_test);
        Button code_btn = findViewById(R.id.generate_code);
        Button share = findViewById(R.id.share);


        code_btn.setOnClickListener(view -> {
            TextView gen_code = findViewById(R.id.text_code);
            the_parent_class obj = new the_parent_class();
            code=obj.getTest_code1()+"-"+obj.getTest_code2();
            gen_code.setText(code);
        });


        share.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,"Let's take a quiz on wyser \n"+code);
            Intent chooser = Intent.createChooser(intent,"Share Code");
            startActivity(chooser);
        });

    }
}