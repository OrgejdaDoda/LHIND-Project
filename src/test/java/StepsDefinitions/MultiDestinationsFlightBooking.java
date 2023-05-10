package StepsDefinitions;

import com.lufthansa.pages.BookingPage;
import com.lufthansa.pages.FlightDetailsPage;
import com.lufthansa.pages.HotelTravelPage;
import com.lufthansa.pages.MultiDestinationsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MultiDestinationsFlightBooking {

    MultiDestinationsPage multiDestinationsPage = new MultiDestinationsPage();
    FlightDetailsPage flightDetailsPage = new FlightDetailsPage();
    HotelTravelPage hotelTravelPage = new HotelTravelPage();
    BookingPage bookingPage = new BookingPage();


    @And("I enter {string} as the {string} at {string} airport for the {string} flight")

    public void iEnterDepartureCity(String departure, String intent, String completetDeparture, String flightNo) {

        multiDestinationsPage.searchMultiDepartureCity(departure, intent, completetDeparture, flightNo);
    }

    @And("I click add a leg button for the {string} flight")

    public void iClickAddALeg(String flightNo) {

        multiDestinationsPage.clickAddALegButton(Integer.parseInt(flightNo));
    }

    @And("I click the advanced option button")

    public void iClickAdvancedOptions() {

        multiDestinationsPage.clickAdvancedOptionButton();
    }

    @Then("I select the Non-stop flight option")

    public void iSelectNonStopFlights() {

        multiDestinationsPage.selectNonStopFlights();
    }

    @And("I select a date after {string} {string} for the {string} flight")

    public void iSelectDate(String amount, String unit, String flightNo) {

        multiDestinationsPage.selectRandomDepartureDate(Integer.parseInt(amount), unit, Integer.parseInt(flightNo));

    }

    @And("I select {string} as the preferred airline and click book now")

    public void iSelectPreferredAirline(String airline) {

        flightDetailsPage.selectPreferredAirlineAndBookNow(airline);

    }

    @And("I click addHotel button")

    public void iClickAddHotelButton() {

        bookingPage.clickAddHotelButton();

    }

    @And("I enter {string} at {string} on the check in location")

    public void iSelectHotelLocation(String location, String locationCode) {

        hotelTravelPage.searchCheckInLocation(location, locationCode);

    }

    @And("I select {string} date")

    public void iSelectCheckInOutDate(String intent) {

        hotelTravelPage.chooseCheckInOutDate(intent);

    }

    @And("I choose {string} rooms")

    public void iSelectNoRooms(String noRooms) {

        hotelTravelPage.chooseRoomNo(noRooms);

    }


    @When("I am on the {string} room I enter {string} adults and children")

    public void iFillInGuestInformation(String roomNo, String adultNo, DataTable dataTable) {

        hotelTravelPage.fillInGuestInformation(roomNo, adultNo, dataTable);

    }

    @Then("I click on the search button")
    public void iClickSearchButton() {

        hotelTravelPage.clickSearchButton();

    }


    @And("I select a hotel cheaper then {string} per night and cheaper then {string} total")

    public void iSelectHotel(String pricePerNight, String totalPrice) {

        hotelTravelPage.selectHotel(pricePerNight, totalPrice);

    }


}
