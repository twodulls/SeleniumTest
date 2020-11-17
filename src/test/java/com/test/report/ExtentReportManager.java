package com.test.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent == null) createInstance();
        return extent;
    }

    //create an extent report instance
    public static ExtentReports createInstance(){
        Path path = Paths.get("");
        String pathStr = path.toAbsolutePath().toString();

        String reportFile = new File(pathStr + "//target//result.html").getAbsolutePath();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFile);
        htmlReporter.setAppendExisting(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFile);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setReportName(reportFile);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "Real");
        return extent;
    }
}
