package com.pages.login;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import com.example.myloginapp.R;
import com.pages.ExamplePageObject;

public class ExampleLoginPage extends ExamplePageObject {

    public ExampleLoginPage enterUsername(String value) {
        espressoDriver.sendKeys(withId(R.id.username), value);
        return this;
    }

    public ExampleLoginPage enterPassword(String value) {
        espressoDriver.sendKeys(withId(R.id.password), value);
        return this;
    }

    public <T extends ExamplePageObject> T clickLoginButton(T page) {
        espressoDriver.click(withId(R.id.loginbtn));
        return page;
    }

    public void checkIsDisplayedLoginPage() {
        espressoDriver.viewIsDisplayed(withId(R.id.username));
        espressoDriver.viewIsDisplayed(withId(R.id.password));
        espressoDriver.viewIsDisplayed(withId(R.id.loginbtn));
    }

    public ViewInteraction getWarningMessage() {
        return onView(withId(R.id.warningMessage));
    }
}
