package com.sofkau.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class FormPage extends CommonActionOnPages {
    private final By emailField = By.cssSelector("input[name='EMAIL']");
    private final By nameField = By.id("mce-FNAME");
    private final By phoneField = By.xpath("(//input[@id='mce-MMERGE4'])[1]");
    private final By subscribeButton = By.id("mc-embedded-subscribe");
    private final By successMessage = By.id("mce-success-response");

    public FormPage(WebDriver driver) {
        super(driver);
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
    private final By username = By.xpath("(//span[@class='header-account-title'])[1]");


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

    public void ingresarCorreo(String correo) {
        driver.findElement(By.xpath("(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[1]"))
                .sendKeys(correo);
    }

    public void ingresarContrasena(String contrasena) {
        driver.findElement(By.xpath("(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[2]"))
                .sendKeys(contrasena);
    }

    public void clickBotonIniciarSesion() {
        driver.findElement(By.xpath("//span[contains(text(),'Acceder')]")).click();
    }

    public boolean confirmarRedireccionCuenta() {
        return driver.getCurrentUrl().contains("zonafit.com/cuenta");
    }


}


