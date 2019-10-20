package com.example.emicalculator;

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

        //References to the layouts
        final EditText e1=(EditText) findViewById(R.id.principle);
        final EditText e2=(EditText) findViewById(R.id.rate);
        final EditText e3 =(EditText) findViewById(R.id.time);
        final TextView t1= (TextView) findViewById(R.id.resultemi);
        final TextView result =(TextView) findViewById(R.id.resulttotal);



       findViewById(R.id.Emicalculate).setOnClickListener(new View.OnClickListener() {
           @Override
           //Validation for empty inputs
           public void onClick(View v) {

               String str1=e1.getText().toString();
               String str2=e2.getText().toString();
               String str3 =e3.getText().toString();


               if(TextUtils.isEmpty(str1)){
                   e1.setError("Please enter amount");
                   return;
               }
               if(TextUtils.isEmpty(str2)){
                   e2.setError("Please enter Rate");
                   return;
               }
               if(TextUtils.isEmpty(str3)){
                   e3.setError("please enter time");
                   return;
               }

               float P=Float.parseFloat(str1);
               float R=Float.parseFloat(str2);
               float i=Float.parseFloat(str3);

               float Principle = calcprinciple(P);
               float Rate = calcrate(R);
               float Time = calctime(i);
               float dvdnt = calcdvdnt(Rate,Time);
               float FD = calcfinaldvdnt(Rate,Time,Principle);
               float D = calcDivider(dvdnt);
               float emi = calcEMI(FD,D);
               float TA = calcta(emi,Time);
               float ti = calcTotal(TA,Principle);

               result.setText(String.valueOf(emi));

               result.setText(String.valueOf(ti));


           }
       });

        }
        public float calcprinciple(float P){
        return (float)(P);
        }

        public float calcrate (float R){
        return (float) (R/12/100);
        }

    public float calctime (float i){
        return (float)(i * 12);
    }

    public  float calcdvdnt (float Rate, float Time){
        return (float) (Math.pow(1+Rate,Time));
        }
        public float calcfinaldvdnt (float Principle, float Rate, float dvdnt){
        return (float) (Principle * Rate * dvdnt);
        }
        public  float calcDivider (float dvdnt){
        return (float) (dvdnt-1);
        }
        public float calcEMI (float FD,float D){
        return (float) (FD/D);
        }
        public float calcta (float emi, float Time){
        return (float) (emi*Time);
        }
        public float calcTotal (float TA , float Principle){
        return (float) (TA-Principle);
        }
    }

