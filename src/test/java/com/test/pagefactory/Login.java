package com.test.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"login-email-input\"]")
    public WebElement loginId;

    @FindBy(xpath = "//*[@id=\"login-password-input\"]")
    public WebElement loginPw;

    @FindBy(className = "login__button login__button--submit _loginSubmitButton")
    public WebElement loginSubmit;

    public void loginToCoupang(String id, String pw){
        loginId.sendKeys(id);
        loginPw.sendKeys(pw);

        loginSubmit.click();
    }
}
