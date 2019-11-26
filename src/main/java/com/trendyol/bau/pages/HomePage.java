package com.trendyol.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class HomePage extends BasePage {

    String PAGE_URL = "https://www.n11.com/";

    private By searchBar = By.id("searchData");
    private By searchButton = By.className("searchBtn");
    private By registerButton = By.className("btnSignUp");
    private By myAccount = By.className("myAccount");
    private By userNameElement = By.cssSelector(".menuLink.user");

    public HomePage(WebDriver driverFromTest) {
        this.driver = driverFromTest;
        this.url = PAGE_URL;
    }

    public SearchResultPage search(String keyword) {
        typeTo(searchBar, keyword);
        clickTo(searchBar);
        return new SearchResultPage(driver);
    }

    public RegisterPage goToRegister() {
        clickTo(registerButton);
        return new RegisterPage(driver);
    }

    public MyAccountPage goToMyAccountPage() {
        clickTo(myAccount);
        return new MyAccountPage(driver);
    }

    public String getUserName() {
        return getText(userNameElement);
    }
}
