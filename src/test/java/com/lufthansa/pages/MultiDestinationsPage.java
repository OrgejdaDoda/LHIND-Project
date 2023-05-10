package com.lufthansa.pages;

import com.lufthansa.elements.MultiDestinationsPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import com.lufthansa.utilities.ComponentsUtils;

public class MultiDestinationsPage {

    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    MultiDestinationsPageElements multiDestinationsPageElements = new MultiDestinationsPageElements();
    ComponentsUtils componentsUtils = new ComponentsUtils();

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }

    //******** Methods********//


    public void searchMultiDepartureCity(String inputDeparture,String intent, String completedDeparture, String flightNo) {

        componentsUtils.searchAutoCompleteMultiLeg(intent, inputDeparture, completedDeparture,Integer.parseInt(flightNo));
    }

    public void clickAddALegButton(int flightNo) {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(multiDestinationsPageElements.addLegButton.get(flightNo-1));
    }

    public void clickAdvancedOptionButton() {

        basePageObject
                .getWebElementUtils()
                        .clickWebElement(multiDestinationsPageElements.advancedOptionsButton);

        System.out.println("Advanced Option button clicked");
    }

    public void selectNonStopFlights() {

        componentsUtils.selectOption(multiDestinationsPageElements.nonStopFlightsDropDown,"Non-stop flights");

        System.out.println("Non-stop flights option selected");
    }


    public void selectRandomDepartureDate(int amount, String unit, int flightNo) {

        componentsUtils.selectRandomDate(multiDestinationsPageElements.departureDateField.get(flightNo-1), amount, unit, flightNo);
    }

}
