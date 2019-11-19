package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class MyAddressesPage {

    WebDriver driver;

    By addAddressButton = By.id("addButton");

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddAddressPage goToAddAddressPage() {
        driver.findElement(addAddressButton).click();
        return new AddAddressPage(driver);
    }
}
