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

public class FifthWeek extends AppCompatActivity {
    Button submit;
    RadioGroup group;
    boolean flag = true;
    TextView que,score,result;
    RadioButton checkedRadioButton;
    RadioButton answer1,answer2,answer3,answer4;
    int x,c,i,answer_count=0,total_count=1 ;
    String question[]=new String[10];
    String options[][]=new String[10][4];
    String answer[]=new String[10];
    Integer rand_question[]=new Integer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_week);

        //function to generate a random question
        Random_Question();

        //number of questions
        question[0] = "Which keyword is used to check \n exception in the block of code?";
        question[1] = "What will happen when the exception \n is not caught in the program?";
        question[2] = "Which operator is used for \n accessing a member of namespace?";
        question[3] = "Which operator is used to \n signify the namespace?";
        question[4] = "What is the general syntax for \n accessing the namespace variable?";
        question[5] = "Which keyword is used to access \n the variable in the namespace?";
        question[6] = "which of the following is used \n to implement the c++ interfaces?";
        question[7] = "What is similar to the interface \n in c++?";
        question[8] = "Which other keywords are also \n used to declare the class other \n than class?";
        question[9] = "Constructors are used to ____________";

        //Options for the questions

        options[0][0] = "catch";
        options[0][1] = "throw";
        options[0][2] = "try";
        options[0][3] = "handlers";

        options[1][0] = "error";
        options[1][1] = "program will execute";
        options[1][2] = "block of that code will not execute";
        options[1][3] = "program will execute & displays wrong output";

        options[2][0] = ":";
        options[2][1] = "::";
        options[2][2] = "->";
        options[2][3] = ".";

        options[3][0] = "conditional operator";
        options[3][1] = "ternary operator";
        options[3][2] = "scope operator";
        options[3][3] = "bitwise operator";

        options[4][0] = "namespace::operator";
        options[4][1] = "namespace,operator";
        options[4][2] = "namespace#operator";
        options[4][3] = "namespace$operator";

        options[5][0] = "using";
        options[5][1] = "dynamic";
        options[5][2] = "const";
        options[5][3] = "static";

        options[6][0] = "absolute variables";
        options[6][1] = "abstract classes";
        options[6][2] = "constant variables";
        options[6][3] = "default variables";

        options[7][0] = "methods";
        options[7][1] = "instance of a class";
        options[7][2] = "methods & instance of a class";
        options[7][3] = "pure abstract class";

        options[8][0] = "struct";
        options[8][1] = "union";
        options[8][2] = "object";
        options[8][3] = "both struct & union";

        options[9][0] = "initialize the objects";
        options[9][1] = "construct the data members";
        options[9][2] = "both initialize the objects & construct the data members";
        options[9][3] = "delete the objects";

        //answers for the questions
        answer[0] = "try";
        answer[1] = "error";
        answer[2] = "::";
        answer[3] = "scope operator";
        answer[4] = "namespace::operator";
        answer[5] = "friend";
        answer[6] = "abstract classes";
        answer[7] = "pure abstract class";
        answer[8] = "both struct & union";
        answer[9] = "initialize the objects";

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
        String ques = Integer.toString(c+1)+" Q. "+question[rand_question[c]];
        que.setText(ques);
        answer1.setText(options[rand_question[c]][0]);
        answer2.setText(options[rand_question[c]][1]);
        answer3.setText(options[rand_question[c]][2]);
        answer4.setText(options[rand_question[c]][3]);
        x = rand_question[c];
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
                    // Changes the textview's text to "Checked: example radiobutton text"
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

    //function to get the random question from a pool of questions
    public void Random_Question()
    {

        int i,j;
        Random random_number = new Random();
        rand_question[0] = random_number.nextInt(9)+1;
        for(i = 1; i < 5;)
        {
            int rno = random_number.nextInt(9)+1;
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
    //function that prompts the next Question
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


    //clears the radiobuttons selected
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
