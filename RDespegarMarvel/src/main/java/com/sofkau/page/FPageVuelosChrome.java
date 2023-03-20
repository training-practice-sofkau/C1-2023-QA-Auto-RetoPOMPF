package com.sofkau.page;

import com.github.javafaker.Faker;
import com.sofkau.model.Pasajero;
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
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[1]/span[2]/div/a[2]")
    private WebElement incrementarAdulto;

    @CacheLookup
    @FindBy(xpath = "/html/body/span[6]/passengers-modal/div/div[2]/span[4]/span/a/em")
    private WebElement botonContinuar;

    @CacheLookup
    @FindBy(id = "#formData\\.travelers\\[0\\]\\.firstName")
    private WebElement nombrePasajero;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"t48d4enq3zojpun80zwgr\"]")
    private WebElement apellidoPasajero;
    private final By inicio = By.xpath("(//div[@class='sbox5-monthgrid-datenumber-number'][normalize-space()='18'])[1]");


    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[1]")
    private WebElement nombre1;


    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[2]")
    private WebElement apellido1;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-0\"]")
    private WebElement documento1;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[3]")
    private WebElement nombre2;


    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[4]")
    private WebElement apellido2;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-1\"]")
    private WebElement documento2;

    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[5]")
    private WebElement nombre3;


    @CacheLookup
    @FindBy(xpath = "(//*[@placeholder='Como figura en el documento de viaje'])[6]")
    private WebElement apellido3;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-2\"]")
    private WebElement documento3;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[1]/chk-email-form/chk-form-container/div/div[3]/div/chk-contact-main-email/div/chk-input/div/div/input")
    private WebElement correo;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[1]/chk-email-form/chk-form-container/div/div[3]/div/chk-contact-repeat-main-email/div/chk-input/div/div/input")
    private WebElement correoConfirmacion;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/contact-phone-container/div/chk-phone-form/chk-form-container/div/div[2]/div/chk-form/div/div/div[2]/chk-contact-phone-number/div/chk-input/div/div/input")
    private WebElement celular;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='payment-method-aligned radio-circle'])[4]")
    private WebElement medioDePago;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[2]/payment-component/div/div[4]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div[1]/cash-container/div/ul/li/div/cash-payment-info/div[1]/div/cash-select/div/div/div/div/div/select")
    private WebElement banco;


    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[2]/payment-component/div/div[4]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div[1]/cash-container/div/ul/li/div/cash-payment-info/div[1]/div/cash-select/div/div/div/div/div/select/option[3]")
    private WebElement bancoSeleccionado;



    //Localizadores formulario factura
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-first-name-0\"]")
    private WebElement nombreFactura;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-last-name-0\"]")
    private WebElement apellidoFactura;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-fiscal-identification-number-0\"]")
    private WebElement nit;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/travelers-container/travelers/old-travelers/div/ul/li/ul/li/traveler/div/div[2]/div/div[1]/traveler-first-name-input/div/div/input-component-v2/div/div/div/input")
    private WebElement ciudad;

    @CacheLookup
    @FindBy(xpath = "//input[@class=\"input-tag invoice-fiscal-address-street ng-untouched ng-pristine ng-invalid\"]\n")
    private WebElement direccion;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='checkbox-check eva-3-icon-checkmark -eva-3-mr-sm'])[1]")
    private WebElement sTerminosYCondiciones;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/buy-container/buy-component/div/div/div/div[1]/button-component/div/a/em[1]")
    private WebElement botonComprar;



    //Método para generar pasajeros
    public static Pasajero generarPasajero() {
        Faker faker = new Faker();
        Pasajero pasajero = new Pasajero();
        pasajero.setNombre(faker.name().firstName());
        pasajero.setApellido(faker.name().lastName());
        pasajero.setDocumento(faker.number().digits(10));
        pasajero.setCorreo(faker.internet().emailAddress());
        pasajero.setTelefono(faker.number().digits(10));
        return pasajero;
    }


    //Métodos
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


    public void filtrarOrigen ( String destino){
        click(selectorOringen);
        clearText(selectorOringen);
        selectorOringen.sendKeys(destino, Keys.ARROW_DOWN);
        selectorOringen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionOrigen);
    }

    public void filtrarDestino ( String destino) throws InterruptedException {
        click(selectorDestino);
        typeInto(selectorOringen, destino);
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
        clickcondelay(incrementarAdulto);
        clickcondelay(incrementarAdulto);
        clickcondelay(botonContinuar);
        Thread.sleep(12000);
    }
    Pasajero pasajero1 = generarPasajero();
    public void formularioPasajero1() {

        clearText(nombre1);
        typeInto(nombre1, pasajero1.getNombre());
        clearText(apellido1);
        typeInto(apellido1, pasajero1.getApellido());
        clearText(documento1);
        typeInto(documento1, pasajero1.getDocumento());
        scroll(800);

    }

    Pasajero pasajero2 = generarPasajero();
    public void formularioPasajero2() {

        clearText(nombre2);
        typeInto(nombre2, pasajero2.getNombre());
        clearText(apellido2);
        typeInto(apellido2, pasajero2.getApellido());
        clearText(documento2);
        typeInto(documento2, pasajero2.getDocumento());
        scroll(800);
      }
    Pasajero pasajero3 = generarPasajero();
    public void formularioPasajero3() {

        clearText(nombre3);
        typeInto(nombre3, pasajero3.getNombre());
        clearText(apellido3);
        typeInto(apellido3, pasajero3.getApellido());
        clearText(documento3);
        typeInto(documento3, pasajero3.getDocumento());
        scroll(800);
    }
    public void formularioContacto(){
        clearText(correo);
        typeInto(correo, pasajero3.getCorreo());
        clearText(correoConfirmacion);
        typeInto(correoConfirmacion, pasajero3.getCorreo());
        scroll(800);
        clearText(celular);
        typeInto(celular, pasajero3.getTelefono());
        scroll(800);

    }
    public void llenarFormularioBanco(){
        clickcondelay(medioDePago);
        clickcondelay(banco);
        clickcondelay(bancoSeleccionado);
        scroll(800);
    }

    public void llenarFormularioFactura(){

        clearText(nombreFactura);
        typeInto(nombreFactura, pasajero1.getNombre() );
        clearText(apellidoFactura);
        typeInto(apellidoFactura,pasajero1.getApellido());
        clearText(nit);
        typeInto(nit, pasajero1.getDocumento());
        scroll(800);
        clearText(direccion);
        typeInto(direccion, "cr 2a 45-29");
    }

    public void confirmarPago(){
        scroll(800);
        clickcondelay(sTerminosYCondiciones);
        //clickcondelay(botonComprar);

    }


}
