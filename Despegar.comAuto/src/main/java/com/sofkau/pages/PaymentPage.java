package com.sofkau.pages;

import com.sofkau.locators.PaymentLocators;
import com.sofkau.models.ResponsiblePassenger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.sofkau.locators.PaymentLocators.*;

public class PaymentPage extends CommonActions {
    private final ResponsiblePassenger passenger = new ResponsiblePassenger();

    public PaymentPage(WebDriver driver) {
        super(driver);
        PaymentLocators locators = PageFactory.initElements(driver, PaymentLocators.class);
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