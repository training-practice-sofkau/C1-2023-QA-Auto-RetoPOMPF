package com.sofka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InicioSesionPage extends CommonActionOnPage{
    private WebDriver webDriver;

    public InicioSesionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
