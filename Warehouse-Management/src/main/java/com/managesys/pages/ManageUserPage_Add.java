package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import com.managesys.testcases.ManageWorkAreaPage_Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static com.managesys.testcases.ManageUserPage_Add.excel;

public class ManageUserPage_Add {
    private WebDriver driver;
    private ValidataHelper validataHelper;

    public ManageUserPage_Add(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }

    private By addNewTitle = By.xpath("//p[@class='text-child-page']");
    private By iconTooltip = By.xpath("//form[1]/div[1]/div[1]/div[2]/div[3]/p[1]/img[1]");

    private By nameInput = By.xpath("//input[@name='username']");
    private By emailInput = By.xpath("//input[@name='email']");
    private By phoneInput = By.xpath("//input[@name='phone_number']");
    private By roomSelect = By.xpath("//select[@name='department_id']");
    private By roleSelect = By.xpath("//select[@name='role_id']");
    private By workAreaSelect = By.xpath("//select[@name='workarea_id']");
    private By codeUserInput = By.xpath("//input[@name='code_user']");


    private By saveBtn = By.xpath("//div[@class='display-but']//button[@type='button']");
    private By popupTitle = By.cssSelector("div[id='myModal'] h4[class='modal-title']");
    private By popupText = By.xpath("//div[@id='myModal']//div[2]");
    private By addBtn = By.xpath("//button[@form='add_user']");


    private String url = "/user/add";
//    private String addNewUserHeader = "Thêm người dùng";
//    private String popupHeader = "Xác nhận";
//    private String popupContent = "Bạn có thực sự muốn thêm nguời dùng này";
    private String Url = "/user";

    public void addNewUserFail() throws Exception {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not add new user page");
//      Assert.assertTrue(validataHelper.verifyTitle(addNewTitle, addNewUserHeader), "Not add new user page");
        for (int i = 1; i < 4; i++) {
            validataHelper.hoverElement(iconTooltip);

            validataHelper.hoverElement(nameInput);
            validataHelper.clickElement(nameInput);
            validataHelper.clearElement(nameInput);
            validataHelper.setText(nameInput, excel.getCellData("name", i));

            validataHelper.clickElement(emailInput);
            validataHelper.clearElement(emailInput);
            validataHelper.setText(emailInput, excel.getCellData("email", i));

            validataHelper.clickElement(phoneInput);
            validataHelper.clearElement(phoneInput);
            validataHelper.setText(phoneInput, excel.getCellData("phone", i));

            validataHelper.selectOptions(roomSelect, "3", "Công nghệ", 24);
            validataHelper.selectOptions(roleSelect, "3", "Quản lý xuất hàng", 7);
            validataHelper.selectOptions(workAreaSelect, "3", "0084", 45);


            validataHelper.clickElement(codeUserInput);
            validataHelper.clearElement(codeUserInput);
            validataHelper.setText(codeUserInput, excel.getCellData("user code", i));
            validataHelper.clickElement(saveBtn);
        }

        //Popup Handle
//        Assert.assertTrue(validataHelper.verifyTitle(popupTitle, popupHeader), "Not display pop up confirm");
//        Assert.assertTrue(validataHelper.verifyTitle(popupText, popupContent), "Not display pop up confirm");
        validataHelper.clickElement(addBtn);
        Assert.assertTrue(validataHelper.verifyUrl(Url), "Have not move to manage user page");
    }

    public void addNewUserSucess() throws Exception {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not add new user page");
//      Assert.assertTrue(validataHelper.verifyTitle(addNewTitle, addNewUserHeader), "Not add new user page");
        validataHelper.hoverElement(iconTooltip);

        validataHelper.hoverElement(nameInput);
        validataHelper.clickElement(nameInput);
        validataHelper.clearElement(nameInput);
        validataHelper.setText(nameInput, excel.getCellData("name", 2));

        validataHelper.clickElement(emailInput);
        validataHelper.clearElement(emailInput);
        validataHelper.setText(emailInput, excel.getCellData("email", 2));

        validataHelper.clickElement(phoneInput);
        validataHelper.clearElement(phoneInput);
        validataHelper.setText(phoneInput, excel.getCellData("phone", 2));

        validataHelper.selectOptions(roomSelect, "3", "Công nghệ", 24);
        validataHelper.selectOptions(roleSelect, "3", "Quản lý xuất hàng", 7);
        validataHelper.selectOptions(workAreaSelect, "3", "0084", 45);


        validataHelper.clickElement(codeUserInput);
        validataHelper.clearElement(codeUserInput);
        validataHelper.setText(codeUserInput, excel.getCellData("user code", 2));
        validataHelper.clickElement(saveBtn);

    //Popup Handle
//        Assert.assertTrue(validataHelper.verifyTitle(popupTitle, popupHeader), "Not display pop up confirm");
//        Assert.assertTrue(validataHelper.verifyTitle(popupText, popupContent), "Not display pop up confirm");
        validataHelper.clickElement(addBtn);
        Assert.assertTrue(validataHelper.verifyUrl(Url), "Have not move to manage user page");
    }

}
