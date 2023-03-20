package com.sofkau.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AsistenciasPage extends CommonActions {

    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public static WebElement closePopUp;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[1]/div/div/div/select")
    public static WebElement assistDestination;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[1]/div/div/div/select/optgroup[1]/option[2]")
    public static WebElement assistDestinationLoc;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div/div/input")
    public static WebElement assistDateD;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/input")
    public static WebElement assistDateR;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/a[2]")
    public static WebElement rightArrowDate;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[10]")
    public static WebElement initDate;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[12]")
    public static WebElement endDate;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button")
    public static WebElement bttnDate;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[3]/div/div/div/div/input")
    public static WebElement passengers;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[1]/div[2]/div/button[2]")
    public static WebElement plusPassengers;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[2]/a")
    public static WebElement bttnPassengers;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[4]/button")
    public static WebElement assistSearchBttn;

    public AsistenciasPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void closePopUp() {
        click(closePopUp);
    }

    public void selectDestination() {
        click(assistDestination);
    }

    public void selectDestinationLoc() {
        click(assistDestinationLoc);
    }

    public void selectDDate() {
        delayClick(assistDateD);
    }

    public void selectRDate() {
        delayClick(assistDateR);
    }

    public void selectOct() {
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
        delayClick(rightArrowDate);
    }

    public void selectDDay() {
        delayClick(initDate);
    }

    public void selectRDay() {
        delayClick(endDate);
    }

    public void applyDate() {
        scroll(300);
        delayClick(bttnDate);
    }

    public void selectPassengers() {
        delayClick(passengers);
    }

    public void increasePassengers() {
        delayClick(plusPassengers);
        delayClick(plusPassengers);
    }

    public void applyPassengers() {
        delayClick(bttnPassengers);
    }

    public void searchAssist() {
        delayClick(assistSearchBttn);
    }

    public void setupAssistPage() {
        closePopUp();
        selectDestination();
        selectDestinationLoc();
        selectDDate();
        selectOct();
        selectDDay();
        selectRDate();
        selectRDay();
        applyDate();
        selectPassengers();
        increasePassengers();
        applyPassengers();
        searchAssist();
    }
}