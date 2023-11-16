package com.managesys.testcases;

import com.managesys.base.BaseSetup;
import com.managesys.base.ExcelUtils;
import com.managesys.base.ValidataHelper;
import com.managesys.pages.SignInPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class SignIn extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private ValidataHelper validataHelper;
    private ExcelUtils excel;

    @BeforeClass
    public void setupBrowser() {
        driver = getDriver();
        excel = new ExcelUtils();
        validataHelper = new ValidataHelper(driver);
    }

    @Test(priority = 1, description = "Login sucessfully with correct data")
    public void signInPageSucess() throws Exception {
        excel.setExcelFile("src/Test_data/Test_data.xlsx", "Login sucessfully");
        signInPage = new SignInPage(driver);
        signInPage.signIn(excel.getCellData("email", 1), excel.getCellData("password", 1));
    }

    @Test(priority = 0, description = "Login failed with incorrect data")
    public void signInPageFail() throws Exception {
        excel.setExcelFile("src/Test_data/Test_data.xlsx", "Login failed");
        signInPage = new SignInPage(driver);
        for (int i = 1; i < 4; i++) {
            signInPage.signIn(excel.getCellData("email", i), excel.getCellData("password", i));

            Thread.sleep(1000);
        }
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        validataHelper.waitForPageLoaded();

        // Screenshot nếu test fail
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Da screenshot: " + result.getName());
            } catch (Exception e) {
                System.out.println("Error when screenshot " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}



