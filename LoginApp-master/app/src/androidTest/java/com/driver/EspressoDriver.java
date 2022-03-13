package com.driver;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import android.view.View;

import androidx.test.espresso.action.ViewActions;

import org.hamcrest.Matcher;

public class EspressoDriver {

    public void click(Matcher<View> element) {
        onView(element).perform(ViewActions.click());
    }

    public void sendKeys(Matcher<View> element, String value) {
        onView(element).perform(replaceText(value));
    }

    public void viewIsDisplayed(Matcher<View> element) {
        onView(element).check(matches(isDisplayed()));
    }
}
