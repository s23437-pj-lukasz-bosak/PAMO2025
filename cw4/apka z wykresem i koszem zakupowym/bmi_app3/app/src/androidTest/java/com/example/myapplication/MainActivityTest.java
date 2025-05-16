package com.example.myapplication;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Test UI Espresso – sprawdza działanie przycisku obliczającego BMI.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testCalculateBMI() {
        // Wpisz wagę 70
        onView(withId(R.id.weightInput)).perform(replaceText("70"));

        // Wpisz wzrost 175
        onView(withId(R.id.heightInput)).perform(replaceText("175"));

        // Kliknij przycisk
        onView(withId(R.id.calculateButton)).perform(click());

        // Sprawdź, czy wynik zawiera słowo "Optimum"
        onView(withId(R.id.resultText)).check(matches(withText(containsString("Optimum"))));
    }
}
