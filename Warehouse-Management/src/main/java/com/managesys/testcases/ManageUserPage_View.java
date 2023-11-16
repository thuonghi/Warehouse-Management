package com.managesys.testcases;

import com.managesys.base.BaseSetup;
import com.managesys.base.ValidataHelper;
import com.managesys.pages.ManageUserPage;
import com.managesys.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManageUserPage_View extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    private ValidataHelper validataHelper;
    private ManageUserPage manageUserPage;

    private com.managesys.pages.ManageUserPage_View manageUserPage_view;

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
    public void openViewDetailUserPage() {
        validataHelper = new ValidataHelper(driver);
        manageUserPage_view=manageUserPage.viewDetailUser();
    }

    @Test(priority = 2)
    public void viewDetailUser(){
        validataHelper = new ValidataHelper(driver);
        manageUserPage_view.checkSeeDetailUserPage();

    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
