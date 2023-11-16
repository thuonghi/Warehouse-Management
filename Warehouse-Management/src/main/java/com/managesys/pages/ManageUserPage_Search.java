package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ManageUserPage_Search {
    private WebDriver driver;
    private ValidataHelper validataHelper;

    public ManageUserPage_Search(WebDriver driver){
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }

    private By searchInput = By.xpath("//input[@type='text']");
    private String valueSearch = "Mie";
    private By valueTable = By.xpath("//table//tbody/tr/td[2]");

    public void CheckSearchByValue() {
        validataHelper.actionSendKeys(searchInput, valueSearch);
    }
    public void checkSearchTableByColumn(int column, String value){
        List<WebElement> row = driver.findElements(valueTable);
        int rowTotal = row.size();
        System.out.println("So dong duoc tim thay la " + rowTotal);
        for (int i = 1; i < rowTotal; i++) {
            WebElement elementCheck = driver.findElement(By.xpath("//table//tbody/tr["+ i + "]/td["+ column +"]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true)", elementCheck);
            Assert.assertTrue(elementCheck.getText().contains(value), "Not contain " + value);
        }
    }
}
