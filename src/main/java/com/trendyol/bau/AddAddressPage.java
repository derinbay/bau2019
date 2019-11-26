package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class AddAddressPage extends BasePage {

    By title = By.id("title");
    By fullName = By.id("fullName");
    By cityId = By.id("cityId");
    By districtId = By.id("districtId");
    By neighbourhoodId = By.id("neighbourhoodId");
    By address = By.id("address");
    By gsm = By.id("gsm");
    By shipping_tcId = By.id("shipping_tcId");
    By saveButton = By.id("saveButton");

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAddress() {
        driver.findElement(title).sendKeys("adres");
        driver.findElement(fullName).sendKeys("test name");

        Select citySelect = new Select(driver.findElement(cityId));
        citySelect.selectByIndex(1);

        Select districtSelect = new Select(driver.findElement(districtId));
        districtSelect.selectByIndex(1);

        Select neighbourSelect = new Select(driver.findElement(neighbourhoodId));
        neighbourSelect.selectByIndex(1);

        driver.findElement(address).sendKeys("rdtfghjkl;cvbn dbask jdfhlaksd fhaskd jfhasdk fhdklj fhskl fahslk ");
        driver.findElement(gsm).sendKeys("555555555");
        driver.findElement(shipping_tcId).sendKeys("10000000146");
        driver.findElement(saveButton).click();
    }
}
