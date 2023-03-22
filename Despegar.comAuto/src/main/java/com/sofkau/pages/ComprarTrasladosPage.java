package com.sofkau.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComprarTrasladosPage extends CommonActions {
    @CacheLookup
    @FindBy(xpath = "/html/body/app-root/results/div/div[4]/div[1]/transfer-cluster/div/div/div[2]/ds-cluster-pricebox/div/div[1]/div[2]/button")
    public static WebElement buyBttn;

    @CacheLookup
    @FindBy(xpath = "/html/body/app-root/results/div/div[4]/div[1]/transfer-cluster/div/div/div[2]/ds-cluster-pricebox/div/div[1]/div[1]/div[2]/span[2]")
    public static WebElement price;

    public ComprarTrasladosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void buyFirst() {
        click(buyBttn);
    }

    public String getPrice() {
        return getText(price);
    }
}