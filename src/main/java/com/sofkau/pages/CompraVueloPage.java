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

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/travelers-container/travelers/old-travelers/div/ul/li/ul/li/traveler/div/div[2]/div/div[1]/traveler-first-name-input/div/div/input-component-v2/div/div/div/input")
    private WebElement inputNombre1;

    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/app[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/travelers-container[1]/travelers[1]/old-travelers[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/traveler[1]/div[1]/div[2]/div[1]/div[1]/traveler-last-name-input[1]/div[1]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement inputApellidos;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.travelers[0].nationality\"]/div/div/label")
    private WebElement paisResidencia;

    public CompraVueloPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void FillMandatoryFields() {
        click(selectorBotonVuelos);
        clearText(selectorOringen);
        click(selectorOringen);
        typeInto(selectorOringen, "Guajira");
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

    public void seleccionarPasajeros() {
        scroll(230);
        clickcondelay(botonSiguiente);
        clickcondelay(botonContinuar);
        //Thread.sleep(5000);
    }


    public void llenarFormulario() {
        clickcondelay(inputNombre1);
        typeInto(inputNombre1, "Santy");
        typeInto(inputApellidos, "Gomez");
    }


}
