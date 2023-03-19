package com.sofkau.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlojamientosChromePage extends CommonActionsOnPages{

    @CacheLookup
    @FindBy(xpath = "//i[contains(@class, 'login-incentive--close') and contains(@class, 'shifu-3-icon-close') and contains(@class, '-eva-3-mr-md')]")
    private WebElement popUpInitial;

    @CacheLookup
    @FindBy(xpath = "//label[@class='button-circle-label' and text()='Alojamientos']")
    private WebElement botonAlojamientos;

    @CacheLookup
    @FindBy(xpath = "//input[@type='text' and @class='input-tag' and contains(@placeholder, 'Ingresa una ciudad')]")
    private WebElement fieldDestiny;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class, 'item-text')])[1]")
    private WebElement destinyDefinied;

    @CacheLookup
    @FindBy(xpath = "//input[@type='text' and @class='input-tag' and contains(@placeholder, 'Entrada')]")
    private WebElement labelDateEntry;

    @CacheLookup
    @FindBy(xpath = "//div[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-31']//div[@class='sbox5-monthgrid-datenumber -weekday -today']")
    private WebElement labelDateselected;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='sbox5-monthgrid-datenumber']/div[@class='sbox5-monthgrid-datenumber-number'])[30]")
    private WebElement labelDateExit;

    @CacheLookup
    @FindBy(xpath = "(//button[contains(@class, 'sbox5-3-btn') and contains(@class, '-primary') and contains(@class, '-md') and em[@class='btn-text' and text()='Aplicar']])[2]")
    private WebElement buttonAplicar;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='sbox5-3-first-input-wrapper']//input[@class='sbox5-3-first-input'])[2]")
    private WebElement habitaSelector;

    @CacheLookup
    @FindBy(xpath = "(//a[@class='sbox5-3-btn -md -link']//em[@class='btn-text'])[2]")
    private WebElement addHabitacion;


    public AlojamientosChromePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAlojamientos(){
        click(popUpInitial);
        click(botonAlojamientos);
    }

    public void fillDestiny(String value){
        click(fieldDestiny);
        fieldDestiny.sendKeys(value, Keys.ARROW_DOWN);
        fieldDestiny.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickwithDelay(destinyDefinied);
    }

    public void fillDateEntry(){
        click(labelDateEntry);
        scrollDown(150);
        clickwithDelay(labelDateselected);
    }

    public void fillDateExit(){
        clickwithDelay(labelDateExit);
        clickwithDelay(buttonAplicar);
    }

    public void selectHabitaciones(){
        clickwithDelay(habitaSelector);
        clickwithDelay(addHabitacion);
    }
}
