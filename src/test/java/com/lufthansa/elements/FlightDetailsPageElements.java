package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightDetailsPageElements {

    public FlightDetailsPageElements() {

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    //FlightDetailsPage Elements

    @FindBy(css = " div[class='row flightDetails']")
    public List<WebElement> flightDetails;

    public String filterAirlineCss = "img.matrixFilterAirline[title='optionValue']";

    public String bookNowButtonXpath = "//div[@class = 'fields non-mobile-ff']//button[contains(@id, 'optionValue')]/../../..//button[contains(text(), 'Book')]";


}
