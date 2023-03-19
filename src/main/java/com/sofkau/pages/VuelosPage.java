package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VuelosPage extends CommonActionsOnPages{

    @CacheLookup
    @FindBy(xpath = "//i[contains(@class, 'login-incentive--close') and contains(@class, 'shifu-3-icon-close') and contains(@class, '-eva-3-mr-md')]")
    private WebElement popUpInitial;

    private By iconFlights = By.xpath("//div[@class='button-content' and contains(label, 'Vuelos')]");

    private By originField = By.xpath("(//input[contains(@placeholder, 'Ingresa desde d')])[1]");

    private By citySelected = By.xpath("//ul[@class='ac-group-items']/li[@class='item -active']/span[@class='item-text']");

    private By destinyField = By.xpath("(//input[contains(@placeholder, 'Ingresa hacia d')])[1]");

    @CacheLookup
    @FindBy(xpath = "//span[@class='switch-circle']")
    private WebElement switchCheap;

    private By btnBuscar = By.xpath("//button[@class='sbox5-box-button-ovr--3LK5x sbox5-3-btn sbox5-button -secondary -icon -lg']");

    private By btnSiguiente = By.xpath("(//span[text()='Siguiente'])[1]");

    private By btnPlus = By.xpath("(//a[@class='steppers-icon-right eva-3-icon-plus'])[1]");
    private By btnContinuar = By.xpath("//em[@class= 'btn-text' and text()='Continuar']");
    //
    //////////////////
    @CacheLookup
    @FindBy(xpath = "//input[@type='text' and @class='input-tag' and contains(@placeholder, 'Ingresa una ciudad')]")
    private WebElement fieldDestiny;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class, 'item-text')])[1]")
    private WebElement destinyDefinied;


    @CacheLookup
    @FindBy(xpath = "//input[@type='text' and @class='input-tag' and contains(@placeholder, 'Entrada')]")
    private WebElement labelDateEntry;

    /*
    @CacheLookup
    @FindBy(xpath = "//div[@class='sbox5-monthgrid-dates sbox5-monthgrid-dates-31']//div[@class='sbox5-monthgrid-datenumber -weekday -today']")
    private WebElement labelDateselected;
*/
    @CacheLookup
    @FindBy(xpath = "(//div[@class='sbox5-monthgrid-datenumber']/div[@class='sbox5-monthgrid-datenumber-number'])[30]")
    private WebElement labelDateExit;

    @CacheLookup
    @FindBy(xpath = "(//button[contains(@class, 'sbox5-3-btn') and contains(@class, '-primary') and contains(@class, '-md') and em[@class='btn-text' and text()='Aplicar']])[2]")
    private WebElement buttonAplicar;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='sbox5-3-first-input-wrapper']//input[@class='sbox5-3-first-input'])[2]")
    private WebElement habitaSelector;

    @CacheLookup
    @FindBy(xpath = "(//a[@class='sbox5-3-btn -md -link']//em[@class='btn-text'])[2]")
    private WebElement addHabitacion;

    @CacheLookup
    @FindBy(xpath = "(//*[@id='svg-minus-29Ddhw5'])[5]")
    private WebElement botonMenos;


    public VuelosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToVuelos() throws InterruptedException {
        click(popUpInitial);
        click(iconFlights);
        Thread.sleep(1000);
    }

    public void selectOriginDestiny(String origin, String destiny){
        clickwithDelay(originField);
        clearText(originField);
        fillFieldsSlows(originField, origin);
        clickwithDelay(citySelected);
        clickwithDelay(destinyField);
        clearText(destinyField);
        fillFieldsSlows(destinyField, destiny);
        clickwithDelay(citySelected);
    }

    public void buscarVuelo(){
        click(switchCheap);
        click(btnBuscar);
        scrollDown(160);
        click(btnSiguiente);
        clickwithDelay(btnPlus);
        clickwithDelay(btnContinuar);
    }

    public void fillDestiny(String value){
        click(fieldDestiny);
        fieldDestiny.sendKeys(value, Keys.ARROW_DOWN);
        fieldDestiny.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickwithDelay(destinyDefinied);
    }

    public void fillDateEntry() throws InterruptedException {
        click(labelDateEntry);
        scrollDown(150);
        Thread.sleep(5000);
        //click(dateinicial);
    }

    public void fillDateExit() throws InterruptedException {
        clickwithDelay(labelDateExit);
        Thread.sleep(5000);
        clickwithDelay(buttonAplicar);
    }

    public void selectHabitaciones(){
        clickwithDelay(habitaSelector);
        clickwithDelay(addHabitacion);
        clickwithDelay(botonMenos);
    }
}
