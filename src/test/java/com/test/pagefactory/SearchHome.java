package com.test.pagefactory;

import com.test.common.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHome extends BasePageFactory {
    public SearchHome(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"search_app\"]/div[2]/div[1]/strong/span[1]")
    public WebElement searchKeywordResult;

    @FindBy(xpath = "//*[@id=\"search_app\"]/div[2]/div[1]/strong/span[2]")
    public WebElement searchResultCount;

    @FindBy(xpath = "//*[@id=\"search_app\"]/div[2]/section/div/ul/div/div/li[1]")
    public WebElement searchResultFirstItem;

    public String getText(WebElement webElement){
        return webElement.getText();
    }

    public void click(WebElement webElement){
        webElement.click();
    }
}
