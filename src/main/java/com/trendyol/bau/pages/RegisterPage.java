package com.trendyol.bau.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class RegisterPage extends BasePage {

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By registrationEmail = By.id("registrationEmail");
    private By registrationPassword = By.id("registrationPassword");
    private By passwordAgain = By.id("passwordAgain");
    private By genderMale = By.cssSelector("[for=genderMale]");
    private By acceptContract = By.cssSelector("[for=acceptContract]");
    private By submitButton = By.id("submitButton");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage register() throws InterruptedException {
        typeTo(firstName, "firsttest");
        typeTo(lastName, "lasttest");
        typeTo(registrationEmail, RandomStringUtils.randomAlphabetic(5)+ "@testtest.com");
        typeTo(registrationPassword, "123qwe");
        typeTo(passwordAgain, "123qwe");
        clickTo(genderMale);
        clickTo(acceptContract);
        clickTo(submitButton);

        return new HomePage(driver);
    }
}
