package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManageUserPage_View {
    private WebDriver driver;
    private ValidataHelper validataHelper;
    public ManageUserPage_View(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }
    private By seeDetailUser = By.xpath("//p[@class='text-child-page']");

    private String seeDetailTitle = "Chi tiết người dùng";
    private String viewDetailUrl = "/user/detail/2";
    private String name = "Lucy";
    private String email = "hmann@gmail.com";
    private String phoneNumber = "986367902";
    private String room = "Dịch vụ";
    private String role = "Nhân viên nhập hàng";
    private String workArea = "KV0048";
    private String userCode = "973873";

    private By nameData = By.xpath("//label[contains(text(),'Lucy')]");
    private By emailData = By.xpath("//label[contains(text(),'hmann@gmail.com')]");
    private By phoneNumberData = By.xpath("//label[contains(text(),'986367902')]");
    private By roomData = By.xpath("//div[2]/div[1]/div[2]/label[1]");
    private By roleData = By.xpath("//div[2]/div[2]/div[2]/label[1]");
    private By workAreaData = By.xpath("//label[contains(text(),'KV0048')]");
    private By userCodeData = By.xpath("//label[contains(text(),'973873')]");


    private By cancelBtn = By.cssSelector("a[class='btn btn-outline-success']");


    public void checkSeeDetailUserPage(){
        Assert.assertTrue(validataHelper.verifyUrl(viewDetailUrl), "Not view details user page");
//       Assert.assertTrue(validataHelper.verifyTitle(seeDetailUser, seeDetailTitle), "Not view details user area page");
        Assert.assertTrue(validataHelper.verifyTitle(nameData, name), "Wrong name");
        Assert.assertTrue(validataHelper.verifyTitle(emailData, email), "Wrong email");
        Assert.assertTrue(validataHelper.verifyTitle(phoneNumberData, phoneNumber), "Wrong phone number");
        Assert.assertTrue(validataHelper.verifyTitle(workAreaData, workArea), "Wrong workArea");
        Assert.assertTrue(validataHelper.verifyTitle(userCodeData, userCode), "Wrong user code");

        validataHelper.clickElement(cancelBtn);
        validataHelper.waitForPageLoaded();
    }
}
