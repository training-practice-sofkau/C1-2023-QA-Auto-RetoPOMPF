package com.sofkau.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraVueloPage extends CommonActionOnPages {

    @CacheLookup
    @FindBy(xpath = "//a[@title='Vuelos']//div[@class='button-content']")
    private WebElement selectorBotonVuelos;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/input")
    private WebElement selectorOringen;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class, 'item-text')])[1]")
    private WebElement SelectorConfirmacionOrigen;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[2]/div/div/input")
    private WebElement selectorDestino;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class, 'item-text')])[1]")
    private WebElement SelectorConfirmacionDestino;

    @CacheLookup
    @FindBy(xpath = "//div[@class='sbox5-segments--lzKBc']//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]")
    private WebElement selectorFechaIda;
    @CacheLookup
    @FindBy(xpath = "(//div[@class='sbox5-monthgrid-datenumber -weekday'])[5]")
    private WebElement selectorDia;

    @CacheLookup
    @FindBy(xpath = " (//input[@placeholder='Vuelta'])[1]")
    private WebElement selectorFechaVuelta;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='sbox5-monthgrid-datenumber'])[7]")
    private WebElement selectorDiaRegreso;

    @CacheLookup
    @FindBy(xpath = "    (//div[@class='sbox5-monthgrid-datenumber -weekday'])[5]")
    private WebElement selectorDiaRegreso2;


    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public WebElement cLogin;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[3]/span/span/label/span[1]")
    private WebElement cualquierFecha;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[3]/button/em")
    private WebElement BotonBuscarVuelo;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"clusters\"]/span[1]/div/span/reduced-cluster/div/div/div/div/div[2]/span[3]/div/span")
    private WebElement botonSiguiente;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[4]/span/a/em")
    private WebElement botonContinuar;

    public CompraVueloPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void FillMandatoryFields() {
        click(selectorBotonVuelos);
        clearText(selectorOringen);
        click(selectorOringen);
        typeInto(selectorOringen, "Barranquilla");
    }


    public void filtrarOrigen(String destino) {
        click(selectorOringen);
        clearText(selectorOringen);
        selectorOringen.sendKeys(destino, Keys.ARROW_DOWN);
        selectorOringen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionOrigen);
    }

    public void filtrarDestino(String destino) {
        click(selectorDestino);
        typeInto(selectorOringen, "Bogota");
        click(selectorDestino);
        clearText(selectorDestino);
        selectorDestino.sendKeys(destino, Keys.ARROW_DOWN);
        selectorDestino.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionDestino);
    }


    public void seleccionarFechaIda() {
        click(selectorFechaIda);
        scroll(150);
        clickcondelay(selectorDia);
        System.out.println(" Imprime pls ");
        click(selectorDiaRegreso);
        click(selectorFechaVuelta);
        scroll(150);
        click(selectorDiaRegreso2);

    }

    public void closeLogin() throws InterruptedException {
        cLogin.click();
    }

    public void clickCualquierFecha() {
        clickcondelay(cualquierFecha);
    }

    public void clickBotonBuscarVuelo() {
        clickcondelay(BotonBuscarVuelo);
    }

    public void seleccionarPasajeros()  {
        scroll(230);
        clickcondelay(botonSiguiente);
        clickcondelay(botonContinuar);
        //Thread.sleep(5000);


    }
}
