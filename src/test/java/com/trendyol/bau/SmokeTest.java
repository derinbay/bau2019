package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by taylan.derinbay on 5.11.2019
 */
public class SmokeTest {

    WebDriver webDriver;

    @BeforeMethod
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/taylan.derinbay/Downloads/chromedriver");
        webDriver = new ChromeDriver();
    }

    @Test
    public void openHomePage() {
        String titleToControl = "n11.com - Alışverişin Uğurlu Adresi";

        webDriver.get("https://www.n11.com");
        String titleFromPage = webDriver.getTitle();
        assertEquals(titleToControl, titleFromPage);
    }





    //"a".equals("a") ==> true
    //object.equals(object) ==> true
    //object1.equals(object2) ==> false
    //"a".equals("b") ==> false

    //"bau".contains("b") ==> true
    //"dashjdkha".contains("hjd") ==> true
    //"dashjdkha".contains("shd") ==> false


    @Test
    public void openLoginPage() {
        String titleToControl = "Giriş Yap - n11.com";

        webDriver.get("https://www.n11.com/giris-yap");
        String titleFromPage = webDriver.getTitle();
        assertEquals(titleFromPage, titleToControl);
    }

    @Test
    public void shouldLogin() {
        webDriver.get("https://www.n11.com/giris-yap");
        WebElement emailTextBox = webDriver.findElement(By.id("email"));
        WebElement passwordTextBox = webDriver.findElement(By.id("password"));
        WebElement loginButton = webDriver.findElement(By.id("loginButton"));

        emailTextBox.sendKeys("test2019@bau.com");
        passwordTextBox.sendKeys("123qwe");
        loginButton.click();

        WebElement userName = webDriver.findElement(By.className("user"));
        String userNameFromPage = userName.getText();
        assertEquals(userNameFromPage, "test test");

        boolean isSignInButtonVisible = isElementVisible(By.className("btnSignIn"));
        assertFalse(isSignInButtonVisible);

        //cssSelector
        //-------------
        //  class ==> .class
        //  id ==> #id
        //  tagname ==> tagname
        //


        //class ==> .user
        //class ==> .user
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    public boolean isElementVisible(By by) {
        try {
            webDriver.findElement(by).isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Test
    public void shouldSearch() {
        webDriver.get("https://www.n11.com");
        WebElement searchBox = webDriver.findElement(By.id("searchData"));
        WebElement searchButton = webDriver.findElement(By.className("iconSearch"));

        searchBox.sendKeys("samsung");
        searchButton.click();

        WebElement resultTextElement = webDriver.findElement(By.className("resultText"));
        String resultText = resultTextElement.getText();
        assertTrue(resultText.contains("Samsung"));
    }
}

