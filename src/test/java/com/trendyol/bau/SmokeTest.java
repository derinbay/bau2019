package com.trendyol.bau;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static org.testng.Assert.*;

/**
 * Created by taylan.derinbay on 5.11.2019
 */
public class SmokeTest {

    WebDriver webDriver;

    @BeforeMethod
    public void startUp() {
        WebDriverManager.getInstance(CHROME).setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.n11.com");
    }

    @Test
    public void openHomePage() throws InterruptedException {
        String titleToControl = "n11.com - Alışverişin Uğurlu Adresi";

        Thread.sleep(3000);
        String titleFromPage = webDriver.getTitle();
        assertEquals(titleToControl, titleFromPage);
    }

    //"a".equals("a") ==> true
    //object.equals(object) ==> true
    //object1.equals(object2) ==> false
    //"a".equals("b") ==> false

    //"bau".contains("b") ==> true
    //"dashjdkha".contains("hjd") ==> true
    //"dashjdkha".contains("shd") ==> false

    @Test
    public void openLoginPage() {
        String titleToControl = "Giriş Yap - n11.com";

        webDriver.get("https://www.n11.com/giris-yap");
        String titleFromPage = webDriver.getTitle();
        assertEquals(titleFromPage, titleToControl);
    }

    @Test
    public void shouldLogin() {
        webDriver.get("https://www.n11.com/giris-yap");

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login();

        WebElement userName = webDriver.findElement(By.className("user"));
        String userNameFromPage = userName.getText();
        assertEquals(userNameFromPage, "test test");

        boolean isSignInButtonVisible = isElementVisible(By.className("btnSignIn"));
        assertFalse(isSignInButtonVisible);

        //cssSelector
        //-------------
        //  class ==> .class
        //  id ==> #id
        //  tagname ==> tagname
        //

        //class ==> .user
        //class ==> .user
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    public boolean isElementVisible(By by) {
        try {
            webDriver.findElement(by).isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Test
    public void shouldSearch() {
        WebElement searchBox = webDriver.findElement(By.id("searchData"));
        WebElement searchButton = webDriver.findElement(By.className("iconSearch"));

        searchBox.sendKeys("samsung" + Keys.ENTER);

        WebElement resultTextElement = webDriver.findElement(By.cssSelector(".resultText > h1"));
        String resultText = resultTextElement.getText();
        assertTrue(resultText.equals("Samsung"));
    }

    @Test
    public void shouldSearchAndAddToCart() {
        HomePage homePage = new HomePage(webDriver);
        SearchResultPage resultPage = homePage.search("Samsung");

        assertEquals(resultPage.getResultText(), "Samsung");

        List<WebElement> products = resultPage.getProducts();
        ProductDetailPage detailPage = resultPage.getFirstProduct(products);


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















