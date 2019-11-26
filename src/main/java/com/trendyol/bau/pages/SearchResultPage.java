package com.trendyol.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class SearchResultPage extends BasePage {

    private By resultText = By.cssSelector(".resultText > h1");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getResultText() {
        return getText(resultText);
    }

    public List<WebElement> getProducts() {
        return findElements(By.cssSelector("#view li.column"));
    }

    public ProductDetailPage getFirstProduct(List<WebElement> products) {
        WebElement firstProduct = products.get(0);
        WebElement firstProductToClick = firstProduct.findElement(By.tagName("img"));
        clickTo(firstProductToClick);
        return new ProductDetailPage(driver);
    }
}
