package pages;

import models.Passenger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;

import static org.bouncycastle.crypto.tls.HashAlgorithm.getText;


public class BookingPage extends CommonActionsOnPages {
    private final By origin = By.id("txtInputOrigin_field");
    private final By destiny = By.id("txtInputDestination_field");
    private final By addPassenger = By.id("btnAddPassengerCTA");
    private final By addAdult = By.id("btnPlusAdults");
    private final By addChildren = By.id("btnPlusChildren");
    private final By addInfant = By.id("btnPlusInfant");
    private final By list = By.id("btnItemAutoComplete_0");
    private final By date = By.id("departureDate");
    private final By departureDate = By.cssSelector("div.CalendarMonthGrid_month__horizontal:nth-child(3) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1)");
    private final By arrivalDate = By.cssSelector("div.CalendarMonthGrid_month__horizontal:nth-child(3) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(7)");
    private final By wait = By.id("popperExtended");
    private final By wait1 = By.id("titleSelectFlightDesktop");
    private final By seatsLater = By.id("buttonChooseLater");
    private final By search = By.id("btnSearchCTA");
    private final By departureFlight = By.id("WrapperCardFlight0");
    private final By departureFlightCost = By.id("bundle-detail-0-flight-select");
    private final By arrivalFlight = By.id("WrapperCardFlight0");
    private final By arrivalFlightCost = By.id("bundle-detail-0-flight-select");
    private final By addBags = By.id("btn-up-segment-BOG-MDE-bag-23-passenger-ADT_1");
    private final By goSeats = By.id("button9--button-wrapper");
    private final By randomSeats = By.id("btnSeatMapLeave");
    private final By cartConfirm = By.id("button-cart-confirm");
    private final By adultPassengerFirstName = By.id("passengerDetails-firstName-ADT_1");
    private final By adultPassengerLastName = By.id("passengerDetails-lastName-ADT_1");
    private final By adultPassengerBirthdate = By.id("passengerInfo-dateOfBirth-ADT_1");
    private final By adultPassengerID = By.id("documentInfo-documentNumber-ADT_1");
    private final By adultPassengerEmail = By.id("passengerInfo-emails-ADT_1");
    private final By adultPassengerPhoneNumber = By.id("passengerInfo-phones0-number-ADT_1");
    private final By saveAdultPassenger = By.id("passengerFormSubmitButtonADT_1");
    private final By childPassengerFirstName = By.id("passengerDetails-firstName-CHD_1");
    private final By childPassengerLastName = By.id("passengerDetails-lastName-CHD_1");
    private final By childPassengerBirthdate = By.id("passengerInfo-dateOfBirth-CHD_1");
    private final By childPassengerID = By.id("documentInfo-documentNumber-CHD_1");
    private final By childPassengerEmail = By.id("passengerInfo-emails-CHD_1");
    private final By childPassengerPhoneNumber = By.id("passengerInfo-phones0-number-CHD_1");
    private final By saveChildPassenger = By.id("passengerFormSubmitButtonCHD_1");
    private final By infantPassengerFirstName = By.id("passengerDetails-firstName-INF_1");
    private final By infantPassengerLastName = By.id("passengerDetails-lastName-INF_1");
    private final By infantPassengerBirthdate = By.id("passengerInfo-dateOfBirth-INF_1");
    private final By infantPassengerID = By.id("documentInfo-documentNumber-INF_1");
    private final By infantPassengerEmail = By.id("passengerInfo-emails-INF_1");
    private final By infantPassengerPhoneNumber = By.id("passengerInfo-phones0-number-INF_1");
    private final By saveInfantPassenger = By.id("passengerFormSubmitButtonINF_1");
    private final By continuePayment = By.cssSelector("#undefined--button-wrapper > button:nth-child(1)");
    private final By termsCheckbox = By.id("TermsAndConditionsCheckbox");
private final By creditCardPayment = By.id("FormCreditCardaddCreditCard");
    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void SelectFlightsAndDates() throws InterruptedException {

        doubleClick(origin);
        typeInto(origin, "Bogota");
        click(list);
        doubleClick(destiny);
        typeInto(destiny, "Medellin");
        click(list);
        implicitWait(10);
        doubleClick(date);
        implicitWait(10);

        click(departureDate);
        click(arrivalDate);
        click(addPassenger);
        implicitWait(5);
        click(addChildren);
        click(addInfant);
        click(search);
        switchTab();
        implicitWait(40);
        click(departureFlight);
        click(departureFlightCost);
        implicitWait(10);
        click(arrivalFlight);
        click(arrivalFlightCost);
        implicitWait(50);
        click(goSeats);
        implicitWait(50);
        click(randomSeats);
        implicitWait(10);
        //click(seatsLater);
        implicitWait(30);

    }

