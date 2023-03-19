package com.sofkau.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class VueloFormPage extends CommonActionOnPages {
    public VueloFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
//span[contains(@class, 'item-text')])[1]
    //private final By selectVuelo = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[2]/div/div[1]/button");

    public WebElement cierreventana;
    @CacheLookup
    @FindBy (xpath="//a[@title='Vuelos']//div[@class='button-content']")
    private WebElement selectorBotonVuelos;

    @CacheLookup
    @FindBy (xpath="//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/input")
    private WebElement selectorOringen;

    @CacheLookup
    @FindBy (xpath="(//span[contains(@class, 'item-text')])[1]")
    private WebElement SelectorConfirmacionOrigen;

    @CacheLookup
    @FindBy (xpath="//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[2]/div/div/input")
    private WebElement selectorDestino;

    @CacheLookup
    @FindBy  (xpath="(//span[contains(@class, 'item-text')])[1]")
    private WebElement SelectorConfirmacionDestino;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[3]/span/span/label/span[1]")
    private WebElement cualquierFecha;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[3]/button/em")
    private WebElement buscar;


    @CacheLookup
    @FindBy(xpath = "(//*[@class='container-next-step -eva-3-bold text-next eva-3-link -eva-3-pt-sm -eva-3-pr-sm -eva-3-pb-sm -eva-3-pl-lg'])[1]")
    private WebElement vuelo;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[4]/span/a/em")
    private WebElement botonContinuar;


    @CacheLookup
    @FindBy (xpath="//div[@class='sbox5-segments--lzKBc']//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]")
    private WebElement selectorFechaIda;
    @CacheLookup
    @FindBy (xpath="(//div[@class='sbox5-monthgrid-datenumber -weekday'])[5]")
    private WebElement selectorDia;

    @CacheLookup
    @FindBy (xpath=" (//input[@placeholder='Vuelta'])[1]")
    private WebElement selectorFechaVuelta;

    @CacheLookup
    @FindBy (xpath="(//div[@class='sbox5-monthgrid-datenumber'])[7]")
    private WebElement selectorDiaRegreso;

    @CacheLookup
    @FindBy (xpath="    (//div[@class='sbox5-monthgrid-datenumber -weekday'])[5]")
    private WebElement selectorDiaRegreso2;


    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public WebElement cLogin;

    public void closeLogin() throws InterruptedException {
        cLogin.click();
    }
    public void fillMandatoryFields() {
        clickElement(selectorBotonVuelos);
        clearText(selectorOringen);
        clickElement(selectorOringen);
        typeInto(selectorOringen, "Barranquilla");
    }

    public void seleccionarFechaIda (){
       // clickElement(selectorFechaIda);
        scroll(150);
        clickcondelay(selectorDia);
        System.out.println(" Imprime pls " );
        clickElement(selectorDiaRegreso);
        clickElement (selectorFechaVuelta);
        scroll(150);
        clickElement(selectorDiaRegreso2);

    }

    public void filtrarOrigen ( String destino){
        clickElement (selectorOringen);
        clearText(selectorOringen);
        selectorOringen.sendKeys(destino,Keys.ARROW_DOWN);
        selectorOringen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionOrigen);
    }

    public void filtrarDestino ( String destino){
        clickElement(selectorDestino);
        typeInto(selectorOringen, "Medellin");
        clickElement (selectorDestino);
        clearText(selectorDestino);
        clickcondelay(cualquierFecha);
        clickcondelay(buscar);
        selectorDestino.sendKeys(destino,Keys.ARROW_DOWN);
        selectorDestino.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionDestino);
    }
    public void seleccionarPasajero() {
        scroll(280);
        clickcondelay(botonContinuar);
    }
}
