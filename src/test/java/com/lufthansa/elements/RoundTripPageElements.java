package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RoundTripPageElements extends OneWayPageElements{

    public RoundTripPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    //RoundTripPage Elements

    @FindBy(css = "#return_date")
    public WebElement returnDateField;

}
