package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button yes,no;

        yes=findViewById(R.id.yes_timer);
        no=findViewById(R.id.no_timer);

        Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
        the_parent_class obj =new the_parent_class();
        yes.setOnClickListener(view -> {
            obj.setFlag(true);
            startActivity(intent);
        });

        no.setOnClickListener(view -> {
            obj.setFlag(false);
            startActivity(intent);
        });
    }
}