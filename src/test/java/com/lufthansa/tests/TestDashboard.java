package com.lufthansa.tests;

import com.lufthansa.DTO.CreditCard;
import com.lufthansa.DTO.Passenger;
import com.lufthansa.globals.Globals;
import com.lufthansa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDashboard {

    OneWayPage oneWayPage = new OneWayPage();
    FlightDetailsPage flightDetailsPage = new FlightDetailsPage();
    BookingPage bookingPage = new BookingPage();
    BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
    RoundTripPage roundTripPage = new RoundTripPage();
    CarTravelPage carTravelPage = new CarTravelPage();
    MultiDestinationsPage multiDestinationsPage = new MultiDestinationsPage();


    @Test(priority = 1)

    public void testOneWayFlight() throws InterruptedException {
        List<Passenger> passengers  = new ArrayList<>();
        passengers.add(new Passenger("Orgejda","Ori","Doda","female","16/Jun/2000"));
        passengers.add(new Passenger("Deivid","Dev","Luka","male","5/Mar/2000"));

        oneWayPage.getUrl(Globals.baseUrl);
        oneWayPage.selectFlightOption("OneWay");
        oneWayPage.searchDepartureCity("New York", "JFK");
        oneWayPage.searchDestinationCity("Miami", "MIA");
        oneWayPage.selectNumberOfAdults("2");
        oneWayPage.selectCabinPreference("Economy");
        //oneWayPage.selectRandomDepartureDate(1);
        oneWayPage.clickSearchButton();
        flightDetailsPage.selectPreferredAirline("American Airlines");
        flightDetailsPage.clickBookNowButton("MAIN-9996");
        //bookingPage.setPassengerInfo(passengers);
        bookingPage.clickSelectSeatButton();
        bookingPage.selectSeat("22A");
        bookingPage.clickSaveButton();
        bookingPage.selectPaymentOption("Cash");
        bookingPage.setCustomField();
        bookingPage.clickAgreeCheckbox();
        bookingPage.clickConfirmButton();
        bookingConfirmationPage.confirmBookingAndGetReferenceNumber();

    }

    @Test(priority = 2)
    public void testReturnFlight() throws InterruptedException {
        List<Passenger> passengers  = new ArrayList<>();
        passengers.add(new Passenger("Orgejda","Ori","Doda","female","16/Jun/2000"));
        passengers.add(new Passenger("Deivid","Dev","Luka","male","5/Mar/2000"));
        passengers.add(new Passenger("Lukas","Luc","Luka","male","5/Feb/2023"));

        List<CreditCard> creditCards  = new ArrayList<>();
       creditCards.add(new CreditCard("5555341244441115","737","7","2023","Orgejda Doda",
       "Albania","Don Bosko", "Tirane", "California", "1001"));


        roundTripPage.getUrl(Globals.baseUrl);
        roundTripPage.selectFlightOption("RoundTrip");
        roundTripPage.searchDepartureCity("Toronto", "YYZ");
        roundTripPage.searchDestinationCity("New York", "JFK");
        Assert.assertTrue(roundTripPage.verifySelectedRoute("YYZ", "JFK"), "Selected route does not have the right destinations");
        roundTripPage.selectNumberOfAdults("2");
        roundTripPage.selectNumberOfInfant("1");
        roundTripPage.selectCabinPreference("Business");
        //roundTripPage.selectRandomDepartureDate(0);
        //roundTripPage.selectRandomReturnDate(1);
        roundTripPage.clickSearchButton();
        flightDetailsPage.selectPreferredAirline("Air Canada");
        flightDetailsPage.clickBookNowButton("EXECLOW-9990");
       // bookingPage.setPassengerInfo(passengers);
        bookingPage.selectPaymentOption("Credit Card/Debit Card");
        bookingPage.clickAddCarButton();
        carTravelPage.clickSearchButton();
        carTravelPage.clickBookNowButton();
       // bookingPage.setPassengerInfo(passengers);
        //bookingPage.setCreditCardInfo(creditCards);
        bookingPage.setCustomField();
        bookingPage.clickAgreeCheckbox();
        bookingPage.clickConfirmButton();
        bookingConfirmationPage.confirmBookingAndGetReferenceNumber();
        //Assert.assertTrue(bookingConfirmationPage.verifyTravelerNamesOnBookingPage(passengers));

    }

     @Test(priority = 3)
    public void testMultiDestinationsFlight() {
        multiDestinationsPage.getUrl(Globals.baseUrl);
       // multiDestinationsPage.selectFlightOption("MultiDestination");
//        multiDestinationsPage.selectNumberOfAdults("3");
//        multiDestinationsPage.selectNumberOfChild("2");
//        multiDestinationsPage.selectCabinPreference("Economy");


    }


}
