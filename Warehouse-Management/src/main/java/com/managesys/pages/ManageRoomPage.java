package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManageRoomPage {
    private WebDriver driver;
    private ValidataHelper validataHelper;
    public ManageRoomPage(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }

    private String url ="/department";
    private By editBtn = By.xpath("//tbody[1]/tr[2]/td[5]/a[1]");
    private By viewBtn = By.xpath("//tbody[1]/tr[2]/td[6]/a[1]");
    private By deleteBtn = By.xpath("//tbody[1]/tr[2]/td[7]/a[1]");
    private String alertText = "Ban có muốn xóa phòng ban này";
    private By addbtn = By.xpath("//div[2]/a[1]/button[1]");
    private By searchInput =  By.xpath("//input[@name='query']");
    private String searchText = "QA";


    //when click edit button
    public ManageRoomPage_Edit editRoom() {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Room Page");
        validataHelper.clickElement(editBtn);
        validataHelper.waitForPageLoaded();
        return new ManageRoomPage_Edit(driver);
    }

    //when click view button
    public ManageRoomPage_View viewRoom(){
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Room Page");
        validataHelper.clickElement(viewBtn);
        validataHelper.waitForPageLoaded();
        return new ManageRoomPage_View(driver);
    }

    //when click delete button
    public void deleteRoom(){
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Room Page");
        validataHelper.clickElement(deleteBtn);
//      Assert.assertTrue(validataHelper.alertGetText(alertText), "Not display alert");
        validataHelper.alertAccept();
    }

    //when click add new button
    public ManageRoomPage_Add addNewRoom(){
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Room Page");
        validataHelper.clickElement(addbtn);
        validataHelper.waitForPageLoaded();
        return new ManageRoomPage_Add(driver);
    }

    //when find records
    public ManageRoomPage_Search findFunction(){
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Room Page");
        return new ManageRoomPage_Search(driver);
    }
}
