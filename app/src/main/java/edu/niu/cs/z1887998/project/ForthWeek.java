package edu.niu.cs.z1887998.project;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class ForthWeek extends AppCompatActivity
{
    Button submit;
    RadioGroup group;
    boolean flag = true;
    TextView que,score,result;
    RadioButton checkedRadioButton;
    RadioButton answer1,answer2,answer3,answer4;
    int x,c,i,answer_count=0,total_count=1 ;
    String question[] = new String[10];
    String options[][] = new String[10][4];
    String answer[] = new String[10];
    Integer rand_question[] = new Integer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth_week);
        //function to generate a random question
        Random_Question();

        //number of questions
        question[0] = "What is this operator called ?:?";
        question[1] = "The switch statement is also called as?";
        question[2] = "The destination statement for the \n goto label is identified by what label?";
        question[3] = "Where does the execution of the \n program starts?";
        question[4] = "What are mandatory parts in the \n function declaration?";
        question[5] = "which of the following is used to \n terminate the function declaration?";
        question[6] = "Which is more effective while  \n calling the functions?";
        question[7] = "Which of the following is the \n default return value of functions \n in C++?";
        question[8] = "An inline function is expanded during \n ______________";
        question[9] = "To where does the program control \n transfers when the exception is arisen?";

        //Options for the questions
        options[0][0] = "conditional";
        options[0][1] = "relational";
        options[0][2] = "casting operator";
        options[0][3] = "unrelational";

        options[1][0] = "choosing structure";
        options[1][1] = "selective structure";
        options[1][2] = "certain structure";
        options[1][3] = "bitwise structure";

        options[2][0] = "$";
        options[2][1] = "@";
        options[2][2] = "*";
        options[2][3] = ":";

        options[3][0] = "user-defined function";
        options[3][1] = "main function";
        options[3][2] = "void function";
        options[3][3] = "else function";

        options[4][0] = "return type, function name";
        options[4][1] = "return type, function name, parameters";
        options[4][2] = "parameters, function name";
        options[4][3] = "parameters, variables";

        options[5][0] = ":";
        options[5][1] = ")";
        options[5][2] = ";";
        options[5][3] = "]";

        options[6][0] = "call by value";
        options[6][1] = "call by reference";
        options[6][2] = "call by pointer";
        options[6][3] = "call by object";

        options[7][0] = "int";
        options[7][1] = "char";
        options[7][2] = "float";
        options[7][3] = "void";

        options[8][0] = "compile-time";
        options[8][1] = "run-time";
        options[8][2] = "never expanded";
        options[8][3] = "end of the program";

        options[9][0] = "catch";
        options[9][1] = "handlers";
        options[9][2] = "throw";
        options[9][3] = "try";

        //answers for the questions
        answer[0] = "conditional";
        answer[1] = "selective structure";
        answer[2] = ":";
        answer[3] = "main function";
        answer[4] = "return type, function name";
        answer[5] = ";";
        answer[6] = "call by reference";
        answer[7] = "int";
        answer[8] = "compile-time";
        answer[9] = "handlers";

        // Submit button
        submit = (Button)findViewById(R.id.submit);
        group = (RadioGroup)findViewById(R.id.radioGroup3);
        answer1 = (RadioButton)findViewById(R.id.ans1);
        answer2 = (RadioButton)findViewById(R.id.ans2);
        answer3 = (RadioButton)findViewById(R.id.ans3);
        answer4 = (RadioButton)findViewById(R.id.ans4);
        result = (TextView)findViewById(R.id.status);
        score = (TextView)findViewById(R.id.score);
        que = (TextView)findViewById(R.id.ques);
        c = 0;
        String ques=Integer.toString(c+1)+" Q. "+question[rand_question[c]];
        que.setText(ques);
        answer1.setText(options[rand_question[c]][0]);
        answer2.setText(options[rand_question[c]][1]);
        answer3.setText(options[rand_question[c]][2]);
        answer4.setText(options[rand_question[c]][3]);
        x=rand_question[c];
        c++;
        submit.setEnabled(false);

        //radiobutton change event
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,  int checkedId) {
                // This will get the radiobutton that has changed in its check state
                checkedRadioButton = (RadioButton)findViewById(checkedId);
                // This variable helps to put the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked && flag)
                {
                    submit.setEnabled(true);
                    flag = false;
                }
            }
        });

        //submit button onclick event
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setEnabled(false);
                check_Answer();
                if(c >= 5)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Exam Completed!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    next_Question();
                }
            }
        });
    }
    //function to get the random questions from a pool of questions
    public void Random_Question()
    {
        int i,j;
        Random random_number = new Random();
        rand_question[0]=random_number.nextInt(9)+1;
        for(i = 1;i < 5;)
        {
            int rno=random_number.nextInt(9)+1;
            for(j = 0; j < i; j++)
            {
                if(rand_question[j] == rno)
                    break;
            }
            if(j == i)
            {
                rand_question[i] = rno;
                i++;
            }

        }
    }
    //function to go to next question
    public void next_Question()
    {
        String ques = Integer.toString(c+1)+" Q. "+question[rand_question[c]];
        que.setText(ques);
        answer1.setText(options[rand_question[c]][0]);
        answer2.setText(options[rand_question[c]][1]);
        answer3.setText(options[rand_question[c]][2]);
        answer4.setText(options[rand_question[c]][3]);
        x = rand_question[c];
        c++;
        onClear();
        flag = true;

    }
    //function to check the answer
    public void check_Answer()
    {
        String getAns = checkedRadioButton.getText().toString();
        if(getAns.equalsIgnoreCase(answer[x]))
        {
            result.setTextColor(Color.rgb(0,255,0));
            result.setText("Correct");
            answer_count++;
        }
        else
        {
            result.setTextColor(Color.rgb(255,0,0));
            result.setText("Incorrect");
        }
        score.setText("Score :"+answer_count+"/"+total_count);
        total_count++;
    }

    //to clear radio buttons
    public void onClear() {
        /* Clears all selected radio buttons to default */
        group.setOnCheckedChangeListener(null);
        group.clearCheck();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,  int checkedId) {
                checkedRadioButton = (RadioButton)findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked && flag)
                {
                    submit.setEnabled(true);
                    flag = false;
                }
            }
        });
    }
}
