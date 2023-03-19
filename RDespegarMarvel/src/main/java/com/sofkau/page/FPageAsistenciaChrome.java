package com.sofkau.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FPageAsistenciaChrome extends CommonActionOnPage {


    //Constructor
    public FPageAsistenciaChrome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Localizadores
    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public WebElement cLogin;


    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[2]/div/div[3]/ul/li[10]/a/div/div")
    public WebElement asistencia;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[1]/div/div/div/select/optgroup[1]/option[3]")
    public WebElement menu;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div")
    public WebElement calendario;

    @CacheLookup
    @FindBy(xpath = "//div[@class='sbox5-monthgrid-datenumber']/div[@class='sbox5-monthgrid-datenumber-number'])[30]")
    public WebElement fechaInicio;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div")
    public WebElement calendario2;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[25]")
    public WebElement fechaFin;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"component-modals\"]/div[3]/div[2]/div[1]/button/em")
    public WebElement aplicarFecha;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-assistance\"]/div/div/div/div/div[3]/div[3]/div/div/div")
    public WebElement pasajeros;

    private final By inicio = By.xpath("(//div[@class='sbox5-monthgrid-datenumber-number'][normalize-space()='18'])[1]");

    public void closeLogin() throws InterruptedException {
        Thread.sleep(200);
        cLogin.click();
    }
    public void selectedPage() throws InterruptedException  {
        asistencia.click();
    }
    public void fillAssistanceForm(){
        menu.click();
        calendario.click();
        scroll(250);
        System.out.println("hola mundo");
        clickwithDelay(fechaInicio);
    }

    public void fillMandatoryFields(){

    }

}
