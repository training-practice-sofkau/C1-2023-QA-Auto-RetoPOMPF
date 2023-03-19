package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BookingPage extends CommonActionsOnPages {
    private final By origin = By.id("txtInputOrigin_field");
    private final By destiny = By.id("txtInputDestination_field");
    private final By addPassenger = By.id("btnAddPassengerCTA");
    private final By addAdult = By.id("btnPlusAdults");
    private final By addChildren = By.id("btnPlusChildren");
    private final By addInfant = By.id("btnPlusInfant");

    private final By list = By.id("btnItemAutoComplete_0");
    private final By date1 = By.id("departureDate");

    private final By departureDate = By.cssSelector("div.CalendarMonthGrid_month__horizontal:nth-child(3) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(5) > span:nth-child(1)");
    private final By arrivalDate = By.cssSelector("div.CalendarMonthGrid_month__horizontal:nth-child(4) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)");

    private final By test = By.id("popperExtended");
    private final By test1 = By.id("titleSelectFlightDesktop");
    private final By test2 = By.cssSelector("a.MuiTypography-root:nth-child(1)");


    private final By search = By.id("btnSearchCTA");
    private final By Flight = By.id("WrapperCardFlight0");
    private final By FlightCost = By.id("bundle-detail-0-flight-select");
    private final By arrivalFlight = By.id("WrapperCardFlight0");
    private final By arrivalFlightCost = By.id("bundle-detail-0-flight-select");
    private final By goSeats = By.id("button9--button-wrapper");
    private final By randomSeats = By.id("btnSeatMapLeave");
    private final By cartConfirm = By.id("button-cart-confirm");



    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void FillMandatoryFields() {

        doubleClick(origin);
        typeInto(origin, "Bogota");
        click(list);
        doubleClick(destiny);
        typeInto(destiny, "Medellin");
        click(list);
        doubleClick(date1);
        explicitWait(test);
        click(departureDate);
        click(arrivalDate);
        click(addPassenger);
        //explicitWait(test1);
        //doubleClick(addChildren);
        click(search);
        switchTab();
        explicitWait(test1);
        click(Flight);
        click(FlightCost);
        implicitWait(20);
        click(Flight);
        click(FlightCost);
        click(goSeats);
        explicitWait(randomSeats);
        click(randomSeats);
        explicitWait(cartConfirm);
        click(cartConfirm);
        //typeInto(departureDate, "25/03/2023");
        //dateInput(returnDate);
        //typeInto(returnDate, "30/03/2023");
        //click(search);
        // switchTab();


    }
}


