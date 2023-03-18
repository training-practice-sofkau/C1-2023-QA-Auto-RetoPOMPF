package com.sofkau.pages;

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


    public AlojamientosChromePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAlojamientos(){
        click(popUpInitial);
        click(botonAlojamientos);
    }
}
