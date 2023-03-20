package com.sofkau.pages;

import com.sofkau.models.FormModel;
import com.sofkau.pages.common.CommonActionPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlujoCompra extends CommonActionPages {


    public final FormModel formModel;
    private WebDriver webDriver;

    @CacheLookup
    @FindBy(xpath = "(//a[@class='dashicons-heart mega-menu-link'])[2]")
    private WebElement outlet;
    private final By anadirProducto1 = By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[7]");

    private final By anadirProducto2 = By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[2]");

    private final By anadirProducto3 = By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[3]");

    private final By anadirAlCarrrito = By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[1]");

    private final By xcarrito = By.xpath("(//button[@class='mfp-close'])");

    private final By pagPrincipal = By.xpath("(//img[@class='header-logo-dark'])[1]");
    private final By cantidad1 = By.xpath("(//input[@value='+'])[1]");
    private final By cantidad2 = By.xpath("(//input[@value='+'])[2]");
    private final By cantidad3 = By.xpath("(//input[@value='+'])[3]");

    @CacheLookup
    @FindBy(xpath = "(//a[@class='button wc-forward wp-element-button'])[1]")
    private WebElement carrito;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div[2]/div[2]/div/div[1]/div/a")
    private WebElement finalizarCompra;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='billing_myfield12'])[1]")
    private WebElement numeroDeDocumento;

    @CacheLookup
    @FindBy(id = "billing_email")
    private WebElement e_Mail;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='billing_first_name'])[1]")
    private WebElement nombre;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='billing_last_name'])[1]")
    private WebElement apellido;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"billing_state_field\"]/span/span/span[1]/span")
    private WebElement seleccionBotondepartamento;

    @CacheLookup
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement departamento;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"select2-billing_state-results\"]")
    private WebElement seleccionDepartamento;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"select2-billing_city-container\"]")
    private WebElement seleccionBotonCiudad;

    @CacheLookup
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement ciudad;
    @CacheLookup
    @FindBy(xpath = "/html/body/span/span/span[2]")
    private WebElement seleccionCiudad;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='billing_address_1'])[1]")
    private WebElement direccion;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='billing_address_2'])[1]")
    private WebElement apartamento;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='billing_phone'])[1]")
    private WebElement numeroCelular;

    @CacheLookup
    @FindBy(xpath = "(//label)[1]")
    private WebElement baloto;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"terms\"]")
    private WebElement terminosCondiciones;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"place_order\"]")
    private WebElement realizarPedido;


    @CacheLookup
    @FindBy(xpath = "(//span)[20]")
    private WebElement ConfirmarCompra;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='payment_method_woo-mercado-pago-basic'])")
    private WebElement tarjetas;

    @CacheLookup
    @FindBy(xpath = "(//label[@for='efecty'])[1]")
    private WebElement botonEfecty;

    @CacheLookup
    @FindBy(xpath = "//a[@class='andes-button andes-button--link button-link']")
    private WebElement VolverSitio;

    //Validacion
    private static final By confirmacionPedido = By.xpath("//*[@id=\"main\"]/div[2]/div/div");

    public FlujoCompra(FormModel formModel, WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.formModel = formModel;
        PageFactory.initElements(webDriver, this);
    }
    //Funciones
    public void llenarInformacion1() throws InterruptedException {

        click(outlet);
        scroll(2000);
        click(anadirProducto1);
        Thread.sleep(1800);
        click(xcarrito);
        scroll(2080);
        Thread.sleep(1800);
// añadirProducto2
        try {
            WebElement producto2 = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt wp-element-button' and contains(text(), 'Greens Powder · 100 gr Universal')]"));
            // si encuentra el producto, no lo selecciona y continua con la ejecución del script
        } catch (Exception e) {
            try {
                click(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[3]"));
            } catch (Exception e2) {
                try {
                    click(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[4]"));
                } catch (Exception e3) {
                    try {
                        click(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[5]"));
                    } catch (Exception e4) {
                    }
                }
            }
        }
        Thread.sleep(1800);
        click(xcarrito);
        scrollDown();

// añadirProducto3
        try {
            WebElement producto3 = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt wp-element-button' and contains(text(), 'Greens Powder · 100 gr Universal')]"));
            // si encuentra el producto, no lo selecciona y continua con la ejecución del script
        } catch (Exception e) {
            try {
                click(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[2]"));
            } catch (Exception e2) {
                try {
                    click(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[4]"));
                } catch (Exception e3) {
                    try {
                        click(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[5]"));
                    } catch (Exception e4) {
                    }
                }
            }
        }
        Thread.sleep(1800);
        click(carrito);
        click(cantidad1);
        //click(cantidad2);
        //click(cantidad3);
        Thread.sleep(6000);
        //click(finalizarCompra);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", finalizarCompra);
        Thread.sleep(6000);

        explicitWaitTime(numeroDeDocumento);
        borrarTexto(numeroDeDocumento);
        //typeInto(numeroDeDocumento, formModel.getCedula());
        explicitWaitTime(e_Mail);
        borrarTexto(e_Mail);
        typeInto(e_Mail, formModel.getEmail());
        explicitWaitTime(nombre);
        borrarTexto(nombre);
        typeInto(nombre, formModel.getName());
        explicitWaitTime(apellido);
        borrarTexto(apellido);
        typeInto(apellido, formModel.getLastName());
        scrollDown(seleccionBotondepartamento);
        click(seleccionBotondepartamento);
        typeInto(departamento, formModel.getRegion());
        explicitWaitTime(departamento);
        click(seleccionDepartamento);
        click(seleccionBotonCiudad);
        typeInto(ciudad, formModel.getCity());
        explicitWaitTime(ciudad);
        click(seleccionCiudad);
        explicitWaitTime(direccion);
        borrarTexto(direccion);
        typeInto(direccion, formModel.getAddress());
        explicitWaitTime(apartamento);
        borrarTexto(apartamento);
        typeInto(apartamento, formModel.getNoAddress());
        explicitWaitTime(numeroCelular);
        borrarTexto(numeroCelular);
        typeInto(numeroCelular, formModel.getPhone());
        Thread.sleep(3000);
        click(terminosCondiciones);
        click(realizarPedido);
        Thread.sleep(10000);
    }
    public static String validacionPedido() {
        return getText(confirmacionPedido).trim();
    }

}




