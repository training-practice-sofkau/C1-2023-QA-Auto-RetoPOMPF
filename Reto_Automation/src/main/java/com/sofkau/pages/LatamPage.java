package com.sofkau.pages;

import com.sofkau.models.Passenger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LatamPage extends CommonActionOnPages{

    private final By departureDate = By.cssSelector("div.CalendarMonthGrid_month__horizontal:nth-child(3) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(5) > span:nth-child(1)");
    private final By arrivalDate = By.cssSelector("div.CalendarMonthGrid_month__horizontal:nth-child(4) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)");


    private final By origin = By.id("txtInputOrigin_field");
    private final By btnAutoComplete = By.id("btnItemAutoComplete_0");
    private final By selIda_Vuelta = By.id("btnTripTypeCTA");
    private final By category = By.id("btnCabinTypeCTA");
    private final By passQuantity = By.id("btnAddPassengerCTA");
    private final By substractAdults = By.id("btnSubstractAdults");
    private final By addAdults = By.id("btnPlusAdults");
    private final By destination = By.id("txtInputDestination_field");
    @CacheLookup
    @FindBy(id = "departureDate")
    private WebElement inputSalida;
    @CacheLookup
    @FindBy(id = "btnSearchCTA")
    private WebElement btnSearch;
    @CacheLookup
    @FindBy(id = "WrapperCardFlight0")
    private WebElement selTicketIda;

    @CacheLookup
    @FindBy(css = ".card-flightstyle__WrapperFlightInfo-sc__sc-16r5pdw-17.ktzsYJ")
    private WebElement selTicketVuelta;
    @CacheLookup
    @FindBy(id = "BasicBundleAlertMessage")
    private WebElement alertTicket;
    @CacheLookup
    @FindBy(id = "bundle-detail-0-flight-select")
    private WebElement continueWithBasicButton;
    @CacheLookup
    @FindBy(id = "bundle-detail-0-flight-select--button-wrapper")
    private WebElement continueWithTop;
    private final By buttonSeats = By.id("button9");
    private final By leaveSeats = By.id("btnSeatMapLeave");
    private final By continueToPay = By.id("button-cart-confirm");
    private final By chooseLater = By.id("buttonChooseLater");
    private final By chooseBag = By.cssSelector("span[data-testid='personal-item-radio']");
    private final By bottonContinue = By.id("undefined--button-wrapper");
    @CacheLookup
    @FindBy(id = "mui-component-select-passengerInfo.gender")
    private WebElement genderInput;

    @CacheLookup
    @FindBy(id="documentInfo-documentNumber-ADT_1-label")
    private WebElement ponerId;

    private final By buttonLoginLatam = By.cssSelector("button[id='cnt_main_login-btn'] span[class='MuiButton-label']");
    private final By inputFinalEmail = By.id("form-input--alias");

    private final By email = By.id("passengerInfo-emails-ADT_1");
    private final By repeatContactInfo = By.id("repeatContactData-ADT_1-label");
    public LatamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void fillSearchForm(String origen) {
        typeInto(origin,origen);
        click(btnAutoComplete);
        click(destination);
        typeInto(destination, "Pasto");
        click(btnAutoComplete);
        click(inputSalida);
        click(departureDate);
        click(arrivalDate);
        click(passQuantity);
        click(addAdults);
        click(addAdults);
        click(btnSearch);
//        selectTickets();
    }
    public void selectTickets() {
        switchTab(1);
        click(selTicketIda);
        click(continueWithBasicButton);
        scrollTo(alertTicket);
        getTabsList();
        scrollTo(selTicketVuelta);
        click(selTicketVuelta);
        click(continueWithTop);
        click(buttonSeats);
        leaveSeatsSelection();
//        click(selTicketIda);
    }

    public void leaveSeatsSelection() {
        click(leaveSeats);
        click(chooseLater);
        click(chooseBag);
        click(continueToPay);
//        click(By.id("hi"));
    }

    public void fillPassengers(List<Passenger> passengers) {
        System.out.println(passengers.size());
        for(int i = 1; i<=passengers.size(); i++){
            click(By.id("passengerDetails-firstName-ADT_"+i));
            typeInto(By.id("passengerDetails-firstName-ADT_"+i), passengers.get(i-1).getFirstName());
            typeInto(By.id("passengerDetails-lastName-ADT_"+i), passengers.get(i-1).getLastName());
            typeInto(By.id("passengerInfo-dateOfBirth-ADT_"+i), passengers.get(i-1).getBirthdate());
            System.out.println("Es masculino");
            typeInto(By.id("documentInfo-documentNumber-ADT_"+i), passengers.get(i-1).getDocumentNumber());
            typeInto(By.id("passengerInfo-phones0-number-ADT_"+i), passengers.get(i-1).getPhoneNumber());
            if(i == 1){
                typeInto(email, "contactowaiterapp@gmail.com");
                click(repeatContactInfo);
                enter(By.id("passengerInfo-phones0-number-ADT_"+i));
            }else{
                enter(By.id("documentInfo-documentNumber-ADT_"+i));
            }
        }
        try {
            Thread.sleep(6000);
        }catch (Exception e){
            e.getMessage();
        }
        click(bottonContinue);
    }

    public String paymentWithPSE() {
        click(buttonLoginLatam);
        click(inputFinalEmail);
        String finalMessge = getText(By.id("form-text"));
        return finalMessge;
    }
}




