package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class SignInPage {

    private WebDriver driver;
    private ValidataHelper validataHelper;

    private By titleLogin = By.xpath("//div[1]/form[1]/div[1]/h4[1]");
    private By loginText = By.xpath("//div[1]/div[1]/form[1]/div[1]/p[1]");
    private By emailInput = By.xpath("//div[1]/form[1]/div[1]/div[1]/div[1]/input[1]");
    private By passwordInput = By.id("password");
    private By signinBtn = By.xpath("//div[1]/form[1]/div[1]/div[3]/button[1]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }


    public void enterEmail(String email) {
        WebElement emailTxtBox = driver.findElement(emailInput);
        if (emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordTxtBox = driver.findElement(passwordInput);
        if (passwordTxtBox.isDisplayed())
            passwordTxtBox.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement signin = driver.findElement(signinBtn);
        if (signin.isDisplayed()) {
            signin.click();
        }
    }

    public ManageUserPage signIn(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
        validataHelper.waitForPageLoaded();
        return new ManageUserPage(driver);
    }

}




