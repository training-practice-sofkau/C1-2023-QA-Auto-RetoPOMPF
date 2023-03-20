package com.sofka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InicioSesionPage extends CommonActionOnPage{
    private WebDriver webDriver;

    @CacheLookup
    @FindBy(xpath="(//div[contains(@class,'header-button')]/a[contains(@class,'nav-top-link')])[1]")
    private WebElement buttonAccess;

    @CacheLookup
    @FindBy(id="username")
    private WebElement inputCorreo;

    @CacheLookup
    @FindBy(id="password")
    private WebElement inputContrasena;

    private final By buttonAccess2 = By.xpath("//p[contains(@class,'form-row')]//button[contains(text(),'Acceder')]");

    private final By message = By.xpath("//div[contains(@class,'page-wrapper')]//div[contains(@class,'woocommerce-notices-wrapper')]");

    public InicioSesionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void formLogin(String correo, String contrasena) {
        clickElementF(buttonAccess);
        clearTextF(inputCorreo);
        typeIntoF(inputCorreo, correo);
        clearTextF(inputContrasena);
        typeIntoF(inputContrasena, contrasena);
        pressSpaceP(buttonAccess2);
    }

    public WebElement getConfirmationMessage (WebDriver webDriver){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message));
    }
}
