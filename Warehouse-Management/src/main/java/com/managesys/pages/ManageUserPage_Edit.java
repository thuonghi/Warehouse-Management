package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.managesys.testcases.ManageUserPage_Edit.excel;

public class ManageUserPage_Edit {
    private WebDriver driver;
    private ValidataHelper validataHelper;

    public ManageUserPage_Edit(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }

    private By editUserTitle = By.xpath("//p[@class='text-child-page']");
    private By iconTooltip = By.xpath("//form[1]/div[1]/div[1]/div[2]/div[3]/p[1]/img[1]");

    private By nameInput = By.xpath("//input[@name='username']");
    private By phoneInput = By.xpath("//input[@name='phone_number']");
    private By statusActive = By.xpath("//input[@value='active']");
    private By statusUnactive = By.xpath("//input[@value='deactive']");

    private By roomSelect = By.xpath("//select[@name='department_id']");
    private By roleSelect = By.xpath("//select[@name='role_id']");
    private By workAreaSelect = By.xpath("//select[@name='workarea_id']");
    private By codeUserInput = By.xpath("//input[@name='code_user']");


    private By saveBtn = By.xpath("//div[@class='display-but']//button[@type='button']");
    private By popupTitle = By.cssSelector("div[id='myModal'] h4[class='modal-title']");
    private By popupText = By.xpath("//div[@id='myModal']//div[2]");
    private By addBtn = By.xpath("//button[@form='add_user']");
    private By editUserBtn = By.xpath("//div[2]/div[1]/div[1]/div[3]/button[2]");


    private String url = "/user/modify/2";
    private String nameInfo = "Lucy";
    private String phoneInfo = "986367902";
    private String codeUserInfo = "973873";

    private String popupHeader = "Xác nhận";
    private String Url = "/user";

    public void editUserSuccess() throws Exception {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not add new user page");
//      Assert.assertTrue(validataHelper.verifyTitle(editUserTitle, editUserHeader), "Not add new user page");
        validataHelper.hoverElement(iconTooltip);

        validataHelper.hoverElement(nameInput);
        validataHelper.clickElement(nameInput);
        validataHelper.clearElement(nameInput);
        validataHelper.setText(nameInput, excel.getCellData("name", 1));


        validataHelper.clickElement(phoneInput);
        validataHelper.clearElement(phoneInput);
        validataHelper.setText(phoneInput, excel.getCellData("phone", 1));

        validataHelper.handleCheckbox(statusActive);
        validataHelper.handleCheckbox(statusUnactive);

        validataHelper.selectOptions(roomSelect, "4", "Dịch vụ", 24);
        validataHelper.selectOptions(roleSelect, "4", "Nhân viên nhập hàng", 7);
        validataHelper.selectOptions(workAreaSelect, "4", "0048", 45);


        validataHelper.clickElement(codeUserInput);
        validataHelper.clearElement(codeUserInput);
        validataHelper.setText(codeUserInput, excel.getCellData("user code", 1));

        validataHelper.clickElement(saveBtn);


        //Popup Handle
//      Assert.assertTrue(validataHelper.verifyTitle(popupHeader, popupTitle), "Not display pop up confirm");
        validataHelper.clickElement(editUserBtn);
        validataHelper.waitForPageLoaded();
        Assert.assertTrue(validataHelper.verifyUrl(Url), "Have not move to manage user page");
    }

    public void editUserFail() throws Exception {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not add new user page");
//      Assert.assertTrue(validataHelper.verifyTitle(editUserTitle, editUserHeader), "Not add new user page");
        for(int i = 1; i < 9; i++) {
            validataHelper.hoverElement(iconTooltip);

            validataHelper.hoverElement(nameInput);
            validataHelper.clickElement(nameInput);
            validataHelper.clearElement(nameInput);
            validataHelper.setText(nameInput, excel.getCellData("name", i));


            validataHelper.clickElement(phoneInput);
            validataHelper.clearElement(phoneInput);
            validataHelper.setText(phoneInput, excel.getCellData("phone", i));

            validataHelper.handleCheckbox(statusActive);
            validataHelper.handleCheckbox(statusUnactive);

            validataHelper.selectOptions(roomSelect, "4", "Dịch vụ", 24);
            validataHelper.selectOptions(roleSelect, "4", "Nhân viên nhập hàng", 7);
            validataHelper.selectOptions(workAreaSelect, "4", "0048", 45);


            validataHelper.clickElement(codeUserInput);
            validataHelper.clearElement(codeUserInput);
            validataHelper.setText(codeUserInput, excel.getCellData("user code", i));

            validataHelper.clickElement(saveBtn);
        }
    }

}
