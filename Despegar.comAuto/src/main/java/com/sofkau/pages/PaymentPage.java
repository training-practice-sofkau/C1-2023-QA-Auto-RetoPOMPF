package com.sofkau.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage extends CommonActions {
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/h2")
    public static WebElement title;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String seeTitle() {
        return getText(title);
    }
}