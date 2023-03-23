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
<<<<<<< HEAD
=======
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
>>>>>>> main

public class FlujoCompra extends CommonActionPages {


    public final FormModel formModel;
    private WebDriver webDriver;

<<<<<<< HEAD
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
=======
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @CacheLookup
    @FindBy(xpath = "(//a[@class='dashicons-heart mega-menu-link'])[2]")
    private WebElement outlet;
    private final By anadirProducto1 = By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[1]");
    @CacheLookup
    @FindBy(xpath = "(//textarea[@id='order_comments'])[1]")
    private WebElement texto;

    private final By Contacto = By.xpath("(//span[normalize-space()='Contacto'])[1]");
    private final By xcarrito = By.xpath("(//button[@class='mfp-close'])");
    private final By cantidad1 = By.xpath("(//input[@value='+'])[1]");
>>>>>>> main

    @CacheLookup
    @FindBy(xpath = "(//a[@class='button wc-forward wp-element-button'])[1]")
    private WebElement carrito;

    @CacheLookup
<<<<<<< HEAD
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div[2]/div[2]/div/div[1]/div/a")
=======
    @FindBy(xpath = "(//a[normalize-space()='Finalizar compra'])[1]")
>>>>>>> main
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

<<<<<<< HEAD
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
=======

    private final By terminosCondiciones = By.xpath("//*[@id=\"terms\"]");

    private final By realizarPedido = By.xpath("//*[@id=\"place_order\"]");


>>>>>>> main

    //Validacion
    private static final By confirmacionPedido = By.xpath("//*[@id=\"main\"]/div[2]/div/div");

    public FlujoCompra(FormModel formModel, WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.formModel = formModel;
        PageFactory.initElements(webDriver, this);
    }
<<<<<<< HEAD
=======

>>>>>>> main
    //Funciones
    public void llenarInformacion1() throws InterruptedException {

        click(outlet);
        click(anadirProducto1);
<<<<<<< HEAD
        Thread.sleep(1800);
        click(xcarrito);
        scrollDown();
        Thread.sleep(1800);
// añadirProducto2
=======
        click(xcarrito);
        WebElement producto2 = driver.findElement(Contacto);
        wait.until(ExpectedConditions.visibilityOf(producto2));
>>>>>>> main
        int productosSeleccionados = 0;
        for (int i = 2; i <= 5; i++) {
            try {
                WebElement producto = driver.findElement(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[" + i + "]"));
                click(producto);
                productosSeleccionados++;
                if (productosSeleccionados == 2) {
                    break;
                }
            } catch (Exception e) {
            }
        }
<<<<<<< HEAD
        Thread.sleep(1800);
        click(xcarrito);
        scrollDown();
=======
        click(xcarrito);
        WebElement producto3 = driver.findElement(Contacto);
        wait.until(ExpectedConditions.visibilityOf(producto3));
>>>>>>> main
// añadirProducto3
        productosSeleccionados = 0;
        for (int i = 2; i <= 5; i++) {
            try {
                WebElement producto = driver.findElement(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])[" + i + "]"));
                click(producto);
                productosSeleccionados++;
                if (productosSeleccionados == 2) {
                    break;
                }
            } catch (Exception e) {
            }
        }
<<<<<<< HEAD
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
=======
        click(carrito);
        click(cantidad1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Finalizar compra'])[1]")));
        click(finalizarCompra);
        typeInto(numeroDeDocumento, formModel.getCedula());
        typeInto(e_Mail, formModel.getEmail());
        typeInto(nombre, formModel.getName());
        typeInto(apellido, formModel.getLastName());
        click(seleccionBotondepartamento);
        typeInto(departamento, formModel.getRegion());
        click(seleccionDepartamento);
        click(seleccionBotonCiudad);
        typeInto(ciudad, formModel.getCity());
        click(seleccionCiudad);
        typeInto(direccion, formModel.getAddress());
        typeInto(numeroCelular, formModel.getPhone());
        WebElement terminos = driver.findElement(By.xpath("//*[@id=\"terms\"]"));
        wait.until(ExpectedConditions.visibilityOf(terminos));
        presionarEspacio(terminosCondiciones);
        WebElement shop = driver.findElement(By.xpath("//*[@id=\"place_order\"]"));
        wait.until(ExpectedConditions.visibilityOf(shop));
        presionarEspacio(realizarPedido);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//strong[normalize-space()='Gracias. Tu pedido ha sido recibido.'])[1]")));

>>>>>>> main
    }
    public static String validacionPedido() {
        return getText(confirmacionPedido).trim();
    }

}



