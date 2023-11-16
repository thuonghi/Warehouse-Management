package com.managesys.testcases;

import com.managesys.base.BaseSetup;
import com.managesys.pages.SignInPage;
import com.managesys.base.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class SignInTestUserPropertiesFile extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    @BeforeClass
    public void setupBrowser() {
        driver = getDriver();
        PropertiesFile.setPropertiesFile();
    }

    @Test
    public void signInPage() throws Exception {
        signInPage = new SignInPage(driver);
        signInPage.signIn(PropertiesFile.getPropValue("email"),PropertiesFile.getPropValue("password"));
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}

