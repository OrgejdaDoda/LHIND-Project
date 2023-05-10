package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarTravelPageElements {

    public CarTravelPageElements(){

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    // CarTravelPage Elements

    @FindBy(css="#submitBTN")
    public WebElement searchButton;

    @FindBy(css="div[class='field three wide'] select[id^='AnyTime1']")
    public WebElement dropdown1;

    @FindBy(css="div[class='field three wide'] select[id^='AnyTime2']")
    public WebElement dropdown2;

    @FindBy(css = "button[class='ui button light-blue right floated']")
    public WebElement bookNowButton;

}
