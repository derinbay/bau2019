package com.trendyol.bau;

import org.testng.annotations.Test;

/**
 * Created by taylan.derinbay on 26.11.2019
 */
public class LoginTest extends BaseTest {

    /**
     * 1- Login sayfasina git
     * 2- dogru email, dogru password gir
     * 3- basarili giris yaptigini kontrol et
     *      - hesabim elementinin geldigi kontrol et
     *      - anasayfaya yonlendirildigini kontrol et
     * */
    @Test
    public void shouldLoginSuccessfully() {

    }

    /**
     * 1- Login sayfasina git
     * 2- dogru email, yanlis password gir
     * 3- "E-posta adresiniz veya şifreniz hatalı" mesajinin geldigini kontrol et
     *      - anasayfaya yonlendirilmedigini kontrol et
     * */
    @Test
    public void shouldNotLoginWithWrongPassword() {

    }
}
