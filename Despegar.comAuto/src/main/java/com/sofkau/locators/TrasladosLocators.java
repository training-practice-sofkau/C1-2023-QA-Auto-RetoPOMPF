package com.sofkau.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TrasladosLocators {
    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public static WebElement closePopUp;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-transferspoi\"]/div/div/div/div/div[3]/div[2]/div[1]/div/div[1]/div/div/input")
    public static WebElement origin;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[8]/div/div/ul/li")
    public static WebElement originWait;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-transferspoi\"]/div/div/div/div/div[3]/div[2]/div[1]/div/div[2]/div/div/input")
    public static WebElement destination;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[15]/div/div/ul/li/span")
    public static WebElement destinationWait;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-transferspoi\"]/div/div/div/div/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/input")
    public static WebElement date;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/a[2]")
    public static WebElement rightArrowDate;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[12]")
    public static WebElement arrivalDate;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-transferspoi\"]/div/div/div/div/div[3]/div[2]/div[2]/div/div/div/div[2]/div/div/div/select")
    public static WebElement selectTime;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-transferspoi\"]/div/div/div/div/div[3]/div[2]/div[2]/div/div/div/div[2]/div/div/div/select/option[19]")
    public static WebElement time;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-transferspoi\"]/div/div/div/div/div[3]/div[2]/div[3]/div/div/div/div/input")
    public static WebElement passengers;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[1]/div[2]/div/button[2]")
    public static WebElement plusAdultPassengers;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[2]/div/button[2]")
    public static WebElement plusChildrenPassengers;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[3]/div[2]/div/div/select")
    public static WebElement selectAge;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[3]/div[2]/div/div/select/option[3]")
    public static WebElement select1Y;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[2]/a")
    public static WebElement bttnPassengers;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-transferspoi\"]/div/div/div/div/div[3]/div[2]/div[4]/button")
    public static WebElement transferSearchBttn;
}
