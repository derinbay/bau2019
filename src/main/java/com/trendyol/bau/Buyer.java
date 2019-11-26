package com.trendyol.bau;

import com.trendyol.bau.pages.BasePage;
import com.trendyol.bau.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by taylan.derinbay on 26.11.2019
 */
public class Buyer {

    private String email;
    private String password;
    private String firstName;
    private String surname;
    private String id;
    private String gsm;
    private String address;
    private String token;
    private String tcNo;

    public Buyer(String email, String password, String firstName, String surname) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName() {
        return getFirstName() + " " + getSurname();
    }

    public LoginPage login(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo(loginPage.url);
        loginPage.login(this);

        return loginPage;
    }
}
