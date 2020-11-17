package com.test.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.yaml.snakeyaml.Yaml;
import com.test.selenium.LaunchWebDriver;
import com.test.testdata.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public WebDriver driver;
    public WebDriverWait wait;
    public LaunchWebDriver launchWebDriver;

    public String headless;
    public String targetUrl;
    public String ID;
    public String PW;
    public String keyword;

    @BeforeSuite
    public void beforeSuite() throws FileNotFoundException {
        //test data 읽어오기
        InputStream input = new FileInputStream( new File("src/test/resources/data.yml"));
        Yaml yaml = new Yaml();
        TestData data = yaml.loadAs(input, TestData.class);

        headless = data.getHeadless();
        targetUrl = data.getTargetUrl();
        ID = data.getId();
        PW = data.getPw();
        keyword = data.getSearchKeyword();

        logger.debug("headleass : {}", headless);
        logger.debug("targetUrl : {}", targetUrl);
        logger.debug("keyword : {}", keyword);
    }

    @BeforeClass
    public void setUp(){
        launchWebDriver = new LaunchWebDriver(driver);
        driver = launchWebDriver.launchWebDriverMode(headless);

        //드라이버 로딩이 되지 않으면 테스트 강제 종료를 위한 assert
        if(driver == null){
            Assert.assertTrue(false);
        }
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }
}
