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
//    @CacheLookup
//    @FindBy(xpath = "//div/descendant::*[528]")
//    private WebElement selFechaIda;
//    @CacheLookup
//    @FindBy(xpath ="//div/descendant::*[534]")
//    private WebElement selFechaLlegada;
    @CacheLookup
    @FindBy(id = "WrapperCardFlight0")
    private WebElement selTicketIda;

    @CacheLookup
    @FindBy(xpath = "//div[@id='WrapperCardFlight0']//div[@role='button']")
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
    private final By genderFemale = By.cssSelector(".MuiButtonBase-root.MuiListItem-root.MuiMenuItem-root.sc-fzqAui.xBvvB.MuiMenuItem-gutters.MuiListItem-gutters.MuiListItem-button[tabindex='-1']");
    @CacheLookup
    @FindBy(id="passengerDetails-firstName-ADT_1")
    private WebElement inputName;

    @CacheLookup
    @FindBy(id="passengerDetails-lastName-ADT_1")
    private WebElement inputLastName;

    @CacheLookup
    @FindBy(id="passengerInfo-dateOfBirth-ADT_1")
    private WebElement inputdate;
    @CacheLookup
    @FindBy(id="documentInfo-documentNumber-ADT_1-label")
    private WebElement ponerId;

    @CacheLookup
    @FindBy(id = "mui-component-select-passengerInfo.gender")
    private WebElement genderInput;
    public LatamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void fillSearchForm() {
        typeInto(origin, "Medellin");
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
        click(continueToPay);
//        click(By.id("hi"));
    }

    public void fillPassengers(List<Passenger> passengers) {
//        for (Passenger passenger : passengers) {
//
//            System.out.println(passenger.getFirstName());
//            System.out.println(passenger.getLastName());
//            System.out.println(passenger.getBirthdate());
//            System.out.println(passenger.getGender());
//            System.out.println(passenger.getDocumentNumber());
//            System.out.println(passenger.getPhoneNumber());
//        }
        click(inputName);
        typeInto(inputName, passengers.get(0).getFirstName());
        typeInto(inputLastName, passengers.get(0).getLastName());
        typeInto(inputdate, passengers.get(0).getBirthdate());
        switch (passengers.get(0).getGender()) {
            case "Masculino":
                System.out.println("Es masculino");
                break;
            case "Femenino":
                click(genderInput);
                click(genderFemale);
                break;
        }
    }

}
