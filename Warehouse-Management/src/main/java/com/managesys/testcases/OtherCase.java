package com.managesys.testcases;

import com.managesys.base.BaseSetup;
import com.managesys.base.ValidataHelper;
import com.managesys.pages.ManageUserPage;
import com.managesys.pages.ManageWorkAreaPage;
import com.managesys.pages.ManageWorkAreaPage_Edit;
import com.managesys.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OtherCase extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    private ValidataHelper validataHelper;
    private ManageUserPage manageUserPage;
    private ManageWorkAreaPage manageWorkAreaPage;
    private com.managesys.pages.ManageWorkAreaPage_View manageWorkAreaPage_view;
    private ManageWorkAreaPage_Edit manageWorkAreaPage_edit;
    private com.managesys.pages.ManageWorkAreaPage_Add manageWorkAreaPage_add;


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
    public void lockAccount() {
        validataHelper = new ValidataHelper(driver);
        manageUserPage.lockAccount();
    }
    @Test(priority = 2)
    public void setNewPassword() {
        validataHelper = new ValidataHelper(driver);
        manageUserPage.setNewPassword();
    }

}

