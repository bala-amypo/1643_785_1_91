package com.example.demo.listener;

import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

public class TestResultListener implements TestExecutionListener {

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        System.out.println("Test plan started");
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        System.out.println("Test plan finished");
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        System.out.println("Started: " + testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, org.junit.platform.engine.TestExecutionResult testExecutionResult) {
        System.out.println("Finished: " + testIdentifier.getDisplayName() + " - " + testExecutionResult.getStatus());
    }
}