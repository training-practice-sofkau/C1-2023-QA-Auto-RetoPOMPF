package com.sofka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InicioSesionPage extends CommonActionOnPage{
    private WebDriver webDriver;

    private final By buttonAccess = By.xpath("(//div[contains(@class,'header-button')]/a[contains(@class,'nav-top-link')])[1]");
    private final By inputCorreo = By.id("username");
    private final By inputContrasena = By.id("password");
    private final By buttonAccess2 = By.xpath("//p[contains(@class,'form-row')]//button[contains(text(),'Acceder')]");

    public InicioSesionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void formLogin(String correo, String contrasena) {
        clickP(buttonAccess);
        clearTextP(inputCorreo);
        typeIntoP(inputCorreo, correo);
        clearTextP(inputContrasena);
        typeIntoP(inputContrasena, contrasena);
        clickP(buttonAccess2);
    }
}
