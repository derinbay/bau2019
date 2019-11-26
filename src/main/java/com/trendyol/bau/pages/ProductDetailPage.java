package com.trendyol.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class ProductDetailPage extends BasePage {

    private By addToBasketButton = By.className("btnAddBasket");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        clickTo(addToBasketButton);
    }

    public WebElement getSuccessPopup() {
        return driver.findElement(By.className("myBasketList"));
    }
}
