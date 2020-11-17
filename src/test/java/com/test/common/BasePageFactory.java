package com.test.common;

import org.openqa.selenium.WebElement;

public class BasePageFactory {

    public void click(WebElement element){
        element.click();
    }

    public void sendKey(WebElement element, String inputText){
        element.sendKeys(inputText);
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }
}
