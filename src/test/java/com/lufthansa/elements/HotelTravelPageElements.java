package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelTravelPageElements {

    public HotelTravelPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    @FindBy(css = "[id*='check_in Location']")
    public WebElement checkInLocationField;

    @FindBy(css = "ul#ui-id-1 li span.g")
    public List<WebElement> suggestionCheckinCitiesList;

    @FindBy(css = "#checkIn_date")
    public WebElement checkInDateField;

    @FindBy(css = "#checkOut_date")
    public WebElement checkOutDateField;

    @FindBy(css = "#noRooms-counter")
    public WebElement noRoomsDropdown;

    @FindBy(css = "[id*='adult_counter']")
    public List<WebElement> adultsDropdown;


    @FindBy(css = "[id*='child_counter']")
    public List<WebElement> childDropdown;

    @FindBy(css = "[id*='child_age']")
    public List<WebElement> childAgeDropdown;

    @FindBy(css="#submitBTN")
    public WebElement searchButton;

    @FindBy(css = "hotel-price")
    public List<WebElement> hotelPrices;

}
