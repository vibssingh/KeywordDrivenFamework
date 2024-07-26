package com.example.tests;

import com.example.keywords.HomePageKeywords;
import com.example.keywords.LoginPageKeywords;
import com.example.utils.Constants;
import com.example.utils.ExcelUtils;
import com.example.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({TestListener.class })
public class LoginPageTests extends BaseTests {

    String username;
    String password;
    String actualResponse;
    String expectedResponse;


    @BeforeTest
    public void setupTestData() throws IOException {

        System.out.println("Setup Test Data");
        ExcelUtils.setExcelFileSheet(Constants.excelTestDataName);
    }

    @Test
    public void validCredentials() throws IOException {

        username = ExcelUtils.getCellData(2,5);
        password = ExcelUtils.getCellData(3,5);
        expectedResponse = ExcelUtils.getCellData(5,6);

        LoginPageKeywords loginPage = new LoginPageKeywords(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.login();

        HomePageKeywords homePage = new HomePageKeywords(driver);
        actualResponse = homePage.verifyHomePage();

        ExcelUtils.setCellData(actualResponse,5,7);
        saveTestResults(5,8);
        Assert.assertEquals(actualResponse,expectedResponse);

    }

    @Test
    public void invalidCredentials() throws IOException {

        username = ExcelUtils.getCellData(9,5);
        password = ExcelUtils.getCellData(10,5);
        expectedResponse = ExcelUtils.getCellData(12,6);

        LoginPageKeywords loginPage = new LoginPageKeywords(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.login();

        actualResponse = loginPage.getErrorMessage();

        ExcelUtils.setCellData(actualResponse,12,7);
        saveTestResults(12,8);
        Assert.assertEquals(actualResponse,expectedResponse);

    }

}
