package com.trendyol.bau.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * Created by taylan.derinbay on 19.11.2019
 */
public class AddAddressPage extends BasePage {

    private By title = By.id("title");
    private By fullName = By.id("fullName");
    private By cityId = By.id("cityId");
    private By districtId = By.id("districtId");
    private By neighbourhoodId = By.id("neighbourhoodId");
    private By address = By.id("address");
    private By gsm = By.id("gsm");
    private By shipping_tcId = By.id("shipping_tcId");
    private By saveButton = By.id("saveButton");

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAddress() {
        typeTo(title, "adres");
        typeTo(fullName, "test name");

        Select citySelect = getSelectObject(cityId);
        citySelect.selectByIndex(1);

        Select districtSelect = getSelectObject(districtId);
        districtSelect.selectByIndex(1);

        Select neighbourSelect = getSelectObject(neighbourhoodId);
        neighbourSelect.selectByIndex(1);

        typeTo(address, randomAlphabetic(30));
        typeTo(gsm, "555555555");
        typeTo(shipping_tcId, "10000000146");
        clickTo(saveButton);
    }
}
