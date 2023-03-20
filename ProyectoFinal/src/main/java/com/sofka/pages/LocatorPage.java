package com.sofka.pages;

import com.sofka.models.ClienteZonaFit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocatorPage extends CommonActionOnPage{
    private WebDriver webDriver;
    private ClienteZonaFit clienteZonaFit;

    private final By product = By.xpath("(//div[@class='add-to-cart-button'])[1]");
    private final By flavor = By.xpath("//div[contains(@class,'ux-swatch tooltip')]/span[contains(@style,'--swatch-color: #ddb471')]");
    private final By buttonShopping = By.xpath("//div[contains(@class,'single_variation_wrap')]//button[contains(@class,'wp-element-button')]");

    private final By product2 = By.xpath("(//div[@class='add-to-cart-button'])[2]");
    private final By flavor2 = By.xpath("//div[contains(@class,'ux-swatch tooltip')]/span[contains(@style,'--swatch-color: #8224e3')]");
    private final By buttonShopping2 = By.xpath("//div[contains(@class,'single_variation_wrap')]//button[contains(@class,'wp-element-button')]");

    private final By product3 = By.xpath("(//div[@class='add-to-cart-button'])[3]");
    private final By flavor3 = By.xpath("(//div[contains(@class,'ux-swatch tooltip')]/span[contains(@style,'--swatch-color: #ffff00')])[1]");
    private final By buttonShopping3 = By.xpath("//div[contains(@class,'single_variation_wrap')]//button[contains(@class,'wp-element-button')]");

    private final By buttonViewShopping = By.xpath("//p[contains(@class,'woocommerce-mini-cart__buttons')]//a[contains(@class,'button wc-forward')]");
    private final By addProduct1 = By.xpath("(//div[contains(@class,'quantity')]//input[@value='+'])[1]");
    private final By addProduct2 = By.xpath("(//div[contains(@class,'quantity')]//input[@value='+'])[2]");
    private final By addProduct3 = By.xpath("(//div[contains(@class,'quantity')]//input[@value='+'])[3]");

    private final By finishBuy = By.xpath("//div[contains(@class,'wc-proceed-to-checkout')]/a[contains(@class,'checkout-button')]");

    private final By documentNumber = By.id("billing_myfield12");
    private final By email = By.id("billing_email");
    private final By name = By.id("billing_first_name");
    private final By lastName = By.id("billing_last_name");
    private final By comboDepartmet = By.id("select2-billing_state-container");
    private final By department = By.cssSelector("input[aria-owns='select2-billing_state-results']");
    private final By comboCity = By.id("select2-billing_city-container");
    private final By city = By.cssSelector("input[aria-owns='select2-billing_city-results']");
    private final By address = By.id("billing_address_1");
    private final By address2 = By.id("billing_address_2");
    private final By phoneNumber = By.id("billing_phone");
    private final By termCondition = By.id("terms");
    private final By order = By.id("place_order");

    private final By messagge = By.xpath("(//main[@id='main']//div[contains(@class,'large-7')]//h2)[1]");

    public LocatorPage(WebDriver driver, ClienteZonaFit clienteZonaFit){
        super(driver);
        this.clienteZonaFit = clienteZonaFit;
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
        click(finishBuy);
    }

    public void formBill(){
        clearTextP(documentNumber);
        typeIntoP(documentNumber, clienteZonaFit.getDocumentNumber());
        clearTextP(email);
        typeIntoP(email, clienteZonaFit.getEmail());
        clearTextP(name);
        typeIntoP(name, clienteZonaFit.getName());
        clearTextP(lastName);
        typeIntoP(lastName, clienteZonaFit.getLastName());
        clickP(comboDepartmet);
        typeIntoP(department, clienteZonaFit.getDepartment());
        pressEnterP(department);
        clickP(comboCity);
        typeIntoP(city, clienteZonaFit.getCity());
        pressEnterP(city);
        clearTextP(address);
        typeIntoP(address, clienteZonaFit.getAddress());
        clearTextP(address2);
        typeIntoP(address2, clienteZonaFit.getAddress2());
        clearTextP(phoneNumber);
        typeIntoP(phoneNumber, clienteZonaFit.getPhoneNumber());
        scrollButton();
        pressSpaceP(termCondition);
        pressSpaceP(order);
    }

    public void formBillFailed(){
        clearTextP(documentNumber);
        typeIntoP(documentNumber, clienteZonaFit.getDocumentNumber());
        clearTextP(email);
        typeIntoP(email, clienteZonaFit.getEmail());
        clearTextP(name);
        typeIntoP(name, clienteZonaFit.getName());
        clearTextP(lastName);
        typeIntoP(lastName, clienteZonaFit.getLastName());
        clickP(comboDepartmet);
        typeIntoP(department, clienteZonaFit.getDepartment());
        pressEnterP(department);
        clickP(comboCity);
        typeIntoP(city, clienteZonaFit.getCity());
        pressEnterP(city);
        clearTextP(address);
        typeIntoP(address, clienteZonaFit.getAddress());
        clearTextP(address2);
        typeIntoP(address2, clienteZonaFit.getAddress2());
        clearTextP(phoneNumber);
        typeIntoP(phoneNumber, clienteZonaFit.getPhoneNumber());
        scrollButton();
        pressSpaceP(termCondition);
        pressSpaceP(order);
    }

    public WebElement getConfirmationMessage (WebDriver webDriver){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messagge));
    }
}