package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MultiDestinationsPageElements extends OneWayPageElements{

    public MultiDestinationsPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    //MultiDestinationsPage Elements


    @FindBy(css = "[id^='mdRow_'] div.ui.from.search.icon.input input[id*='departure_city_']")
    public List<WebElement> departureCityField;

    @FindBy(css = "[id^='mdRow_'] div.ui.from.search.icon.input input[id*='destination_city_']")
    public List<WebElement> destinationCityField;

    @FindBy(css = "li span.g")
    public List<WebElement> suggestionCitiesList;

    @FindBy(css = "[id^='addLeg_']")
    public List<WebElement> addLegButton;

    @FindBy(css = "div[class='ui accordion']")
    public WebElement advancedOptionsButton;

    @FindBy(css = "#non_stop_flights")
    public WebElement nonStopFlightsDropDown;

    @FindBy(css = "input[id^='departure_date_']")
    public List<WebElement> departureDateField;







}
