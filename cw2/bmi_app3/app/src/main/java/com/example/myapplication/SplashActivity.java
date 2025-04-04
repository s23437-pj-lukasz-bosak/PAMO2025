package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Ekran powitalny aplikacji.
 * Wyświetla logo przez określony czas, a następnie przechodzi do ekranu głównego (MainActivity).
 */
public class SplashActivity extends AppCompatActivity {

    /** Czas wyświetlania splash screena w milisekundach (2000 ms = 2 sekundy). */
    private static final int SPLASH_DISPLAY_LENGTH = 2000;

    /**
     * Metoda uruchamiana przy tworzeniu aktywności.
     * Ustawia layout splash i uruchamia opóźnione przejście do ekranu głównego.
     *
     * @param savedInstanceState zapisany stan aktywności (jeśli istnieje)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}