package com.example.keywords;

import com.example.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageKeywords extends BasePage{

    public LoginPageKeywords(WebDriver driver) {
        super(driver);

    }

    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@class='oxd-form']/div[1]/div/span")
    public WebElement missingUsernameErrorMessage;

    @FindBy(xpath = "//*[@class='oxd-form']/div[2]/div/span")
    public WebElement missingPasswordErrorMessage;

    @FindBy(xpath = "//*[@class='oxd-form']/div[3]/button")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    public  WebElement errorMessage;


    public void enterUsername(String strUserName) {
        userName.sendKeys(strUserName);
    }

    public void enterPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void login() {
        loginBtn.click();
    }


    public void login(String strUserName, String strPassword) {

        userName.sendKeys(strUserName);
        password.sendKeys(strPassword);


    }

    public String getMissingUsernameText() {
        return missingUsernameErrorMessage.getText();
    }

    public String getMissingPasswordText() {
        return missingPasswordErrorMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public LoginPageKeywords saveTestResults(int row, int column) {
        ExcelUtils.rowNumber = row ;
        ExcelUtils.columnNumber = column;
        return this;
    }

}