package com.sofkau.pages;

import com.sofkau.models.FormModel;
import com.sofkau.pages.common.AccionComunDeLaPagina;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZonaFitPaginaEscenarioUno extends AccionComunDeLaPagina {


    public final FormModel formModel;
    private WebDriver webDriver;

    @CacheLookup
    @FindBy(xpath = "(//a[@class='dashicons-heart mega-menu-link'])[2]")
    private WebElement outlet;
    private final By anadirProducto1 = By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[7]");

    private final By anadirProducto2 = By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[3]");

    private final By anadirProducto3 = By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[4]");

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
    @FindBy(xpath = "(//input[@id='billing_myfield12'])[1]")
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

    private final By departamento = By.xpath("/html/body/span/span/span[1]/input");

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"select2-billing_state-results\"]")
    private WebElement seleccionDepartamento;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"select2-billing_city-container\"]")
    private WebElement seleccionBotonCiudad;

    private final By ciudad = By.xpath("/html/body/span/span/span[1]/input");

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

    //Validacion
    private static final By confirmacionPedido = By.xpath("//*[@id=\"main\"]/div[2]/div/div");


    public ZonaFitPaginaEscenarioUno(FormModel formModel, WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.formModel = formModel;
        PageFactory.initElements(webDriver, this);
    }

    //Funciones
    public void llenarInformacion() throws InterruptedException {

        click(outlet);
        scrollDown();
        Thread.sleep(1000);
        click(anadirProducto1);
        Thread.sleep(1000);
        click(xcarrito);
        Thread.sleep(1000);
        scrollDown();
        Thread.sleep(1000);
        click(anadirProducto2);
        Thread.sleep(1000);
        click(xcarrito);
        Thread.sleep(1000);
        scrollDown();
        Thread.sleep(1000);
        click(anadirProducto3);
        Thread.sleep(1000);
        click(carrito);
        Thread.sleep(4000);
        /*click(cantidad1);
        Thread.sleep(4000);
        click(cantidad2);
        Thread.sleep(4000);
        click(cantidad3);
        Thread.sleep(4000);

         */
        click(finalizarCompra);
        Thread.sleep(8000);
        explicitWaitTime(numeroDeDocumento);
        escribir(numeroDeDocumento, formModel.getCedula());
        Thread.sleep(4000);
        explicitWaitTime(e_Mail);
        borrarTexto(e_Mail);
        escribir(e_Mail, formModel.getEmail());
        explicitWaitTime(nombre);
        borrarTexto(nombre);
        escribir(nombre, formModel.getName());
        explicitWaitTime(apellido);
        borrarTexto(apellido);
        escribir(apellido, formModel.getLastName());
        scrollDown(seleccionBotondepartamento);
        click(seleccionBotondepartamento);
        escribir(departamento, formModel.getRegion());
        explicitWaitTime(departamento);
        click(seleccionDepartamento);
        click(seleccionBotonCiudad);
        escribir(ciudad, formModel.getCity());
        explicitWaitTime(ciudad);
        click(seleccionCiudad);
        explicitWaitTime(direccion);
        borrarTexto(direccion);
        escribir(direccion, formModel.getAddress());
        explicitWaitTime(apartamento);
        borrarTexto(apartamento);
        escribir(apartamento, formModel.getNoAddress());
        explicitWaitTime(numeroCelular);
        borrarTexto(numeroCelular);
        escribir(numeroCelular, formModel.getPhone());
        Thread.sleep(4000);
        scroll(100);
        click(terminosCondiciones);
        Thread.sleep(3000);
        click(realizarPedido);

    }

                 /*JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[1]"));
        executor.executeScript("arguments[0].click();", webElement);
        Thread.sleep(20000);
         */





    public static String validacionPedido(){return getText(confirmacionPedido).trim();}


}
