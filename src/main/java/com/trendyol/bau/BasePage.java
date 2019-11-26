package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by taylan.derinbay on 26.11.2019
 */
public class BasePage {

    WebDriver driver;

    public boolean isElementVisible(By by) {
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }
}
