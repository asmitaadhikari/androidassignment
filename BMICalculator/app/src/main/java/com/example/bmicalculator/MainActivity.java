package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //references to the widgets

        final EditText e1 = (EditText) findViewById(R.id.weight);
        final EditText e2 = (EditText) findViewById(R.id.height);
        final TextView result = (TextView) findViewById(R.id.result);

        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            //validation for empty spaces
            public void onClick(View v) {
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if (TextUtils.isEmpty(str1)) {
                    e1.setError("please enter your weight");
                    e1.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    e2.setError(("Please enter your height"));
                    e2.requestFocus();
                    return;
                }
                //get the users value from layout
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2) / 100;

                //Calculate BMI
                float bmiValue = calculateBMI(weight, height);

                //Defining BMI
                String bmiInterpretation = interpretBMI(bmiValue);

                result.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));
            }
        });

    }

    //Calculate BMI
    private float calculateBMI(float weight, float height) {
        return (float) (weight / (height * height));
    }
    //Interpret BMI

    private String interpretBMI(float bmiValue) {
        if  (bmiValue < 18.5) {
            return "you are Underweight";
        } else if (bmiValue < 25) {
            return "you are normal";
        } else if (bmiValue < 30) {
            return "you are overweight";
        } else {
            return "you are obese";
        }
    }
}
