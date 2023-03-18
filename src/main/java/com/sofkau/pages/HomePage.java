package com.sofkau.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By emailInputLocator = By.xpath("(//input[@id='mce-EMAIL'])[1]");
    private By nameInputLocator = By.xpath("(//input[@id='mce-FNAME'])[1]");
    private By phoneInputLocator = By.xpath("(//input[@id='mce-MMERGE4'])[1]");
    private By subscribeButtonLocator = By.xpath("(//input[@id='mc-embedded-subscribe'])[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

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
}

