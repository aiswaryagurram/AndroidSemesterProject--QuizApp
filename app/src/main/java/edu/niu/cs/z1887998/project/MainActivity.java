/*******************************************************************************
 *     Class Name: MainActivity.java                                           *
 *                                                                             *
 *   Developer(s): Aiswarya Gurram	                                       *
 *                                                                             *
 * Purpose: This main activity initializes spinner element and provides a drop *
 *           down layout for the student to select the quiz,when the student   *
 *           selects the quiz,the layout is dispayed according to the week     *
 *           selected by the student                                           *
 ******************************************************************************/

package edu.niu.cs.z1887998.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner week = (Spinner) findViewById(R.id.spinner);                           // Spinner element
        Button button=(Button)findViewById(R.id.button);
        week.setOnItemSelectedListener(this);                                               // Spinner click listener
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("1st Week Quiz");
        categories.add("2nd Week Quiz");
        categories.add("3rd Week Quiz");
        categories.add("4th Week Quiz");
        categories.add("5th Week Quiz");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);            //Initializing adapter for spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // Drop down layout style
        week.setAdapter(dataAdapter);                                                       // attaching data adapter to spinner
        //selecting the quiz week
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = String.valueOf(week.getSelectedItem());
                Intent intent=null;
                if(Text.equalsIgnoreCase("1st Week Quiz"))
                    intent= new Intent(MainActivity.this,FirstWeek.class);
                else if(Text.equalsIgnoreCase("2nd Week Quiz"))
                    intent= new Intent(MainActivity.this,SecondWeek.class);
                else  if(Text.equalsIgnoreCase("3rd Week Quiz"))
                    intent= new Intent(MainActivity.this,ThirdWeek.class);
                else if(Text.equalsIgnoreCase("4th Week Quiz"))
                    intent= new Intent(MainActivity.this,ForthWeek.class);
                else if(Text.equalsIgnoreCase("5th Week Quiz"))
                    intent= new Intent(MainActivity.this,FifthWeek.class);
                intent.putExtra("data",String.valueOf(week.getSelectedItem()));
                startActivity(intent);
            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String item = parent.getItemAtPosition(position).toString();                            // On selecting a spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show(); //shows selected spinner element

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}

