package com.example.myapplication;

import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Aktywność wyświetlająca rekomendacje kulinarne na podstawie dziennego zapotrzebowania kalorycznego użytkownika.
 * Pokazuje dwa przepisy: dla diety wysokobiałkowej oraz dla diety wegetariańskiej.
 */
public class RecipeRecommendationActivity extends AppCompatActivity {

    /** Nagłówek ekranu rekomendacji. */
    private TextView recommendationTitle;

    /** Tekst wyświetlający pierwszy przepis — dieta wysokobiałkowa. */
    private TextView recipe1;

    /** Tekst wyświetlający drugi przepis — dieta wegetariańska. */
    private TextView recipe2;

    private Button backButton;

    /**
     * Metoda wywoływana przy tworzeniu aktywności.
     * Inicjalizuje widoki i ustawia rekomendacje przepisów na podstawie przekazanych danych.
     *
     * @param savedInstanceState zapisany stan aktywności (jeśli istnieje, np. przywracanie po obrocie ekranu)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_recommendation);

        // Inicjalizacja widoków
        recommendationTitle = findViewById(R.id.recommendationTitle);
        recipe1 = findViewById(R.id.recipe1);
        recipe2 = findViewById(R.id.recipe2);

        // Pobieramy przekazaną wartość kalorii (opcjonalnie), domyślnie 2000 kcal
        int dailyCalories = getIntent().getIntExtra("dailyCalories", 2000);

        // Ustawiamy teksty przepisów na podstawie danych z resources/strings.xml
        recipe1.setText(getString(R.string.high_protein_diet_recipe));
        recipe2.setText(getString(R.string.vegetarian_diet_recipe));
        //obsluga buttona wstecz
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }
}
