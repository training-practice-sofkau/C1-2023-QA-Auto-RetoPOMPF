package com.sofkau.pages;
import com.sofkau.models.Facturacion_Envio;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


public class FormPage extends CommonActionOnPages {

    //////////////////////////////////////////////////////////////////////
    ////// REGISTRO NEWSLETTER
    private final By emailField = By.cssSelector("input[name='EMAIL']");
    private final By nameField = By.id("mce-FNAME");
    private final By phoneField = By.xpath("(//input[@id='mce-MMERGE4'])[1]");
    private final By subscribeButton = By.id("mc-embedded-subscribe");
    private final By successMessage = By.id("mce-success-response");

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
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
        this.facturacion_envio=facturacion_envio;
    }
    private final By product1Btn = By.xpath("(//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[2]");
    private final By product2Btn = By.xpath("(//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[3]");
    private final By product3Btn = By.xpath("(//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[4]");
    private final By product1FlavorBtn = By.xpath("//div[@class='ux-swatch tooltip ux-swatch--color swatch-french-vanilla tooltipstered selected']//span[@class='ux-swatch__color ux-swatch__color--single-color']");
    private final By product2FlavorBtn = By.xpath("//div[@class='ux-swatch tooltip ux-swatch--color swatch-watermelon tooltipstered selected']//span[@class='ux-swatch__color ux-swatch__color--single-color']");
    private final By product3FlavorBtn = By.xpath("//div[@class='ux-swatch tooltip ux-swatch--color swatch-banana tooltipstered selected']//span[@class='ux-swatch__color ux-swatch__color--single-color']");
    private final By addToCartBtn = By.xpath("(//*[@class='single_add_to_cart_button button alt wp-element-button'])[1]");
    private final By closeCartBtn = By.xpath("//*[@class='mfp-close']");
    private final By homeBtn = By.xpath("//a[@class='dashicons-admin-home mega-menu-link']");
    private final By product1QuantityBtn = By.xpath("(//*[@class='plus button is-form'])[1]");
    private final By product2QuantityBtn = By.xpath("(//*[@class='plus button is-form'])[2]");
    private final By product3QuantityBtn = By.xpath("(//*[@class='plus button is-form'])[3]");
    private final By deleteLastProductBtn = By.xpath("(//*[@class='remove'])[3]");
    private final By checkoutBtn = By.xpath("(//*[@class='checkout-button button alt wc-forward wp-element-button'])");
    private final By documentNumberField = By.xpath("(//input[@id='billing_myfield12'])[1]");
    private final By email1 = By.xpath("(//input[@id='billing_email'])[1]");
    private final By firstNameField = By.xpath("(//input[@id='billing_first_name'])[1]");
    private final By lastNameField = By.xpath("(//input[@id='billing_last_name'])[1]");
    private final By stateDropdown = By.xpath("//span[@id='select2-billing_state-container']");
    private final By cityField = By.xpath("(//span[@id='select2-billing_city-container'])[1]");
    private final By addressField = By.xpath("//*[@id='billing_address_1']");
    private final By addressComplementField = By.xpath("//*[@id='billing_address_2']");
    private final By phone1 = By.xpath("(//input[@id='billing_phone'])[1]");
    private final By additionalNoteField = By.xpath("(//textarea[@id='order_comments'])[1]");
    private final By paymentBtn = By.xpath("(//input[@id='payment_method_bacs'])[1]");
    private final By termsAndConditionsBtn = By.xpath("//*[@id='terms']");


    public void clickProduct1Btn() {
        driver.findElement(product1Btn).click();
    }

    public void clickProduct2Btn() {
        driver.findElement(product2Btn).click();
    }

    public void clickProduct3Btn() {
        driver.findElement(product3Btn).click();
    }

    public void clickProduct1FlavorBtn() {
        driver.findElement(product1FlavorBtn).click();
    }
    public void clickProduct2FlavorBtn() {
        driver.findElement(product2FlavorBtn).click();
    }

    public void clickProduct3FlavorBtn() {
        driver.findElement(product3FlavorBtn).click();
    }

    public void clickAddToCartBtn() {
        driver.findElement(addToCartBtn).click();
    }

    public void clickCloseCartBtn() {
        driver.findElement(closeCartBtn).click();
    }

    public void clickHomeBtn() {
        driver.findElement(homeBtn).click();
    }

    public void clickProduct1QuantityBtn() {
        driver.findElement(product1QuantityBtn).click();
    }

    public void clickProduct2QuantityBtn() {
        driver.findElement(product2QuantityBtn).click();
    }

    public void clickProduct3QuantityBtn() {
        driver.findElement(product3QuantityBtn).click();
    }

    public void clickDeleteLastProductBtn() {
        driver.findElement(deleteLastProductBtn).click();
    }

    public void clickCheckoutBtn() {
        driver.findElement(checkoutBtn).click();
    }

    public void enterDocumentNumber(String number) {
        driver.findElement(documentNumberField).sendKeys(number);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void selectState(String state) {
        driver.findElement(stateDropdown).click();
        driver.findElement(By.xpath("//li[contains(text(), '" + state + "')]")).click();
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterAddressComplement(String complement) {
        driver.findElement(addressComplementField).sendKeys(complement);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterAdditionalNote(String note) {
        driver.findElement(additionalNoteField).sendKeys(note);
    }

    public void clickPaymentBtn() {
        driver.findElement(paymentBtn).click();
    }

    public void clickTermsAndConditionsBtn() {
        driver.findElement(termsAndConditionsBtn).click();
    }
}









