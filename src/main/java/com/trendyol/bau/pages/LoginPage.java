package com.trendyol.bau.pages;

import com.trendyol.bau.Buyer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by taylan.derinbay on 12.11.2019
 */
public class LoginPage extends BasePage {

    public String PAGE_URL = "https://www.n11.com/giris-yap";

    public LoginPage(WebDriver driverFromTest) {
        this.driver = driverFromTest;
        this.url = PAGE_URL;
    }

    private By emailTextBox = By.id("email");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.id("loginButton");

    public BasePage login(Buyer buyer) {
        typeTo(emailTextBox, buyer.getEmail());
        typeTo(passwordTextBox, buyer.getPassword());
        clickTo(loginButton);
        return new BasePage();
    }

    public String getErrorMessage() {
        return getText(By.cssSelector("[data-errormessagefor=password] > .errorText"));
    }
}
