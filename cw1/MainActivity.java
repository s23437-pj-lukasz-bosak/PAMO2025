package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput;
    private EditText heightInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Pobranie wartości z pól tekstowych
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();


        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100;


            float bmi = weight / (height * height);


            String bmiCategory;
            if (bmi < 18.5) {
                bmiCategory = "Niedowaga";
            } else if (bmi <= 24.9) {
                bmiCategory = "Optimum";
            } else if (bmi <= 29.9) {
                bmiCategory = "Nadwaga";
            } else {
                bmiCategory = "Otyłość";
            }


            String result = String.format("Wynik BMI: %.2f - %s", bmi, bmiCategory);
            resultText.setText(result);
        } else {

            resultText.setText("Wprowadź wagę i wzrost.");
        }
    }
}