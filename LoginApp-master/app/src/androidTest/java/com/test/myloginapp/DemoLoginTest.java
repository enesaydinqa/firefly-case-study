package com.test.myloginapp;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.listener.TestRunner;
import com.pages.login.ExampleLoginPage;
import com.pages.welcome.ExampleWelcomePage;
import com.test.DemoTestClient;
import com.util.Constants;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(TestRunner.class)
public class DemoLoginTest extends DemoTestClient {

    @Test
    public void testEmailAndPasswordShouldNotBeEmpty() throws Exception {

        exampleLoginPage
                .enterUsername("")
                .enterPassword("")
                .clickLoginButton(exampleLoginPage);

        exampleLoginPage.getWarningMessage().check(matches(withText(Constants.Login.EMAIL_AND_PASSWORD_SHOULD_NOT_BE_EMPTY)));
        adbLogAssert.assertADBLogsExist("Email and password should not be empty"); // sample adb log assert
    }

    @Test
    public void testEmailFormatNotCorrect() {
        exampleLoginPage
                .enterUsername("abcde")
                .enterPassword("***")
                .clickLoginButton(exampleLoginPage);

        exampleLoginPage.getWarningMessage().check(matches(withText(Constants.Login.EMAIL_FORMAT_NOT_CORRECT)));
    }

    @Test
    public void testPasswordShouldBeMinimum5Characters() {
        exampleLoginPage
                .enterUsername("admin@fireflyon.com")
                .enterPassword("****")
                .clickLoginButton(exampleLoginPage);

        exampleLoginPage.getWarningMessage().check(matches(withText(Constants.Login.PASSWORD_SHOULD_BE_MINIMUM_5_CHARACTERS)));
    }

    @Test
    public void testSuccessLogin() {
        ExampleWelcomePage exampleWelcomePage = exampleLoginPage
                .enterUsername("admin@fireflyon.com")
                .enterPassword("admin")
                .clickLoginButton(new ExampleWelcomePage());

        exampleWelcomePage.getWelcomeText().check(matches(withText(Constants.Login.SUCCESS_WELCOME_MESSAGE.replace("{USERNAME}", "Admin"))));
    }

    @Test
    public void testLogout() {
        ExampleWelcomePage exampleWelcomePage = exampleLoginPage
                .enterUsername("admin@fireflyon.com")
                .enterPassword("admin")
                .clickLoginButton(new ExampleWelcomePage());

        ExampleLoginPage exampleLoginPage = exampleWelcomePage.clickLogoutButton();
        exampleLoginPage.checkIsDisplayedLoginPage();
    }
}