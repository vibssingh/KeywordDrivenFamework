package com.example.tests;

import com.example.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTests {

    public static WebDriver driver;
    public final static int TIMEOUT = 10;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
       // options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    public BaseTests saveTestResults(int row, int column) {
        ExcelUtils.rowNumber = row ;
        ExcelUtils.columnNumber = column;
        return this;
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}