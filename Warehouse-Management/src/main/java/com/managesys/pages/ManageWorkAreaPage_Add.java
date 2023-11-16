package com.managesys.pages;

import com.managesys.base.ExcelUtils;
import com.managesys.base.ValidataHelper;
import com.managesys.testcases.ManageUserPage_Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.managesys.testcases.ManageWorkAreaPage_Add.excel;

public class ManageWorkAreaPage_Add {
    private WebDriver driver;
    private ValidataHelper validataHelper;
    private ManageUserPage_Add manageUserPage_add;

    public ManageWorkAreaPage_Add(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
//        excel = new ExcelUtils();

    }
    private By addNewTitle = By.xpath("//p[@class='text-child-page']");
    private By iconTooltip = By.xpath("//body[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[3]/p[1]/img[1]");

    private By kvCode = By.xpath("//input[@name='work_areas_code']");
    private By kvName= By.xpath("//input[@name='name']");
    private By saveBtn = By.xpath("//div[@class='display-but']//button[@type='button']");
    private By popupTitle = By.cssSelector("div[id='myModal'] h4[class='modal-title']");
    private By popupText = By.xpath("//div[@id='myModal']//div[2]");
    private By addBtn = By.xpath("//div[2]/div[2]/div[1]/div[1]/div[3]/button[2]");

    private String url = "/work-space-management/add";
    private String addNewHeader = "Thêm mới khu vực làm việc";
    private String popupHeader = "Xác nhận";
    private String popupContent = "Bạn có thực sự muốn thêm khu vực này";
    private String Url = "/work-space-management";

    public void addNewAreaWorkFail() throws Exception {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not add new work area page");
//      Assert.assertTrue(validataHelper.verifyTitle(addNewTitle, addNewHeader), "Not add new work area page");
        for(int i = 1; i < 3; i++) {
            validataHelper.hoverElement(iconTooltip);
            validataHelper.hoverElement(kvCode);

            validataHelper.clickElement(kvCode);
            validataHelper.clearElement(kvCode);
            validataHelper.setText(kvCode, excel.getCellData("code work area", i));

            validataHelper.hoverElement(kvName);
            validataHelper.clickElement(kvName);
            validataHelper.clearElement(kvName);
            validataHelper.setText(kvName, excel.getCellData("name work area", i));
            validataHelper.clickElement(saveBtn);
        }
            //Popup Handle
//        Assert.assertTrue(validataHelper.verifyTitle(popupTitle, popupHeader), "Not display pop up confirm");
//        Assert.assertTrue(validataHelper.verifyTitle(popupText, popupContent), "Not display pop up confirm");
             validataHelper.clickElement(addBtn);
             Assert.assertTrue(validataHelper.verifyUrl(Url), "Have not move to manage work area page");
        }

    public void addNewAreaWorkSuccess() throws Exception {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not add new work area page");
//      Assert.assertTrue(validataHelper.verifyTitle(addNewTitle, addNewHeader), "Not add new work area page");
            validataHelper.hoverElement(iconTooltip);
            validataHelper.hoverElement(kvCode);

            validataHelper.clickElement(kvCode);
            validataHelper.clearElement(kvCode);
            validataHelper.setText(kvCode, excel.getCellData("code work area", 1));

            validataHelper.hoverElement(kvName);
            validataHelper.clickElement(kvName);
            validataHelper.clearElement(kvName);
            validataHelper.setText(kvName, excel.getCellData("name work area", 1));
            validataHelper.clickElement(saveBtn);
        //Popup Handle
//        Assert.assertTrue(validataHelper.verifyTitle(popupTitle, popupHeader), "Not display pop up confirm");
//        Assert.assertTrue(validataHelper.verifyTitle(popupText, popupContent), "Not display pop up confirm");
        validataHelper.clickElement(addBtn);
        Assert.assertTrue(validataHelper.verifyUrl(Url), "Have not move to manage work area page");
    }
}
