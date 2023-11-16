package com.managesys.testcases;

import com.managesys.base.BaseSetup;
import com.managesys.base.ValidataHelper;
import com.managesys.pages.ManageRoomPage;
import com.managesys.pages.ManageRoomPage_Edit;
import com.managesys.pages.ManageUserPage;
import com.managesys.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManageRoomPage_View extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    private ValidataHelper validataHelper;
    private ManageUserPage manageUserPage;
    private ManageRoomPage manageRoomPage;
    private com.managesys.pages.ManageRoomPage_Search manageRoomPage_search;
    private com.managesys.pages.ManageRoomPage_View manageRoomPage_view;
    private ManageRoomPage_Edit manageRoomPage_edit;



    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test(priority = 0)
    public void signIn() throws Exception {
        signInPage = new SignInPage(driver);
        manageUserPage = signInPage.signIn("admin@gmail.com", "Abc@1234");
    }

    @Test(priority = 1)
    public void openManageRoomPage() {
        validataHelper = new ValidataHelper(driver);
        manageRoomPage=manageUserPage.openManageRoomPage();
    }

    @Test(priority = 3)
    public void searchRoom() throws Exception {
        validataHelper = new ValidataHelper(driver);
        manageRoomPage_view = manageRoomPage.viewRoom();
        manageRoomPage_edit = manageRoomPage_view.checkViewRoomPage();
        manageRoomPage_edit.roomPageSuccess();
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