    public void addBags() {
        implicitWait(30);
        click(addBags);
        click(cartConfirm);
        implicitWait(10);


    }

    public void FillPassengersForm() throws InterruptedException {
        Passenger adultPassenger = Passenger.generateAdultPassenger();
        String AfirstName = adultPassenger.getFirstName();
        String AlastName = adultPassenger.getLastName();
        String Abirthdate = adultPassenger.getBirthdate();
        String Aid = adultPassenger.getId();
        String Aemail = adultPassenger.getEmail();
        String AphoneNumber = adultPassenger.getPhoneNumber();
        click(adultPassengerFirstName);
        typeInto(adultPassengerFirstName, AfirstName);
        click(adultPassengerLastName);
        typeInto(adultPassengerLastName, AlastName);
        click(adultPassengerBirthdate);
        typeInto(adultPassengerBirthdate, Abirthdate);
        click(adultPassengerID);
        typeInto(adultPassengerID, Aid);
        click(adultPassengerEmail);
        typeInto(adultPassengerEmail, Aemail);
        click(adultPassengerPhoneNumber);
        typeInto(adultPassengerPhoneNumber, AphoneNumber);
        click(saveAdultPassenger);
        implicitWait(10);

        Passenger childPassenger = Passenger.generateChildPassenger();
        String CfirstName = childPassenger.getFirstName();
        String ClastName = childPassenger.getLastName();
        String Cbirthdate = childPassenger.getBirthdate();
        String Cid = childPassenger.getId();
        String Cemail = childPassenger.getEmail();
        String CphoneNumber = childPassenger.getPhoneNumber();
        click(childPassengerFirstName);
        typeInto(childPassengerFirstName, CfirstName);
        click(childPassengerLastName);
        typeInto(childPassengerLastName, ClastName);
        click(childPassengerBirthdate);
        typeInto(childPassengerBirthdate, Cbirthdate);
        click(childPassengerID);
        typeInto(childPassengerID, Cid);
        click(childPassengerEmail);
        typeInto(childPassengerEmail, Cemail);
        click(childPassengerPhoneNumber);
        typeInto(childPassengerPhoneNumber, CphoneNumber);
        click(saveChildPassenger);
        implicitWait(10);

        Passenger infantPassenger = Passenger.generateInfantPassenger();
        String IfirstName = infantPassenger.getFirstName();
        String IlastName = infantPassenger.getLastName();
        String Ibirthdate = infantPassenger.getBirthdate();
        String Iid = infantPassenger.getId();
        String Iemail = infantPassenger.getEmail();
        String IphoneNumber = infantPassenger.getPhoneNumber();
        click(infantPassengerFirstName);
        typeInto(infantPassengerFirstName, IfirstName);
        click(infantPassengerLastName);
        typeInto(infantPassengerLastName, IlastName);
        click(infantPassengerBirthdate);
        typeInto(infantPassengerBirthdate, Ibirthdate);
        click(infantPassengerID);
        typeInto(infantPassengerID, Iid);
        click(infantPassengerEmail);
        typeInto(infantPassengerEmail, Iemail);
        click(infantPassengerPhoneNumber);
        typeInto(infantPassengerPhoneNumber, IphoneNumber);
        click(saveInfantPassenger);
        implicitWait(10);
        click(continuePayment);
    }

    public static String payment() {
        implicitWait(40);
        click(termsCheckbox);
        click(creditCardPayment);
        String paymentMessage = getText(By.id("credit-card-addMethodPayment-dialog-title"));
        return paymentMessage;


    }
}



