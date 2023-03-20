package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonActionOnPages{
    private WebDriver webDriver;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //localizadores
    private final By botonAcceder = By.xpath("(//span[contains(text(),'Acceder')])[1]");
    private final By usuarios = By.xpath("(//input[@id='username'])[1]");
    private final By passwords = By.xpath("(//input[@id='password'])[1]");
    private final By botonIniciarSesion = By.xpath("(//button[normalize-space()='Acceder'])[1]");
    private final By header = By.xpath("//span[@class='header-account-title']");

    @CacheLookup
    @FindBy(id = "username")
    private WebElement usuario;

    @CacheLookup
    @FindBy(id = "password")
    private WebElement password;

    public void navegar() {
        click(botonAcceder);
    }

    public void acceder() {
        typeIntoPOM(usuarios,"baremi2221@asoflex.com");
        typeIntoPOM(passwords,"prueba123");
        click(botonIniciarSesion);
    }

    public void accederInvalido() {
        typeIntoPOM(usuarios,"baremi2221@asoflex.com");
        typeIntoPOM(passwords,"prueba321");
        click(botonIniciarSesion);
    }


}
