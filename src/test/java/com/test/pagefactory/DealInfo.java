package com.test.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealInfo {
    public DealInfo(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"view-default-scene-default\"]/section[1]/div[3]/article[1]/div[2]/h2")
    public WebElement title;

    public String getText(WebElement webElement){
        return webElement.getText();
    }

    public void click(WebElement webElement){
        webElement.click();
    }
}
