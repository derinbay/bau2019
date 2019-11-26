package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class SearchResultPage extends BasePage {

    public By resultText = By.cssSelector(".resultText > h1");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }

    public List<WebElement> getProducts() {
        List<WebElement> products = driver.findElements(By.cssSelector("#view li.column"));
        return products;
    }

    public ProductDetailPage getFirstProduct(List<WebElement> products) {
        WebElement firstProduct = products.get(0);
        WebElement firstProductToClick = firstProduct.findElement(By.tagName("img"));
        firstProductToClick.click();
        return new ProductDetailPage(driver);
    }

}
