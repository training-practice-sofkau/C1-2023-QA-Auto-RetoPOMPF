package com.sofkau.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonActions {
    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/debt-published/div/div[3]/debt-published-info/div/div/div[1]/div/span[2]")
    public static WebElement finalTitle;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String seeFinalTitle() {
        return getText(finalTitle);
    }
}