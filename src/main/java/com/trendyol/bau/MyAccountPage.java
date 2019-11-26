package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class MyAccountPage extends BasePage {

    By myAddresses = By.cssSelector(".accNav li:nth-child(9)> a");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAddressesPage goToMyAddressesPage() {
        driver.findElement(myAddresses).click();
        return new MyAddressesPage(driver);
    }
}
