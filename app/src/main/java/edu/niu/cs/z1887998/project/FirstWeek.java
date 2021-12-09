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

public class FirstWeek extends AppCompatActivity {
    Button submit;
    RadioGroup group;
    boolean flag = true;
    TextView que,score,result;
    RadioButton checkedRadioButton;
    RadioButton answer1,answer2,answer3,answer4;
    int x,c,i,answer_count=0,total_count = 1 ;
    String answer[] = new String[10];
    Integer rand_question[] = new Integer[5];
    String question[] = new String[10];
    String options[][] = new String[10][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_week);
        //function to generate a random question
        Random_Question();

        //number of questions
        question[0] = "Wrapping data and its related \n functionality into a single entity \n is known as _____________";
        question[1] = "Which concept allows you to reuse \n the written code? ";
        question[2] = "Which of the following shows \n multiple inheritances?";
        question[3] = "Which of the following class allows \n to declare only one object of it?";
        question[4] = "Which of the following is not a \n type of Constructor?";
        question[5] = "Out of the following, which is \n not a member of the class?";
        question[6] = "What is the other name used for \n functions inside a class?";
        question[7] = "Which of the following cannot \n be a friend? ";
        question[8] = "How many types of polymorphism \n are there in C++?";
        question[9] = "Which of the following is  an \n abstract data type? ";

        //Options for the questions
        options[0][0] = "Abstraction";
        options[0][1] = "Encapsulation";
        options[0][2] = "Polymorphism";
        options[0][3] = "Modularity";

        options[1][0] = "Encapsulation";
        options[1][1] = "Abstraction";
        options[1][2] = "Inheritance";
        options[1][3] = "Polymorphism";

        options[2][0] = "A->B->C";
        options[2][1] = "A->B; A->C";
        options[2][2] = "A,B->C";
        options[2][3] = " B->A";

        options[3][0] = "Abstract class";
        options[3][1] = "Virtual class";
        options[3][2] = "Singleton class";
        options[3][3] = "Friend class";

        options[4][0] = "Friend constructor";
        options[4][1] = "Copy constructor";
        options[4][2] = "Default constructor";
        options[4][3] = "Parameterized constructor";

        options[5][0] = "Static function";
        options[5][1] = "Friend function";
        options[5][2] = "Constant function";
        options[5][3] = "Virtual function";

        options[6][0] = "Member variables";
        options[6][1] = "Member functions";
        options[6][2] = "Class functions";
        options[6][3] = "Class variables";

        options[7][0] = "Function";
        options[7][1] = "Class";
        options[7][2] = "Object";
        options[7][3] = "Operator function";

        options[8][0] = "1";
        options[8][1] = "2";
        options[8][2] = "3";
        options[8][3] = "4";

        options[9][0] = "int";
        options[9][1] = "float";
        options[9][2] = "class";
        options[9][3] = "string";

        //answers for the questions
        answer[0] = "Encapsulation";
        answer[1] = "Inheritance";
        answer[2] = "A,B->C";
        answer[3] = "Singleton class";
        answer[4] = "Friend constructor";
        answer[5] = "Friend function";
        answer[6] = "Member functions";
        answer[7] = "Object";
        answer[8] = "2";
        answer[9] = "class";

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
        for(i = 1 ;i < 5;)
        {
            int rno = random_number.nextInt(9)+1;
            for(j = 0;j < i; j++)
            {
                if(rand_question[j] == rno)
                {
                    break;
                }
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
        String get_Ans=checkedRadioButton.getText().toString();
        if(get_Ans.equalsIgnoreCase(answer[x]))
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
