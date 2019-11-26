package com.trendyol.bau;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class RegisterPage extends BasePage {

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By registrationEmail = By.id("registrationEmail");
    By registrationPassword = By.id("registrationPassword");
    By passwordAgain = By.id("passwordAgain");
    By genderMale = By.cssSelector("[for=genderMale]");
    By acceptContract = By.cssSelector("[for=acceptContract]");
    By submitButton = By.id("submitButton");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //[for=genderMale]
    //[attribute=value]

    public HomePage register() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(firstName).sendKeys("firsttest");
        Thread.sleep(1000);
        driver.findElement(lastName).sendKeys("lasttest");
        Thread.sleep(1000);
        driver.findElement(registrationEmail).sendKeys(RandomStringUtils.randomAlphabetic(5)+ "@testtest.com");
        Thread.sleep(1000);
        driver.findElement(registrationPassword).sendKeys("123qwe");
        Thread.sleep(1000);
        driver.findElement(passwordAgain).sendKeys("123qwe");
        Thread.sleep(1000);
        driver.findElement(genderMale).click();
        Thread.sleep(1000);
        driver.findElement(acceptContract).click();
        Thread.sleep(1000);
        driver.findElement(submitButton).click();
        Thread.sleep(1000);
        return new HomePage(driver);
    }
}
