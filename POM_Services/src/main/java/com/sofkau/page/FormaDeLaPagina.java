package com.sofkau.page;
import com.sofkau.util.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormaDeLaPagina extends CommonActionOnPage {
    public static String convenio;
    public static String boton;
    public static String error;
    public static String mensaje;
    public FormaDeLaPagina(WebDriver driver) {
        super(driver);
    }
    public void clickOpcionProteinas() throws InterruptedException {
        ponerMouse("header-vertical-menu__title");
        Thread.sleep(300);
        click(By.xpath("(//a[@class='nav-top-link'])[5]"));
    }
    public void clickProductos() throws InterruptedException {
        for (int i=4;i<7;i++){
            scroll(500);
            click(By.xpath(String.format("(//div[@class='image-fade_in_back'])[%s]",i)));
            scroll(500);
            if (i==4)
                click(By.xpath("(//div[@data-value='vanilla'])"));
            else
                click(By.xpath("(//div[@data-value='banana'])"));
            click(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])"));
            click(By.className("mfp-close"));
            clickOpcionProteinas();
        }
        click(By.className("header-cart-title"));
        click(By.xpath("(//a[@class='button wc-forward wp-element-button'])"));
        scroll(200);
        for(int i=2;i<7;i++){
            click(By.xpath("(//input [@type='button'])["+i+"]"));
            i++;
        }
    }
    public void finalizarCompra() throws InterruptedException {
        WebDriverWait typeWait= new WebDriverWait(driver, Duration.ofSeconds(10));;
        scroll(100);
        click(By.xpath("(//a[@class='checkout-button button alt wc-forward wp-element-button'])"));
        typeInto(By.xpath("(//input[@id='billing_myfield12'])"),"1021234598");
        typeInto(By.xpath("(//input[@id='billing_email'])"),"damir29305@etondy.com");
        typeInto(By.xpath("(//input[@id='billing_first_name'])"),"Natalia");
        typeInto(By.xpath("(//input[@id='billing_last_name'])"),"Quintero");
        click(By.xpath("(//span[@id='select2-billing_state-container'])"));
        typeInto(By.xpath("(//input[@class='select2-search__field'])"),"Antioquia");
        tab(By.xpath("(//input[@class='select2-search__field'])"));
        scroll(100);
        click(By.xpath("(//span[@id='select2-billing_city-container'])"));
        typeInto(By.xpath("(//input[@class='select2-search__field'])"),"Medellin");
        tab(By.xpath("(//input[@class='select2-search__field'])"));
        typeInto(By.xpath("(//input[@id='billing_address_1'])"),"Cra. 23b #84b192");
        typeInto(By.xpath("//input[@id='billing_phone']"),"3222025132");
        scroll(800);
        Thread.sleep(3000);
        typeWait.until(ExpectedConditions.elementToBeClickable(By.id("terms"))).click();
        typeWait.until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();
    }
    public void puntoBaloto() {
        convenio=driver.findElement(By.xpath("(//strong[text()='1204346'])")).getText();
    }
    public void clickAcceder() {
        click(By.xpath("(//a[@class='nav-top-link nav-top-not-logged-in icon primary button round is-small'])"));
    }
    public void ingresarCredenciales() throws InterruptedException {
        Thread.sleep(500);
        typeInto(By.id("username"),"damir29305@etondy.com");
        typeInto(By.id("password"),"Test.prueba00");
        click(By.xpath("(//button[@class='woocommerce-button button woocommerce-form-login__submit wp-element-button'])"));
    }
    public void compararBotonAcceso() {
        boton=driver.findElement(By.xpath("(//span[@class='header-account-title'])")).getText();
    }
    public void ingresarCredencialesIncorrectas() {
        typeInto(By.id("username"),"damir29305@etondy.com");
        typeInto(By.id("password"),"Hola.gansito123");
        click(By.xpath("(//button[@class='woocommerce-button button woocommerce-form-login__submit wp-element-button'])"));
    }
    public void mensajeError() {
        error=driver.findElement(By.xpath("(//a[@title='Password Lost and Found'])")).getText();
    }
    public void clickUsiario() {
        ponerMouseXpath("(//a[@title='Mi cuenta'])[1]");
    }
    public void clickSalir(){
        click(By.xpath("(//a[@href='https://zonafit.co/mi-cuenta/customer-logout/'])"));
    }
    public void cerrarSesion() {
        click(By.xpath("(//a[text()='Confirmar y salir'])"));
    }
    public void botonAcceder() {
        boton=driver.findElement(By.xpath("(//a[@class='nav-top-link nav-top-not-logged-in icon primary button round is-small'])")).getText();
    }
    public void clickDetalles() {
        click(By.xpath("(//a[@href='https://zonafit.co/mi-cuenta/edit-account/'])"));
    }
    public void cambioContrasena(String vieja,String nueva){
        typeInto(By.id("password_current"),vieja);
        typeInto(By.id("password_1"),nueva);
        typeInto(By.id("password_2"),nueva);
        click(By.xpath("(//button[@class='woocommerce-Button button wp-element-button'])"));
    }
    public void mensajeCambio() {
        mensaje=driver.findElement(By.xpath("(//div[@class='message-container container success-color medium-text-center'])")).getText();
    }
}
