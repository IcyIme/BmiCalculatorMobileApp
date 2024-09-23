package com.grade.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    EditText weightInput;
    EditText heightInput;
    TextView BMIResult;
    TextView BMICategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        BMIResult = findViewById(R.id.bmiResult);
        BMICategory = findViewById(R.id.bmiCategory);
    }

    public void Calculate(View view){
        double weight = 0;
        int height = 0;

        try {
            weight = Double.parseDouble(weightInput.getText().toString());
            height = Integer.parseInt(heightInput.getText().toString());
        }catch (Exception ex){
            Toast.makeText(this,"Wrong input: Error> " + ex, Toast.LENGTH_LONG).show();
        }

        CalculateBMI calculateBMI = new CalculateBMI(weight, height);
        HashMap<Double, String> result = calculateBMI.BMIResult();

        for(Map.Entry<Double, String> entry : result.entrySet()){
            BMIResult.setText(String.format("Your BMI is: %.2f", entry.getKey()));
            BMICategory.setText(String.format("Your Category is: " + entry.getValue()));
        }

        Toast.makeText(this,"Successfully calculated", Toast.LENGTH_LONG).show();
    }
}