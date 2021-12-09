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

public class ThirdWeek extends AppCompatActivity {
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
        setContentView(R.layout.activity_third_week);
        //function to generate a random question
        Random_Question();

        //number of questions
        question[0] = "Which of the following correctly \n declares an array?";
        question[1] = "What is the index number of the \n last element of an array with \n 9 elements?";
        question[2] = "Which of the following gives the \n memory address of the first \n element in array?";
        question[3] = "The constants are also called as _____________";
        question[4] = "What are the parts of the \n literal constants?";
        question[5] = "How are the constants declared?";
        question[6] = "The operator used for dereferencing \n or indirection is ____";
        question[7] = "Which of the following is illegal?";
        question[8] = "Which operator is having the \n right to left associativity \n in the following??";
        question[9] = "Which operator is having the \n highest precedence?";

        //Options for the questions
        options[0][0] = "int array[10];";
        options[0][1] = "int array;";
        options[0][2] = "array{10};";
        options[0][3] = "array array[10];";

        options[1][0] = "9";
        options[1][1] = "8";
        options[1][2] = "0";
        options[1][3] = "Programmer-defined";

        options[2][0] = "array[0];";
        options[2][1] = "array[1];";
        options[2][2] = "array(2);";
        options[2][3] = "array;";

        options[3][0] = "const";
        options[3][1] = "preprocessor";
        options[3][2] = "literals";
        options[3][3] = "variables";

        options[4][0] = "integer numerals";
        options[4][1] = "floating-point numerals";
        options[4][2] = "strings and boolean values";
        options[4][3] = "all of the mentioned";

        options[5][0] = "const keyword";
        options[5][1] = "#define preprocessor";
        options[5][2] = "both const keyword and #define preprocessor";
        options[5][3] = "$define";

        options[6][0] = "*";
        options[6][1] = "&";
        options[6][2] = "->";
        options[6][3] = "–>>";

        options[7][0] = "int *ip;";
        options[7][1] = "string s, *sp = 0;";
        options[7][2] = "int i; double* dp = &i;";
        options[7][3] = "int *pi = 0;";

        options[8][0] = "Array subscripting";
        options[8][1] = "Function call";
        options[8][2] = "Addition and subtraction";
        options[8][3] = "Type cast";

        options[9][0] = "postfix";
        options[9][1] = "unary";
        options[9][2] = "shift";
        options[9][3] = "equality";

        //answers for the questions
        answer[0] = "int array[10];";
        answer[1] = "8";
        answer[2] = "array;";
        answer[3] = "literals";
        answer[4] = "all of the mentioned";
        answer[5] = "both const keyword and #define preprocessor";
        answer[6] = "*";
        answer[7] = "int i; double* dp = &i;";
        answer[8] = "Type cast";
        answer[9] = "postfix";

        // Submit button
        submit=(Button)findViewById(R.id.submit);
        group=(RadioGroup)findViewById(R.id.radioGroup3);
        answer1=(RadioButton)findViewById(R.id.ans1);
        answer2=(RadioButton)findViewById(R.id.ans2);
        answer3=(RadioButton)findViewById(R.id.ans3);
        answer4=(RadioButton)findViewById(R.id.ans4);
        result=(TextView)findViewById(R.id.status);
        score=(TextView)findViewById(R.id.score);
        que=(TextView)findViewById(R.id.ques);
        c=0;
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
    //function to go to the next question
    public void next_Question()
    {
        String ques=Integer.toString(c+1)+" Q. "+question[rand_question[c]];
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
    //function to check the answers
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

    public void onClear()
    {
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
