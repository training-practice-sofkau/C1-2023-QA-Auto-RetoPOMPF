package com.sofkau.pages;

import com.sofkau.pages.common.CommonActionPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class PagPrincipal extends CommonActionPages {

    private WebDriver driver;

    //localizadores de entrada
    private By emailInputLocator = By.xpath("(//input[@id='mce-EMAIL'])[1]");
    private By nameInputLocator = By.xpath("(//input[@id='mce-FNAME'])[1]");
    private By phoneInputLocator = By.xpath("(//input[@id='mce-MMERGE4'])[1]");
    private By subscribeButtonLocator = By.xpath("(//input[@id='mc-embedded-subscribe'])[1]");

    public void setEmail(String email) {
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    public void setName(String name) {
        driver.findElement(nameInputLocator).sendKeys(name);
    }

    public void setPhone(String phone) {
        driver.findElement(phoneInputLocator).sendKeys(phone);
    }

    public void clickSubscribeButton() {
        driver.findElement(subscribeButtonLocator).click();
    }
    private static final By btnAgregarCarrito = By.xpath("//*[@class=\"add-to-cart-button\"]");

    public PagPrincipal(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, PagPrincipal.this);
    }
}
