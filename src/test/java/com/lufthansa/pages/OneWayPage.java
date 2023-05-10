package com.lufthansa.pages;

import com.lufthansa.elements.CarTravelPageElements;
import com.lufthansa.elements.OneWayPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.ComponentsUtils;


public class OneWayPage {

    OneWayPageElements oneWayPageElements = new OneWayPageElements();
    ComponentsUtils componentsUtils = new ComponentsUtils();
    CarTravelPageElements carTravelPageElements = new CarTravelPageElements();

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }

    //******** Methods********//

    public void selectFlightOption(String option){

        componentsUtils.selectFlightOption(option);
    }


    public void searchDepartureCity(String inputDeparture, String completedDeparture) {

        componentsUtils.searchAutoComplete("Departure", inputDeparture, completedDeparture);
    }

    public void searchDestinationCity(String inputDestination, String completedDestination) {

        componentsUtils.searchAutoComplete("Destination", inputDestination, completedDestination);
    }


    public void selectNumberOfAdults(String numberOfAdults) {

        componentsUtils.selectOption(oneWayPageElements.adultsDropdown, numberOfAdults);
    }

    public void selectDropdownOption(String intent, String param){

        switch (intent){

            case "adult":
                componentsUtils.selectOption(oneWayPageElements.adultsDropdown, param);
                break;

            case "infant":
                componentsUtils.selectOption(oneWayPageElements.infantDropdopwn, param);
                break;

            case "children":
                componentsUtils.selectOption(oneWayPageElements.childDropdown, param);
                break;

            case "cabin":
                componentsUtils.selectOption(oneWayPageElements.cabinDropdown, param);
                break;

            case "hours":
                    componentsUtils.selectOption(carTravelPageElements.dropdown1, param);
                    componentsUtils.selectOption(carTravelPageElements.dropdown2, param);
                break;
        }
        System.out.println("Selected " + param + " " + intent);
    }

    public void selectCabinPreference(String cabinPreference) {

        componentsUtils.selectOption(oneWayPageElements.cabinDropdown, cabinPreference);
    }

    public void selectRandomDepartureDate(int month, String unit) {

        componentsUtils.selectRandomDate(oneWayPageElements.departureDateField, month, unit, 0);
    }


    public void clickSearchButton() {

        componentsUtils.clickSearchButton();
    }
}


