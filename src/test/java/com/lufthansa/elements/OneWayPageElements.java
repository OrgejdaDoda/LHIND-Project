package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OneWayPageElements {

    public OneWayPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    //OneWayPage Elements

    @FindBy(css = "li#OneWay")
    public WebElement oneWayFlightOption;

    @FindBy(css = "li#RoundTrip")
    public WebElement roundTripFlightOption;

    @FindBy(css = "li#MultiDestination")
    public WebElement multiDestinationFlightOption;

    @FindBy(css = "[id*='departure_city']")
    public WebElement departureCityField;

    @FindBy(css = "ul#ui-id-1 li span.g")
    public List<WebElement> suggestionDepartureCitiesList;

    @FindBy(css = "ul#ui-id-2 li span.g")
    public List<WebElement> suggestionDestionationCitiesList;

    @FindBy(css = "[id*='destination_city']")
    public WebElement destinationCityField;

    @FindBy(css = "#adult-counter")
    public WebElement adultsDropdown;


    @FindBy(css = "#child-counter")
    public WebElement childDropdown;

    @FindBy(css = "#infant-counter")
    public WebElement infantDropdopwn;

    @FindBy(css = "#pref_class")
    public WebElement cabinDropdown;

    @FindBy(css = "#departure_date")
    public WebElement departureDateField;

    @FindBy(css = "a[class*='ui-state-default']")
    public List<WebElement> calendarDates;

    @FindBy(css = "span[class='ui-icon ui-icon-circle-triangle-e']")
    public WebElement nextButton;

    @FindBy(css="#submitBTN")
    public WebElement searchButton;












}
