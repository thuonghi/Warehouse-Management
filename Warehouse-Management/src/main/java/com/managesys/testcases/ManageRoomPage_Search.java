package com.managesys.testcases;

import com.managesys.base.BaseSetup;
import com.managesys.base.ValidataHelper;
import com.managesys.pages.*;
import com.managesys.pages.ManageWorkAreaPage_Edit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManageRoomPage_Search extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    private ValidataHelper validataHelper;
    private ManageUserPage manageUserPage;
    private ManageRoomPage manageRoomPage;
    private com.managesys.pages.ManageRoomPage_Search manageRoomPage_search;



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
    public void searchRoom(){
        validataHelper = new ValidataHelper(driver);
        manageRoomPage_search = manageRoomPage.findFunction();
        manageRoomPage_search.CheckSearchByValue();
        manageRoomPage_search.checkSearchTableByColumn(2, "QA");
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
