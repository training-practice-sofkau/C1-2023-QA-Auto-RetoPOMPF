package com.sofkau.pages;

import com.github.javafaker.Faker;
import com.sofkau.models.Usuario;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservaConEscala extends CommonActionOnPages {


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
    @FindBy(xpath = "//*[@id=\"clusters\"]/span/div/span/cluster/div/div/div[2]/fare/span/span/div/buy-button/a/div/em")
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
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/input")
    private WebElement selectorOringen;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-last-name-0\"]")
    private WebElement apellidoFactura;


    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class, 'item-text')])[1]")
    private WebElement SelectorConfirmacionOrigen;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='invoice-fiscal-identification-number-0'])[1]")
    private WebElement documentoFactura;


    @CacheLookup
    @FindBy(xpath = "(//input[@role='presentation'])[18]")
    private WebElement direccionFactura;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/buy-container/buy-component/div/agreement-component/div/ol/li/terms-checkbox-component/checkbox-component/span/div/label")
    private WebElement aceptaTerminos;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/buy-container/buy-component/div/div/div/div[1]/button-component/div/a")
    private WebElement comprarSinAistencia;


    @CacheLookup
    @FindBy(xpath = "//span[@class='eva-3-h3 cash-title' and text()='¡Genial! Ahora solo te falta realizar el pago.']")
    private WebElement mensajeFinal;


    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[3]")
    private WebElement nombreUsuario2;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[4]")
    private WebElement apellidoUsuario2;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-1\"]")
    private WebElement documentoUsuario2;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[5]")
    private WebElement nombreUsuario3;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[6]")
    private WebElement apellidoUsuario3;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-2\"]")
    private WebElement documentoUsuario3;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[1]/span[2]/div/a[2]")
    private WebElement adultoMas;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='payment-method-aligned radio-circle'])[4]")
    private WebElement pse;


    @CacheLookup
    @FindBy(xpath = "(//i[@class='checkbox-check eva-3-icon-checkmark -eva-3-mr-sm'])[1]")
    private WebElement selectorTerminosYCondiciones;

    @CacheLookup
    @FindBy(xpath = "//*[@id='card-selector-0']")
    private WebElement comboBox;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div/div/input")
    public static WebElement fechaPartida;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/input")
    public static WebElement fechaLlegada;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/a[2]")
    public static WebElement correrDerecha;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[10]")
    public static WebElement fechaInicial;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[12]")
    public static WebElement fechaFinal;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button")
    public static WebElement botonFecha;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"filter-stops\"]/li/ul/div/checkbox-filter/checkbox-filter-item[4]/li/span/span[1]/span/label/i")
    public static WebElement escala;

    public ReservaConEscala(WebDriver driver, Usuario usuario) {
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
            click(inputOrigen);
            clearText(inputOrigen);
            inputOrigen.sendKeys("MEDELLIN", Keys.ARROW_DOWN);
            inputOrigen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            clickcondelay(SelectorConfirmacionOrigen);
            click(inputDestino);
            clearText(inputDestino);
            typeWithDelay(inputDestino, "MADRID", 350);
            clickcondelay(SelectorConfirmacionDestino);
            clickcondelay(cualquierFecha);
            clickcondelay(botonBuscar);
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
        }
    }


    public void selectVuelo() {
        scroll(700);
        clickcondelay(escala);
        clickcondelay(Elegirvuelo1);
        clickcondelay(adultoMas);
        clickcondelay(adultoMas);
        clickcondelay(botonContinuar);
        scroll(500);
    }


    public void llenarFormulario() {

        Usuario usuario1 = llenarJavaFaker();
        Usuario usuario2 = llenarJavaFaker();
        Usuario usuario3 = llenarJavaFaker();

        clickcondelay(clickAdulto);
        typeInto(nombre, usuario1.getNombre());
        clickcondelay(clickAdulto);
        typeInto(apeliido, usuario1.getApellido());
        clickcondelay(clickAdulto);
        typeInto(documento, usuario1.getDocumento());
        scroll(300);

        clickcondelay(clickAdulto);
        typeInto(nombreUsuario2, usuario2.getNombre());
        clickcondelay(clickAdulto);
        typeInto(apellidoUsuario2, usuario2.getApellido());
        clickcondelay(clickAdulto);
        typeInto(documentoUsuario2, usuario2.getDocumento());
        scroll(300);

        clickcondelay(clickAdulto);
        typeInto(nombreUsuario3, usuario3.getNombre());
        clickcondelay(clickAdulto);
        typeInto(apellidoUsuario3, usuario3.getApellido());
        clickcondelay(clickAdulto);
        typeInto(documentoUsuario3, usuario3.getDocumento());
        scroll(300);


    }


    public static Usuario llenarJavaFaker() {

        Faker faker = new Faker();
        Usuario usuario = new Usuario();
        usuario.setNombre(faker.name().firstName());
        usuario.setApellido(faker.name().lastName());
        usuario.setDocumento(String.valueOf(faker.number().randomNumber(8, true)));
        usuario.setCorreo(faker.internet().emailAddress());
        usuario.setDireccion(faker.address().fullAddress());
        usuario.setNumero(String.valueOf(Integer.parseInt(String.valueOf(faker.number().randomNumber(8, true)))));
        return usuario;
    }


    public void llenarCorreoNumero() {

        Usuario correoNumero = llenarJavaFaker();

        scroll(500);
        typeInto(email, correoNumero.getCorreo());
        //typeInto(email, "joer@gmail.com");
        typeInto(emailConfirmar, correoNumero.getCorreo());
        typeInto(numeroCelular, correoNumero.getNumero());
        scroll(200);
        clickcondelay(pse);
        scroll(200);
        selectComboox(comboBox);
        scroll(300);
    }


    public void emitirFactura() {

        Usuario usuarioFactura = llenarJavaFaker();
        scroll(500);
        clickcondelay(personaNatural);
        typeInto(nombreFactura, usuarioFactura.getNombre());
        scroll(200);
        typeInto(apellidoFactura, usuarioFactura.getApellido());
        clickcondelay(clickAdulto);
        typeInto(documentoFactura, usuarioFactura.getDocumento());
        scroll(300);
        typeInto(direccionFactura, usuarioFactura.getDireccion());
        scroll(900);
        clickcondelay(aceptaTerminos);
        clickcondelay(comprarSinAistencia);

    }
    //click(banco);

    //  for(int i = 0; i < 3; i++) {
    //banco.sendKeys(Keys.ARROW_DOWN);
    //}

    //enter(banco);


    public String getTextoFinal() {
        return getTextoFinal(mensajeFinal);
    }

}
