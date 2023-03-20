package com.sofkau.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentLocators {
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
}