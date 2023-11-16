package com.managesys.testcases;

import com.managesys.base.BaseSetup;
import com.managesys.base.ValidataHelper;
import com.managesys.pages.DeFaultPasswordPage;
import com.managesys.pages.ManageUserPage;
import com.managesys.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DefaultPasswordPage extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    private ValidataHelper validataHelper;
    private ManageUserPage manageUserPage;

    private DeFaultPasswordPage defaultPasswordPage;


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
    public void openManageRoom() {
        validataHelper = new ValidataHelper(driver);
        defaultPasswordPage =manageUserPage.openDeFaultPasswordPage();
        defaultPasswordPage.changePassword();
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
