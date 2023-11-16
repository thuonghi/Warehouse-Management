package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManageRoomPage_View {
    private WebDriver driver;
    private ValidataHelper validataHelper;
    public ManageRoomPage_View(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }
    private By viewRoomDetail = By.xpath("//p[@class='text-child-page']");

    private String viewRoomTitle = "Chi tiết phòng ban";
    private String viewRoomUrl = "/department/detail/2";
    private String roomData = "Nhân sự";
    private String personelData = "42";

    private By roomInfo = By.xpath("//div[2]/div[2]/label[1]");
    private By personelInfo = By.xpath("//div[2]/div[2]/label[1]");

    private By editBtn = By.xpath("//div[3]/div[2]/a[1]/button[1]");


    public ManageRoomPage_Edit checkViewRoomPage(){
        Assert.assertTrue(validataHelper.verifyUrl(viewRoomUrl), "Not view work area page");
//       Assert.assertTrue(validataHelper.verifyTitle(viewWorkArea, viewAreaTitle), "Not view work area page");
        Assert.assertTrue(validataHelper.verifyTitle(roomInfo,roomData), "Wrong room information");
        Assert.assertTrue(validataHelper.verifyTitle(personelInfo,personelData), "Wrong personel information");
        validataHelper.clickElement(editBtn);
        validataHelper.waitForPageLoaded();
        return new ManageRoomPage_Edit(driver);
    }
}
