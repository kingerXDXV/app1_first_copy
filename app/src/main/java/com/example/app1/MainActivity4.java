package com.example.app1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity4 extends AppCompatActivity {

    private TextView question;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private Button next_question;
    private TextView answer_show;
    private int count=0,skip=0;
    private String answer1,answer2,answer3,answer4;
    private int correct_answer=0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //-------------------------------------------------------all buttons, textview in the activity main 4 imported from fragment
        question=findViewById(R.id.question_text);
        option1=findViewById(R.id.option_1);
        option2=findViewById(R.id.option_2);
        option3=findViewById(R.id.option_3);
        option4=findViewById(R.id.option_4);
        next_question = findViewById(R.id.next_question);
        answer_show = findViewById(R.id.answer_show);

        //-----------------------------------------------------asking user to skip the question
        next_question.setText("Skip");

        // ---------------------------------------------------calling the parent class
        the_parent_class obj=new the_parent_class();

        set_timer(obj);
        //---------------------------------------loading question
        loadQuestion(obj);

        next_question.setOnClickListener(view -> {
            if(next_question.getText().equals("Skip")){
                skip++;
            }
            if(count==14){
                end_quiz(obj);
            }
            next_question.setText("Skip");
            loadQuestion(obj);
            count++;
            option1.setClickable(true);
            option2.setClickable(true);
            option3.setClickable(true);
            option4.setClickable(true);
            answer_show.setText("");
            option1.setBackgroundColor(Color.LTGRAY);
            option2.setBackgroundColor(Color.LTGRAY);
            option3.setBackgroundColor(Color.LTGRAY);
            option4.setBackgroundColor(Color.LTGRAY);
        });

        //---------------------------------------------------------option buttons
        option1.setOnClickListener(view -> {
            next_question.setText("Next");
            if(answer1.equals("true")){
                option1.setBackgroundColor(Color.GREEN);
                correct_answer++;
            }else{
                answer_show.setText("Wrong, Correct answer = "+checker());
                option1.setBackgroundColor(Color.RED);
            }
            button_clickable();
        });
        option2.setOnClickListener(view -> {
            next_question.setText("Next");
            if (answer2.equals("true")) {
                option2.setBackgroundColor(Color.GREEN);
                correct_answer++;
            }else{
                answer_show.setText("Wrong, Correct answer = "+checker());
                option2.setBackgroundColor(Color.RED);
            }
            button_clickable();
        });
        option3.setOnClickListener(view -> {
            next_question.setText("Next");
            if(answer3.equals("true")){
                option3.setBackgroundColor(Color.GREEN);
                correct_answer++;
            }else{
                answer_show.setText("Wrong, Correct answer = "+checker());
                option3.setBackgroundColor(Color.RED);
            }
            button_clickable();
        });
        option4.setOnClickListener(view -> {
            next_question.setText("Next");
            if(answer4.equals("true")){
                option4.setBackgroundColor(Color.GREEN);
                correct_answer++;
            }else{
                answer_show.setText("Wrong, Correct answer = "+checker());
                option4.setBackgroundColor(Color.RED);
            }
            button_clickable();
        });


    }

    private void button_clickable() {
        option1.setClickable(false);
        option2.setClickable(false);
        option3.setClickable(false);
        option4.setClickable(false);
    }

    @SuppressLint("ResourceAsColor")
    private String checker() {

        String correct = "";
        if(answer1.equals("true")){
            correct= "option 1";
        }else if(answer2.equals("true")){
            correct= "option 2";
        }else if(answer3.equals("true")){
            correct= "option 3";
        }else if(answer4.equals("true")){
            correct= "option 4";
        }
        return correct;
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
                    end_quiz(obj);
                }
            }.start();
        }else{
            end_quiz(obj);
            watch_time.setText("");
        }
    }

    private void end_quiz(the_parent_class obj) {
        String subject, level;
        subject=obj.getSubject();
        level=obj.getLevel();
        new progress_class(subject,level,Integer.toString(correct_answer), Integer.toString(skip));

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
        builder.setMessage("Your Quiz has finished")
                .setTitle("Quiz Ended")
                .setPositiveButton("OK", (dialogInterface, i) -> {
                    Intent intent = new Intent(getApplicationContext(),Result_activity.class);
                    startActivity(intent);
                }).setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // To load the question for attempting
    private void loadQuestion(the_parent_class obj) {

        String url;


        url=obj.getUrl();

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {


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
        }, error -> question.setText(R.string.error));

        // use of volley library
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
        builder.setMessage("Do you want to Exit the test.")
                .setPositiveButton("No, Take me back",null).setCancelable(false)
                .setNegativeButton("Exit Anyway", (dialogInterface, i) -> {
                    Intent intent = new Intent(getApplicationContext(),Home_activity.class);
                    startActivity(intent);
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
