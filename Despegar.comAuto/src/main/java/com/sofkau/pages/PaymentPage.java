package com.sofkau.pages;

import com.fasterxml.jackson.core.sym.Name3;
import com.sofkau.models.Passenger;
import com.sofkau.models.ResponsiblePassenger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage extends CommonActions {
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/h2")
    public static WebElement title;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='input-tag traveler-first-name ng-untouched ng-pristine ng-invalid'])[1]")
    public static WebElement name;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='input-tag traveler-last-name ng-untouched ng-pristine ng-invalid'])[1]")
    public static WebElement lName;

        @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.contactData.mainEmailAddress\"]")
    public static WebElement email;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.contactData.repeatMainEmailAddress\"]")
    public static WebElement emailValidation;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.contactData.phones[0].number\"]")
    public static WebElement number;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='payment-method-aligned radio-circle'])[3]")
    public static WebElement method;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"card-selector-0\"]")
    public static WebElement bank;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"card-selector-0\"]/option[9]")
    public static WebElement bankType;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-first-name-0\"]")
    public static WebElement invoiceName;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-last-name-0\"]")
    public static WebElement invoiceLName;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-fiscal-identification-number-0\"]")
    public static WebElement cc;

    @CacheLookup
    @FindBy(xpath = "//input[@class='input-tag invoice-fiscal-address-street ng-untouched ng-pristine ng-invalid']")
    public static WebElement address;

    @CacheLookup
    @FindBy(xpath = "//i[@class='checkbox-check eva-3-icon-checkmark -eva-3-mr-sm']")
    public static WebElement checkBox;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"buy-button\"]")
    public static WebElement buyBttn;

    private final ResponsiblePassenger passenger = new ResponsiblePassenger();

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String seeTitle() {
        return getText(title);
    }

    public void typeName(WebElement element) {
        delayClick(element);
        type(element, passenger.getName());
    }

    public void typeLName(WebElement element) {
        delayClick(element);
        type(element, passenger.getLName());
    }

    public void typeEmail(WebElement element) {
        delayClick(element);
        type(element, passenger.getEmail());
    }

    public void typeNumber(WebElement element) {
        delayClick(element);
        type(element, passenger.getNumber());
    }

    public void typeCC(WebElement element) {
        delayClick(element);
        type(element, passenger.getCc());
    }

    public void typeAddress(WebElement element) {
        delayClick(element);
        type(element, passenger.getAddress());
    }

    public void selectPayment() {
        delayClick(method);
    }

    public void selectBank() {
        delayClick(bank);
    }

    public void selectBankType() {
        delayClick(bankType);
    }

    public void verification() {
        delayClick(checkBox);
    }

    public void buy() {
        delayClick(buyBttn);
    }

    public void setupPaymentPage() {
        typeName(name);
        typeLName(lName);
        scroll(300);
        typeEmail(email);
        typeEmail(emailValidation);
        scroll(500);
        typeNumber(number);
        scroll(500);
        selectPayment();
        scroll(500);
        selectBank();
        selectBankType();
        scroll(600);
        typeName(invoiceName);
        typeLName(invoiceLName);
        typeCC(cc);
        typeAddress(address);
        verification();
        buy();
    }
}