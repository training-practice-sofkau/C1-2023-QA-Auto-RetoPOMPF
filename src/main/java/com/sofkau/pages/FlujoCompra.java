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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlujoCompra extends CommonActionPages {


    public final FormModel formModel;
    private WebDriver webDriver;

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

    @CacheLookup
    @FindBy(xpath = "(//a[@class='button wc-forward wp-element-button'])[1]")
    private WebElement carrito;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Finalizar compra'])[1]")
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


    private final By terminosCondiciones = By.xpath("//*[@id=\"terms\"]");

    private final By realizarPedido = By.xpath("//*[@id=\"place_order\"]");



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
        click(anadirProducto1);
        click(xcarrito);
        WebElement producto2 = driver.findElement(Contacto);
        wait.until(ExpectedConditions.visibilityOf(producto2));
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
        click(xcarrito);
        WebElement producto3 = driver.findElement(Contacto);
        wait.until(ExpectedConditions.visibilityOf(producto3));
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

    }
    public static String validacionPedido() {
        return getText(confirmacionPedido).trim();
    }

}



