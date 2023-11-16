package com.managesys.pages;

import com.managesys.base.ValidataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.managesys.testcases.ManageRoomPage_Add.excel;

public class ManageRoomPage_Add {
    private WebDriver driver;
    private ValidataHelper validataHelper;
    public ManageRoomPage_Add(WebDriver driver) {
        this.driver = driver;
        validataHelper = new ValidataHelper(driver);
    }
    private By addNewTitle = By.xpath("//p[@class='text-child-page']");
    private By iconTooltip = By.xpath("//body[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[3]/p[1]/img[1]");

    private By roomInput = By.xpath("//input[@name='name']");
    private By saveBtn = By.xpath("//div[@class='display-but']//button[@type='button']");
    private By popupTitle = By.cssSelector("div[id='myModal'] h4[class='modal-title']");
    private By popupText = By.xpath("//div[@id='myModal']//div[2]");
    private By addBtn = By.xpath("//button[@form='add_department']");

    private String url = "/department/add";
    private String addNewHeader = "Thêm mới phòng ban";
    private String popupHeader = "Xác nhận";
    private String popupContent = "Bạn có thực sự muốn thêm mới phòng ban này";
    private String Url = "/department";

    public void addNewRoomFail() throws Exception {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not add new work area page");
//      Assert.assertTrue(validataHelper.verifyTitle(addNewTitle, addNewHeader), "Not add new work area page");
        for (int i = 1; i < 5; i++) {
            validataHelper.hoverElement(iconTooltip);

            validataHelper.hoverElement(roomInput);
            validataHelper.clickElement(roomInput);
            validataHelper.clearElement(roomInput);
            validataHelper.setText(roomInput, excel.getCellData("room name", i));
            validataHelper.clickElement(saveBtn);

            //Popup Handle
//        Assert.assertTrue(validataHelper.verifyTitle(popupTitle, popupHeader), "Not display pop up confirm");
//        Assert.assertTrue(validataHelper.verifyTitle(popupText, popupContent), "Not display pop up confirm");
            validataHelper.clickElement(addBtn);
            Assert.assertTrue(validataHelper.verifyUrl(Url), "Have not move to manage room page");
        }
    }

    public void addNewRoomSuccess() throws Exception {
        Assert.assertTrue(validataHelper.verifyUrl(url), "Not add new work area page");
//      Assert.assertTrue(validataHelper.verifyTitle(addNewTitle, addNewHeader), "Not add new work area page");
            validataHelper.hoverElement(iconTooltip);

            validataHelper.hoverElement(roomInput);
            validataHelper.clickElement(roomInput);
            validataHelper.clearElement(roomInput);
            validataHelper.setText(roomInput, excel.getCellData("room name", 1));
            validataHelper.clickElement(saveBtn);

        //Popup Handle
//        Assert.assertTrue(validataHelper.verifyTitle(popupTitle, popupHeader), "Not display pop up confirm");
//        Assert.assertTrue(validataHelper.verifyTitle(popupText, popupContent), "Not display pop up confirm");
        validataHelper.clickElement(addBtn);
        Assert.assertTrue(validataHelper.verifyUrl(Url), "Have not move to manage room page");
    }

}
