package com.listener;

import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.Date;

public class TestListener extends RunListener {

    long startTime;
    long endTime;

    @Override
    public void testRunStarted(Description description) {
        startTime = new Date().getTime();
        System.out.println("Tests started! Number of Test case: " + description.testCount() + "\n");
    }

    @Override
    public void testRunFinished(Result result) {
        endTime = new Date().getTime();
        System.out.println("Tests finished! Number of test case: " + result.getRunCount());
        long elapsedSeconds = (endTime - startTime) / 1000;
        System.out.println("Elapsed time of tests execution: " + elapsedSeconds + " seconds");
    }

    @Override
    public void testStarted(Description description) {
        System.out.println(description.getMethodName() + " test is starting...");
    }

    @Override
    public void testFinished(Description description) {
        System.out.println(description.getMethodName() + " test is finished...\n");
    }

    @Override
    public void testFailure(Failure failure) {
        System.out.println(failure.getDescription().getMethodName() + " test FAILED!!!");
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        super.testIgnored(description);
        Ignore ignore = description.getAnnotation(Ignore.class);
        String ignoreMessage = String.format(
                "@Ignore test method '%s()': '%s'",
                description.getMethodName(), ignore.value());
        System.out.println(ignoreMessage + "\n");
    }
}
