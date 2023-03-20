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
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/travelers-container/travelers/old-travelers/div/ul/li/ul/li/traveler/div/div[2]/div/div[1]/traveler-first-name-input/div/div/input-component-v2/div/div/div/input")
    private WebElement nombre1;


    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/app[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/travelers-container[1]/travelers[1]/old-travelers[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/traveler[1]/div[1]/div[2]/div[1]/div[1]/traveler-last-name-input[1]/div[1]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement apellido1;


    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/app[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/travelers-container[1]/travelers[1]/old-travelers[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/traveler[1]/div[1]/div[2]/div[1]/div[2]/traveler-identification[1]/div[1]/div[1]/div[3]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]")
    private WebElement documento1;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[1]/chk-email-form/chk-form-container/div/div[3]/div/chk-contact-main-email/div/chk-input/div/div/input")
    private WebElement correo1;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[1]/chk-email-form/chk-form-container/div/div[3]/div/chk-contact-repeat-main-email/div/chk-input/div/div/input")
    private WebElement correoConfirmacion1;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[2]/payment-component/payment-method-selector/div/ul/div/payment-method-selector-radio-button-option[3]/li/p/label/i")
    private WebElement celular1;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='payment-method-aligned radio-circle'])[4]")
    private WebElement medioDePago;



    //Localizadores formulario factura
    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[2]/payment-component/div/div[3]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div[3]/invoice-component/div/div[2]/div/invoice-default-component/div/div[2]/div/div[2]/div/fiscal-first-name-input/div/div/input-component-v2/div/div/div/input")
    private WebElement nombreFactura;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[2]/payment-component/div/div[3]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div[3]/invoice-component/div/div[2]/div/invoice-default-component/div/div[2]/div/div[3]/div/fiscal-last-name-input/div/div/input-component-v2/div/div/div/input")
    private WebElement apellidoFactura;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-fiscal-identification-number-0\"]")
    private WebElement nit;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/travelers-container/travelers/old-travelers/div/ul/li/ul/li/traveler/div/div[2]/div/div[1]/traveler-first-name-input/div/div/input-component-v2/div/div/div/input")
    private WebElement ciudad;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/checkout-form/div/form-component/form/div[1]/div[2]/payment-component/div/div[3]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div[3]/invoice-component/div/div[2]/div/invoice-default-component/div/address/div/div[4]/div/address-street-input/div/div/input-component-v2/div/div/div/input")
    private WebElement direccion;

    //Metodo para generar pasajeros
    public static Pasajero generarPasajero() {
        Faker faker = new Faker();

        Pasajero pasajero = new Pasajero();
        pasajero.setNombre(faker.name().firstName());
        pasajero.setApellido(faker.name().lastName());
        pasajero.setDocumento(faker.number().digits(10));
        pasajero.setCorreo(faker.internet().emailAddress());
        pasajero.setTelefono(faker.phoneNumber().cellPhone());

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
        clearText(correo1);
        typeInto(correo1, pasajero1.getCorreo());
        clearText(correoConfirmacion1);
        typeInto(correoConfirmacion1, pasajero1.getCorreo());
        scroll(800);
        clearText(celular1);
        typeInto(celular1, pasajero1.getTelefono());
        scroll(800);
    }

    Pasajero pasajero2 = generarPasajero();
    public void formularioPasajero2() {

        clearText(nombre1);
        typeInto(nombre1, pasajero1.getNombre());
        clearText(apellido1);
        typeInto(apellido1, pasajero1.getApellido());
        clearText(documento1);
        typeInto(documento1, pasajero1.getDocumento());
        scroll(800);
        clearText(correo1);
        typeInto(correo1, pasajero1.getCorreo());
        clearText(correoConfirmacion1);
        typeInto(correoConfirmacion1, pasajero1.getCorreo());
        scroll(800);
        clearText(celular1);
        typeInto(celular1, pasajero1.getTelefono());
        scroll(800);
      }
    Pasajero pasajero3 = generarPasajero();
    public void formularioPasajero3() {

        clearText(nombre1);
        typeInto(nombre1, pasajero1.getNombre());
        clearText(apellido1);
        typeInto(apellido1, pasajero1.getApellido());
        clearText(documento1);
        typeInto(documento1, pasajero1.getDocumento());
        scroll(800);
        clearText(correo1);
        typeInto(correo1, pasajero1.getCorreo());
        clearText(correoConfirmacion1);
        typeInto(correoConfirmacion1, pasajero1.getCorreo());
        scroll(800);
        clearText(celular1);
        typeInto(celular1, pasajero1.getTelefono());
        scroll(800);
    }
    public void llenarFormularioBanco(){
        clickcondelay(medioDePago);
        //clickcondelay(banco);
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

    }


}
