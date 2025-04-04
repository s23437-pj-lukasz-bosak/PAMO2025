package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Główna aktywność aplikacji BMI.
 * Pozwala użytkownikowi obliczyć swoje BMI oraz przejść do kalkulatora kalorii.
 */
public class MainActivity extends AppCompatActivity {

    /** Pole do wprowadzenia wagi użytkownika. */
    private EditText weightInput;

    /** Pole do wprowadzenia wzrostu użytkownika. */
    private EditText heightInput;

    /** Przycisk do obliczenia BMI. */
    private Button calculateButton;

    /** Przycisk do przejścia do kalkulatora kalorii. */
    private Button openCalorieCalculator;

    /** Pole tekstowe do wyświetlenia wyniku BMI. */
    private TextView resultText;

    /**
     * Metoda uruchamiana przy tworzeniu aktywności.
     * Inicjalizuje widoki i ustawia nasłuchiwacze przycisków.
     *
     * @param savedInstanceState zapisany stan aktywności (jeśli istnieje)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja pól widoku
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        // Obsługa przycisku do przejścia do kalkulatora kalorii
        openCalorieCalculator = findViewById(R.id.openCalorieCalculator);
        openCalorieCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tworzymy intent do przejścia do CalorieCalculatorActivity
                Intent intent = new Intent(MainActivity.this, CalorieCalculatorActivity.class);
                startActivity(intent);
            }
        });

        // Obsługa przycisku do obliczenia BMI
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    /**
     * Metoda obliczająca BMI na podstawie danych użytkownika.
     * Wyświetla wynik BMI oraz kategorię wagową.
     */
    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100; // zamiana wzrostu na metry

            float bmi = weight / (height * height);

            String bmiCategory;
            if (bmi < 18.5) {
                bmiCategory = getString(R.string.underweight);
            } else if (bmi <= 24.9) {
                bmiCategory = getString(R.string.normal);
            } else if (bmi <= 29.9) {
                bmiCategory = getString(R.string.overweight);
            } else {
                bmiCategory = getString(R.string.obesity);
            }

            // Formatowanie wyniku i wyświetlenie
            String result = String.format(getString(R.string.result_bmi) + "%.2f - %s", bmi, bmiCategory);
            resultText.setText(result);
        } else {
            // Komunikat w przypadku braku danych
            resultText.setText(R.string.enter_weight_and_height);
        }
    }
}
