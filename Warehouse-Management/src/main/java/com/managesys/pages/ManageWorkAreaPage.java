package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.Alert;

public class ManageWorkAreaPage {
    private WebDriver driver;
    private ValidataHelper validataHelper;


    public ManageWorkAreaPage(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }

    private String url ="/work-space-management";
    private By editBtn = By.xpath("//tbody/tr[2]/td[6]/a[1]");
    private By viewBtn = By.xpath("//tbody/tr[1]/td[7]/a[1]");
    private By deleteBtn = By.xpath("//tbody/tr[1]/td[8]/a[1]");
    private String alertText = "Ban có muốn xóa phòng ban này";
    private By addbtn = By.xpath("//div[1]/div[2]/a[1]/button[1]");
    private By searchInput =  By.xpath("//input[@name='query']");
    private String searchText = "KV1020";


    //when click edit button
    public ManageWorkAreaPage_Edit editWorkArea() {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Area Page");
        validataHelper.clickElement(editBtn);
        validataHelper.waitForPageLoaded();
        return new ManageWorkAreaPage_Edit(driver);
    }

    //when click view button
    public ManageWorkAreaPage_View viewWorkArea(){
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Area Page");
        validataHelper.clickElement(viewBtn);
        validataHelper.waitForPageLoaded();
        return new ManageWorkAreaPage_View(driver);
    }

    //when click delete button
    public void deleteWorkArea(){
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Area Page");
        validataHelper.clickElement(deleteBtn);
//      Assert.assertTrue(validataHelper.alertGetText(alertText), "Not display alert");
        validataHelper.alertAccept();
    }

    //when click add new button
    public ManageWorkAreaPage_Add addNewArea(){
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Area Page");
        validataHelper.clickElement(addbtn);
        validataHelper.waitForPageLoaded();
        return new ManageWorkAreaPage_Add(driver);
    }

    //when find records
    public ManageWorkAreaPage_Search findFunction(){
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Area Page");
        validataHelper.actionSendKeys(searchInput, searchText);
        return new ManageWorkAreaPage_Search(driver);
    }

}
