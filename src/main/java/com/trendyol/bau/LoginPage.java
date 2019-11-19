package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by taylan.derinbay on 12.11.2019
 */
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement emailTextBox = driver.findElement(By.id("email"));
    WebElement passwordTextBox = driver.findElement(By.id("password"));
    WebElement loginButton = driver.findElement(By.id("loginButton"));

    public void login() {
        emailTextBox.sendKeys("test2019@bau.com");
        passwordTextBox.sendKeys("123qwe");
        loginButton.click();
    }
}
