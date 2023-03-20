package com.sofkau.pages;

import com.sofkau.models.Cliente;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OutlinePage extends CommonActionOnPages{
    private WebDriver webDriver;

    @CacheLookup
    @FindBy(id = "mce-EMAIL")
    private WebElement correo;
    @CacheLookup
    @FindBy(id = "mce-FNAME")
    private WebElement name;
    @CacheLookup
    @FindBy(id = "mce-MMERGE4")
    private WebElement phone;
    private final By botonSuscribete = By.id("mc-embedded-subscribe");

    public OutlinePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegar () {
        scrollTo(correo);
    }
    public void fillMandatoryFields(String email, String nombre, String telefono) {
        typeIntoFactory(correo,email);
        typeIntoFactory(name,nombre);
        typeIntoFactory(phone,telefono);
        click(botonSuscribete);
    }
}
