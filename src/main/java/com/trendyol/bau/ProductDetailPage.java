package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class ProductDetailPage extends BasePage {


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToBasketButton = By.className("btnAddBasket");

    public void addToCart() {
        driver.findElement(addToBasketButton).click();
    }

    public WebElement getSuccessPopup() {
        return driver.findElement(By.className("myBasketList"));
    }
}
