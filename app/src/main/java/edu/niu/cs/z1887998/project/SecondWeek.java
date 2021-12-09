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

public class SecondWeek extends AppCompatActivity {
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
        setContentView(R.layout.activity_second_week);
        //function to generate a random question
        Random_Question();

        //number of questions
        question[0] = "Which concept means the addition \n of new components to a program as it runs?";
        question[1] = "Which of the following explains \n the overloading of functions?";
        question[2] = "Which of the following approach \n is used by C++?";
        question[3] = "Which operator is overloaded \n for a cout object?";
        question[4] = "Which of the following cannot be \n used with the virtual keyword?";
        question[5] = "Which concept is used to \n implement late binding?";
        question[6] = "Which of the following is a \n static polymorphism mechanism?";
        question[7] = "Which of the following is not \n a type of inheritance?";
        question[8] = "Which members are inherited but \n are not accessible in any case?";
        question[9] = "What does a class in C++ holds?";

        //Options for the questions
        options[0][0] = "Data hiding";
        options[0][1] = "Dynamic binding";
        options[0][2] = "Dynamic loading";
        options[0][3] = "Dynamic typing";

        options[1][0] = "Virtual polymorphism";
        options[1][1] = "Transient polymorphism";
        options[1][2] = "Ad-hoc polymorphism";
        options[1][3] = "Pseudo polymorphism";

        options[2][0] = "Top-down";
        options[2][1] = "Bottom-up";
        options[2][2] = "Left-right";
        options[2][3] = "Right-left";

        options[3][0] = ">>";
        options[3][1] = "<<";
        options[3][2] = "<";
        options[3][3] = ">";

        options[4][0] = "Class";
        options[4][1] = "Member functions";
        options[4][2] = "Constructors";
        options[4][3] = "Destructors";

        options[5][0] = "Virtual functions";
        options[5][1] = "Operator functions";
        options[5][2] = "Constant functions";
        options[5][3] = "Static functions";

        options[6][0] = "Function overloading";
        options[6][1] = "Operator overloading";
        options[6][2] = "Templates";
        options[6][3] = "All of the mentioned";

        options[7][0] = "Multiple";
        options[7][1] = "Multilevel";
        options[7][2] = "Distributive";
        options[7][3] = "Hierarchical";

        options[8][0] = "Private";
        options[8][1] = "Public";
        options[8][2] = "Protected";
        options[8][3] = "Both private and protected";

        options[9][0] = "function";
        options[9][1] = "data";
        options[9][2] = "both data & function";
        options[9][3] = "none of the above";

        //answers for the questions
        answer[0] = "Dynamic loading";
        answer[1] = "Ad-hoc polymorphism";
        answer[2] = "Bottom-up";
        answer[3] = "<<";
        answer[4] = "Constructors";
        answer[5] = "Virtual functions";
        answer[6] = "All of the mentioned";
        answer[7] = "Distributive";
        answer[8] = "Private";
        answer[9] = "both data & function";

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
                    flag=false;
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
        flag=true;

    }
    //function to check the answer
    public void check_Answer()
    {
        String getAns=checkedRadioButton.getText().toString();
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
    public void onClear()
    {
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
