package com.managesys.base;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import java.time.Duration;

public class ValidataHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    JavascriptExecutor js;

    public ValidataHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    //VerifyURL
    public boolean verifyUrl(String element){
        return driver.getCurrentUrl().contains(element);
    }

    //VerifyTitle
    public boolean verifyTitle(By element, String value) {
        return driver.findElement(element).getText().equals(value);
    }

    //VerifyTitle-Contains
    public boolean verifyByContain(By element, String value) {
        return driver.findElement(element).getText().contains(value);
    }
    //SendKeys
    public void setText(By element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }

    //Click element
    public void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    //Move to element
    public void hoverElement(By element){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).perform();
    }

    //Clear Element
    public void clearElement(By element){
        driver.findElement(element).clear();
    }

    //Alert
    public void alertAccept(){
       Alert alert = driver.switchTo().alert();
       alert.accept();
    }
    public void alertDismiss(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public boolean alertGetText(String value){
        Alert alert = driver.switchTo().alert();
        return alert.getText().equals(value);
    }

    //sendKeys & enter
    public void actionSendKeys(By element, String value){
        actions = new Actions(driver);
        actions.sendKeys(driver.findElement(element), value).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    //select dropdown tĩnh
    public void selectOptions(By element, String value, String input, int totalOption){
        Select select = new Select(driver.findElement(element));
        select.selectByValue(value);
        Assert.assertFalse(select.isMultiple());
        Assert.assertEquals(totalOption, select.getOptions().size());
//        Assert.assertEquals(input, select.getFirstSelectedOption().getText());
    }

    //radio handle
    public void handleCheckbox(By element){
        driver.findElement(element).isEnabled();
        driver.findElement(element).isSelected();
        driver.findElement(element).click();

    }

    //Wait for page load
    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Assert.fail("Quá thời gian load trang.");
        }

    }


}
