package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManageWorkAreaPage_View {
    private WebDriver driver;
    private ValidataHelper validataHelper;
    public ManageWorkAreaPage_View(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }
    private By viewWorkArea = By.xpath("//p[@class='text-child-page']");

    private String viewAreaTitle = "Xem Chi Tiết Khu Vực Làm Việc";
    private String viewAreaUrl = "/work-space-management/detail/1";
    private String kvlvCode = "KV001";
    private String kvlvName = "KVLV18";
    private String personel = "63";

    private By code = By.xpath("//label[contains(text(),'KV001')]");
    private By name = By.xpath("//label[contains(text(),'KVLV18')]");
    private By person = By.xpath("//div[2]/div[3]/div[2]/label[1]");

    private By editBtn = By.xpath("//div[3]/div[2]/a[1]/button[1]");


    public ManageWorkAreaPage_Edit checkViewAreaPage(){
        Assert.assertTrue(validataHelper.verifyUrl(viewAreaUrl), "Not view work area page");
//       Assert.assertTrue(validataHelper.verifyTitle(viewWorkArea, viewAreaTitle), "Not view work area page");
        Assert.assertTrue(validataHelper.verifyTitle(code,kvlvCode), "Wrong code");
        Assert.assertTrue(validataHelper.verifyTitle(name,kvlvName), "Wrong name");
        Assert.assertTrue(validataHelper.verifyByContain(person,personel), "Wrong personel");
        validataHelper.clickElement(editBtn);
        validataHelper.waitForPageLoaded();
        return new ManageWorkAreaPage_Edit(driver);
    }
}
