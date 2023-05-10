package StepsDefinitions;

import com.lufthansa.globals.Globals;
import com.lufthansa.pages.BookingConfirmationPage;
import com.lufthansa.pages.BookingPage;
import com.lufthansa.pages.FlightDetailsPage;
import com.lufthansa.pages.OneWayPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class OneWayFlightBooking {

    OneWayPage oneWayPage = new OneWayPage();
    FlightDetailsPage flightDetailsPage = new FlightDetailsPage();
    BookingPage bookingPage = new BookingPage();
    BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();


    @Given("I am on the flight booking page")

    public void iAmOnFlightBookingPage() {

        oneWayPage.getUrl(Globals.baseUrl);
    }

    @When("I select {string} flight")

    public void iSelectFlightOption(String flightOption) {

        oneWayPage.selectFlightOption(flightOption);
    }

    @And("I enter {string} as the departure at {string} airport")

    public void iEnterDepartureCity(String departure, String completetDeparture) {

        oneWayPage.searchDepartureCity(departure, completetDeparture);
    }

    @And("I enter {string} as the destination at {string} airport")

    public void iEnterDestinationCity(String destination, String completetDestination) {

        oneWayPage.searchDestinationCity(destination, completetDestination);

    }

    @And("I select a date on the upcoming month")

    public void iSelectDate() {

        oneWayPage.selectRandomDepartureDate(1, "month");

    }

    @And("I select {string} {string}")

    public void iSelectNoAdults(String numberOfAdults, String intent) {

        oneWayPage.selectDropdownOption(intent, numberOfAdults);

    }


    @And("I click search button")

    public void iClickSearchButton() {

        oneWayPage.clickSearchButton();

    }

    @And("I select {string} as the preferred airline")

    public void iSelectAirline(String preferredAirline) {

        flightDetailsPage.selectPreferredAirline(preferredAirline);

    }

    @And("I select {string} option")

    public void iSelectPriceOption(String cabinOption) {

        flightDetailsPage.clickBookNowButton(cabinOption);

    }

    @And("I set the following passenger information")

    public void setPassengerInformation(DataTable dataTable) {

        bookingPage.setPassengerInfo(dataTable);
    }


    @And("I click the seat button")

    public void iClickSeatButton() {

        bookingPage.clickSelectSeatButton();

    }

    @And("I select {string} as the preferred seat")

    public void iSelectSeat(String seatCode) {

        bookingPage.selectSeat(seatCode);
    }

    @And("I click the save button")

    public void iClickSaveButton() {

        bookingPage.clickSaveButton();

    }

    @And("I choose {string} for payment type")

    public void iSelectPaymentType(String paymentType) {

        bookingPage.selectPaymentOption(paymentType);

    }

    @And("I set custom field")

    public void iSetCustomField() {

        bookingPage.setCustomField();

    }

    @And("I click the agree checkbox")

    public void iClickAgreeCheckbox() {

        bookingPage.clickAgreeCheckbox();

    }

    @And("I click the confirm button")

    public void iClickConfirmButton() {

        bookingPage.clickConfirmButton();

    }

    @Then("I should see the booking confirmation page,get the booking reference number and verify these passenger names")

    public void iSeeBookingConfirmation(DataTable dataTable) {

        bookingConfirmationPage.confirmBookingAndGetReferenceNumber();

        Assert.assertTrue(bookingConfirmationPage.verifyTravelerNamesOnBookingPage(dataTable));

    }
}
