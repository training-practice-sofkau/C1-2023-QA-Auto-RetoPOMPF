package com.sofkau.pages;
import com.sofkau.models.InformacionFormularioComprarVuelo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraVueloPage extends CommonActionOnPages {

    private final InformacionFormularioComprarVuelo persona;
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

    @CacheLookup
    @FindBy(xpath = "//input[@id='traveler-identification-number-0']")
    private WebElement inputIdentificacion;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.contactData.mainEmailAddress\"]")
    private WebElement inputCorreo;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"formData.contactData.repeatMainEmailAddress\"]")
    private WebElement inputconfirmarCorreo;

    @CacheLookup
    @FindBy(xpath = "    //*[@id=\"formData.contactData.phones[0].number\"]")
    private WebElement inputNumeroCelular;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='payment-method-aligned radio-circle'])[4]")
    private WebElement selectorPagoSuRed;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"invoice-first-name-0\"]")
    private WebElement inputNombreFactura;

    @CacheLookup
    @FindBy(xpath = " (//input[@id='invoice-last-name-0'])[1]")
    private WebElement inputApellidoFactura;

    @CacheLookup
    @FindBy(xpath = " //*[@id=\"invoice-fiscal-identification-number-0\"]")
    private WebElement inputIdentificacionFactura;
    @CacheLookup
    @FindBy(xpath = " (//input[@role='presentation'])[12]")
    private WebElement inputDireccionFactura;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='checkbox-check eva-3-icon-checkmark -eva-3-mr-sm'])[1]")
    private WebElement selectorTerminosYCondiciones;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"checkout-content\"]/div[1]/buy-container/buy-component/div/div/div/div[1]/button-component/div/a")
    private WebElement botonPagarSinAsistencia;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"card-selector-0\"]/option[3]")
    private WebElement comboBox;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/app/debt-published/div/div[3]/debt-published-info/div/div/div[1]/div/span[2]")
    private WebElement mensajeConfirmacionCompra;


    public CompraVueloPage(WebDriver driver, InformacionFormularioComprarVuelo persona) {
        super(driver);
        this.persona = persona;
        PageFactory.initElements(driver, this);
    }

    public void FillMandatoryFields() {
        click(selectorBotonVuelos);
    }

    public void filtrarOrigen(String origen) {
        click(selectorOringen);
        clearText(selectorOringen);
        selectorOringen.sendKeys(origen, Keys.ARROW_DOWN);
        selectorOringen.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionOrigen);
        typeWithDelay(selectorOringen, persona.getOringen(), 30);
    }


    public void filtrarDestino(String destino) {
        click(selectorDestino);
        typeWithDelay(selectorDestino, persona.getDestino(), 30);
        click(selectorDestino);
        selectorDestino.sendKeys(destino, Keys.ARROW_DOWN);
        selectorDestino.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        clickcondelay(SelectorConfirmacionDestino);
    }


    public void seleccionarFechaIda() {
        click(selectorFechaIda);
        scroll(150);
        clickcondelay(selectorDia);
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
    }


    public void llenarFormulario() {
        clickcondelay(inputNombre1);
        typeInto(inputNombre1, persona.getNombre());
        typeInto(inputApellidos, persona.getApellido());
        clickcondelay(paisResidencia);
        typeInto(inputIdentificacion, persona.getNumeroDeIdentificacionFactura());
        typeInto(inputCorreo, persona.getCorreo());
        typeInto(inputconfirmarCorreo, persona.getCorreo());
        typeInto(inputNumeroCelular, persona.getNumeroCelular());
        scroll(200);
        clickcondelay(selectorPagoSuRed);
        clickcondelay(comboBox);
        typeInto(inputNombreFactura, persona.getNombreFactura());
        typeInto(inputApellidoFactura, persona.getApellidoFactura());
        typeInto(inputIdentificacionFactura, persona.getNumeroDeIdentificacionFactura());
        typeInto(inputDireccionFactura, persona.getDireccionFactura());
        scroll(500);
        clickcondelay(selectorTerminosYCondiciones);
        scroll(500);
        clickcondelay(botonPagarSinAsistencia);
    }

    public String CompararTexto() {
        return getText(mensajeConfirmacionCompra);
    }
}



