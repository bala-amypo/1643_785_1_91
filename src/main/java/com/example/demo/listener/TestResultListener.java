package com.example.demo.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.springframework.stereotype.Component;

@Component
public class TestResultListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // Test suite started
    }

    @Override
    public void onFinish(ITestContext context) {
        // Test suite finished
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Test started
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Test passed
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Test failed
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Test skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Partial success
    }
}