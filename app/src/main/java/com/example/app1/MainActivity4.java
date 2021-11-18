package com.example.app1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity4 extends AppCompatActivity {

    private TextView question;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private TextView answer_show;
    int count=0;
    private String answer1,answer2,answer3,answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        question=findViewById(R.id.question_text);
        option1=findViewById(R.id.option_1);
        option2=findViewById(R.id.option_2);
        option3=findViewById(R.id.option_3);
        option4=findViewById(R.id.option_4);
        Button next_question = findViewById(R.id.next_question);
        answer_show = findViewById(R.id.answer_show);


        the_parent_class obj=new the_parent_class();

        set_timer(obj);
        loadQuestion(obj);
        next_question.setOnClickListener(view -> {
            loadQuestion(obj);
            count++;
            option1.setClickable(true);
            option2.setClickable(true);
            option3.setClickable(true);
            option4.setClickable(true);
            answer_show.setText("");
        });

        option_checker();

    }

    // to check if option is correct of not
    private void option_checker() {
        option1.setOnClickListener(view -> {
            checker(answer1);
        });
        option2.setOnClickListener(view -> {
            checker(answer2);
        });
        option3.setOnClickListener(view -> {
            checker(answer3);
        });
        option4.setOnClickListener(view -> {
            checker(answer4);
        });
    }

    //extension of option_checker function
    @SuppressLint("SetTextI18n")
    private void checker(String answer) {

        if (answer.equals("true")){
            answer_show.setText("Correct");
        }else{
            String correct = null;
            if(answer1.equals("true")){
                correct="a";
            }else if(answer2.equals("true")){
                correct="b";
            }else if(answer3.equals("true")){
                correct="c";
            }else if(answer4.equals("true")){
                correct="d";
            }
            answer_show.setText("Incorrect, Correct answer = "+correct);
        }
        option1.setClickable(false);
        option2.setClickable(false);
        option3.setClickable(false);
        option4.setClickable(false);
    }

    //To set time and display an alert dialog
    private void set_timer(the_parent_class obj) {
        TextView watch_time=findViewById(R.id.watch_time);

        if(obj.isFlag()){
            new CountDownTimer(15000, 1000) {
                int count_seconds=0;
                int minutes=0;
                @SuppressLint("DefaultLocale")
                @Override
                public void onTick(long l) {

                    if(count_seconds==60){
                        ++minutes;
                        count_seconds=1;
                    }else{
                        ++count_seconds;
                    }

                    watch_time.setText(String.format("%d %s %2d",minutes,":",count_seconds));
                }

                @Override
                public void onFinish() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
                    builder.setMessage("Your time has finished")
                            .setTitle("Time Ended")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(getApplicationContext(),Home_activity.class);
                                    startActivity(intent);
                                }
                            }).setCancelable(false);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            }.start();
        }else{
            watch_time.setText("");
        }
    }

    // To load the question for attempting
    private void loadQuestion(the_parent_class obj) {

        String url;
        String category;


        url=obj.getUrl();
        category= obj.getCategory();

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                try {
                        JSONObject quiz = response.getJSONObject(count);
                        question.setText(quiz.getString("question"));
                        // json object to fetch options
                        JSONObject op = quiz.getJSONObject("answers");
                        option1.setText(op.getString("answer_a"));
                        option2.setText(op.getString("answer_b"));
                        option3.setText(op.getString("answer_c"));
                        option4.setText(op.getString("answer_d"));
                        // json object to fetch the correct answer
                        JSONObject correct_op = quiz.getJSONObject("correct_answers");
                        answer1=correct_op.getString("answer_a_correct");
                        answer2=correct_op.getString("answer_b_correct");
                        answer3=correct_op.getString("answer_c_correct");
                        answer4=correct_op.getString("answer_d_correct");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                question.setText(R.string.error);
            }
        });

        // use of volley library
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
        builder.setMessage("Do you want to Exit the test.")
                .setPositiveButton("No, Take me back",null).setCancelable(false)
                .setNegativeButton("Exit Anyway", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(),Home_activity.class);
                        startActivity(intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
