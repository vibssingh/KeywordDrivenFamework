package com.example.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageKeywords extends BasePage {

    public HomePageKeywords(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")
    public  WebElement homePageUserName;

    public String verifyHomePage() {
        return homePageUserName.getText();
    }

}