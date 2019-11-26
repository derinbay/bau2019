package com.trendyol.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by taylan.derinbay on 26.11.2019
 */
public class BasePage {

    WebDriver driver;
    public String url;

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

    public void goTo(String url) {
        driver.get(url);
    }

    public void typeTo(By by, String text) {
        new WebDriverWait(driver, 15).until(visibilityOfElementLocated(by)).sendKeys(text);
    }

    public void clickTo(By by) {
        new WebDriverWait(driver, 15).until(elementToBeClickable(by)).click();
    }

    public void clickTo(WebElement element) {
        new WebDriverWait(driver, 15).until(elementToBeClickable(element)).click();
    }

    public List<WebElement> findElements(By by) {
        return new WebDriverWait(driver, 15).until(visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement findElement(By by) {
        return new WebDriverWait(driver, 15).until(visibilityOfElementLocated(by));
    }

    public Select getSelectObject(By by) {
        return new Select(findElement(by));
    }
}
