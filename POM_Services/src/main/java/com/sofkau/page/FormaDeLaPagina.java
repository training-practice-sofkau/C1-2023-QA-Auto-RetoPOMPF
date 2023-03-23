package com.sofkau.page;
import com.sofkau.util.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormaDeLaPagina extends CommonActionOnPage {
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    public static String convenio;
    public static String boton;
    public static String error;
    public static String mensaje;
    public FormaDeLaPagina(WebDriver driver) {
        super(driver);
    }
    public void clickOpcionProteinas(){
        ponerMouse("header-vertical-menu__title");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='nav-top-link'])[5]"))).click();
    }
    public void clickProductos(){
        for (int i=4;i<7;i++){
            scroll(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("(//div[@class='image-fade_in_back'])[%s]",i)))).click();
            scroll(500);
            if (i==4)
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-value='vanilla'])"))).click();
            else
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-value='banana'])"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='single_add_to_cart_button button alt wp-element-button'])"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.className("mfp-close"))).click();
            clickOpcionProteinas();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.className("header-cart-title"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='button wc-forward wp-element-button'])"))).click();
        scroll(200);
        for(int i=2;i<7;i++){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input [@type='button'])["+i+"]"))).click();
            i++;
        }
    }
    public void finalizarCompra(){
        scroll(100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='checkout-button button alt wc-forward wp-element-button'])"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='billing_myfield12'])")));
        typeInto(By.xpath("(//input[@id='billing_myfield12'])"),"1021234598");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='billing_email'])")));
        typeInto(By.xpath("(//input[@id='billing_email'])"),"damir29305@etondy.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='billing_first_name'])")));
        typeInto(By.xpath("(//input[@id='billing_first_name'])"),"Natalia");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='billing_last_name'])")));
        typeInto(By.xpath("(//input[@id='billing_last_name'])"),"Quintero");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@id='select2-billing_state-container'])"))).click();
        typeInto(By.xpath("(//input[@class='select2-search__field'])"),"Antioquia");
        tab(By.xpath("(//input[@class='select2-search__field'])"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@id='select2-billing_city-container'])"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='select2-search__field'])")));
        typeInto(By.xpath("(//input[@class='select2-search__field'])"),"Medellin");
        tab(By.xpath("(//input[@class='select2-search__field'])"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='billing_address_1'])")));
        typeInto(By.xpath("(//input[@id='billing_address_1'])"),"Cra. 23b #84b192");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='billing_phone']")));
        typeInto(By.xpath("//input[@id='billing_phone']"),"3222025132");
        driver.findElement(By.id("terms")).sendKeys(Keys.SPACE);
        driver.findElement(By.id("place_order")).sendKeys(Keys.SPACE);
    }
    public void puntoBaloto() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//strong[text()='1204346'])")));
        convenio=driver.findElement(By.xpath("(//strong[text()='1204346'])")).getText();
    }
    public void clickAcceder() {
        click(By.xpath("(//a[@class='nav-top-link nav-top-not-logged-in icon primary button round is-small'])"));
    }
    public void ingresarCredenciales(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).click();
        typeInto(By.id("username"),"damir29305@etondy.com");
        typeInto(By.id("password"),"Prueba.test00");
        click(By.xpath("(//button[@class='woocommerce-button button woocommerce-form-login__submit wp-element-button'])"));
    }
    public void ingresarCredenciales(String string){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        typeInto(By.id("username"),"damir29305@etondy.com");
        typeInto(By.id("password"),string);
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
