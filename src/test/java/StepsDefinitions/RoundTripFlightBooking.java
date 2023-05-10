package StepsDefinitions;

import com.lufthansa.pages.BookingPage;
import com.lufthansa.pages.CarTravelPage;
import com.lufthansa.pages.RoundTripPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class RoundTripFlightBooking {

    RoundTripPage roundTripPage = new RoundTripPage();
    BookingPage bookingPage = new BookingPage();
    CarTravelPage carTravelPage = new CarTravelPage();


    @And("I select the first date of the {string} {string} as the departure date")

    public void iSelectDepartureDate(String amount, String unit) {
        if (amount.equals("present")) {
            roundTripPage.selectRandomDepartureDate(0, unit);
        } else {
            roundTripPage.selectRandomReturnDate(Integer.parseInt(amount), unit);
        }
    }

    @And("I select after {string} {string} the return date")

    public void iSelectReturnDate(String amount, String unit) {

        roundTripPage.selectRandomReturnDate(Integer.parseInt(amount), unit);

    }

    @Then("I verify the route has these airports {string} {string}")

    public void iVerifyAirports(String departureAirport, String destinationAirport) {

        roundTripPage.verifySelectedRoute(departureAirport, destinationAirport);

    }

    @And("I select {string} {string} hours")

    public void selectOpeningHours(String opening, String closing) {

        roundTripPage.selectDropdownOption("hours", opening);

    }


    @And("I click addCar button")

    public void iClickAddCarButton() {

        bookingPage.clickAddCarButton();

    }

    @And("I click bookNow button")

    public void iClickBookNowButton() {

        carTravelPage.clickBookNowButton();

    }

    @And("I enter the following card information")

    public void iSetCustomField(DataTable dataTable) {

        bookingPage.setCreditCardInfo(dataTable);

    }

}
