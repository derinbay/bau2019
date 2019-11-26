package com.trendyol.bau;

import com.trendyol.bau.pages.HomePage;
import com.trendyol.bau.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by taylan.derinbay on 26.11.2019
 */
public class LoginTest extends BaseTest {

    /**
     * 1- Login sayfasina git
     * 2- dogru email, dogru password gir
     * 3- basarili giris yaptigini kontrol et
     * - hesabim elementinin geldigi kontrol et
     * - anasayfaya yonlendirildigini kontrol et
     */
    @Test
    public void shouldLoginSuccessfully() {
        Buyer buyer = BuyerPool.aBuyer();
        buyer.login(driver);

        HomePage homePage = new HomePage(driver);
        assertEquals(homePage.getUserName(), buyer.getFullName());
        assertEquals(driver.getCurrentUrl(), homePage.url);
    }

    /**
     * 1- Login sayfasina git
     * 2- dogru email, yanlis password gir
     * 3- "E-posta adresiniz veya şifreniz hatalı" mesajinin geldigini kontrol et
     * 4- anasayfaya yonlendirilmedigini kontrol et
     */
    @Test
    public void shouldNotLoginWithWrongPassword() {
        Buyer buyer = BuyerPool.aBuyerWithEmptyPassword();
        buyer.setPassword("123456");
        LoginPage loginPage = (LoginPage) buyer.login(driver);

        assertEquals(loginPage.getErrorMessage(), "E-posta adresiniz veya şifreniz hatalı");
        assertEquals(driver.getCurrentUrl(), loginPage.url);
    }

    @Test
    public void shouldNotLoginWithEmptyPassword() {
        Buyer buyer = BuyerPool.aBuyerWithEmptyPassword();
        LoginPage loginPage = (LoginPage) buyer.login(driver);

        assertEquals(loginPage.getErrorMessage(), "Bu alanın doldurulması zorunludur.");
        assertEquals(driver.getCurrentUrl(), loginPage.url);
    }

    @Test
    public void shouldNotLoginWithMoreThan15CharPassword() {
        Buyer buyer = BuyerPool.aBuyerWithEmptyPassword();
        buyer.setPassword("123456789012345678");
        LoginPage loginPage = (LoginPage) buyer.login(driver);

        assertEquals(loginPage.getErrorMessage(), "Girilen değer en fazla 15 karakter olmalıdır.");
        assertEquals(driver.getCurrentUrl(), loginPage.url);
    }
}
