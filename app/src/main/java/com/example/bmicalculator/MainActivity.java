package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText height=findViewById(R.id.editTextText);
        EditText weight=findViewById(R.id.editTextText2);

        TextView result=findViewById(R.id.result);
        Button btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the entered height and weight
                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();

                // Convert the height and weight strings to numeric values
                double heightValue = Double.parseDouble(heightStr);
                double weightValue = Double.parseDouble(weightStr);

                // Calculate BMI
                double bmi = calculateBMI(weightValue, heightValue);

                // Display the calculated BMI
                result.setText("Your BMI is: " + bmi);
            }
        });

// Method to calculate BMI
    }
    private double calculateBMI(double weight, double height) {
        // Convert height to meters
        double heightInMeters = height*0.3048;

        // Calculate BMI using the formula
        double bmi = weight / (heightInMeters * heightInMeters);

        return bmi;
    }
}