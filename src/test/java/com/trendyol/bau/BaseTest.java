package com.trendyol.bau;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * Created by taylan.derinbay on 26.11.2019
 */
public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        WebDriverManager.getInstance(CHROME).setup();
        driver = new ChromeDriver();
        driver.get("https://www.n11.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
