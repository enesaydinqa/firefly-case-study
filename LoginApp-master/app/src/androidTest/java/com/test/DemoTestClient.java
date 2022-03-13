package com.test;

import android.Manifest;
import android.os.Bundle;
import android.provider.Settings;
import android.support.test.runner.AndroidJUnitRunner;

import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;

import com.example.myloginapp.MainActivity;
import com.linkedin.android.testbutler.TestButler;
import com.pages.login.ExampleLoginPage;
import com.squareup.spoon.Spoon;
import com.util.LogAssert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public class DemoTestClient extends AndroidJUnitRunner {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    /*
    @Rule
    public GrantPermissionRule permissionsRule = GrantPermissionRule.grant(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    );
     */

    @Rule
    public TestName name = new TestName();

    public LogAssert adbLogAssert = new LogAssert();
    public ExampleLoginPage exampleLoginPage;

    @Before
    public void before() {
        exampleLoginPage = new ExampleLoginPage();
    }

    @Override
    public void onStart() {
        TestButler.setup(getTargetContext());
        TestButler.setLocationMode(Settings.Secure.LOCATION_MODE_OFF);
        TestButler.setWifiState(true);
        //Spoon.screenshot(activityRule.getActivity(), "initial"); real devices
        super.onStart();
    }

    @Override
    public void finish(int resultCode, Bundle results) {
        TestButler.teardown(getTargetContext());
        //Spoon.screenshot(activityRule.getActivity(), "after"); real devices
        super.finish(resultCode, results);
    }
}
