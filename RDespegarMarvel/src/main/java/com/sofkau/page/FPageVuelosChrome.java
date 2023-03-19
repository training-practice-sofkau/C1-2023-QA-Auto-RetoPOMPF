package com.sofkau.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FPageVuelosChrome extends CommonActionOnPage {


    //Constructor
    public FPageVuelosChrome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private final By selectorIda = By.xpath("//span[text()='Solo ida']");
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public WebElement cLogin;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"header\"]/nav/div[2]/div/div[3]/ul/li[2]/a/div/div/i")
    public WebElement vuelos;

    @CacheLookup
    @FindBy (xpath="//a[@title='Vuelos']//div[@class='button-content']")
    private WebElement selectorBotonVuelos;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[1]/div/div/div/select/optgroup[1]/option[3]")
    public WebElement menu;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div")
    public WebElement calendario;

    @CacheLookup
    @FindBy(xpath = "//div[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-31']/html/body/div[8]/div[1]/div[1]/div[2]/div[1]/div[3]/div[18]")
    public WebElement fechaInicio;

    @CacheLookup
    @FindBy (xpath= "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/input")
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
    private WebElement buscarVuelo;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"clusters\"]/span[1]/div/span/reduced-cluster/div/div/div/div/div[2]/span[3]/div/span")
    private WebElement botonSiguiente;

    @CacheLookup
    @FindBy(xpath = "/html/body/span[6]/passengers-modal/div/div[2]/span[4]/span/a/em")
    private WebElement botonContinuar;


    @CacheLookup
    @FindBy(id = "#formData\\.travelers\\[0\\]\\.firstName")
    private WebElement nombrePasajero;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"t48d4enq3zojpun80zwgr\"]")
    private WebElement apellidoPasajero;

    private final By name = By.id("yigu8lbrc9bb8zveey2uwd");





    private final By inicio = By.xpath("(//div[@class='sbox5-monthgrid-datenumber-number'][normalize-space()='18'])[1]");

    public void closeLogin() throws InterruptedException {
        Thread.sleep(200);
        cLogin.click();
    }
    public void selectedPage() throws InterruptedException  {
        selectorBotonVuelos.click();
    }
    public void fillAssistanceForm(){
        menu.click();
        calendario.click();
        scroll(250);
        clickwithDelay(fechaInicio);
        fechaInicio.click();
        pressEnter(inicio);
        System.out.println("hola mundo");
        getText(fechaInicio);
        System.out.println(getText(fechaInicio));
    }

    public void fillMandatoryFields(){

    }
    public void filtrarOrigen ( String destino){
        click(selectorOringen);
        clearText(selectorOringen);
        selectorOringen.sendKeys(destino, Keys.ARROW_DOWN);
        selectorOringen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionOrigen);
    }

    public void filtrarDestino ( String destino) throws InterruptedException {
        click(selectorDestino);
        typeInto(selectorOringen, "Bogota");
        click (selectorDestino);
        clearText(selectorDestino);
        selectorDestino.sendKeys(destino,Keys.ARROW_DOWN);
        selectorDestino.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);



    }
    public void seleccionarVuelo() throws InterruptedException {
        clickcondelay(SelectorConfirmacionDestino);
        clickcondelay(cualquierFecha);
        clickcondelay(buscarVuelo);
        scroll(280);
        clickcondelay(botonSiguiente);
        clickcondelay(botonContinuar);
        Thread.sleep(12000);

    }

    public void llenarFormulario(String nombre){
    clearText(nombrePasajero);
    typeInto(nombrePasajero, nombre);
    clearTextl(name);
    typeIntol(name, "Yoli");


    }

}
