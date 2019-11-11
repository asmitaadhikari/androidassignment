package com.example.presidents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplaySpinner extends AppCompatActivity {

    TextView tvname,tvage,tveducation,tvemail,tvaddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinnerdisplay);

        tvname = findViewById(R.id.name);
        tvage= findViewById(R.id.age);
        tveducation=findViewById(R.id.edu);
        tvemail = findViewById(R.id.email);
        tvaddress = findViewById(R.id.address);

        Bundle bundleForm = getIntent().getExtras();
        if(bundleForm != null){
            tvname.setText(bundleForm.getString("forName"));
            tvage.setText(bundleForm.getString("forage"));
            tveducation.setText(bundleForm.getString("foreducation"));
            tvemail.setText(bundleForm.getString("foremail"));
            tvaddress.setText(bundleForm.getString("forAddress"));

        }
        else{
            Toast.makeText(this, "Sorry, no data found.", Toast.LENGTH_SHORT).show();
        }

    }
}
