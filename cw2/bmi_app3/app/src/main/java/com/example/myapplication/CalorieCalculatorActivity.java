package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Aktywność kalkulatora kalorii.
 * Umożliwia użytkownikowi obliczenie dziennego zapotrzebowania kalorycznego
 * na podstawie wzoru Mifflina-St Jeora, a następnie przejście do ekranu rekomendacji przepisów.
 */
public class CalorieCalculatorActivity extends AppCompatActivity {

    /** Pole do wprowadzenia wagi użytkownika (w kilogramach). */
    private EditText weightInput;

    /** Pole do wprowadzenia wzrostu użytkownika (w centymetrach). */
    private EditText heightInput;

    /** Pole do wprowadzenia wieku użytkownika (w latach). */
    private EditText ageInput;

    /** Pole do wprowadzenia poziomu aktywności fizycznej użytkownika. */
    private EditText activityLevelInput;

    /** Przycisk do uruchomienia kalkulacji dziennego zapotrzebowania kalorycznego. */
    private Button calculateButton;

    /** Pole tekstowe do wyświetlenia wyniku kalkulacji kalorii. */
    private TextView resultText;

    /**
     * Metoda uruchamiana przy tworzeniu aktywności.
     * Inicjalizuje wszystkie widoki oraz ustawia nasłuchiwacz przycisku obliczenia kalorii.
     *
     * @param savedInstanceState zapisany stan aktywności (jeśli istnieje), chodzi o to żeby np po obrocie ekranu byl zapisany stan aplikacji, nie utracimy danych wczesniej zapisanych.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);

        // Inicjalizacja pól widoku
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        ageInput = findViewById(R.id.ageInput);
        activityLevelInput = findViewById(R.id.activityLevelInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        // Obsługa kliknięcia przycisku do obliczania kalorii
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCalories();
            }
        });
    }

    /**
     * Metoda obliczająca dzienne zapotrzebowanie kaloryczne użytkownika
     * na podstawie wzoru Mifflina-St Jeora dla mężczyzn.
     * Po obliczeniu wyniku przechodzi do ekranu rekomendacji kulinarnych,
     * przekazując opcjonalnie obliczoną wartość kalorii.
     */
    private void calculateCalories() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();
        String ageStr = ageInput.getText().toString();
        String activityLevelStr = activityLevelInput.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty() && !ageStr.isEmpty() && !activityLevelStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr);
            int age = Integer.parseInt(ageStr);
            float activityLevel = Float.parseFloat(activityLevelStr);

            // Obliczanie podstawowej przemiany materii (BMR)
            double bmr = 10 * weight + 6.25 * height - 5 * age + 5;

            // Obliczanie dziennego zapotrzebowania kalorycznego
            double dailyCalories = bmr * activityLevel;

            // Wyświetlenie wyniku na ekranie
            resultText.setText(String.format(getString(R.string.result_calories), (int) dailyCalories));

            // Po obliczeniu przechodzimy do ekranu z rekomendacjami kulinarnymi
            Intent intent = new Intent(CalorieCalculatorActivity.this, RecipeRecommendationActivity.class);
            intent.putExtra("dailyCalories", (int) dailyCalories);
            startActivity(intent);

        } else {
            // Komunikat o konieczności uzupełnienia wszystkich pól
            resultText.setText(getString(R.string.enter_all_fields));
        }
    }
}
