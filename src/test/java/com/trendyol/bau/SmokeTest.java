package com.trendyol.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by taylan.derinbay on 5.11.2019
 */
public class SmokeTest extends BaseTest {

    @Test
    public void openHomePage() throws InterruptedException {
        String titleToControl = "n11.com - Alışverişin Uğurlu Adresi";

        Thread.sleep(3000);
        String titleFromPage = driver.getTitle();
        assertEquals(titleToControl, titleFromPage);
    }

    @Test
    public void openLoginPage() {
        String titleToControl = "Giriş Yap - n11.com";

        driver.get("https://www.n11.com/giris-yap");
        String titleFromPage = driver.getTitle();
        assertEquals(titleFromPage, titleToControl);
    }

    @Test
    public void shouldLogin() {
        driver.get("https://www.n11.com/giris-yap");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        WebElement userName = driver.findElement(By.className("user"));
        String userNameFromPage = userName.getText();
        assertEquals(userNameFromPage, "test test");

        HomePage homePage = new HomePage(driver);
        boolean isSignInButtonVisible = homePage.isElementVisible(By.className("btnSignIn"));
        assertFalse(isSignInButtonVisible);
    }

    @Test
    public void shouldSearch() {
        WebElement searchBox = driver.findElement(By.id("searchData"));
        WebElement searchButton = driver.findElement(By.className("iconSearch"));

        searchBox.sendKeys("samsung" + Keys.ENTER);

        WebElement resultTextElement = driver.findElement(By.cssSelector(".resultText > h1"));
        String resultText = resultTextElement.getText();
        assertTrue(resultText.equals("Samsung"));
    }

    @Test
    public void shouldSearchAndAddToCart() throws InterruptedException {
        String keyword = "Samsung";
        HomePage homePage = new HomePage(driver);
        SearchResultPage resultPage = homePage.search(keyword);
        Thread.sleep(3000);

        assertEquals(resultPage.getResultText(), keyword);

        List<WebElement> products = resultPage.getProducts();
        ProductDetailPage detailPage = resultPage.getFirstProduct(products);
        Thread.sleep(3000);
        detailPage.addToCart();
        WebElement successPopup = detailPage.getSuccessPopup();
        assertTrue(successPopup.isDisplayed());
    }

    @Test
    public void registerAndAddAnAddress() throws InterruptedException {
        /**
         * 1- register
         * 2- go to my account page
         * 3- go to addresses page
         * 4- add an address
         *
         * */
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.goToRegister();

        homePage = registerPage.register();
        MyAccountPage myAccountPage = homePage.goToMyAccountPage();
        MyAddressesPage myAddressesPage = myAccountPage.goToMyAddressesPage();

        AddAddressPage addAddressPage = myAddressesPage.goToAddAddressPage();
        addAddressPage.addAddress();

        // add assertion
        // refactor for duplication
    }
}





/**
 * id: #email   -> By.cssSelector("#email")
 * class: .email -> By.cssSelector(".email")
 * tagName: input -> By.cssSelector("input")
 * relative path -> By.cssSelector(".catMenu .catMenuItem")
 * relative path -> By.cssSelector(".catMenu > .catMenuItem")
 * <p>
 * <p>
 * xpath: class=resultText ->  By.xpath("//div[@class='resultText']")
 * //*[@id='hgjk']
 * //*[@type='text/javascript']
 * //tagName[@attribute='value']
 * <p>
 * //div[@class='resultText ']//h1
 * <p>
 * <p>
 * By.cssSelector("#id")
 * By.cssSelector(".className")
 * By.cssSelector("[name=address]")
 * By.cssSelector(".addressBoxBlack #address01")
 * <p>
 * By.cssSelector(".resultText > h1")
 * By.cssSelector(".listingGroup h1")
 */

//**
// By.id("searchData")
// By.className("hMedMenu");
// By.className("searchBox")
// By.className("withLocalization")
// By.name("address")
//

/**
 * By.cssSelector("#id")
 * By.cssSelector(".className")
 * By.cssSelector("[name=address]")
 * By.cssSelector(".addressBoxBlack #address01")
 *
 * By.cssSelector(".resultText > h1")
 * By.cssSelector(".listingGroup h1")
 *
 *
 */















