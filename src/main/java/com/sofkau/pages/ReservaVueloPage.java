package com.sofkau.pages;

import com.sofkau.models.Usuario;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservaVueloPage extends CommonActionOnPages {


    private Usuario usuario;

    public static Logger LOGGER = Logger.getLogger(ReservaVueloPage.class);

    private static final String ASSERTION_EXCEPTION_MESSAGE = "No son los valores esperados";


    /**
     * Localizadores
     */

    @CacheLookup
    @FindBy(css = "i.login-incentive--close")
    private WebElement ventana;

    @CacheLookup
    @FindBy(css = "div.button-circle-icon i.shifu-icon-product.shifu-3-icon-flights")
    private WebElement vuelos;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/input")
    private WebElement inputOrigen;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[2]/div/div/input")
    private WebElement inputDestino;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[3]/span/span/label/span[1]")
    private WebElement cualquierFecha;


    @CacheLookup
    @FindBy(xpath = "(//*[@class='sbox5-flighttype-radio-container--2J-iw sbox5-oneWay-input--2ttKb'])")
    private WebElement soloIda;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class, 'item-text')])[1]")
    private WebElement SelectorConfirmacionDestino;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[3]/button/em")
    private WebElement botonBuscar;


    @CacheLookup
    @FindBy(xpath = "(//*[@class='container-next-step -eva-3-bold text-next eva-3-link -eva-3-pt-sm -eva-3-pr-sm -eva-3-pb-sm -eva-3-pl-lg'])[1]")
    private WebElement Elegirvuelo1;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[4]/span/a/em")
    private WebElement botonContinuar;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/travelers-container/travelers/old-travelers/div/ul/li/ul/li/traveler/div/div[1]/div")
    private WebElement clickAdulto;


    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/travelers-container/travelers/old-travelers/div/ul/li/ul/li/traveler/div/div[2]/div/div[1]/traveler-first-name-input/div/div/input-component-v2/div/div/div/input")
    private WebElement nombre;


    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/app[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/travelers-container[1]/travelers[1]/old-travelers[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/traveler[1]/div[1]/div[2]/div[1]/div[1]/traveler-last-name-input[1]/div[1]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement apeliido;


    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/app[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/travelers-container[1]/travelers[1]/old-travelers[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/traveler[1]/div[1]/div[2]/div[1]/div[2]/traveler-identification[1]/div[1]/div[1]/div[3]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement documento;


    @CacheLookup
    @FindBy(xpath = "//input[@id='formData.contactData.mainEmailAddress']")
    private WebElement email;


    @CacheLookup
    @FindBy(xpath = "//input[@id='formData.contactData.repeatMainEmailAddress']")
    private WebElement emailConfirmar;


    @CacheLookup
    @FindBy(xpath = "(//input[@id='formData.contactData.phones[0].number'])[1]")
    private WebElement numeroCelular;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/div[2]/payment-component/payment-method-selector/div/ul/div/payment-method-selector-radio-button-option[4]/li/p/label/i")
    private WebElement metodoPagoSuRed;


    @CacheLookup
    @FindBy(xpath = "(//em[normalize-space()='Persona natural'])[1]")
    private WebElement personaNatural;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-first-name-0\"]")
    private WebElement nombreFactura;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-last-name-0\"]")
    private WebElement apellidoFactura;


    public ReservaVueloPage(WebDriver driver, Usuario usuario) {
        super(driver);
        this.usuario = usuario;
        PageFactory.initElements(driver, this);

    }


    public void clickInicio() throws InterruptedException {
        try {
            explicitWaitInit();
            waitGeneral(ventana);
            click(ventana);
            waitGeneral(vuelos);
            click(vuelos);
            click(soloIda);

        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
        }

    }


    public void selectRuta() {
        try {
            clearText(inputOrigen);
            typeInto(inputOrigen, "MEDELLIN");
            pressEnter(inputOrigen);
            waitGeneral(inputDestino);
            click(inputDestino);
            clearText(inputDestino);
            typeInto(inputDestino, "CALI");
            //waitGeneral(inputDestino);
            //inputDestino.sendKeys("CALI", Keys.ARROW_DOWN, Keys.ENTER);
            clickcondelay(SelectorConfirmacionDestino);
            clickcondelay(cualquierFecha);
            clickcondelay(botonBuscar);
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
        }
    }


    public void selectVuelo() {
        scroll(280);
        clickcondelay(Elegirvuelo1);
        clickcondelay(botonContinuar);
    }

    public void llenarFormulario() {
        clickcondelay(clickAdulto);
        typeInto(nombre, "YEISON");
        clickcondelay(clickAdulto);
        typeInto(apeliido, "FERNEY");
        clickcondelay(clickAdulto);
        typeInto(documento, "108547895");
        scroll(500);
    }


    public void llenarCorreoNumero() {
        scroll(500);
        typeInto(email, "yeison@gmail.com");
        typeInto(emailConfirmar, "yeison@gmail.com");
        typeInto(numeroCelular, "3158954578");
        scroll(200);
        clickcondelay(metodoPagoSuRed);
        scroll(300);
    }


    public void emitirFactura() {
        scroll(500);
        clickcondelay(personaNatural);
        typeInto(nombreFactura, "YEISON1");
        scroll(200);
        typeInto(apellidoFactura, "OSORIO");

    }
}
