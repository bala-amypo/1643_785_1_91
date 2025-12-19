package com.example.demo.listener;

import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.util.Optional;

public class TestResultListener implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("PASSED: " + context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("FAILED: " + context.getDisplayName() + " - " + cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("DISABLED: " + context.getDisplayName() + " - " + reason.orElse("No reason"));
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("ABORTED: " + context.getDisplayName() + " - " + cause.getMessage());
    }
}