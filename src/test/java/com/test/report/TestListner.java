package com.test.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner implements ITestListener {
    //Extent Report Declarations
    private static final Logger logger = LoggerFactory.getLogger(TestListner.class);
    private static ExtentReports extent = ExtentReportManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onStart(ITestContext context) {
        logger.debug("Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        logger.debug("Test Suite is finished!");
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        logger.debug(result.getMethod().getMethodName() + " started!");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        extentTest.assignCategory(result.getTestClass().getRealClass().getSimpleName());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        logger.debug(result.getMethod().getMethodName() + " passed!");
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        logger.debug(result.getMethod().getMethodName() + " failed!");
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        logger.debug(result.getMethod().getMethodName() + " skipped!");
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.debug("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName());
    }
}
