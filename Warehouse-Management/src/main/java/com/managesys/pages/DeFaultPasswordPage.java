package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeFaultPasswordPage {
    private WebDriver driver;
    private ValidataHelper validataHelper;

    public DeFaultPasswordPage(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }
    private By passwordPageHeader = By.xpath("//p[@class='text-child-page']");
    private By newPassword = By.xpath("//input[@name='new-password-default']");
    private By confirmNewPassword = By.xpath("//input[@name='new-password-default-confirm']");
    private By defaultPass = By.xpath("//label[contains(text(),'Abc@1234')]");

    private By returnBtn = By.xpath("//div[1]/div[7]/div[1]/a[1]");
    private By editButton = By.xpath("//div[1]/div[7]/div[2]/button[1]");

    private By popupTitle = By.cssSelector("//div[2]/div[1]/div[1]/div[1]/h4[1]");
    private By popupText = By.xpath("//div[2]/div[1]/div[1]/div[2]");

    private By cancelBtn = By.xpath("//div[1]/div[1]/div[3]/button[1]");
    private By editBtn = By.xpath("//button[@form='update']");

    private String url = "/default-password";
    private String passwordPageTitle = "Chỉnh sửa mật khẩu mặc định";
    private String popupHeader = "Xác nhận";
    private String popupContent = "Bạn có muốn thay đổi mật khẩu mặc định mới";

    public void changePassword() {
        validataHelper.verifyUrl(url);
        validataHelper.verifyTitle(passwordPageHeader, passwordPageTitle);
        System.out.println("Mat khau mac dinh" + driver.findElement(defaultPass).getText());
        validataHelper.setText(newPassword, "Abc@hihi");
        validataHelper.setText(confirmNewPassword, "Abc@hihi");
        validataHelper.clickElement(editButton);

        //popupHandl
//        Assert.assertTrue(validataHelper.verifyTitle(popupTitle, popupHeader), "Not display pop up confirm");
//        Assert.assertTrue(validataHelper.verifyTitle(popupText, popupContent), "Not display pop up confirm");
        validataHelper.clickElement(cancelBtn);

    }
}
