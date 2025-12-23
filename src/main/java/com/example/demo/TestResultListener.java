package com.example.demo;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestResultListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED: " + result.getName() + " - " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test SKIPPED: " + result.getName());
    }
}
