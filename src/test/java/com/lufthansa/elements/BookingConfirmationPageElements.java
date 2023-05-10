package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingConfirmationPageElements {

    public BookingConfirmationPageElements() {

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    //BookingConfirmationPage Elements

    @FindBy(css = "div[class='ref_num_btn'] h2 span")
    public WebElement bookingReferenceNumber;

    @FindBy(css = "div[class='ref_num_btn'] h2")
    public WebElement confirmationMessage;

    @FindBy(css = " #bookingPassengersResultDiv table.ui.table tbody tr td:nth-child(2)")
    public List<WebElement> travelerNameElements;


}
