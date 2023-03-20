package com.sofkau.pages;

import com.github.javafaker.Faker;
import com.sofkau.model.Usuario;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VueloFormPage extends CommonActionOnPages {

    public static Logger LOGGER = Logger.getLogger(VueloFormPage.class);
    private Usuario usuario;
    public VueloFormPage(WebDriver driver) {
        super(driver);
        this.usuario = usuario;
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
    @FindBy(xpath = "//*[@id=\"clusters\"]/span[1]/div/span/reduced-cluster/div/div/div/div/div[2]/span[3]/div/span")
    private WebElement botonContinuar;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[1]/span[2]/div/a[2]")
    private WebElement aumentarPersona;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[1]/span[2]/div/a[2]")
    private WebElement aumentarPersona1;


    @CacheLookup
    @FindBy(xpath = "/html/body/span[6]/passengers-modal/div/div[2]/span[4]/span/a")
    private WebElement continuarAlformulario;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[1]")
    private WebElement nombreAdulto1;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[2]")
    private WebElement apellidoAdulto1;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-0\"]")
    private WebElement numeroDocumento;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[3]")
    private WebElement nombreAdulto2;
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[4]")
    private WebElement apellidoAdulto2;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-1\"]")
    private WebElement numeroDocumento2;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[5]")
    private WebElement nombreAdulto3;
    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Como figura en el documento de viaje'])[6]")
    private WebElement apellidoAdulto3;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"traveler-identification-number-2\"]")
    private WebElement numeroDocumento3;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.contactData.mainEmailAddress\"]")
    private WebElement email;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.contactData.repeatMainEmailAddress\"]")
    private WebElement confirmarEmail;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.contactData.phones[0].number\"]")
    private WebElement numeroTelefono;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='payment-method-aligned radio-circle'])[4]")
    private WebElement pse;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"card-selector-0\"]/option[3]")
    private WebElement comboBox;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-first-name-0\"]")
    private WebElement nombrePersonaPago;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-last-name-0\"]")
    private WebElement apellidoPersonaPago;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-fiscal-identification-number-0\"]")
    private WebElement cedulaPersonaPago;

    @CacheLookup
    @FindBy(xpath = "(//input[@role='presentation'])[18]")
    private WebElement direccionPersonaPago;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"vamt5bykhf8tq8s8gctio\"]")
    private WebElement direccionPersa;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/buy-container/buy-component/div/agreement-component/div/ol/li/terms-checkbox-component/checkbox-component/span/div/label")
    private WebElement aceptaTerminos;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/buy-container/buy-component/div/div/div/div[1]/button-component/div/a")
    private WebElement comprarSinAistencia;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/debt-published/div/div[3]/debt-published-info/div/div/div[1]/div/span[2]")
    private WebElement mensajeFinal;
    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public WebElement cLogin;




    public void closeLogin() throws InterruptedException {
        cLogin.click();
    }
    public void fillMandatoryFields() {
        clickElement(selectorBotonVuelos);
        clearText(selectorOringen);

    }


    public void filtrarOrigen ( String destino){
        //scroll(150);
        clickElement(selectorOringen);
        typeInto(selectorOringen, "Medellin");
        clickElement(selectorOringen);
        clickElement(selectorOringen);
        clearText(selectorOringen);
        selectorOringen.sendKeys(destino,Keys.ARROW_DOWN);
        selectorOringen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionOrigen);
        clearText(selectorOringen);
    }

    public void filtrarDestino ( String destino){
        Usuario usuario1 = generarDatosUsuario();
        Usuario usuario2 = generarDatosUsuario();
        Usuario usuario3 = generarDatosUsuario();
        Usuario usuario4 = generarDatosUsuario();

        clickElement(selectorDestino);
        typeInto(selectorOringen, "Pereira");
        clickElement (selectorDestino);
        clearText(selectorDestino);
        selectorDestino.sendKeys(destino,Keys.ARROW_DOWN);
        selectorDestino.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionDestino);
        clickcondelay(cualquierFecha);
        clickcondelay(buscar);
        scroll(280);
        clickcondelay(botonContinuar);
        clickElement(aumentarPersona);
        clickElement(aumentarPersona1);
        scroll(280);
        clickcondelay(continuarAlformulario);
      //  clickElement(nombreAdulto1);
        typeWithDelay(nombreAdulto1,usuario1.nombre(),150);
        scroll(280);
        typeWithDelay(apellidoAdulto1,usuario1.apellido(),150);
        typeWithDelay(numeroDocumento, usuario1.documento(), 150);
        scroll(280);
        typeWithDelay(nombreAdulto2, usuario2.nombre(), 150);
        typeWithDelay(apellidoAdulto2, usuario2.apellido(), 150);
        scroll(280);
        typeWithDelay(numeroDocumento2, usuario2.documento(), 150);
        typeWithDelay(nombreAdulto3,usuario3.nombre(),150);
        typeWithDelay(apellidoAdulto3,usuario3.apellido(),150);
        scroll(280);
        typeWithDelay(numeroDocumento3,usuario3.documento(),150);
        scroll(600);
        typeWithDelay(email,usuario1.email(),150);
        typeWithDelay(confirmarEmail,usuario1.email(),150);
        scroll(400);
        typeWithDelay(numeroTelefono,usuario1.telefono(),150);
        scroll(280);
        clickcondelay(pse);
        scroll(400);
        clickcondelay(comboBox);
        scroll(600);
        typeWithDelay(nombrePersonaPago,usuario4.nombre(),150);
        typeWithDelay(apellidoPersonaPago,usuario4.apellido(),150);
        typeWithDelay(cedulaPersonaPago,usuario4.documento(),150);
        scroll(600);
        typeWithDelay(direccionPersonaPago,usuario4.direccion(),150);
        scroll(800);
        clickcondelay(aceptaTerminos);
        clickcondelay(comprarSinAistencia);


    }
    public static Usuario generarDatosUsuario() {
        Faker faker = new Faker();

        Usuario usuario = new Usuario();
        usuario.setNombre(faker.name().firstName());
        usuario.setApellido(faker.name().lastName());
        usuario.setDocumento(faker.number().digits(10));
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setTelefono("31" + faker.number().digits(8));
        usuario.setDireccion(faker.address().fullAddress());

        return usuario;
    }

    public String verMensajeFinal(){
        return getTextoFinal(mensajeFinal);
    }
    public void seleccionarPasajero() {
        scroll(280);
        clickcondelay(botonContinuar);
    }
}
