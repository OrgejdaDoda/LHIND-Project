package com.lufthansa.utilities;

import com.lufthansa.elements.FlightDetailsPageElements;
import com.lufthansa.elements.HotelTravelPageElements;
import com.lufthansa.elements.MultiDestinationsPageElements;
import com.lufthansa.elements.OneWayPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ComponentsUtils {

    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    OneWayPageElements oneWayPageElements = new OneWayPageElements();
    HotelTravelPageElements hotelTravelPageElements = new HotelTravelPageElements();

    FlightDetailsPageElements flightDetailsPageElements = new FlightDetailsPageElements();
    MultiDestinationsPageElements multiDestinationsPageElements = new MultiDestinationsPageElements();


    String chosenArrivalDate = "";
    String chosenDepartureDate = "";


    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }


    public void selectFlightOption(String option) {


        switch (option) {
            case "OneWay":

                basePageObject
                        .getWebElementUtils()
                        .clickWebElement(oneWayPageElements.oneWayFlightOption);

                break;

            case "RoundTrip":

                basePageObject
                        .getWebElementUtils()
                        .clickWebElement(oneWayPageElements.roundTripFlightOption);

                break;
            case "MultiDestination":

                basePageObject
                        .getWebElementUtils()
                        .clickWebElement(oneWayPageElements.multiDestinationFlightOption);

                break;

            default:
        }
        System.out.println("Selected flight option: " + option);

    }

    public void selectOption(WebElement dropdown, String optionToSelect) {

        Select selectCabinPref = new Select(dropdown);

        selectCabinPref.selectByVisibleText(optionToSelect);

    }

    public void searchAutoComplete(String inputField, String inputCity, String completedCity) {

        WebElement inputAutocomplete = null;
        List<WebElement> listSuggestions = new ArrayList<>();

        switch (inputField) {

            case "Departure":
                inputAutocomplete = oneWayPageElements.departureCityField;
                listSuggestions = oneWayPageElements.suggestionDepartureCitiesList;
                break;

            case "Destination":
                inputAutocomplete = oneWayPageElements.destinationCityField;
                listSuggestions = oneWayPageElements.suggestionDestionationCitiesList;
                break;

            case "Check In":
                inputAutocomplete = hotelTravelPageElements.checkInLocationField;
                listSuggestions = hotelTravelPageElements.suggestionCheckinCitiesList;
                break;

            default:
        }

        basePageObject
                .getWebElementUtils()
                .sendKeysToElement(inputAutocomplete, inputCity);

        basePageObject
                .getWaitUtils()
                .waitForAllElementsToBeVisible(listSuggestions);

        for (WebElement element : listSuggestions) {
            if (element.getText().equals(", " + completedCity)) {
                basePageObject.getWebElementUtils().clickWebElement(element);
                break;
            }
        }
        System.out.println("Searched for " + inputField + " city: " + inputCity);
    }


    public void searchAutoCompleteMultiLeg(String inputField, String inputCity, String completedCity, int flightNo) {

        WebElement inputAutocomplete = null;
        List<WebElement> listSuggestions = new ArrayList<>();

        switch (inputField.toLowerCase()) {

            case "departure":
                inputAutocomplete = multiDestinationsPageElements.departureCityField.get(flightNo - 1);
                listSuggestions = multiDestinationsPageElements.suggestionCitiesList;
                break;

            case "destination":
                inputAutocomplete = multiDestinationsPageElements.destinationCityField.get(flightNo - 1);
                listSuggestions = multiDestinationsPageElements.suggestionCitiesList;
                break;

            default:
        }

        basePageObject
                .getWebElementUtils()
                .sendKeysToElement(inputAutocomplete, inputCity);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (WebElement element : listSuggestions) {
            if (element.getText().equals(", " + completedCity)) {
                basePageObject.getWebElementUtils().clickWebElement(element);
                break;
            }
        }
        System.out.println("Searched for " + inputField + " city: " + inputCity);
    }


    public void selectCheckInCheckOutDate(String intent) {

        String dateToSelect = "";

        if (intent.equalsIgnoreCase("Check In")) {
            hotelTravelPageElements.checkInDateField.click();
            dateToSelect = this.chosenArrivalDate;
        } else {
            hotelTravelPageElements.checkOutDateField.click();
            dateToSelect = this.chosenDepartureDate;
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate departureDate = LocalDate.parse(dateToSelect, DateTimeFormatter.ofPattern("M/d/yyyy"));
        String date = String.valueOf(departureDate.getDayOfMonth());
        Period period = Period.between(currentDate.withDayOfMonth(1), departureDate.withDayOfMonth(1));
        int clickCount = period.getYears() * 12 + period.getMonths();

        while (clickCount > 0) {
            basePageObject.getWebElementUtils().clickWebElement(oneWayPageElements.nextButton);
            clickCount--;
        }

        basePageObject.getWaitUtils().waitForAllElementsToBeVisible(oneWayPageElements.calendarDates);
        for (WebElement element : oneWayPageElements.calendarDates) {
            if (element.getText().equals(date)) {
                element.click();
                break;
            }
        }
        Assert.assertEquals(dateToSelect, oneWayPageElements.departureDateField.getAttribute("value"));

        System.out.println("Departure date selected: " + dateToSelect);
    }

    public void selectCalendarDate(WebElement calendar, String dateToSelect) {

        //Find the departure date field and click it
        basePageObject.getWebElementUtils().clickWebElement(calendar);

        LocalDate currentDate = LocalDate.now();
        LocalDate departureDate = LocalDate.parse(dateToSelect, DateTimeFormatter.ofPattern("M/d/yyyy"));
        String date = String.valueOf(departureDate.getDayOfMonth());
        Period period = Period.between(currentDate.withDayOfMonth(1), departureDate.withDayOfMonth(1));
        int clickCount = period.getYears() * 12 + period.getMonths();

        while (clickCount > 0) {
            basePageObject
                    .getWebElementUtils()
                    .clickWebElement(oneWayPageElements.nextButton);
            clickCount--;
        }

        basePageObject.getWaitUtils().waitForAllElementsToBeVisible(oneWayPageElements.calendarDates);
        for (WebElement element : oneWayPageElements.calendarDates) {
            if (element.getText().equals(date)) {
                element.click();
                break;
            }
        }
        Assert.assertEquals(dateToSelect, oneWayPageElements.departureDateField.getAttribute("value"));

        System.out.println("Departure date selected: " + dateToSelect);
    }

    public void selectRandomDate(WebElement calendar, int amount, String unit, int flightNo) {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(calendar);

        if (unit.equalsIgnoreCase("month")) {
            Month currentMonth = LocalDate.now().getMonth();
            Month resultingMonth = currentMonth.plus(amount);

            while (amount > 0) {
                basePageObject
                        .getWebElementUtils()
                        .clickWebElement(oneWayPageElements.nextButton);
                amount--;
            }

            basePageObject
                    .getWaitUtils()
                    .waitForAllElementsToBeVisible(oneWayPageElements.calendarDates);

            String selectedDate = oneWayPageElements.calendarDates.get(0).getText();

            basePageObject
                    .getWebElementUtils()
                    .clickWebElement(oneWayPageElements.calendarDates.get(0));

            System.out.println("Departure date selected: " + selectedDate + " " + resultingMonth);

        } else if (unit.equalsIgnoreCase("days")) {
            String departureDate = "";
            if (flightNo == 2) {
                departureDate = multiDestinationsPageElements.departureDateField.get(0).getAttribute("value");
            } else if (flightNo == 3) {
                departureDate = multiDestinationsPageElements.departureDateField.get(1).getAttribute("value");
                this.chosenArrivalDate = departureDate;
            } else {
                departureDate = oneWayPageElements.departureDateField.getAttribute("value");
            }
            LocalDate selectedDate = LocalDate.parse(departureDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
            LocalDate resultingDate = selectedDate.plusDays(amount);
            String resultingDateStr = resultingDate.format(DateTimeFormatter.ofPattern("d"));
            this.chosenDepartureDate = resultingDateStr;

            basePageObject
                    .getWaitUtils()
                    .waitForAllElementsToBeVisible(oneWayPageElements.calendarDates);

            for (WebElement date : oneWayPageElements.calendarDates) {
                if (date.getText().equals(resultingDateStr)) {
                    date.click();

                    System.out.println("Departure date selected: " + date.getText() + " " + resultingDate.getMonth());
                    break;
                }
            }
        } else {

            System.out.println("Invalid unit input. Please use 'month' or 'days'.");
        }
    }

    public void clickSearchButton() {

        basePageObject.getWebElementUtils().clickWebElement(oneWayPageElements.searchButton);

        System.out.println("Search button clicked");
    }

    public void selectPreferredAirline(String airline) {

        basePageObject
                .getWaitUtils()
                .waitForAllElementsToBeVisible(flightDetailsPageElements.flightDetails);

        WebElement filterAirline = BaseInformation.getDriver()
                .findElement(By.cssSelector(flightDetailsPageElements.filterAirlineCss.replace("optionValue", airline)));

        basePageObject
                .getWebElementUtils()
                .clickWebElement(filterAirline);

        basePageObject
                .getWaitUtils()
                .waitForElementToBeInvisible(filterAirline);

        basePageObject
                .getWaitUtils()
                .waitForAllElementsToBeVisible(flightDetailsPageElements.flightDetails);

        for (WebElement e : flightDetailsPageElements.flightDetails) {
            List<WebElement> airlineImgs = e.findElements(By.cssSelector("img[title='" + airline + "']"));

            if (!airlineImgs.isEmpty()) {
                WebElement priceElement = e.findElement(By.cssSelector("div[class='ui mini light-blue ff-price-padding button']"));
                priceElement.click();
                break;
            }
        }
        System.out.println("Selected " + airline + " as the preferred airline");

    }


    public void selectPreferredAirlineAndBookNow(String airline) {

        basePageObject
                .getWaitUtils()
                .waitForAllElementsToBeVisible(flightDetailsPageElements.flightDetails);

        for (WebElement e : flightDetailsPageElements.flightDetails) {
            List<WebElement> airlineImgs = e.findElements(By.cssSelector("img[title='" + airline + "']"));

            if (!airlineImgs.isEmpty()) {
                WebElement priceElement = e.findElement(By.cssSelector("div[class='ui mini light-blue ff-price-padding button']"));
                priceElement.click();
                WebElement bookNow = e.findElement(By.cssSelector("button[class='ui button red  ']"));
                bookNow.click();
                break;
            }
        }
        System.out.println("Selected " + airline + " as the preferred airline");

    }
}
      