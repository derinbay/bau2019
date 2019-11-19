package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class HomePage {

    WebDriver driver;

    public By searchBar = By.id("searchData");
    public By searchButton = By.className("searchBtn");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultPage search(String keyword) {
        driver.findElement(searchBar).sendKeys(keyword);
        driver.findElement(searchButton).click();

        return new SearchResultPage(driver);
    }

}
