package com.example.presidents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SpinnerForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText Name, Age, Education, Email;
    Spinner spinner;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_form);

        viewValue();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String name, age, edu, email, add;
                name = Name.getText().toString();
                age = Age.getText().toString();
                edu = Education.getText().toString();
                email = Email.getText().toString();
                add = spinner.getSelectedItem().toString();

                Intent intentForm = new Intent(SpinnerForm.this, DisplaySpinner.class);
                intentForm.putExtra("forname", name);
                intentForm.putExtra("forage", age);
                intentForm.putExtra("forEdu", edu);
                intentForm.putExtra("foremail", email);
                intentForm.putExtra("forAddress", add);

                startActivity(intentForm);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void viewValue() {
        Name = findViewById(R.id.etName);
        Age = findViewById(R.id.etAge);
        Education = findViewById(R.id.etEducation);
        Email = findViewById(R.id.etEmail);
        spinner = findViewById(R.id.spinner);
        submit= findViewById(R.id.submit);
    }
}