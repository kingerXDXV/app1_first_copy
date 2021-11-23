package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Result_activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int correct_answer;
        String subject;

        the_parent_class obj = new the_parent_class();
        correct_answer=obj.getAnswer_correct();
        subject=obj.getSubject();

        TextView txt_result = new TextView(getApplicationContext());
        txt_result.setText("\b\tSubject:- "+subject+"\b\n\tCorrect Answer:- "+correct_answer);
        txt_result.setTextSize(15);

        LinearLayout result_linear = findViewById(R.id.result_linear);
        result_linear.addView(txt_result);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Result_activity.this,Home_activity.class);
        startActivity(intent);
    }
}