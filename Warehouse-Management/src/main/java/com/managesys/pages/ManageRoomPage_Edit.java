package com.managesys.pages;

import org.openqa.selenium.WebDriver;
import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.managesys.testcases.ManageRoomPage_Edit.excel;


public class ManageRoomPage_Edit {
    private WebDriver driver;
    private ValidataHelper validataHelper;

    public ManageRoomPage_Edit(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }
    private By titlePage = By.xpath("//div[@class='container-fluid']//p[@class='text']");
    private String url ="/department";
    private String pageHeader = "Quản lý phòng ban";
    private By editBtn = By.xpath("//tbody[1]/tr[2]/td[5]/a[1]");
    private By titleEditAreaPage = By.xpath("//div[@class='container-fluid']//p[@class='text-child-page']");
    private String editAreaHeader = "Chỉnh sửa phòng ban";
    private By iconTooltip = By.xpath("//div[2]/div[3]/p[1]/img[1]");
    private By roomInput = By.xpath("//input[@name='name']");
    private By saveBtn = By.xpath("//div[2]/div[2]/button[1]");
    private By popupHeader = By.xpath("//h4[@class='modal-title']");
    private String popupTitle = "Xác nhận";
    private By cancelBtn = By.xpath("//div//button[@data-bs-dismiss='modal']");
    private By editAreaBtn = By.xpath("//div//button[@form='mod_department']");



    public void roomPageSuccess() throws Exception {
        validataHelper.waitForPageLoaded();
//        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Area Page");
//      Assert.assertTrue(validataHelper.verifyTitle(titlePage,pageHeader));
//        validataHelper.clickElement(editBtn);
//        validataHelper.waitForPageLoaded();
//      Assert.assertTrue(validataHelper.verifyTitle(titleEditAreaPage, editAreaHeader), "Not edit area page");
        validataHelper.hoverElement(iconTooltip);

        //setText into Room Input
        validataHelper.hoverElement(roomInput);
        validataHelper.clickElement(roomInput);
        validataHelper.clearElement(roomInput);
        validataHelper.setText(roomInput, excel.getCellData("room name", 1));


        //click Save
        validataHelper.clickElement(saveBtn);

        //Popup Handle
//      Assert.assertTrue(validataHelper.verifyTitle(popupHeader, popupTitle), "Not display pop up confirm");
        validataHelper.clickElement(editAreaBtn);
        Assert.assertTrue(validataHelper.verifyUrl(url), "Have not move to manage work area page");
    }

    public void roomPageFail() throws Exception {
        validataHelper.waitForPageLoaded();
//        Assert.assertTrue(validataHelper.verifyUrl(url), "Not Manage Area Page");
//      Assert.assertTrue(validataHelper.verifyTitle(titlePage,pageHeader));
//        validataHelper.clickElement(editBtn);
//        validataHelper.waitForPageLoaded();
//      Assert.assertTrue(validataHelper.verifyTitle(titleEditAreaPage, editAreaHeader), "Not edit area page");
        for (int i = 1; i < 5; i++) {
            validataHelper.hoverElement(iconTooltip);

            //setText into Room Input
            validataHelper.hoverElement(roomInput);
            validataHelper.clickElement(roomInput);
            validataHelper.clearElement(roomInput);
            validataHelper.setText(roomInput, excel.getCellData("room name", i));
            //click Save
            validataHelper.clickElement(saveBtn);
            validataHelper.clickElement(editAreaBtn);
            Assert.assertTrue(validataHelper.verifyUrl(url), "Have not move to manage work area page");
        }
    }

}
