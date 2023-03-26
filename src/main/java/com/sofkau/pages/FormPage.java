package com.sofkau.pages;
import com.sofkau.models.Facturacion_Envio;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage extends CommonActionOnPages {
    private  WebDriverWait wait;

    //////////////////////////////////////////////////////////////////////
    ////// REGISTRO NEWSLETTER
    private final By emailField = By.cssSelector("input[name='EMAIL']");
    private final By nameField = By.id("mce-FNAME");
    private final By phoneField = By.xpath("(//input[@id='mce-MMERGE4'])[1]");
    private final By subscribeButton = By.id("mc-embedded-subscribe");
    private final By successMessage = By.id("mce-success-response");

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String email, String name, String phone) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickSubscribeButton() {
        driver.findElement(subscribeButton).click();
    }

    public String getSuccessMessage() {
        System.out.println(driver.findElement(successMessage).getText());
        return driver.findElement(successMessage).getText();

    }

    ////////////////////////////////////////////////////////
    // Para registrar un nuevo usuario

    public void clickAccederRegistrarseButton() {
        WebElement accederRegistrarseButton = driver.findElement(By.xpath("//span[contains(text(),'Acceder')]"));
        accederRegistrarseButton.click();
    }

    public void setEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("(//input[@id='reg_email'])[1]"));
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("(//input[@id='reg_password'])[1]"));
        passwordField.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordField = driver.findElement(By.xpath("(//input[@id='password_confirm'])[1]"));
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickRegistrarseButton() {
        WebElement registrarseButton = driver.findElement(By.cssSelector(".woocommerce-Button.woocommerce-button.button.wp-element-button.woocommerce-form-register__submit"));
        registrarseButton.click();
    }

    public String getConfirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']//li"));
        return confirmationMessage.getText();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///// Inicio de Session
    private final By loginButton = By.xpath("//span[contains(text(),'Acceder')]");
    private final By emailInput = By.xpath("(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[1]");
    private final By passwordInput = By.xpath("(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[2]");
    private final By accederButton = By.xpath("(//button[normalize-space()='Acceder'])[1]");
    private final By username = By.xpath("//span[@class='header-account-title']");


    public void setEmaill(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPasswordd(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickAccederButton() {
        driver.findElement(accederButton).click();
    }

    public String getUsername() {
        return driver.findElement(username).getText();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///// Inicio de Session multiple con Scenario Outline

    @CacheLookup
    @FindBy(xpath = "(//a[@class='nav-top-link nav-top-not-logged-in icon primary button round is-small'])[1]")
    public WebElement option;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='username'])[1]")
    public WebElement usernamee;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='password'])[1]")
    public WebElement password;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Acceder'])[1]")
    public WebElement buttonUser;

    public void clickLoguin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(option));
        wait.until(ExpectedConditions.elementToBeClickable(option));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", option);
        Thread.sleep(200);
    }

    public void fillMandatory2(String correo, String contrasenna) {
        this.usernamee.sendKeys(correo);

        this.password.sendKeys(contrasenna);

        buttonUser.click();

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///// FLUJO DE COMPRA
    Facturacion_Envio facturacion_envio = new Facturacion_Envio();

    public FormPage(WebDriver driver, Facturacion_Envio facturacion_envio) {
        super(driver);
        this.facturacion_envio = facturacion_envio;


    }

    private final By producto1Btn = By.xpath("(//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[2]");
    private final By producto2Btn = By.xpath("(//img[@alt='bandas'])[1]");
    private final By producto3Btn = By.xpath("//img[@alt='gold standard 2 lb']");
    private final By producto1SaborBtn = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[6]");
    private final By producto2SaborBtn = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[4]");
    private final By producto3SaborBtn = By.xpath("(//span[@class='ux-swatch__color ux-swatch__color--single-color'])[1]");
    private final By anadirCarritoBtn = By.xpath("(//*[@class='single_add_to_cart_button button alt wp-element-button disabled wc-variation-selection-needed'])[1]");
    private final By anadirCarritoBandas = By.cssSelector("button[value='198365'][name='add-to-cart']");
    private final By cerrarCarritoBtn = By.xpath("//*[@class='mfp-close']");
    private final By InicioBtn = By.xpath("//a[@class='dashicons-admin-home mega-menu-link']");
    private final By producto1CantidadBtn = By.xpath("(//*[@class='plus button is-form'])[1]");
    private final By producto2CantidadBtn = By.xpath("(//*[@class='plus button is-form'])[2]");
    private final By producto3CantidadBtn = By.xpath("(//*[@class='plus button is-form'])[3]");
    private final By borrarUltimoProductoBtn = By.xpath("(//*[@class='remove'])[3]");
    private final By finalizarCompraBtn = By.xpath("(//*[@class='checkout-button button alt wc-forward wp-element-button'])");
    private final By numeroDocumento = By.xpath("(//input[@id='billing_myfield12'])[1]");
    private final By email1 = By.xpath("(//input[@id='billing_email'])[1]");
    private final By nombre = By.xpath("(//input[@id='billing_first_name'])[1]");
    private final By apellido = By.xpath("(//input[@id='billing_last_name'])[1]");
    private final By departamento = By.xpath("//span[@id='select2-billing_state-container']");
    private final By box_department = By.cssSelector("input[aria-owns='select2-billing_state-results']");
    private final By ciudad = By.xpath("(//span[@id='select2-billing_city-container'])[1]");
    private final By box_ciudad = By.cssSelector("input[aria-owns='select2-billing_city-results']");
    private final By direccion = By.xpath("//*[@id='billing_address_1']");
    private final By complementoDireccion= By.xpath("//*[@id='billing_address_2']");
    private final By celular = By.xpath("(//input[@id='billing_phone'])[1]");
    private final By notasDelPedido = By.xpath("(//textarea[@id='order_comments'])[1]");
    private final By PagoBtn = By.id("place_order");

    private final By OpcionOutlet = By.xpath("(//a[@class='dashicons-heart mega-menu-link'][normalize-space()='Outlet'])[1]");

    private final By PagoOption = By.xpath("(//input[@id='payment_method_bank_transfer_1'])[1]");
    private final By terminosAndCondicionesBtn = By.id("terms");
    private final By LocalizadorMensaje = By.xpath("//strong[normalize-space()='Gracias. Tu pedido ha sido recibido.']");
    private final By carritoSimbolo = By.xpath("//div[contains(@class,'single_variation_wrap')]//button[contains(@class,'wp-element-button')]");
    private final By vercarrito= By.xpath("//p[contains(@class,'woocommerce-mini-cart__buttons')]//a[contains(@class,'button wc-forward')]");
    private final By icon2 = By.xpath("//div[@class='row hide-for-small large-columns-8 medium-columns-3 small-columns-2 row-small']//div[1]//div[1]//a[1]");
    public void agregar()  {
        // PARA AGREGAR EL PRIMER PRODUCTO
        bajarHastaProducto1();
        click(producto1Btn);
        click(producto1SaborBtn);
        click(carritoSimbolo);
        click(cerrarCarritoBtn);
        click(OpcionOutlet);
        bajarHastaProducto2();
        // PARA AGREGAR EL SEGUNDO PRODUCTO

        click(producto2Btn);

        click(anadirCarritoBandas);
        click(cerrarCarritoBtn);
        click(InicioBtn);
        // PARA AGREGAR EL TERCER PRODUCTO
        bajarHastaProducto3();
        click(producto3Btn);
        click(producto3SaborBtn);
        click(carritoSimbolo);
        click(vercarrito);

        click(producto2CantidadBtn);

        click(finalizarCompraBtn);

    }
    public void facturacion ()  {
        typeInto(numeroDocumento,facturacion_envio.getNumeroDocumento());
        typeInto(email1,facturacion_envio.getEmail1());
        typeInto(nombre,facturacion_envio.getNombre());
        typeInto(apellido,facturacion_envio.getApellido());
        click(departamento);
        typeInto(box_department,facturacion_envio.getDepartamento());
        pressEnter(box_department);
        click(ciudad);
        typeInto(box_ciudad,facturacion_envio.getCiudad());
        pressEnter(box_ciudad);
        typeInto(direccion,facturacion_envio.getDireccion());
        typeInto(complementoDireccion,facturacion_envio.getComplementoDireccion());
        typeInto(celular,facturacion_envio.getCelular());
        typeInto(notasDelPedido,facturacion_envio.getNotasDelPedido());
        bajarHastaPago();
        pressSpace(terminosAndCondicionesBtn);
        pressSpace(PagoBtn);
    }
    public void bajarHastaProducto1() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(producto1Btn));
    }

    public void bajarHastaProducto2() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(producto2Btn));
    }
    public void bajarHastaProducto3() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(producto3Btn));
    }
    public void bajarHastaPago() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(PagoOption));
    }

    public WebElement getMensajeFinal(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(25));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LocalizadorMensaje));
}

    public void DatosFacturacionn(){
        facturacion_envio =new Facturacion_Envio ();
        facturacion_envio.setNumeroDocumento("1035437112");
        facturacion_envio.setEmail1("david2222@hotmail.com");
        facturacion_envio.setNombre("Bryan");
        facturacion_envio.setApellido("Polo");
        facturacion_envio.setDepartamento("ANTIOQUIA");
        facturacion_envio.setCiudad("COPACABANA (ANT)");
        facturacion_envio.setDireccion("carrea 46C 41-21");
        facturacion_envio.setComplementoDireccion("piso 1");
        facturacion_envio.setCelular("3104565821");
        facturacion_envio.setNotasDelPedido("Subiendo por la tienda los chochales");
    }
}








