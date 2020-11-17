package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class LaunchWebDriver {
    private static final Logger logger = LoggerFactory.getLogger(LaunchWebDriver.class);

    public WebDriver driver;

    public LaunchWebDriver(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver launchWebDriverMode(String headlessOnOff){
        Path path = Paths.get("");
        String pathStr = path.toAbsolutePath().toString();

        logger.debug("pathStr : {}", pathStr);

        //크롬 드라이버 세팅
        System.setProperty("webdriver.chrome.driver", pathStr + "//src//driver//chromedriver");

        ChromeOptions co = new ChromeOptions();
        /* 공통 ChromeOptions 값. */
        co.addArguments("start-maximized");
        co.addArguments("enable-automation");
        co.addArguments("--disable-gpu");
        co.addArguments("--no-sandbox");

        if ("On".equals(headlessOnOff)) { // On / Off
            /* headless chrome */
            co.addArguments("--headless");
        }

        driver = new ChromeDriver(co);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 기본 대기 시간
        driver.manage().window().maximize();
        return driver;

    }
}
