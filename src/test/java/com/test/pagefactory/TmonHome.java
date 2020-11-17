package com.test.pagefactory;

import com.test.common.BasePageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TmonHome extends BasePageFactory {
    public TmonHome(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header2\"]/div/div[2]/div[1]/ul/li[1]/a")
    public WebElement login;

    @FindBy(xpath = "//*[@id=\"userid\"]")
    public WebElement loginId;

    @FindBy(xpath = "//*[@id=\"pwd\"]")
    public WebElement loginPw;

    @FindBy(className = "btn_login")
    public WebElement loginSubmit;

    @FindBy(className = "logout")
    public WebElement logout;

    //layer time box
//    @FindBy(className = "_closeTimeAlert button button_line")
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/button" )
    public WebElement time_box_close;

    @FindBy(xpath = "//*[@id=\"top_srch\"]")
    public WebElement topSearch;

    public void clickLogin(){
        login.click();
    }

    public void loginToCoupang(String id, String pw){
        loginId.sendKeys(id);
        loginPw.sendKeys(pw);

        loginSubmit.click();
    }

    public void closeTimeBox(){
        time_box_close.click();
    }

    public void inputSearchKeyword(String keyword){
        topSearch.sendKeys(keyword);
        topSearch.sendKeys(Keys.ENTER);
    }
}
