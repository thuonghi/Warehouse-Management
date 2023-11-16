package com.managesys.testcases;

import com.managesys.base.BaseSetup;
import com.managesys.base.ExcelUtils;
import com.managesys.base.ValidataHelper;
import com.managesys.pages.ManageUserPage;
import com.managesys.pages.ManageWorkAreaPage;
import com.managesys.pages.SignInPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class ManageWorkAreaPage_Edit extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    private ValidataHelper validataHelper;
    private ManageUserPage manageUserPage;
    private ManageWorkAreaPage manageWorkAreaPage;
    private com.managesys.pages.ManageWorkAreaPage_Edit manageWorkAreaPage_edit;
    public static ExcelUtils excel;



    @BeforeClass
    public void setUp() {
        driver = getDriver();
        excel = new ExcelUtils();
    }

    @Test(priority = 0)
    public void signIn() throws Exception {
        signInPage = new SignInPage(driver);
        excel.setExcelFile("src/Test_data/Test_data.xlsx", "Login sucessfully");
        manageUserPage = signInPage.signIn(excel.getCellData("email", 1), excel.getCellData("password", 1));

    }

    @Test(priority = 1)
    public void openManageAreaPage() {
        validataHelper = new ValidataHelper(driver);
        manageWorkAreaPage=manageUserPage.openManageArea();
    }

    @Test(priority = 3, description = "Edit work area successfully with correct data")
    public void editWorkAreaSuccess() throws Exception {
        validataHelper = new ValidataHelper(driver);
        manageWorkAreaPage_edit=manageWorkAreaPage.editWorkArea();
        excel.setExcelFile("src/Test_data/Test_data.xlsx", "EditWorkAreaSuccess");
        manageWorkAreaPage_edit.editAreaSuccess();
    }

    @Test(priority = 3, description = "Edit work area failed with incorrect data")
    public void editWorkAreaFail() throws Exception {
        validataHelper = new ValidataHelper(driver);
        manageWorkAreaPage_edit=manageWorkAreaPage.editWorkArea();
        excel.setExcelFile("src/Test_data/Test_data.xlsx", "EditWorkAreaFail");
        manageWorkAreaPage_edit.editAreaFail();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws InterruptedException {
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
                System.out.println("Screenshot success: " + result.getName());
            } catch (Exception e) {
                System.out.println("Error when screenshot " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
