package com.pages.welcome;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import com.example.myloginapp.R;
import com.pages.ExamplePageObject;
import com.pages.login.ExampleLoginPage;

public class ExampleWelcomePage extends ExamplePageObject {

    public ViewInteraction getWelcomeText() {
        return onView(withId(R.id.welcomeText));
    }

    public void checkWelcomeText(String value) {
        onView(withId(R.id.welcomeText)).check(matches(hasValueEqualTo(value)));
    }

    public ExampleLoginPage clickLogoutButton() {
        espressoDriver.click(withId(R.id.logout));
        return new ExampleLoginPage();
    }
}
