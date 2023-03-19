package com.sofkau.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FPageDisneyChrome extends CommonActionOnPage {


    //Constructor
    public FPageDisneyChrome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private final By selectorIda = By.xpath("//span[text()='Solo ida']");
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
    public WebElement cLogin;


    @CacheLookup
    @FindBy(xpath = "/html/body/nav/div[2]/div/div[3]/ul/li[9]/a/div/div/i")
    public WebElement disney;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"date-picker\"]/div[2]/activities-datepicker/div/div[1]/datepicker-child/div/div/div/input")
    public WebElement calendario;


    @CacheLookup
    @FindBy(xpath = "/html/body/div[9]/div/div/div/div/div[3]")
    public WebElement fechas;
    @CacheLookup
    @FindBy(xpath = "/html/body/div[9]/div/div/div/div/div[3]/div[25]")
    public WebElement fechaInicio;




    public void closeLogin() throws InterruptedException {
        cLogin.click();
    }
    public void selectedPage() throws InterruptedException  {
        disney.click();
    }
    public void fillAssistanceForm(){
        scroll(2200);
        calendario.click();
        clickwithDelay(fechas);
        clickwithDelay(fechaInicio);


    }

    public void fillMandatoryFields(){

    }

}
