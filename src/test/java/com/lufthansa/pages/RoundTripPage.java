package com.lufthansa.pages;

import com.lufthansa.elements.RoundTripPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.ComponentsUtils;


public class RoundTripPage extends OneWayPage {

    RoundTripPageElements roundTripPageElements = new RoundTripPageElements();
    ComponentsUtils componentsUtils = new ComponentsUtils();

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }

    //******** Methods********//


    public boolean verifySelectedRoute(String expectedDeparture, String expectedDestination) {

        String selectedDeparture = roundTripPageElements.departureCityField.getAttribute("value").split("\\(")[1].replaceAll("[^A-Za-z]+", "");
        String selectedDestination = roundTripPageElements.destinationCityField.getAttribute("value").split("\\(")[1].replaceAll("[^A-Za-z]+", "");

        boolean isSelectedRouteValid = selectedDeparture.equals(expectedDeparture) && selectedDestination.equals(expectedDestination);
        if (isSelectedRouteValid) {
            System.out.println("Selected route has the right destinations");
        }
        return isSelectedRouteValid;
    }

    public void selectNumberOfInfant(String numberOfInfant) {

        componentsUtils.selectOption(roundTripPageElements.infantDropdopwn, numberOfInfant);
    }

    public void selectRandomReturnDate(int amount, String unit) {

        componentsUtils.selectRandomDate(roundTripPageElements.returnDateField, amount, unit, 0);
    }

}
