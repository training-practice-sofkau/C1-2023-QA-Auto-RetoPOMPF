package com.sofka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorPage extends CommonActionOnPage{
    private WebDriver webDriver;

    private final By product = By.xpath("(//div[@class='add-to-cart-button'])[1]");
    private final By flavor = By.xpath("//div[contains(@class,'ux-swatch tooltip')]/span[contains(@style,'--swatch-color: #ddb471')]");
    private final By buttonShopping = By.xpath("//div[contains(@class,'single_variation_wrap')]//button[contains(@class,'wp-element-button')]");

    private final By product2 = By.xpath("(//div[@class='add-to-cart-button'])[2]");
    private final By flavor2 = By.xpath("//div[contains(@class,'ux-swatch tooltip')]/span[contains(@style,'--swatch-color: #8224e3')]");
    private final By buttonShopping2 = By.xpath("//div[contains(@class,'single_variation_wrap')]//button[contains(@class,'wp-element-button')]");

    private final By product3 = By.xpath("(//div[@class='add-to-cart-button'])[4]");
    private final By flavor3 = By.xpath("//div[contains(@class,'swatch-strawberry')]/span[contains(@style,'--swatch-color: #ff3a3a')]");
    private final By buttonShopping3 = By.xpath("//div[contains(@class,'single_variation_wrap')]//button[contains(@class,'wp-element-button')]");

    private final By buttonViewShopping = By.xpath("//p[contains(@class,'woocommerce-mini-cart__buttons')]//a[contains(@class,'button wc-forward')]");
    private final By addProduct1 = By.xpath("(//div[contains(@class,'quantity')]//input[@value='+'])[1]");
    private final By addProduct2 = By.xpath("(//div[contains(@class,'quantity')]//input[@value='+'])[2]");
    private final By addProduct3 = By.xpath("(//div[contains(@class,'quantity')]//input[@value='+'])[3]");

    private final By finishBuy = By.xpath("//div[contains(@class,'wc-proceed-to-checkout')]/a[contains(@class,'checkout-button')]");

    @CacheLookup
    @FindBy(xpath="(//li[@id='item-3'])[1]")
    private WebElement optionWebTables;

    @CacheLookup
    @FindBy(id="addNewRecordButton")
    private WebElement buttonAdd;

    public LocatorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegar() {
        scrollP();
        click(product);
        click(flavor);
        click(buttonShopping);
        goBackP();
        goBackP();

        click(product2);
        click(flavor2);
        click(buttonShopping2);
        goBackP();
        goBackP();

        click(product3);
        click(flavor3);
        click(buttonShopping3);

        click(buttonViewShopping);
        click(addProduct1);
        click(addProduct2);
        click(addProduct2);
        click(addProduct3);
        click(finishBuy);
    }

    public void formBill(){

    }
}